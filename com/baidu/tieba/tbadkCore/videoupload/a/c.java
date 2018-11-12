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
    private boolean aIY = false;
    private final int chunkLength;
    private final String forumId;
    private h hfy;
    private x hhp;
    private final int hhq;
    private e hhr;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.hhq = i2 / i;
        this.hfy = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hhr = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aU(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bCB();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String i2 = s.i(l.w(file));
        if (!StringUtils.isNull(i2)) {
            i2 = i2.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c vv = com.baidu.tieba.tbadkCore.videoupload.b.vv(i2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int o = o(length, this.chunkLength);
        int o2 = o(o, this.hhq);
        String str2 = vv != null ? vv.hhl : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i3 = vv != null ? vv.hhm : 0;
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
                this.hhp = b(i2, length, o2, str2);
                ac(i3, o, 55);
                if (i4 == o) {
                    videoBlockUploadResult = d(a, i4, o2, o);
                } else if (i4 % this.hhq == 0) {
                    videoBlockUploadResult = c(a, i4, o2, o);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = a(i4, a, o2, o);
                }
                ac(i3, o, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.hfy != null) {
                        this.hfy.e(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.vu(i2);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new am("c12024").ax("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.l(i2, str2, i4);
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
        com.baidu.tieba.tbadkCore.videoupload.b.vu(i2);
        videoFinishResult.setVideoMd5(i2);
        randomAccessFile.close();
        if (this.hfy != null) {
            this.hfy.baA();
        }
        return videoFinishResult;
    }

    private void ac(int i, int i2, int i3) {
        if (this.hhr != null) {
            this.hhr.az((i + (i3 / 100.0f)) / i2);
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
        this.aIY = true;
        if (this.hhp != null) {
            this.hhp.jg();
        }
    }

    private VideoBlockUploadResult a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.hhq;
        int length = bArr.length;
        int i6 = (i / this.hhq) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hhq);
        } else {
            i4 = this.hhq;
        }
        a(this.hhp, i5, length, i4, i6, bArr);
        this.hhp.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.hhp);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.hhq;
        int length = bArr.length;
        int i6 = i / this.hhq;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hhq);
        } else {
            i4 = this.hhq;
        }
        a(this.hhp, i5, length, i4, i6, bArr);
        this.hhp.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.hhp);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.hhq == 0) {
            i4 = i / this.hhq;
        } else {
            i4 = (i / this.hhq) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.hhq);
        } else {
            i5 = this.hhq;
        }
        a(this.hhp, i5, length, i5, i4, bArr);
        this.hhp.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.hhp);
    }

    private VideoBlockUploadResult b(x xVar) {
        int Ck;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aIY) {
            Ck = xVar.Cj();
            errMsg = xVar.getErrorString();
        } else {
            String BK = xVar.BK();
            if (xVar.Cf().De().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(BK, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        Ck = errorCode;
                    }
                }
                errMsg = null;
                Ck = 0;
            } else if (xVar.Ck() == 200) {
                Ck = xVar.Cj();
                errMsg = xVar.getErrorString();
            } else {
                Ck = xVar.Ck();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(Ck);
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
