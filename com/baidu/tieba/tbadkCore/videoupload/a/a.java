package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.aa;
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
    private boolean aiN = false;
    private final int chunkLength;
    private final int dZo;
    private aa dZs;
    private final int dZt;
    private InterfaceC0088a dZu;
    private final String forumId;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void K(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.dZo = i2;
        this.dZt = i2 / i;
    }

    public void a(InterfaceC0088a interfaceC0088a) {
        this.dZu = interfaceC0088a;
    }

    public VideoFinishResult c(String str, File file) {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.aNx();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String f = t.f(m.o(file));
        if (!StringUtils.isNull(f)) {
            f = f.toLowerCase();
        }
        c mW = b.mW(f);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int i = i(length, this.chunkLength);
        int i2 = i(i, this.dZt);
        String str2 = mW != null ? mW.dZq : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i3 = mW != null ? mW.dZr : 0;
        if (i3 < i && randomAccessFile.skipBytes(this.chunkLength * i3) < this.chunkLength * i3) {
            randomAccessFile.close();
            return null;
        }
        while (i3 < i) {
            L(i3, i, 10);
            int i4 = i3 + 1;
            byte[] a = a(randomAccessFile, i3, i, length);
            L(i3, i, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                L(i3, i, 40);
                this.dZs = b(f, length, i2, str2);
                L(i3, i, 55);
                if (i4 == i) {
                    videoBlockUploadResult = c(a, i4, i2, i);
                } else if (i4 % this.dZt == 0) {
                    videoBlockUploadResult = b(a, i4, i2, i);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i4, a, i2, i);
                }
                L(i3, i, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    videoFinishResult.setSuccess(false);
                    if (videoFinishResult.getErrorNo() == 320033) {
                        b.mV(f);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                b.k(f, str2, i4);
                L(i3, i, 100);
            }
            i3++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        videoFinishResult.setSuccess(true);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        b.mV(f);
        videoFinishResult.setVideoMd5(f);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void L(int i, int i2, int i3) {
        if (this.dZu != null) {
            this.dZu.K(i, i2, i3);
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

    private int i(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    public void cancel() {
        this.aiN = true;
        if (this.dZs != null) {
            this.dZs.gT();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.dZt;
        int length = bArr.length;
        int i6 = (i / this.dZt) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.dZt);
        } else {
            i4 = this.dZt;
        }
        a(this.dZs, i5, length, i4, i6, bArr);
        this.dZs.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.dZs);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.dZt;
        int length = bArr.length;
        int i6 = i / this.dZt;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.dZt);
        } else {
            i4 = this.dZt;
        }
        a(this.dZs, i5, length, i4, i6, bArr);
        this.dZs.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.dZs);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int length = bArr.length;
        int i5 = (i / this.dZt) + 1;
        if (i5 == i2) {
            i4 = i3 - ((i5 - 1) * this.dZt);
        } else {
            i4 = this.dZt;
        }
        a(this.dZs, i4, length, i4, i5, bArr);
        this.dZs.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.dZs);
    }

    private VideoBlockUploadResult a(aa aaVar) {
        int vG;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aiN) {
            vG = aaVar.vF();
            errMsg = aaVar.getErrorString();
        } else {
            String vc = aaVar.vc();
            if (aaVar.vB().ww().rl()) {
                i objectWithJsonStr = i.objectWithJsonStr(vc, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        vG = errorCode;
                    }
                }
                errMsg = null;
                vG = 0;
            } else if (aaVar.vG() == 0) {
                vG = aaVar.vF();
                errMsg = aaVar.getErrorString();
            } else {
                vG = aaVar.vG();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(vG);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private aa b(String str, long j, int i, String str2) {
        aa aaVar = new aa();
        aaVar.p("forum_id", this.forumId);
        aaVar.p("tbs", TbadkCoreApplication.m411getInst().getTbs());
        aaVar.p("total_length", String.valueOf(j));
        aaVar.p("video_md5", str);
        aaVar.p("block_num", String.valueOf(i));
        aaVar.p("upload_id", str2);
        return aaVar;
    }

    private void a(aa aaVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (aaVar != null) {
            aaVar.p("chunk_no", String.valueOf(i));
            aaVar.p("chunk_length", String.valueOf(j));
            aaVar.p("chunk_num", String.valueOf(i2));
            aaVar.p("block_no", String.valueOf(i3));
            aaVar.d("video_chunk", bArr);
        }
    }
}
