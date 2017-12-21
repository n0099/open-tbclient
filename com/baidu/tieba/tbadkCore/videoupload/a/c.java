package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean aqi = false;
    private final int chunkLength;
    private final String forumId;
    private h gCU;
    private x gEK;
    private final int gEL;
    private e gEM;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.gEL = i2 / i;
        this.gCU = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gEM = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aH(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bxW();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String e = s.e(k.q(file));
        if (!StringUtils.isNull(e)) {
            e = e.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c tr = com.baidu.tieba.tbadkCore.videoupload.b.tr(e);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.gEL);
        String str2 = tr != null ? tr.gEG : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = tr != null ? tr.gEH : 0;
        if (i2 < z && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < z) {
            ab(i2, z, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, z, length);
            ab(i2, z, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ab(i2, z, 40);
                this.gEK = b(e, length, z2, str2);
                ab(i2, z, 55);
                if (i3 == z) {
                    videoBlockUploadResult = c(a, i3, z2, z);
                } else if (i3 % this.gEL == 0) {
                    videoBlockUploadResult = b(a, i3, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, z2, z);
                }
                ab(i2, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.gCU != null) {
                        this.gCU.f(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.tq(e);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.m(e, str2, i3);
                ab(i2, z, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.tq(e);
        videoFinishResult.setVideoMd5(e);
        randomAccessFile.close();
        if (this.gCU != null) {
            this.gCU.aNT();
        }
        return videoFinishResult;
    }

    private void ab(int i, int i2, int i3) {
        if (this.gEM != null) {
            this.gEM.am((i + (i3 / 100.0f)) / i2);
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
        this.aqi = true;
        if (this.gEK != null) {
            this.gEK.fo();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.gEL;
        int length = bArr.length;
        int i6 = (i / this.gEL) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gEL);
        } else {
            i4 = this.gEL;
        }
        a(this.gEK, i5, length, i4, i6, bArr);
        this.gEK.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.gEK);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.gEL;
        int length = bArr.length;
        int i6 = i / this.gEL;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gEL);
        } else {
            i4 = this.gEL;
        }
        a(this.gEK, i5, length, i4, i6, bArr);
        this.gEK.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.gEK);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.gEL == 0) {
            i4 = i / this.gEL;
        } else {
            i4 = (i / this.gEL) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.gEL);
        } else {
            i5 = this.gEL;
        }
        a(this.gEK, i5, length, i5, i4, bArr);
        this.gEK.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.gEK);
    }

    private VideoBlockUploadResult b(x xVar) {
        int uS;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aqi) {
            uS = xVar.uR();
            errMsg = xVar.getErrorString();
        } else {
            String us = xVar.us();
            if (xVar.uN().vL().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(us, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        uS = errorCode;
                    }
                }
                errMsg = null;
                uS = 0;
            } else if (xVar.uS() == 200) {
                uS = xVar.uR();
                errMsg = xVar.getErrorString();
            } else {
                uS = xVar.uS();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(uS);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private x b(String str, long j, int i, String str2) {
        x xVar = new x();
        xVar.n("forum_id", this.forumId);
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        xVar.n("total_length", String.valueOf(j));
        xVar.n("video_md5", str);
        xVar.n("block_num", String.valueOf(i));
        xVar.n("upload_id", str2);
        return xVar;
    }

    private void a(x xVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (xVar != null) {
            xVar.n("chunk_no", String.valueOf(i));
            xVar.n("chunk_length", String.valueOf(j));
            xVar.n("chunk_num", String.valueOf(i2));
            xVar.n("block_no", String.valueOf(i3));
            xVar.d("video_chunk", bArr);
        }
    }
}
