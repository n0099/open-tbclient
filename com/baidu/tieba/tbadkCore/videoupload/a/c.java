package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean aqQ = false;
    private final int chunkLength;
    private final String forumId;
    private w gmt;
    private final int gmu;
    private e gmv;

    public c(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.gmu = i2 / i;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gmv = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aA(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bug();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String q = r.q(k.q(file));
        if (!StringUtils.isNull(q)) {
            q = q.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c sq = com.baidu.tieba.tbadkCore.videoupload.b.sq(q);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int x = x(length, this.chunkLength);
        int x2 = x(x, this.gmu);
        String str2 = sq != null ? sq.gmo : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = sq != null ? sq.gmp : 0;
        if (i2 < x && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < x) {
            S(i2, x, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, x, length);
            S(i2, x, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                S(i2, x, 40);
                this.gmt = b(q, length, x2, str2);
                S(i2, x, 55);
                if (i3 == x) {
                    videoBlockUploadResult = c(a, i3, x2, x);
                } else if (i3 % this.gmu == 0) {
                    videoBlockUploadResult = b(a, i3, x2, x);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, x2, x);
                }
                S(i2, x, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.sp(q);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new aj("c12024").aa(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.n(q, str2, i3);
                S(i2, x, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.sp(q);
        videoFinishResult.setVideoMd5(q);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void S(int i, int i2, int i3) {
        if (this.gmv != null) {
            this.gmv.al((i + (i3 / 100.0f)) / i2);
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

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.aqQ = true;
        if (this.gmt != null) {
            this.gmt.fA();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.gmu;
        int length = bArr.length;
        int i6 = (i / this.gmu) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gmu);
        } else {
            i4 = this.gmu;
        }
        a(this.gmt, i5, length, i4, i6, bArr);
        this.gmt.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.gmt);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.gmu;
        int length = bArr.length;
        int i6 = i / this.gmu;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gmu);
        } else {
            i4 = this.gmu;
        }
        a(this.gmt, i5, length, i4, i6, bArr);
        this.gmt.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.gmt);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.gmu == 0) {
            i4 = i / this.gmu;
        } else {
            i4 = (i / this.gmu) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.gmu);
        } else {
            i5 = this.gmu;
        }
        a(this.gmt, i5, length, i5, i4, bArr);
        this.gmt.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.gmt);
    }

    private VideoBlockUploadResult b(w wVar) {
        int vq;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aqQ) {
            vq = wVar.vp();
            errMsg = wVar.getErrorString();
        } else {
            String uQ = wVar.uQ();
            if (wVar.vl().wi().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(uQ, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        vq = errorCode;
                    }
                }
                errMsg = null;
                vq = 0;
            } else if (wVar.vq() == 200) {
                vq = wVar.vp();
                errMsg = wVar.getErrorString();
            } else {
                vq = wVar.vq();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(vq);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private w b(String str, long j, int i, String str2) {
        w wVar = new w();
        wVar.n("forum_id", this.forumId);
        wVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        wVar.n("total_length", String.valueOf(j));
        wVar.n("video_md5", str);
        wVar.n("block_num", String.valueOf(i));
        wVar.n("upload_id", str2);
        return wVar;
    }

    private void a(w wVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (wVar != null) {
            wVar.n("chunk_no", String.valueOf(i));
            wVar.n("chunk_length", String.valueOf(j));
            wVar.n("chunk_num", String.valueOf(i2));
            wVar.n("block_no", String.valueOf(i3));
            wVar.d("video_chunk", bArr);
        }
    }
}
