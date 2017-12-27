package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class c implements b {
    private boolean beg = false;
    private final int chunkLength;
    private final String forumId;
    private h hjJ;
    private e hlA;
    private x hly;
    private final int hlz;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.hlz = i2 / i;
        this.hjJ = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hlA = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aH(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bDm();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String e = s.e(k.r(file));
        if (!StringUtils.isNull(e)) {
            e = e.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c tq = com.baidu.tieba.tbadkCore.videoupload.b.tq(e);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.hlz);
        String str2 = tq != null ? tq.hlu : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = tq != null ? tq.hlv : 0;
        if (i2 < z && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < z) {
            ak(i2, z, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, z, length);
            ak(i2, z, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ak(i2, z, 40);
                this.hly = b(e, length, z2, str2);
                ak(i2, z, 55);
                if (i3 == z) {
                    videoBlockUploadResult = c(a, i3, z2, z);
                } else if (i3 % this.hlz == 0) {
                    videoBlockUploadResult = b(a, i3, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, z2, z);
                }
                ak(i2, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.hjJ != null) {
                        this.hjJ.h(HttpStatus.SC_USE_PROXY, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.tp(e);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.m(e, str2, i3);
                ak(i2, z, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.tp(e);
        videoFinishResult.setVideoMd5(e);
        randomAccessFile.close();
        if (this.hjJ != null) {
            this.hjJ.aUV();
        }
        return videoFinishResult;
    }

    private void ak(int i, int i2, int i3) {
        if (this.hlA != null) {
            this.hlA.aA((i + (i3 / 100.0f)) / i2);
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

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.beg = true;
        if (this.hly != null) {
            this.hly.mR();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.hlz;
        int length = bArr.length;
        int i6 = (i / this.hlz) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hlz);
        } else {
            i4 = this.hlz;
        }
        a(this.hly, i5, length, i4, i6, bArr);
        this.hly.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.hly);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.hlz;
        int length = bArr.length;
        int i6 = i / this.hlz;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hlz);
        } else {
            i4 = this.hlz;
        }
        a(this.hly, i5, length, i4, i6, bArr);
        this.hly.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.hly);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.hlz == 0) {
            i4 = i / this.hlz;
        } else {
            i4 = (i / this.hlz) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.hlz);
        } else {
            i5 = this.hlz;
        }
        a(this.hly, i5, length, i5, i4, bArr);
        this.hly.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.hly);
    }

    private VideoBlockUploadResult b(x xVar) {
        int Cs;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.beg) {
            Cs = xVar.Cr();
            errMsg = xVar.getErrorString();
        } else {
            String BS = xVar.BS();
            if (xVar.Cn().Dl().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(BS, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        Cs = errorCode;
                    }
                }
                errMsg = null;
                Cs = 0;
            } else if (xVar.Cs() == 200) {
                Cs = xVar.Cr();
                errMsg = xVar.getErrorString();
            } else {
                Cs = xVar.Cs();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(Cs);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private x b(String str, long j, int i, String str2) {
        x xVar = new x();
        xVar.n("forum_id", this.forumId);
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        xVar.n("total_length", String.valueOf(j));
        xVar.n("video_md5", str);
        xVar.n("block_num", String.valueOf(i));
        xVar.n("upload_id", str2);
        return xVar;
    }

    private void a(x xVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (xVar != null) {
            xVar.n("chunk_no", String.valueOf(i));
            xVar.n("chunk_length", String.valueOf(j));
            xVar.n("chunk_num", String.valueOf(i2));
            xVar.n("block_no", String.valueOf(i3));
            xVar.d("video_chunk", bArr);
        }
    }
}
