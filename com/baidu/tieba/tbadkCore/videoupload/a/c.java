package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.l.g;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean fnj = false;
    private final String forumId;
    private g noh;
    private final int nqk;
    private z nqs;
    private final int nqt;
    private e nqu;

    public c(String str, int i, int i2, g gVar) {
        this.forumId = str;
        this.nqk = i;
        this.nqt = i2 / i;
        this.noh = gVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.nqu = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bV(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.dMD();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c SF = com.baidu.tieba.tbadkCore.videoupload.b.SF(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int I = I(length, this.nqk);
        int I2 = I(I, this.nqt);
        String str2 = SF != null ? SF.nqo : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = SF != null ? SF.nqp : 0;
        if (i2 < I && randomAccessFile.skipBytes(this.nqk * i2) < this.nqk * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < I) {
            ah(i2, I, 10);
            int i3 = i2 + 1;
            byte[] a2 = a(randomAccessFile, i2, I, length);
            ah(i2, I, 25);
            if (a2 == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a2.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ah(i2, I, 40);
                this.nqs = c(md5, length, I2, str2);
                ah(i2, I, 55);
                if (i3 == I) {
                    videoBlockUploadResult = d(a2, i3, I2, I);
                } else if (i3 % this.nqt == 0) {
                    videoBlockUploadResult = c(a2, i3, I2, I);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a2, I2, I);
                }
                ah(i2, I, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.noh != null) {
                        this.noh.p(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.SE(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new aq("c12024").dW("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.w(md5, str2, i3);
                ah(i2, I, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.SE(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.noh != null) {
            this.noh.deI();
        }
        return videoFinishResult;
    }

    private void ah(int i, int i2, int i3) {
        if (this.nqu != null) {
            this.nqu.aX((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.nqk * i));
        } else {
            i3 = this.nqk;
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

    private int I(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fnj = true;
        if (this.nqs != null) {
            this.nqs.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.nqt;
        int length = bArr.length;
        int i6 = (i / this.nqt) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.nqt);
        } else {
            i4 = this.nqt;
        }
        a(this.nqs, i5, length, i4, i6, bArr);
        this.nqs.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return c(this.nqs);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.nqt;
        int length = bArr.length;
        int i6 = i / this.nqt;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.nqt);
        } else {
            i4 = this.nqt;
        }
        a(this.nqs, i5, length, i4, i6, bArr);
        this.nqs.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return c(this.nqs);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.nqt == 0) {
            i4 = i / this.nqt;
        } else {
            i4 = (i / this.nqt) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.nqt);
        } else {
            i5 = this.nqt;
        }
        a(this.nqs, i5, length, i5, i4, bArr);
        this.nqs.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return c(this.nqs);
    }

    private VideoBlockUploadResult c(z zVar) {
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        int i = 0;
        if (this.fnj) {
            i = zVar.getServerErrorCode();
            errMsg = zVar.getErrorString();
        } else {
            String postMultiNetData = zVar.postMultiNetData();
            if (zVar.brX().bsH().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(postMultiNetData, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        i = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                    }
                }
                errMsg = null;
            } else if (zVar.getNetErrorCode() == 200) {
                i = zVar.getServerErrorCode();
                errMsg = zVar.getErrorString();
            } else {
                i = zVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(i);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private z c(String str, long j, int i, String str2) {
        z zVar = new z();
        zVar.addPostData("forum_id", this.forumId);
        zVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        zVar.addPostData("total_length", String.valueOf(j));
        zVar.addPostData("video_md5", str);
        zVar.addPostData("block_num", String.valueOf(i));
        zVar.addPostData("upload_id", str2);
        return zVar;
    }

    private void a(z zVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (zVar != null) {
            zVar.addPostData("chunk_no", String.valueOf(i));
            zVar.addPostData("chunk_length", String.valueOf(j));
            zVar.addPostData("chunk_num", String.valueOf(i2));
            zVar.addPostData("block_no", String.valueOf(i3));
            zVar.addPostData("video_chunk", bArr);
        }
    }
}
