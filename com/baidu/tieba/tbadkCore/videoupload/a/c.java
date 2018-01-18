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
    private boolean bem = false;
    private final int chunkLength;
    private final String forumId;
    private h gZj;
    private x haZ;
    private final int hba;
    private e hbb;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.hba = i2 / i;
        this.gZj = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hbb = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aJ(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bwJ();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String e = s.e(k.r(file));
        if (!StringUtils.isNull(e)) {
            e = e.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c sK = com.baidu.tieba.tbadkCore.videoupload.b.sK(e);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.hba);
        String str2 = sK != null ? sK.haV : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = sK != null ? sK.haW : 0;
        if (i2 < z && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < z) {
            aj(i2, z, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, z, length);
            aj(i2, z, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                aj(i2, z, 40);
                this.haZ = b(e, length, z2, str2);
                aj(i2, z, 55);
                if (i3 == z) {
                    videoBlockUploadResult = c(a, i3, z2, z);
                } else if (i3 % this.hba == 0) {
                    videoBlockUploadResult = b(a, i3, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, z2, z);
                }
                aj(i2, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.gZj != null) {
                        this.gZj.h(HttpStatus.SC_USE_PROXY, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.sJ(e);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.l(e, str2, i3);
                aj(i2, z, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.sJ(e);
        videoFinishResult.setVideoMd5(e);
        randomAccessFile.close();
        if (this.gZj != null) {
            this.gZj.aVa();
        }
        return videoFinishResult;
    }

    private void aj(int i, int i2, int i3) {
        if (this.hbb != null) {
            this.hbb.ay((i + (i3 / 100.0f)) / i2);
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
        this.bem = true;
        if (this.haZ != null) {
            this.haZ.mR();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.hba;
        int length = bArr.length;
        int i6 = (i / this.hba) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hba);
        } else {
            i4 = this.hba;
        }
        a(this.haZ, i5, length, i4, i6, bArr);
        this.haZ.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.haZ);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.hba;
        int length = bArr.length;
        int i6 = i / this.hba;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.hba);
        } else {
            i4 = this.hba;
        }
        a(this.haZ, i5, length, i4, i6, bArr);
        this.haZ.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.haZ);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.hba == 0) {
            i4 = i / this.hba;
        } else {
            i4 = (i / this.hba) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.hba);
        } else {
            i5 = this.hba;
        }
        a(this.haZ, i5, length, i5, i4, bArr);
        this.haZ.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.haZ);
    }

    private VideoBlockUploadResult b(x xVar) {
        int Ck;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.bem) {
            Ck = xVar.Cj();
            errMsg = xVar.getErrorString();
        } else {
            String BK = xVar.BK();
            if (xVar.Cf().Dc().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(BK, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        Ck = errorCode;
                    }
                }
                errMsg = null;
                Ck = 0;
            } else if (xVar.Ck() == 200) {
                Ck = xVar.Cj();
                errMsg = xVar.getErrorString();
            } else {
                Ck = xVar.Ck();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(Ck);
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
