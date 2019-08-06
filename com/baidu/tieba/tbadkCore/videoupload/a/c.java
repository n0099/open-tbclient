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
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean ceM = false;
    private final String forumId;
    private h jhv;
    private final int jjg;
    private x jjo;
    private final int jjp;
    private e jjq;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.jjg = i;
        this.jjp = i2 / i;
        this.jhv = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jjq = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bp(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.cqQ();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String h = s.h(m.z(file));
        if (!StringUtils.isNull(h)) {
            h = h.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c Fb = com.baidu.tieba.tbadkCore.videoupload.b.Fb(h);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int r = r(length, this.jjg);
        int r2 = r(r, this.jjp);
        String str2 = Fb != null ? Fb.jjk : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = Fb != null ? Fb.jjl : 0;
        if (i2 < r && randomAccessFile.skipBytes(this.jjg * i2) < this.jjg * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < r) {
            ah(i2, r, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, r, length);
            ah(i2, r, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ah(i2, r, 40);
                this.jjo = b(h, length, r2, str2);
                ah(i2, r, 55);
                if (i3 == r) {
                    videoBlockUploadResult = d(a, i3, r2, r);
                } else if (i3 % this.jjp == 0) {
                    videoBlockUploadResult = c(a, i3, r2, r);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, r2, r);
                }
                ah(i2, r, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.jhv != null) {
                        this.jhv.h(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.Fa(h);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new an("c12024").bT("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.t(h, str2, i3);
                ah(i2, r, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.Fa(h);
        videoFinishResult.setVideoMd5(h);
        randomAccessFile.close();
        if (this.jhv != null) {
            this.jhv.bOP();
        }
        return videoFinishResult;
    }

    private void ah(int i, int i2, int i3) {
        if (this.jjq != null) {
            this.jjq.aR((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.jjg * i));
        } else {
            i3 = this.jjg;
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

    private int r(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.ceM = true;
        if (this.jjo != null) {
            this.jjo.ik();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.jjp;
        int length = bArr.length;
        int i6 = (i / this.jjp) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.jjp);
        } else {
            i4 = this.jjp;
        }
        a(this.jjo, i5, length, i4, i6, bArr);
        this.jjo.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.jjo);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.jjp;
        int length = bArr.length;
        int i6 = i / this.jjp;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.jjp);
        } else {
            i4 = this.jjp;
        }
        a(this.jjo, i5, length, i4, i6, bArr);
        this.jjo.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.jjo);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.jjp == 0) {
            i4 = i / this.jjp;
        } else {
            i4 = (i / this.jjp) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.jjp);
        } else {
            i5 = this.jjp;
        }
        a(this.jjo, i5, length, i5, i4, bArr);
        this.jjo.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.jjo);
    }

    private VideoBlockUploadResult b(x xVar) {
        int aiL;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.ceM) {
            aiL = xVar.aiK();
            errMsg = xVar.getErrorString();
        } else {
            String ail = xVar.ail();
            if (xVar.aiG().ajH().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(ail, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        aiL = errorCode;
                    }
                }
                errMsg = null;
                aiL = 0;
            } else if (xVar.aiL() == 200) {
                aiL = xVar.aiK();
                errMsg = xVar.getErrorString();
            } else {
                aiL = xVar.aiL();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(aiL);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private x b(String str, long j, int i, String str2) {
        x xVar = new x();
        xVar.o("forum_id", this.forumId);
        xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        xVar.o("total_length", String.valueOf(j));
        xVar.o("video_md5", str);
        xVar.o("block_num", String.valueOf(i));
        xVar.o("upload_id", str2);
        return xVar;
    }

    private void a(x xVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (xVar != null) {
            xVar.o("chunk_no", String.valueOf(i));
            xVar.o("chunk_length", String.valueOf(j));
            xVar.o("chunk_num", String.valueOf(i2));
            xVar.o("block_no", String.valueOf(i3));
            xVar.d("video_chunk", bArr);
        }
    }
}
