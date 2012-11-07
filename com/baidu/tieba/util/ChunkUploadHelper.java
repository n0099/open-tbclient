package com.baidu.tieba.util;

import com.baidu.tieba.data.ChunkUploadData;
import com.baidu.tieba.data.ChunkUploadResult;
import com.baidu.tieba.data.Config;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class ChunkUploadHelper {
    private ChunkUploadData mChunkUploadData;
    private String mFileName;
    private boolean mIsCancelled = false;
    private NetWork mNetWork;
    private String mUrl;

    public ChunkUploadHelper(String filename, ChunkUploadData uploadData, String url) {
        this.mFileName = null;
        this.mUrl = null;
        this.mChunkUploadData = null;
        this.mFileName = filename;
        this.mChunkUploadData = uploadData;
        this.mUrl = url;
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.cancelNetConnect();
        }
        this.mIsCancelled = true;
    }

    public ChunkUploadResult uploadChunkFile() throws IOException {
        ChunkUploadResult result = new ChunkUploadResult();
        long totalLength = this.mChunkUploadData.getTotalLength();
        long chunkNo = totalLength % 102400 == 0 ? totalLength / 102400 : (totalLength / 102400) + 1;
        int startChunk = this.mChunkUploadData.getChunkNo();
        if (startChunk < chunkNo) {
            File image = FileHelper.GetFile(this.mFileName);
            RandomAccessFile fileToUpload = new RandomAccessFile(image, "r");
            TiebaLog.d("ChunkUploadHelper", "uploadChunkFile", String.format("start chunk : %d", Integer.valueOf(startChunk)));
            fileToUpload.skipBytes(Config.CHUNK_UPLOAD_SIZE * startChunk);
            for (int i = startChunk; i < chunkNo; i++) {
                int byteCount = Config.CHUNK_UPLOAD_SIZE;
                if (i == chunkNo - 1) {
                    byteCount = (int) (totalLength - (102400 * (chunkNo - 1)));
                }
                byte[] data = new byte[byteCount];
                int num = fileToUpload.read(data, 0, byteCount);
                if (num != -1) {
                    this.mNetWork = new NetWork(this.mUrl);
                    this.mNetWork.addPostData("md5", this.mChunkUploadData.getMd5());
                    this.mNetWork.addPostData("total_length", String.valueOf(totalLength));
                    this.mNetWork.addPostData("total_num", String.valueOf(chunkNo));
                    TiebaLog.d("ChunkUploadHelper", "uploadChunkFile", String.format("total length : %d, chunk_no : %d", Long.valueOf(totalLength), Integer.valueOf(i)));
                    this.mNetWork.addPostData("pic_chunk", data);
                    this.mNetWork.addPostData("offset", String.valueOf(Config.CHUNK_UPLOAD_SIZE * i));
                    this.mNetWork.addPostData("chunk_no", String.valueOf(i + 1));
                    this.mNetWork.addPostData("length", String.valueOf(num));
                    boolean isFail = false;
                    if (this.mIsCancelled) {
                        isFail = true;
                    } else {
                        String ret = this.mNetWork.postMultiNetData();
                        TiebaLog.d("ChunkUploadHelper", "uploadChunkFile", "ret " + ret);
                        if (ret == null || !this.mNetWork.isRequestSuccess()) {
                            this.mChunkUploadData.setChunkNo(i);
                            DatabaseService.saveChunkUploadData(this.mChunkUploadData);
                            fileToUpload.close();
                            isFail = true;
                        }
                    }
                    if (isFail) {
                        result.setErrorCode(this.mNetWork.getErrorCode());
                        result.setErrorString(this.mNetWork.getErrorString());
                        result.setData(this.mChunkUploadData);
                        result.setIsSuccess(false);
                        break;
                    }
                }
            }
            fileToUpload.close();
        }
        result.setIsSuccess(true);
        return result;
    }
}
