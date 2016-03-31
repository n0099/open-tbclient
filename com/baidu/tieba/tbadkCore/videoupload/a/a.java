package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.b;
import com.baidu.tieba.tbadkCore.videoupload.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a {
    private boolean ajd = false;
    private final int chunkLength;
    private ab esi;
    private final int esj;
    private InterfaceC0086a esk;
    private final String forumId;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0086a {
        void K(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.esj = i2 / i;
    }

    public void a(InterfaceC0086a interfaceC0086a) {
        this.esk = interfaceC0086a;
    }

    public VideoFinishResult c(String str, File file) {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.aUy();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String d = t.d(m.m(file));
        if (!StringUtils.isNull(d)) {
            d = d.toLowerCase();
        }
        c oj = b.oj(d);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int w = w(length, this.chunkLength);
        int w2 = w(w, this.esj);
        String str2 = oj != null ? oj.esg : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i = oj != null ? oj.esh : 0;
        if (i < w && randomAccessFile.skipBytes(this.chunkLength * i) < this.chunkLength * i) {
            randomAccessFile.close();
            return null;
        }
        while (i < w) {
            L(i, w, 10);
            int i2 = i + 1;
            byte[] a = a(randomAccessFile, i, w, length);
            L(i, w, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                L(i, w, 40);
                this.esi = b(d, length, w2, str2);
                L(i, w, 55);
                if (i2 == w) {
                    videoBlockUploadResult = b(a, i2, w2, w);
                } else if (i2 % this.esj == 0) {
                    videoBlockUploadResult = a(a, i2, w2, w);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i2, a, w2, w);
                }
                L(i, w, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    videoFinishResult.setSuccess(false);
                    if (videoFinishResult.getErrorNo() == 320033) {
                        b.oi(d);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                b.l(d, str2, i2);
                L(i, w, 100);
            }
            i++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        videoFinishResult.setSuccess(true);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        b.oi(d);
        videoFinishResult.setVideoMd5(d);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void L(int i, int i2, int i3) {
        if (this.esk != null) {
            this.esk.K(i, i2, i3);
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

    private int w(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    public void cancel() {
        this.ajd = true;
        if (this.esi != null) {
            this.esi.gX();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.esj;
        int length = bArr.length;
        int i6 = (i / this.esj) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.esj);
        } else {
            i4 = this.esj;
        }
        a(this.esi, i5, length, i4, i6, bArr);
        this.esi.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.esi);
    }

    private VideoBlockUploadResult a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.esj;
        int length = bArr.length;
        int i6 = i / this.esj;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.esj);
        } else {
            i4 = this.esj;
        }
        a(this.esi, i5, length, i4, i6, bArr);
        this.esi.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.esi);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.esj == 0) {
            i4 = i / this.esj;
        } else {
            i4 = (i / this.esj) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.esj);
        } else {
            i5 = this.esj;
        }
        a(this.esi, i5, length, i5, i4, bArr);
        this.esi.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.esi);
    }

    private VideoBlockUploadResult a(ab abVar) {
        int vZ;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.ajd) {
            vZ = abVar.vY();
            errMsg = abVar.getErrorString();
        } else {
            String vz = abVar.vz();
            if (abVar.vU().wP().qC()) {
                i objectWithJsonStr = i.objectWithJsonStr(vz, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        vZ = errorCode;
                    }
                }
                errMsg = null;
                vZ = 0;
            } else if (abVar.vZ() == 0) {
                vZ = abVar.vY();
                errMsg = abVar.getErrorString();
            } else {
                vZ = abVar.vZ();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(vZ);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private ab b(String str, long j, int i, String str2) {
        ab abVar = new ab();
        abVar.p("forum_id", this.forumId);
        abVar.p("tbs", TbadkCoreApplication.m411getInst().getTbs());
        abVar.p("total_length", String.valueOf(j));
        abVar.p("video_md5", str);
        abVar.p("block_num", String.valueOf(i));
        abVar.p("upload_id", str2);
        return abVar;
    }

    private void a(ab abVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (abVar != null) {
            abVar.p("chunk_no", String.valueOf(i));
            abVar.p("chunk_length", String.valueOf(j));
            abVar.p("chunk_num", String.valueOf(i2));
            abVar.p("block_no", String.valueOf(i3));
            abVar.c("video_chunk", bArr);
        }
    }
}
