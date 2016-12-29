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
    private boolean aiU = false;
    private final int chunkLength;
    private z fjc;
    private final int fjd;
    private e fje;
    private final String forumId;

    public c(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fjd = i2 / i;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fje = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aC(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bhc();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(m.n(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c qy = com.baidu.tieba.tbadkCore.videoupload.b.qy(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int x = x(length, this.chunkLength);
        int x2 = x(x, this.fjd);
        String str2 = qy != null ? qy.fiX : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = qy != null ? qy.fiY : 0;
        if (i2 < x && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < x) {
            Q(i2, x, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, x, length);
            Q(i2, x, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                Q(i2, x, 40);
                this.fjc = b(k, length, x2, str2);
                Q(i2, x, 55);
                if (i3 == x) {
                    videoBlockUploadResult = c(a, i3, x2, x);
                } else if (i3 % this.fjd == 0) {
                    videoBlockUploadResult = b(a, i3, x2, x);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, x2, x);
                }
                Q(i2, x, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.qx(k);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.m(k, str2, i3);
                Q(i2, x, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.qx(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void Q(int i, int i2, int i3) {
        if (this.fje != null) {
            this.fje.al((i + (i3 / 100.0f)) / i2);
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

    private int x(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.aiU = true;
        if (this.fjc != null) {
            this.fjc.eg();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fjd;
        int length = bArr.length;
        int i6 = (i / this.fjd) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fjd);
        } else {
            i4 = this.fjd;
        }
        a(this.fjc, i5, length, i4, i6, bArr);
        this.fjc.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fjc);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fjd;
        int length = bArr.length;
        int i6 = i / this.fjd;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fjd);
        } else {
            i4 = this.fjd;
        }
        a(this.fjc, i5, length, i4, i6, bArr);
        this.fjc.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fjc);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fjd == 0) {
            i4 = i / this.fjd;
        } else {
            i4 = (i / this.fjd) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fjd);
        } else {
            i5 = this.fjd;
        }
        a(this.fjc, i5, length, i5, i4, bArr);
        this.fjc.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fjc);
    }

    private VideoBlockUploadResult a(z zVar) {
        int uN;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aiU) {
            uN = zVar.uM();
            errMsg = zVar.getErrorString();
        } else {
            String un = zVar.un();
            if (zVar.uI().vC().oH()) {
                i objectWithJsonStr = i.objectWithJsonStr(un, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        uN = errorCode;
                    }
                }
                errMsg = null;
                uN = 0;
            } else if (zVar.uN() == 200) {
                uN = zVar.uM();
                errMsg = zVar.getErrorString();
            } else {
                uN = zVar.uN();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(uN);
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
