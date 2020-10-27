package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean eVO = false;
    private final String forumId;
    private h mSh;
    private final int mUd;
    private aa mUm;
    private final int mUn;
    private e mUo;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.mUd = i;
        this.mUn = i2 / i;
        this.mSh = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.mUo = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bK(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.dIE();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c SN = com.baidu.tieba.tbadkCore.videoupload.b.SN(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int B = B(length, this.mUd);
        int B2 = B(B, this.mUn);
        String str2 = SN != null ? SN.mUh : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = SN != null ? SN.mUi : 0;
        if (i2 < B && randomAccessFile.skipBytes(this.mUd * i2) < this.mUd * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < B) {
            ae(i2, B, 10);
            int i3 = i2 + 1;
            byte[] a2 = a(randomAccessFile, i2, B, length);
            ae(i2, B, 25);
            if (a2 == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a2.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ae(i2, B, 40);
                this.mUm = c(md5, length, B2, str2);
                ae(i2, B, 55);
                if (i3 == B) {
                    videoBlockUploadResult = d(a2, i3, B2, B);
                } else if (i3 % this.mUn == 0) {
                    videoBlockUploadResult = c(a2, i3, B2, B);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a2, B2, B);
                }
                ae(i2, B, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.mSh != null) {
                        this.mSh.o(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.SM(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new aq("c12024").dR("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.u(md5, str2, i3);
                ae(i2, B, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.SM(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.mSh != null) {
            this.mSh.dbB();
        }
        return videoFinishResult;
    }

    private void ae(int i, int i2, int i3) {
        if (this.mUo != null) {
            this.mUo.aL((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.mUd * i));
        } else {
            i3 = this.mUd;
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

    private int B(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.eVO = true;
        if (this.mUm != null) {
            this.mUm.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.mUn;
        int length = bArr.length;
        int i6 = (i / this.mUn) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.mUn);
        } else {
            i4 = this.mUn;
        }
        a(this.mUm, i5, length, i4, i6, bArr);
        this.mUm.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return c(this.mUm);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.mUn;
        int length = bArr.length;
        int i6 = i / this.mUn;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.mUn);
        } else {
            i4 = this.mUn;
        }
        a(this.mUm, i5, length, i4, i6, bArr);
        this.mUm.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return c(this.mUm);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.mUn == 0) {
            i4 = i / this.mUn;
        } else {
            i4 = (i / this.mUn) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.mUn);
        } else {
            i5 = this.mUn;
        }
        a(this.mUm, i5, length, i5, i4, bArr);
        this.mUm.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return c(this.mUm);
    }

    private VideoBlockUploadResult c(aa aaVar) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.eVO) {
            netErrorCode = aaVar.getServerErrorCode();
            errMsg = aaVar.getErrorString();
        } else {
            String postMultiNetData = aaVar.postMultiNetData();
            if (aaVar.bon().boU().isRequestSuccess()) {
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
            } else if (aaVar.getNetErrorCode() == 200) {
                netErrorCode = aaVar.getServerErrorCode();
                errMsg = aaVar.getErrorString();
            } else {
                netErrorCode = aaVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(netErrorCode);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private aa c(String str, long j, int i, String str2) {
        aa aaVar = new aa();
        aaVar.addPostData("forum_id", this.forumId);
        aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        aaVar.addPostData("total_length", String.valueOf(j));
        aaVar.addPostData("video_md5", str);
        aaVar.addPostData("block_num", String.valueOf(i));
        aaVar.addPostData("upload_id", str2);
        return aaVar;
    }

    private void a(aa aaVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (aaVar != null) {
            aaVar.addPostData("chunk_no", String.valueOf(i));
            aaVar.addPostData("chunk_length", String.valueOf(j));
            aaVar.addPostData("chunk_num", String.valueOf(i2));
            aaVar.addPostData("block_no", String.valueOf(i3));
            aaVar.addPostData("video_chunk", bArr);
        }
    }
}
