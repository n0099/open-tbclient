package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ax;
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
    private boolean aiB = false;
    private final int chunkLength;
    private final String forumId;
    private ab fxM;
    private final int fxN;
    private InterfaceC0082a fxO;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        void P(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fxN = i2 / i;
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.fxO = interfaceC0082a;
    }

    public VideoFinishResult a(String str, File file, long j) throws IOException {
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.bkS();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(m.n(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        c rx = b.rx(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.fxN);
        String str2 = rx != null ? rx.fxK : null;
        VideoBlockUploadResult videoBlockUploadResult = null;
        int i = rx != null ? rx.fxL : 0;
        if (i < z && randomAccessFile.skipBytes(this.chunkLength * i) < this.chunkLength * i) {
            randomAccessFile.close();
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (i < z) {
            Q(i, z, 10);
            int i2 = i + 1;
            byte[] a = a(randomAccessFile, i, z, length);
            Q(i, z, 25);
            if (a != null && a.length > 0) {
                Q(i, z, 40);
                this.fxM = b(k, length, z2, str2);
                Q(i, z, 55);
                if (i2 == z) {
                    videoBlockUploadResult = c(a, i2, z2, z);
                } else if (i2 % this.fxN == 0) {
                    videoBlockUploadResult = b(a, i2, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i2, a, z2, z);
                }
                Q(i, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    videoFinishResult.setSuccess(false);
                    if (videoFinishResult.getErrorNo() == 320033) {
                        b.rw(k);
                    }
                    randomAccessFile.close();
                    a(k, length, j, i2 % this.fxN, z2, System.currentTimeMillis() - currentTimeMillis, false);
                    return videoFinishResult;
                }
                b.m(k, str2, i2);
                Q(i, z, 100);
            }
            i++;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        videoFinishResult.setSuccess(true);
        if (videoBlockUploadResult != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult.video_url);
        }
        a(k, length, j, z2, z2, System.currentTimeMillis() - currentTimeMillis, false);
        b.rw(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void a(String str, long j, long j2, int i, int i2, long j3, boolean z) {
        ax axVar = new ax("c11684");
        axVar.ab("video_md5", str);
        axVar.g("video_size", j);
        axVar.g("video_duration", j2);
        axVar.ab("video_resolution", "480x480");
        axVar.s("sum_block", i2);
        axVar.s("block_num", i);
        axVar.g("up_time", j3);
        axVar.s("is_success", z ? 1 : 0);
        TiebaStatic.log(axVar);
    }

    private void Q(int i, int i2, int i3) {
        if (this.fxO != null) {
            this.fxO.P(i, i2, i3);
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

    public void cancel() {
        this.aiB = true;
        if (this.fxM != null) {
            this.fxM.eg();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fxN;
        int length = bArr.length;
        int i6 = (i / this.fxN) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fxN);
        } else {
            i4 = this.fxN;
        }
        a(this.fxM, i5, length, i4, i6, bArr);
        this.fxM.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fxM);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fxN;
        int length = bArr.length;
        int i6 = i / this.fxN;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fxN);
        } else {
            i4 = this.fxN;
        }
        a(this.fxM, i5, length, i4, i6, bArr);
        this.fxM.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fxM);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fxN == 0) {
            i4 = i / this.fxN;
        } else {
            i4 = (i / this.fxN) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fxN);
        } else {
            i5 = this.fxN;
        }
        a(this.fxM, i5, length, i5, i4, bArr);
        this.fxM.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fxM);
    }

    private VideoBlockUploadResult a(ab abVar) {
        int uX;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aiB) {
            uX = abVar.uW();
            errMsg = abVar.getErrorString();
        } else {
            String ux = abVar.ux();
            if (abVar.uS().vO().oF()) {
                i objectWithJsonStr = i.objectWithJsonStr(ux, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        uX = errorCode;
                    }
                }
                errMsg = null;
                uX = 0;
            } else if (abVar.uX() == 0) {
                uX = abVar.uW();
                errMsg = abVar.getErrorString();
            } else {
                uX = abVar.uX();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(uX);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private ab b(String str, long j, int i, String str2) {
        ab abVar = new ab();
        abVar.n("forum_id", this.forumId);
        abVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        abVar.n("total_length", String.valueOf(j));
        abVar.n("video_md5", str);
        abVar.n("block_num", String.valueOf(i));
        abVar.n("upload_id", str2);
        return abVar;
    }

    private void a(ab abVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (abVar != null) {
            abVar.n("chunk_no", String.valueOf(i));
            abVar.n("chunk_length", String.valueOf(j));
            abVar.n("chunk_num", String.valueOf(i2));
            abVar.n("block_no", String.valueOf(i3));
            abVar.d("video_chunk", bArr);
        }
    }
}
