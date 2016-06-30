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
    private boolean afq = false;
    private final int chunkLength;
    private ab fah;
    private final int fai;
    private InterfaceC0080a faj;
    private final String forumId;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080a {
        void J(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fai = i2 / i;
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        this.faj = interfaceC0080a;
    }

    public VideoFinishResult c(String str, File file) {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.bdn();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String d = t.d(m.m(file));
        if (!StringUtils.isNull(d)) {
            d = d.toLowerCase();
        }
        c pO = b.pO(d);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int x = x(length, this.chunkLength);
        int x2 = x(x, this.fai);
        String str2 = pO != null ? pO.faf : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i = pO != null ? pO.fag : 0;
        if (i < x && randomAccessFile.skipBytes(this.chunkLength * i) < this.chunkLength * i) {
            randomAccessFile.close();
            return null;
        }
        while (i < x) {
            K(i, x, 10);
            int i2 = i + 1;
            byte[] a = a(randomAccessFile, i, x, length);
            K(i, x, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                K(i, x, 40);
                this.fah = b(d, length, x2, str2);
                K(i, x, 55);
                if (i2 == x) {
                    videoBlockUploadResult = c(a, i2, x2, x);
                } else if (i2 % this.fai == 0) {
                    videoBlockUploadResult = b(a, i2, x2, x);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i2, a, x2, x);
                }
                K(i, x, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    videoFinishResult.setSuccess(false);
                    if (videoFinishResult.getErrorNo() == 320033) {
                        b.pN(d);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                b.m(d, str2, i2);
                K(i, x, 100);
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
        b.pN(d);
        videoFinishResult.setVideoMd5(d);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void K(int i, int i2, int i3) {
        if (this.faj != null) {
            this.faj.J(i, i2, i3);
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

    private int x(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    public void cancel() {
        this.afq = true;
        if (this.fah != null) {
            this.fah.dm();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fai;
        int length = bArr.length;
        int i6 = (i / this.fai) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fai);
        } else {
            i4 = this.fai;
        }
        a(this.fah, i5, length, i4, i6, bArr);
        this.fah.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fah);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fai;
        int length = bArr.length;
        int i6 = i / this.fai;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fai);
        } else {
            i4 = this.fai;
        }
        a(this.fah, i5, length, i4, i6, bArr);
        this.fah.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fah);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fai == 0) {
            i4 = i / this.fai;
        } else {
            i4 = (i / this.fai) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fai);
        } else {
            i5 = this.fai;
        }
        a(this.fah, i5, length, i5, i4, bArr);
        this.fah.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fah);
    }

    private VideoBlockUploadResult a(ab abVar) {
        int tD;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.afq) {
            tD = abVar.tC();
            errMsg = abVar.getErrorString();
        } else {
            String td = abVar.td();
            if (abVar.ty().uv().nU()) {
                i objectWithJsonStr = i.objectWithJsonStr(td, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        tD = errorCode;
                    }
                }
                errMsg = null;
                tD = 0;
            } else if (abVar.tD() == 0) {
                tD = abVar.tC();
                errMsg = abVar.getErrorString();
            } else {
                tD = abVar.tD();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(tD);
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
