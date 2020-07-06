package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean eiF = false;
    private final String forumId;
    private h lHf;
    private final int lIX;
    private y lJf;
    private final int lJg;
    private e lJh;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.lIX = i;
        this.lJg = i2 / i;
        this.lHf = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.lJh = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bF(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.dji();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c Nu = com.baidu.tieba.tbadkCore.videoupload.b.Nu(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int t = t(length, this.lIX);
        int t2 = t(t, this.lJg);
        String str2 = Nu != null ? Nu.lJb : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = Nu != null ? Nu.lJc : 0;
        if (i2 < t && randomAccessFile.skipBytes(this.lIX * i2) < this.lIX * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < t) {
            ad(i2, t, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, t, length);
            ad(i2, t, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                ad(i2, t, 40);
                this.lJf = c(md5, length, t2, str2);
                ad(i2, t, 55);
                if (i3 == t) {
                    videoBlockUploadResult = d(a, i3, t2, t);
                } else if (i3 % this.lJg == 0) {
                    videoBlockUploadResult = c(a, i3, t2, t);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, t2, t);
                }
                ad(i2, t, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.lHf != null) {
                        this.lHf.l(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.Nt(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new ao("c12024").dk("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.t(md5, str2, i3);
                ad(i2, t, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.Nt(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.lHf != null) {
            this.lHf.cCt();
        }
        return videoFinishResult;
    }

    private void ad(int i, int i2, int i3) {
        if (this.lJh != null) {
            this.lJh.ay((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.lIX * i));
        } else {
            i3 = this.lIX;
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

    private int t(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.eiF = true;
        if (this.lJf != null) {
            this.lJf.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.lJg;
        int length = bArr.length;
        int i6 = (i / this.lJg) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.lJg);
        } else {
            i4 = this.lJg;
        }
        a(this.lJf, i5, length, i4, i6, bArr);
        this.lJf.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return c(this.lJf);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.lJg;
        int length = bArr.length;
        int i6 = i / this.lJg;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.lJg);
        } else {
            i4 = this.lJg;
        }
        a(this.lJf, i5, length, i4, i6, bArr);
        this.lJf.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return c(this.lJf);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.lJg == 0) {
            i4 = i / this.lJg;
        } else {
            i4 = (i / this.lJg) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.lJg);
        } else {
            i5 = this.lJg;
        }
        a(this.lJf, i5, length, i5, i4, bArr);
        this.lJf.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return c(this.lJf);
    }

    private VideoBlockUploadResult c(y yVar) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.eiF) {
            netErrorCode = yVar.getServerErrorCode();
            errMsg = yVar.getErrorString();
        } else {
            String postMultiNetData = yVar.postMultiNetData();
            if (yVar.aWu().aWW().isRequestSuccess()) {
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
            } else if (yVar.getNetErrorCode() == 200) {
                netErrorCode = yVar.getServerErrorCode();
                errMsg = yVar.getErrorString();
            } else {
                netErrorCode = yVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(netErrorCode);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private y c(String str, long j, int i, String str2) {
        y yVar = new y();
        yVar.addPostData("forum_id", this.forumId);
        yVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        yVar.addPostData("total_length", String.valueOf(j));
        yVar.addPostData("video_md5", str);
        yVar.addPostData("block_num", String.valueOf(i));
        yVar.addPostData("upload_id", str2);
        return yVar;
    }

    private void a(y yVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (yVar != null) {
            yVar.addPostData("chunk_no", String.valueOf(i));
            yVar.addPostData("chunk_length", String.valueOf(j));
            yVar.addPostData("chunk_num", String.valueOf(i2));
            yVar.addPostData("block_no", String.valueOf(i3));
            yVar.addPostData("video_chunk", bArr);
        }
    }
}
