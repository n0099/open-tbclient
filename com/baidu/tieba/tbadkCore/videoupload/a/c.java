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
    private boolean bVG = false;
    private final int chunkLength;
    private final String forumId;
    private h iGY;
    private x iIP;
    private final int iIQ;
    private e iIR;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.iIQ = i2 / i;
        this.iGY = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.iIR = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bs(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.cfu();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String j = s.j(m.F(file));
        if (!StringUtils.isNull(j)) {
            j = j.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c CP = com.baidu.tieba.tbadkCore.videoupload.b.CP(j);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int t = t(length, this.chunkLength);
        int t2 = t(t, this.iIQ);
        String str2 = CP != null ? CP.iIL : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = CP != null ? CP.iIM : 0;
        if (i2 < t && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < t) {
            af(i2, t, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, t, length);
            af(i2, t, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                af(i2, t, 40);
                this.iIP = b(j, length, t2, str2);
                af(i2, t, 55);
                if (i3 == t) {
                    videoBlockUploadResult = d(a, i3, t2, t);
                } else if (i3 % this.iIQ == 0) {
                    videoBlockUploadResult = c(a, i3, t2, t);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = a(i3, a, t2, t);
                }
                af(i2, t, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.iGY != null) {
                        this.iGY.g(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.CO(j);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new am("c12024").bJ("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.u(j, str2, i3);
                af(i2, t, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.CO(j);
        videoFinishResult.setVideoMd5(j);
        randomAccessFile.close();
        if (this.iGY != null) {
            this.iGY.bEe();
        }
        return videoFinishResult;
    }

    private void af(int i, int i2, int i3) {
        if (this.iIR != null) {
            this.iIR.aM((i + (i3 / 100.0f)) / i2);
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

    private int t(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.bVG = true;
        if (this.iIP != null) {
            this.iIP.ji();
        }
    }

    private VideoBlockUploadResult a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.iIQ;
        int length = bArr.length;
        int i6 = (i / this.iIQ) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.iIQ);
        } else {
            i4 = this.iIQ;
        }
        a(this.iIP, i5, length, i4, i6, bArr);
        this.iIP.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.iIP);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.iIQ;
        int length = bArr.length;
        int i6 = i / this.iIQ;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.iIQ);
        } else {
            i4 = this.iIQ;
        }
        a(this.iIP, i5, length, i4, i6, bArr);
        this.iIP.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.iIP);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.iIQ == 0) {
            i4 = i / this.iIQ;
        } else {
            i4 = (i / this.iIQ) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.iIQ);
        } else {
            i5 = this.iIQ;
        }
        a(this.iIP, i5, length, i5, i4, bArr);
        this.iIP.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.iIP);
    }

    private VideoBlockUploadResult b(x xVar) {
        int acJ;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.bVG) {
            acJ = xVar.acI();
            errMsg = xVar.getErrorString();
        } else {
            String acj = xVar.acj();
            if (xVar.acE().adD().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(acj, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        acJ = errorCode;
                    }
                }
                errMsg = null;
                acJ = 0;
            } else if (xVar.acJ() == 200) {
                acJ = xVar.acI();
                errMsg = xVar.getErrorString();
            } else {
                acJ = xVar.acJ();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(acJ);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private x b(String str, long j, int i, String str2) {
        x xVar = new x();
        xVar.x("forum_id", this.forumId);
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        xVar.x("total_length", String.valueOf(j));
        xVar.x("video_md5", str);
        xVar.x("block_num", String.valueOf(i));
        xVar.x("upload_id", str2);
        return xVar;
    }

    private void a(x xVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (xVar != null) {
            xVar.x("chunk_no", String.valueOf(i));
            xVar.x("chunk_length", String.valueOf(j));
            xVar.x("chunk_num", String.valueOf(i2));
            xVar.x("block_no", String.valueOf(i3));
            xVar.d("video_chunk", bArr);
        }
    }
}
