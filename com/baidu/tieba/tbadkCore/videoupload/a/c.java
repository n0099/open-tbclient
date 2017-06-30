package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean aoE = false;
    private final int chunkLength;
    private ab fOR;
    private final int fOS;
    private e fOT;
    private final String forumId;

    public c(String str, int i, int i2) {
        this.forumId = str;
        this.chunkLength = i;
        this.fOS = i2 / i;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fOT = eVar;
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
        com.baidu.tieba.tbadkCore.videoupload.b.bnu();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String k = t.k(n.q(file));
        if (!StringUtils.isNull(k)) {
            k = k.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c rx = com.baidu.tieba.tbadkCore.videoupload.b.rx(k);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int x = x(length, this.chunkLength);
        int x2 = x(x, this.fOS);
        String str2 = rx != null ? rx.fOM : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = rx != null ? rx.fON : 0;
        if (i2 < x && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < x) {
            R(i2, x, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, x, length);
            R(i2, x, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                R(i2, x, 40);
                this.fOR = b(k, length, x2, str2);
                R(i2, x, 55);
                if (i3 == x) {
                    videoBlockUploadResult = c(a, i3, x2, x);
                } else if (i3 % this.fOS == 0) {
                    videoBlockUploadResult = b(a, i3, x2, x);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, x2, x);
                }
                R(i2, x, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.rw(k);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new au("c12024").Z(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.n(k, str2, i3);
                R(i2, x, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.rw(k);
        videoFinishResult.setVideoMd5(k);
        randomAccessFile.close();
        return videoFinishResult;
    }

    private void R(int i, int i2, int i3) {
        if (this.fOT != null) {
            this.fOT.aj((i + (i3 / 100.0f)) / i2);
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
        this.aoE = true;
        if (this.fOR != null) {
            this.fOR.fr();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.fOS;
        int length = bArr.length;
        int i6 = (i / this.fOS) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fOS);
        } else {
            i4 = this.fOS;
        }
        a(this.fOR, i5, length, i4, i6, bArr);
        this.fOR.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.fOR);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.fOS;
        int length = bArr.length;
        int i6 = i / this.fOS;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.fOS);
        } else {
            i4 = this.fOS;
        }
        a(this.fOR, i5, length, i4, i6, bArr);
        this.fOR.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.fOR);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.fOS == 0) {
            i4 = i / this.fOS;
        } else {
            i4 = (i / this.fOS) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.fOS);
        } else {
            i5 = this.fOS;
        }
        a(this.fOR, i5, length, i5, i4, bArr);
        this.fOR.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.fOR);
    }

    private VideoBlockUploadResult b(ab abVar) {
        int va;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aoE) {
            va = abVar.uZ();
            errMsg = abVar.getErrorString();
        } else {
            String uA = abVar.uA();
            if (abVar.uV().vS().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(uA, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        va = errorCode;
                    }
                }
                errMsg = null;
                va = 0;
            } else if (abVar.va() == 200) {
                va = abVar.uZ();
                errMsg = abVar.getErrorString();
            } else {
                va = abVar.va();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(va);
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
