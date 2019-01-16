package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean aNc = false;
    private final int chunkLength;
    private final String forumId;
    private h hqL;
    private x hsD;
    private final int hsE;
    private e hsF;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.hsE = i2 / i;
        this.hqL = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hsF = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aW(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bFW();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String i2 = s.i(l.x(file));
        if (!StringUtils.isNull(i2)) {
            i2 = i2.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c wp = com.baidu.tieba.tbadkCore.videoupload.b.wp(i2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int o = o(length, this.chunkLength);
        int o2 = o(o, this.hsE);
        String str2 = wp != null ? wp.hsz : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i3 = wp != null ? wp.hsA : 0;
        if (i3 < o && randomAccessFile.skipBytes(this.chunkLength * i3) < this.chunkLength * i3) {
            randomAccessFile.close();
            return null;
        }
        while (i3 < o) {
            ac(i3, o, 10);
            int i4 = i3 + 1;
            byte[] a = a(randomAccessFile, i3, o, length);
            ac(i3, o, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ac(i3, o, 40);
                this.hsD = b(i2, length, o2, str2);
                ac(i3, o, 55);
                if (i4 == o) {
                    videoBlockUploadResult = d(a, i4, o2, o);
                } else if (i4 % this.hsE == 0) {
                    videoBlockUploadResult = c(a, i4, o2, o);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = a(i4, a, o2, o);
                }
                ac(i3, o, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.hqL != null) {
                        this.hqL.e(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.wo(i2);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new am("c12024").aB("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.m(i2, str2, i4);
                ac(i3, o, 100);
            }
            i3++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.wo(i2);
        videoFinishResult.setVideoMd5(i2);
        randomAccessFile.close();
        if (this.hqL != null) {
            this.hqL.bdE();
        }
        return videoFinishResult;
    }

    private void ac(int i, int i2, int i3) {
        if (this.hsF != null) {
            this.hsF.az((i + (i3 / 100.0f)) / i2);
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

    private int o(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.aNc = true;
        if (this.hsD != null) {
            this.hsD.jg();
        }
    }

    private VideoBlockUploadResult a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.hsE;
        int length = bArr.length;
        int i6 = (i / this.hsE) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hsE);
        } else {
            i4 = this.hsE;
        }
        a(this.hsD, i5, length, i4, i6, bArr);
        this.hsD.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.hsD);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.hsE;
        int length = bArr.length;
        int i6 = i / this.hsE;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hsE);
        } else {
            i4 = this.hsE;
        }
        a(this.hsD, i5, length, i4, i6, bArr);
        this.hsD.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.hsD);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.hsE == 0) {
            i4 = i / this.hsE;
        } else {
            i4 = (i / this.hsE) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.hsE);
        } else {
            i5 = this.hsE;
        }
        a(this.hsD, i5, length, i5, i4, bArr);
        this.hsD.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.hsD);
    }

    private VideoBlockUploadResult b(x xVar) {
        int DB;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aNc) {
            DB = xVar.DA();
            errMsg = xVar.getErrorString();
        } else {
            String Db = xVar.Db();
            if (xVar.Dw().Ev().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(Db, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        DB = errorCode;
                    }
                }
                errMsg = null;
                DB = 0;
            } else if (xVar.DB() == 200) {
                DB = xVar.DA();
                errMsg = xVar.getErrorString();
            } else {
                DB = xVar.DB();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(DB);
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
