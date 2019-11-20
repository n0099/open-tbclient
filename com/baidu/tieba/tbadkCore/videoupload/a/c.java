package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private boolean cta = false;
    private final String forumId;
    private h jiP;
    private final int jkA;
    private x jkI;
    private final int jkJ;
    private e jkK;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.jkA = i;
        this.jkJ = i2 / i;
        this.jiP = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jkK = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bm(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.cpv();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(m.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c Ef = com.baidu.tieba.tbadkCore.videoupload.b.Ef(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int s = s(length, this.jkA);
        int s2 = s(s, this.jkJ);
        String str2 = Ef != null ? Ef.jkE : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = Ef != null ? Ef.jkF : 0;
        if (i2 < s && randomAccessFile.skipBytes(this.jkA * i2) < this.jkA * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < s) {
            Z(i2, s, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, s, length);
            Z(i2, s, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                Z(i2, s, 40);
                this.jkI = c(md5, length, s2, str2);
                Z(i2, s, 55);
                if (i3 == s) {
                    videoBlockUploadResult = d(a, i3, s2, s);
                } else if (i3 % this.jkJ == 0) {
                    videoBlockUploadResult = c(a, i3, s2, s);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, s2, s);
                }
                Z(i2, s, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.jiP != null) {
                        this.jiP.h(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.Ee(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new an("c12024").bS("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.r(md5, str2, i3);
                Z(i2, s, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.Ee(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.jiP != null) {
            this.jiP.bMA();
        }
        return videoFinishResult;
    }

    private void Z(int i, int i2, int i3) {
        if (this.jkK != null) {
            this.jkK.av((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.jkA * i));
        } else {
            i3 = this.jkA;
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

    private int s(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.cta = true;
        if (this.jkI != null) {
            this.jkI.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.jkJ;
        int length = bArr.length;
        int i6 = (i / this.jkJ) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.jkJ);
        } else {
            i4 = this.jkJ;
        }
        a(this.jkI, i5, length, i4, i6, bArr);
        this.jkI.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.jkI);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.jkJ;
        int length = bArr.length;
        int i6 = i / this.jkJ;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.jkJ);
        } else {
            i4 = this.jkJ;
        }
        a(this.jkI, i5, length, i4, i6, bArr);
        this.jkI.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.jkI);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.jkJ == 0) {
            i4 = i / this.jkJ;
        } else {
            i4 = (i / this.jkJ) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.jkJ);
        } else {
            i5 = this.jkJ;
        }
        a(this.jkI, i5, length, i5, i4, bArr);
        this.jkI.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.jkI);
    }

    private VideoBlockUploadResult b(x xVar) {
        int netErrorCode;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.cta) {
            netErrorCode = xVar.getServerErrorCode();
            errMsg = xVar.getErrorString();
        } else {
            String postMultiNetData = xVar.postMultiNetData();
            if (xVar.amp().amQ().isRequestSuccess()) {
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
            } else if (xVar.getNetErrorCode() == 200) {
                netErrorCode = xVar.getServerErrorCode();
                errMsg = xVar.getErrorString();
            } else {
                netErrorCode = xVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(netErrorCode);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private x c(String str, long j, int i, String str2) {
        x xVar = new x();
        xVar.addPostData("forum_id", this.forumId);
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        xVar.addPostData("total_length", String.valueOf(j));
        xVar.addPostData("video_md5", str);
        xVar.addPostData("block_num", String.valueOf(i));
        xVar.addPostData("upload_id", str2);
        return xVar;
    }

    private void a(x xVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (xVar != null) {
            xVar.addPostData("chunk_no", String.valueOf(i));
            xVar.addPostData("chunk_length", String.valueOf(j));
            xVar.addPostData("chunk_num", String.valueOf(i2));
            xVar.addPostData("block_no", String.valueOf(i3));
            xVar.addPostData("video_chunk", bArr);
        }
    }
}
