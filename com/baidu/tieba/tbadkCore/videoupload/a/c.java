package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean aif = false;
    private final int chunkLength;
    private final String forumId;
    private y fso;
    private final int fsp;
    private e fsq;

    public c(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fsp = i2 / i;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fsq = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aD(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.biN();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(l.n(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c qS = com.baidu.tieba.tbadkCore.videoupload.b.qS(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int y = y(length, this.chunkLength);
        int y2 = y(y, this.fsp);
        String str2 = qS != null ? qS.fsj : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = qS != null ? qS.fsk : 0;
        if (i2 < y && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < y) {
            R(i2, y, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, y, length);
            R(i2, y, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                R(i2, y, 40);
                this.fso = b(k, length, y2, str2);
                R(i2, y, 55);
                if (i3 == y) {
                    videoBlockUploadResult = c(a, i3, y2, y);
                } else if (i3 % this.fsp == 0) {
                    videoBlockUploadResult = b(a, i3, y2, y);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, y2, y);
                }
                R(i2, y, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.qR(k);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.n(k, str2, i3);
                R(i2, y, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.qR(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void R(int i, int i2, int i3) {
        if (this.fsq != null) {
            this.fsq.ae((i + (i3 / 100.0f)) / i2);
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

    private int y(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.aif = true;
        if (this.fso != null) {
            this.fso.ee();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fsp;
        int length = bArr.length;
        int i6 = (i / this.fsp) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fsp);
        } else {
            i4 = this.fsp;
        }
        a(this.fso, i5, length, i4, i6, bArr);
        this.fso.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fso);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fsp;
        int length = bArr.length;
        int i6 = i / this.fsp;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fsp);
        } else {
            i4 = this.fsp;
        }
        a(this.fso, i5, length, i4, i6, bArr);
        this.fso.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fso);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fsp == 0) {
            i4 = i / this.fsp;
        } else {
            i4 = (i / this.fsp) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fsp);
        } else {
            i5 = this.fsp;
        }
        a(this.fso, i5, length, i5, i4, bArr);
        this.fso.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fso);
    }

    private VideoBlockUploadResult a(y yVar) {
        int uH;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aif) {
            uH = yVar.uG();
            errMsg = yVar.getErrorString();
        } else {
            String ug = yVar.ug();
            if (yVar.uC().vw().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(ug, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        uH = errorCode;
                    }
                }
                errMsg = null;
                uH = 0;
            } else if (yVar.uH() == 200) {
                uH = yVar.uG();
                errMsg = yVar.getErrorString();
            } else {
                uH = yVar.uH();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(uH);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private y b(String str, long j, int i, String str2) {
        y yVar = new y();
        yVar.n("forum_id", this.forumId);
        yVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        yVar.n("total_length", String.valueOf(j));
        yVar.n("video_md5", str);
        yVar.n("block_num", String.valueOf(i));
        yVar.n("upload_id", str2);
        return yVar;
    }

    private void a(y yVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (yVar != null) {
            yVar.n("chunk_no", String.valueOf(i));
            yVar.n("chunk_length", String.valueOf(j));
            yVar.n("chunk_num", String.valueOf(i2));
            yVar.n("block_no", String.valueOf(i3));
            yVar.d("video_chunk", bArr);
        }
    }
}
