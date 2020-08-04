package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean eoR = false;
    private final String forumId;
    private h lOv;
    private final int lQn;
    private z lQv;
    private final int lQw;
    private e lQx;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.lQn = i;
        this.lQw = i2 / i;
        this.lOv = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.lQx = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bD(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.dmr();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c Oc = com.baidu.tieba.tbadkCore.videoupload.b.Oc(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int u = u(length, this.lQn);
        int u2 = u(u, this.lQw);
        String str2 = Oc != null ? Oc.lQr : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = Oc != null ? Oc.lQs : 0;
        if (i2 < u && randomAccessFile.skipBytes(this.lQn * i2) < this.lQn * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < u) {
            aa(i2, u, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, u, length);
            aa(i2, u, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                aa(i2, u, 40);
                this.lQv = c(md5, length, u2, str2);
                aa(i2, u, 55);
                if (i3 == u) {
                    videoBlockUploadResult = d(a, i3, u2, u);
                } else if (i3 % this.lQw == 0) {
                    videoBlockUploadResult = c(a, i3, u2, u);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, u2, u);
                }
                aa(i2, u, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.lOv != null) {
                        this.lOv.m(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.Ob(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new ap("c12024").dn("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.t(md5, str2, i3);
                aa(i2, u, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.Ob(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.lOv != null) {
            this.lOv.cGo();
        }
        return videoFinishResult;
    }

    private void aa(int i, int i2, int i3) {
        if (this.lQx != null) {
            this.lQx.ax((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.lQn * i));
        } else {
            i3 = this.lQn;
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

    private int u(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.eoR = true;
        if (this.lQv != null) {
            this.lQv.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.lQw;
        int length = bArr.length;
        int i6 = (i / this.lQw) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.lQw);
        } else {
            i4 = this.lQw;
        }
        a(this.lQv, i5, length, i4, i6, bArr);
        this.lQv.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return c(this.lQv);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.lQw;
        int length = bArr.length;
        int i6 = i / this.lQw;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.lQw);
        } else {
            i4 = this.lQw;
        }
        a(this.lQv, i5, length, i4, i6, bArr);
        this.lQv.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return c(this.lQv);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.lQw == 0) {
            i4 = i / this.lQw;
        } else {
            i4 = (i / this.lQw) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.lQw);
        } else {
            i5 = this.lQw;
        }
        a(this.lQv, i5, length, i5, i4, bArr);
        this.lQv.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return c(this.lQv);
    }

    private VideoBlockUploadResult c(z zVar) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.eoR) {
            netErrorCode = zVar.getServerErrorCode();
            errMsg = zVar.getErrorString();
        } else {
            String postMultiNetData = zVar.postMultiNetData();
            if (zVar.bav().baX().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(postMultiNetData, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        netErrorCode = errorCode;
                    }
                }
                errMsg = null;
                netErrorCode = 0;
            } else if (zVar.getNetErrorCode() == 200) {
                netErrorCode = zVar.getServerErrorCode();
                errMsg = zVar.getErrorString();
            } else {
                netErrorCode = zVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(netErrorCode);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private z c(String str, long j, int i, String str2) {
        z zVar = new z();
        zVar.addPostData("forum_id", this.forumId);
        zVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        zVar.addPostData("total_length", String.valueOf(j));
        zVar.addPostData("video_md5", str);
        zVar.addPostData("block_num", String.valueOf(i));
        zVar.addPostData("upload_id", str2);
        return zVar;
    }

    private void a(z zVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (zVar != null) {
            zVar.addPostData("chunk_no", String.valueOf(i));
            zVar.addPostData("chunk_length", String.valueOf(j));
            zVar.addPostData("chunk_num", String.valueOf(i2));
            zVar.addPostData("block_no", String.valueOf(i3));
            zVar.addPostData("video_chunk", bArr);
        }
    }
}
