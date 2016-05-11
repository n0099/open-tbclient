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
    private boolean aeP = false;
    private final int chunkLength;
    private ab evr;
    private final int evs;
    private InterfaceC0078a evt;
    private final String forumId;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078a {
        void J(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.evs = i2 / i;
    }

    public void a(InterfaceC0078a interfaceC0078a) {
        this.evt = interfaceC0078a;
    }

    public VideoFinishResult c(String str, File file) {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.aUT();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String d = t.d(m.m(file));
        if (!StringUtils.isNull(d)) {
            d = d.toLowerCase();
        }
        c oh = b.oh(d);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int x = x(length, this.chunkLength);
        int x2 = x(x, this.evs);
        String str2 = oh != null ? oh.evp : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i = oh != null ? oh.evq : 0;
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
                this.evr = b(d, length, x2, str2);
                K(i, x, 55);
                if (i2 == x) {
                    videoBlockUploadResult = b(a, i2, x2, x);
                } else if (i2 % this.evs == 0) {
                    videoBlockUploadResult = a(a, i2, x2, x);
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
                        b.og(d);
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
        b.og(d);
        videoFinishResult.setVideoMd5(d);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void K(int i, int i2, int i3) {
        if (this.evt != null) {
            this.evt.J(i, i2, i3);
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
        this.aeP = true;
        if (this.evr != null) {
            this.evr.dl();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.evs;
        int length = bArr.length;
        int i6 = (i / this.evs) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.evs);
        } else {
            i4 = this.evs;
        }
        a(this.evr, i5, length, i4, i6, bArr);
        this.evr.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.evr);
    }

    private VideoBlockUploadResult a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.evs;
        int length = bArr.length;
        int i6 = i / this.evs;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.evs);
        } else {
            i4 = this.evs;
        }
        a(this.evr, i5, length, i4, i6, bArr);
        this.evr.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.evr);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.evs == 0) {
            i4 = i / this.evs;
        } else {
            i4 = (i / this.evs) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.evs);
        } else {
            i5 = this.evs;
        }
        a(this.evr, i5, length, i5, i4, bArr);
        this.evr.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.evr);
    }

    private VideoBlockUploadResult a(ab abVar) {
        int tF;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aeP) {
            tF = abVar.tE();
            errMsg = abVar.getErrorString();
        } else {
            String tf = abVar.tf();
            if (abVar.tA().uv().nZ()) {
                i objectWithJsonStr = i.objectWithJsonStr(tf, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        tF = errorCode;
                    }
                }
                errMsg = null;
                tF = 0;
            } else if (abVar.tF() == 0) {
                tF = abVar.tE();
                errMsg = abVar.getErrorString();
            } else {
                tF = abVar.tF();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(tF);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private ab b(String str, long j, int i, String str2) {
        ab abVar = new ab();
        abVar.n("forum_id", this.forumId);
        abVar.n("tbs", TbadkCoreApplication.m11getInst().getTbs());
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
            abVar.c("video_chunk", bArr);
        }
    }
}
