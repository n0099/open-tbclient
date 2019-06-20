package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private boolean cdC = false;
    private final int chunkLength;
    private final String forumId;
    private h iZX;
    private x jbO;
    private final int jbP;
    private e jbQ;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.jbP = i2 / i;
        this.iZX = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jbQ = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bo(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.cnB();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String h = s.h(m.z(file));
        if (!StringUtils.isNull(h)) {
            h = h.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c En = com.baidu.tieba.tbadkCore.videoupload.b.En(h);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int r = r(length, this.chunkLength);
        int r2 = r(r, this.jbP);
        String str2 = En != null ? En.jbK : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = En != null ? En.jbL : 0;
        if (i2 < r && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < r) {
            ag(i2, r, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, r, length);
            ag(i2, r, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ag(i2, r, 40);
                this.jbO = b(h, length, r2, str2);
                ag(i2, r, 55);
                if (i3 == r) {
                    videoBlockUploadResult = d(a, i3, r2, r);
                } else if (i3 % this.jbP == 0) {
                    videoBlockUploadResult = c(a, i3, r2, r);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, r2, r);
                }
                ag(i2, r, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.iZX != null) {
                        this.iZX.h(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.Em(h);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new am("c12024").bT("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.t(h, str2, i3);
                ag(i2, r, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.Em(h);
        videoFinishResult.setVideoMd5(h);
        randomAccessFile.close();
        if (this.iZX != null) {
            this.iZX.bLT();
        }
        return videoFinishResult;
    }

    private void ag(int i, int i2, int i3) {
        if (this.jbQ != null) {
            this.jbQ.aQ((i + (i3 / 100.0f)) / i2);
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

    private int r(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.cdC = true;
        if (this.jbO != null) {
            this.jbO.ia();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.jbP;
        int length = bArr.length;
        int i6 = (i / this.jbP) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.jbP);
        } else {
            i4 = this.jbP;
        }
        a(this.jbO, i5, length, i4, i6, bArr);
        this.jbO.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.jbO);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.jbP;
        int length = bArr.length;
        int i6 = i / this.jbP;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.jbP);
        } else {
            i4 = this.jbP;
        }
        a(this.jbO, i5, length, i4, i6, bArr);
        this.jbO.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.jbO);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.jbP == 0) {
            i4 = i / this.jbP;
        } else {
            i4 = (i / this.jbP) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.jbP);
        } else {
            i5 = this.jbP;
        }
        a(this.jbO, i5, length, i5, i4, bArr);
        this.jbO.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.jbO);
    }

    private VideoBlockUploadResult b(x xVar) {
        int ahH;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.cdC) {
            ahH = xVar.ahG();
            errMsg = xVar.getErrorString();
        } else {
            String ahh = xVar.ahh();
            if (xVar.ahC().aiC().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(ahh, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        ahH = errorCode;
                    }
                }
                errMsg = null;
                ahH = 0;
            } else if (xVar.ahH() == 200) {
                ahH = xVar.ahG();
                errMsg = xVar.getErrorString();
            } else {
                ahH = xVar.ahH();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(ahH);
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
