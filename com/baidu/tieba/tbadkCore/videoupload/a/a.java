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
    private boolean aiZ = false;
    private final int chunkLength;
    private final String forumId;
    private ab fvf;
    private final int fvg;
    private InterfaceC0079a fvh;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0079a {
        void M(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fvg = i2 / i;
    }

    public void a(InterfaceC0079a interfaceC0079a) {
        this.fvh = interfaceC0079a;
    }

    public VideoFinishResult d(String str, File file) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.bkg();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(m.n(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        c ri = b.ri(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.fvg);
        String str2 = ri != null ? ri.fvd : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i = ri != null ? ri.fve : 0;
        if (i < z && randomAccessFile.skipBytes(this.chunkLength * i) < this.chunkLength * i) {
            randomAccessFile.close();
            return null;
        }
        while (i < z) {
            N(i, z, 10);
            int i2 = i + 1;
            byte[] a = a(randomAccessFile, i, z, length);
            N(i, z, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                N(i, z, 40);
                this.fvf = b(k, length, z2, str2);
                N(i, z, 55);
                if (i2 == z) {
                    videoBlockUploadResult = c(a, i2, z2, z);
                } else if (i2 % this.fvg == 0) {
                    videoBlockUploadResult = b(a, i2, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i2, a, z2, z);
                }
                N(i, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    videoFinishResult.setSuccess(false);
                    if (videoFinishResult.getErrorNo() == 320033) {
                        b.rh(k);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                b.m(k, str2, i2);
                N(i, z, 100);
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
        b.rh(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void N(int i, int i2, int i3) {
        if (this.fvh != null) {
            this.fvh.M(i, i2, i3);
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
        this.aiZ = true;
        if (this.fvf != null) {
            this.fvf.eg();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fvg;
        int length = bArr.length;
        int i6 = (i / this.fvg) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fvg);
        } else {
            i4 = this.fvg;
        }
        a(this.fvf, i5, length, i4, i6, bArr);
        this.fvf.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fvf);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fvg;
        int length = bArr.length;
        int i6 = i / this.fvg;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fvg);
        } else {
            i4 = this.fvg;
        }
        a(this.fvf, i5, length, i4, i6, bArr);
        this.fvf.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fvf);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fvg == 0) {
            i4 = i / this.fvg;
        } else {
            i4 = (i / this.fvg) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fvg);
        } else {
            i5 = this.fvg;
        }
        a(this.fvf, i5, length, i5, i4, bArr);
        this.fvf.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fvf);
    }

    private VideoBlockUploadResult a(ab abVar) {
        int uI;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aiZ) {
            uI = abVar.uH();
            errMsg = abVar.getErrorString();
        } else {
            String uh = abVar.uh();
            if (abVar.uD().vA().oE()) {
                i objectWithJsonStr = i.objectWithJsonStr(uh, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        uI = errorCode;
                    }
                }
                errMsg = null;
                uI = 0;
            } else if (abVar.uI() == 0) {
                uI = abVar.uH();
                errMsg = abVar.getErrorString();
            } else {
                uI = abVar.uI();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(uI);
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
