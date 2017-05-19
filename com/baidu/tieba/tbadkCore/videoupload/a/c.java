package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean anU = false;
    private final int chunkLength;
    private final String forumId;
    private z fwU;
    private final int fwV;
    private e fwW;

    public c(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fwV = i2 / i;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fwW = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult ay(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bhM();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(l.o(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c ql = com.baidu.tieba.tbadkCore.videoupload.b.ql(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int w = w(length, this.chunkLength);
        int w2 = w(w, this.fwV);
        String str2 = ql != null ? ql.fwP : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = ql != null ? ql.fwQ : 0;
        if (i2 < w && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < w) {
            Q(i2, w, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, w, length);
            Q(i2, w, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                Q(i2, w, 40);
                this.fwU = b(k, length, w2, str2);
                Q(i2, w, 55);
                if (i3 == w) {
                    videoBlockUploadResult = c(a, i3, w2, w);
                } else if (i3 % this.fwV == 0) {
                    videoBlockUploadResult = b(a, i3, w2, w);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, w2, w);
                }
                Q(i2, w, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.qk(k);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new as("c12024").aa(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.n(k, str2, i3);
                Q(i2, w, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.qk(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void Q(int i, int i2, int i3) {
        if (this.fwW != null) {
            this.fwW.ac((i + (i3 / 100.0f)) / i2);
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

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.anU = true;
        if (this.fwU != null) {
            this.fwU.fs();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fwV;
        int length = bArr.length;
        int i6 = (i / this.fwV) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fwV);
        } else {
            i4 = this.fwV;
        }
        a(this.fwU, i5, length, i4, i6, bArr);
        this.fwU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return a(this.fwU);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fwV;
        int length = bArr.length;
        int i6 = i / this.fwV;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fwV);
        } else {
            i4 = this.fwV;
        }
        a(this.fwU, i5, length, i4, i6, bArr);
        this.fwU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return a(this.fwU);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fwV == 0) {
            i4 = i / this.fwV;
        } else {
            i4 = (i / this.fwV) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fwV);
        } else {
            i5 = this.fwV;
        }
        a(this.fwU, i5, length, i5, i4, bArr);
        this.fwU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return a(this.fwU);
    }

    private VideoBlockUploadResult a(z zVar) {
        int uO;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.anU) {
            uO = zVar.uN();
            errMsg = zVar.getErrorString();
        } else {
            String uo = zVar.uo();
            if (zVar.uJ().vE().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(uo, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        uO = errorCode;
                    }
                }
                errMsg = null;
                uO = 0;
            } else if (zVar.uO() == 200) {
                uO = zVar.uN();
                errMsg = zVar.getErrorString();
            } else {
                uO = zVar.uO();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(uO);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private z b(String str, long j, int i, String str2) {
        z zVar = new z();
        zVar.n("forum_id", this.forumId);
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        zVar.n("total_length", String.valueOf(j));
        zVar.n("video_md5", str);
        zVar.n("block_num", String.valueOf(i));
        zVar.n("upload_id", str2);
        return zVar;
    }

    private void a(z zVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (zVar != null) {
            zVar.n("chunk_no", String.valueOf(i));
            zVar.n("chunk_length", String.valueOf(j));
            zVar.n("chunk_num", String.valueOf(i2));
            zVar.n("block_no", String.valueOf(i3));
            zVar.d("video_chunk", bArr);
        }
    }
}
