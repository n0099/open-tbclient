package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean ajt = false;
    private final int chunkLength;
    private z fEV;
    private final int fEW;
    private e fEX;
    private final String forumId;

    public c(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fEW = i2 / i;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fEX = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aG(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bni();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(m.n(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c rS = com.baidu.tieba.tbadkCore.videoupload.b.rS(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.fEW);
        String str2 = rS != null ? rS.fEQ : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = rS != null ? rS.fER : 0;
        if (i2 < z && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < z) {
            R(i2, z, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, z, length);
            R(i2, z, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                R(i2, z, 40);
                this.fEV = b(k, length, z2, str2);
                R(i2, z, 55);
                if (i3 == z) {
                    videoBlockUploadResult = c(a, i3, z2, z);
                } else if (i3 % this.fEW == 0) {
                    videoBlockUploadResult = b(a, i3, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, z2, z);
                }
                R(i2, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.rR(k);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.m(k, str2, i3);
                R(i2, z, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.rR(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void R(int i, int i2, int i3) {
        if (this.fEX != null) {
            this.fEX.as((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.chunkLength * i));
        } else {
            i3 = this.chunkLength;
        }
        byte[] bArr = new byte[i3];
        try {
            z = randomAccessFile.read(bArr, 0, i3) != -1;
        } catch (IOException e) {
            z = false;
        }
        if (z) {
            return bArr;
        }
        return null;
    }

    private int z(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.ajt = true;
        if (this.fEV != null) {
            this.fEV.eg();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fEW;
        int length = bArr.length;
        int i6 = (i / this.fEW) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fEW);
        } else {
            i4 = this.fEW;
        }
        a(this.fEV, i5, length, i4, i6, bArr);
        this.fEV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fEV);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fEW;
        int length = bArr.length;
        int i6 = i / this.fEW;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fEW);
        } else {
            i4 = this.fEW;
        }
        a(this.fEV, i5, length, i4, i6, bArr);
        this.fEV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fEV);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fEW == 0) {
            i4 = i / this.fEW;
        } else {
            i4 = (i / this.fEW) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fEW);
        } else {
            i5 = this.fEW;
        }
        a(this.fEV, i5, length, i5, i4, bArr);
        this.fEV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fEV);
    }

    private VideoBlockUploadResult a(z zVar) {
        int vb;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.ajt) {
            vb = zVar.va();
            errMsg = zVar.getErrorString();
        } else {
            String uB = zVar.uB();
            if (zVar.uW().vS().oH()) {
                i objectWithJsonStr = i.objectWithJsonStr(uB, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        vb = errorCode;
                    }
                }
                errMsg = null;
                vb = 0;
            } else if (zVar.vb() == 200) {
                vb = zVar.va();
                errMsg = zVar.getErrorString();
            } else {
                vb = zVar.vb();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(vb);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private z b(String str, long j, int i, String str2) {
        z zVar = new z();
        zVar.n("forum_id", this.forumId);
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        zVar.n("total_length", String.valueOf(j));
        zVar.n("video_md5", str);
        zVar.n("block_num", String.valueOf(i));
        zVar.n("upload_id", str2);
        return zVar;
    }

    private void a(z zVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (zVar != null) {
            zVar.n("chunk_no", String.valueOf(i));
            zVar.n("chunk_length", String.valueOf(j));
            zVar.n("chunk_num", String.valueOf(i2));
            zVar.n("block_no", String.valueOf(i3));
            zVar.d("video_chunk", bArr);
        }
    }
}
