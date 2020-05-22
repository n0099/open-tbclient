package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean dZV = false;
    private final String forumId;
    private h lmg;
    private final int lnZ;
    private x loj;
    private final int lok;
    private e lol;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.lnZ = i;
        this.lok = i2 / i;
        this.lmg = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.lol = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bG(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.deG();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(m.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c MR = com.baidu.tieba.tbadkCore.videoupload.b.MR(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int t = t(length, this.lnZ);
        int t2 = t(t, this.lok);
        String str2 = MR != null ? MR.loe : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = MR != null ? MR.lof : 0;
        if (i2 < t && randomAccessFile.skipBytes(this.lnZ * i2) < this.lnZ * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < t) {
            ad(i2, t, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, t, length);
            ad(i2, t, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ad(i2, t, 40);
                this.loj = c(md5, length, t2, str2);
                ad(i2, t, 55);
                if (i3 == t) {
                    videoBlockUploadResult = d(a, i3, t2, t);
                } else if (i3 % this.lok == 0) {
                    videoBlockUploadResult = c(a, i3, t2, t);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, t2, t);
                }
                ad(i2, t, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.lmg != null) {
                        this.lmg.l(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.MQ(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new an("c12024").dh("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.t(md5, str2, i3);
                ad(i2, t, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.MQ(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.lmg != null) {
            this.lmg.cye();
        }
        return videoFinishResult;
    }

    private void ad(int i, int i2, int i3) {
        if (this.lol != null) {
            this.lol.at((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.lnZ * i));
        } else {
            i3 = this.lnZ;
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

    private int t(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.dZV = true;
        if (this.loj != null) {
            this.loj.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.lok;
        int length = bArr.length;
        int i6 = (i / this.lok) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.lok);
        } else {
            i4 = this.lok;
        }
        a(this.loj, i5, length, i4, i6, bArr);
        this.loj.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return c(this.loj);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.lok;
        int length = bArr.length;
        int i6 = i / this.lok;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.lok);
        } else {
            i4 = this.lok;
        }
        a(this.loj, i5, length, i4, i6, bArr);
        this.loj.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return c(this.loj);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.lok == 0) {
            i4 = i / this.lok;
        } else {
            i4 = (i / this.lok) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.lok);
        } else {
            i5 = this.lok;
        }
        a(this.loj, i5, length, i5, i4, bArr);
        this.loj.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return c(this.loj);
    }

    private VideoBlockUploadResult c(x xVar) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.dZV) {
            netErrorCode = xVar.getServerErrorCode();
            errMsg = xVar.getErrorString();
        } else {
            String postMultiNetData = xVar.postMultiNetData();
            if (xVar.aUA().aVb().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(postMultiNetData, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        netErrorCode = errorCode;
                    }
                }
                errMsg = null;
                netErrorCode = 0;
            } else if (xVar.getNetErrorCode() == 200) {
                netErrorCode = xVar.getServerErrorCode();
                errMsg = xVar.getErrorString();
            } else {
                netErrorCode = xVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(netErrorCode);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private x c(String str, long j, int i, String str2) {
        x xVar = new x();
        xVar.addPostData("forum_id", this.forumId);
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        xVar.addPostData("total_length", String.valueOf(j));
        xVar.addPostData("video_md5", str);
        xVar.addPostData("block_num", String.valueOf(i));
        xVar.addPostData("upload_id", str2);
        return xVar;
    }

    private void a(x xVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (xVar != null) {
            xVar.addPostData("chunk_no", String.valueOf(i));
            xVar.addPostData("chunk_length", String.valueOf(j));
            xVar.addPostData("chunk_num", String.valueOf(i2));
            xVar.addPostData("block_no", String.valueOf(i3));
            xVar.addPostData("video_chunk", bArr);
        }
    }
}
