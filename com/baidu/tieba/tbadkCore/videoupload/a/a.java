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
    private boolean agf = false;
    private final int chunkLength;
    private ab fnl;
    private final int fnm;
    private InterfaceC0079a fnn;
    private final String forumId;

    /* renamed from: com.baidu.tieba.tbadkCore.videoupload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0079a {
        void K(int i, int i2, int i3);
    }

    public a(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fnm = i2 / i;
    }

    public void a(InterfaceC0079a interfaceC0079a) {
        this.fnn = interfaceC0079a;
    }

    public VideoFinishResult d(String str, File file) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str) || file == null) {
            return null;
        }
        b.bgF();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(m.n(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        c qy = b.qy(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int y = y(length, this.chunkLength);
        int y2 = y(y, this.fnm);
        String str2 = qy != null ? qy.fnj : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i = qy != null ? qy.fnk : 0;
        if (i < y && randomAccessFile.skipBytes(this.chunkLength * i) < this.chunkLength * i) {
            randomAccessFile.close();
            return null;
        }
        while (i < y) {
            L(i, y, 10);
            int i2 = i + 1;
            byte[] a = a(randomAccessFile, i, y, length);
            L(i, y, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                L(i, y, 40);
                this.fnl = b(k, length, y2, str2);
                L(i, y, 55);
                if (i2 == y) {
                    videoBlockUploadResult = c(a, i2, y2, y);
                } else if (i2 % this.fnm == 0) {
                    videoBlockUploadResult = b(a, i2, y2, y);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i2, a, y2, y);
                }
                L(i, y, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    videoFinishResult.setSuccess(false);
                    if (videoFinishResult.getErrorNo() == 320033) {
                        b.qx(k);
                    }
                    randomAccessFile.close();
                    return videoFinishResult;
                }
                b.m(k, str2, i2);
                L(i, y, 100);
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
        b.qx(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void L(int i, int i2, int i3) {
        if (this.fnn != null) {
            this.fnn.K(i, i2, i3);
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

    private int y(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    public void cancel() {
        this.agf = true;
        if (this.fnl != null) {
            this.fnl.dl();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fnm;
        int length = bArr.length;
        int i6 = (i / this.fnm) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fnm);
        } else {
            i4 = this.fnm;
        }
        a(this.fnl, i5, length, i4, i6, bArr);
        this.fnl.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fnl);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fnm;
        int length = bArr.length;
        int i6 = i / this.fnm;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fnm);
        } else {
            i4 = this.fnm;
        }
        a(this.fnl, i5, length, i4, i6, bArr);
        this.fnl.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fnl);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fnm == 0) {
            i4 = i / this.fnm;
        } else {
            i4 = (i / this.fnm) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fnm);
        } else {
            i5 = this.fnm;
        }
        a(this.fnl, i5, length, i5, i4, bArr);
        this.fnl.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fnl);
    }

    private VideoBlockUploadResult a(ab abVar) {
        int tC;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.agf) {
            tC = abVar.tB();
            errMsg = abVar.getErrorString();
        } else {
            String tc = abVar.tc();
            if (abVar.tx().uv().nJ()) {
                i objectWithJsonStr = i.objectWithJsonStr(tc, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        tC = errorCode;
                    }
                }
                errMsg = null;
                tC = 0;
            } else if (abVar.tC() == 0) {
                tC = abVar.tB();
                errMsg = abVar.getErrorString();
            } else {
                tC = abVar.tC();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(tC);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private ab b(String str, long j, int i, String str2) {
        ab abVar = new ab();
        abVar.n("forum_id", this.forumId);
        abVar.n("tbs", TbadkCoreApplication.m10getInst().getTbs());
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
