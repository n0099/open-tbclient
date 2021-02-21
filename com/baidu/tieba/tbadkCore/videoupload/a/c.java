package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.l.g;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c implements b {
    private final String forumId;
    private boolean fpC = false;
    private aa nAC;
    private final int nAD;
    private e nAE;
    private final int nAu;
    private g nyu;

    public c(String str, int i, int i2, g gVar) {
        this.forumId = str;
        this.nAu = i;
        this.nAD = i2 / i;
        this.nyu = gVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.nAE = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bW(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.dOW();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String md5 = s.toMd5(o.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            md5 = md5.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c TP = com.baidu.tieba.tbadkCore.videoupload.b.TP(md5);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int G = G(length, this.nAu);
        int G2 = G(G, this.nAD);
        String str2 = TP != null ? TP.nAy : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = TP != null ? TP.nAz : 0;
        if (i2 < G && randomAccessFile.skipBytes(this.nAu * i2) < this.nAu * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < G) {
            af(i2, G, 10);
            int i3 = i2 + 1;
            byte[] a2 = a(randomAccessFile, i2, G, length);
            af(i2, G, 25);
            if (a2 == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a2.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                af(i2, G, 40);
                this.nAC = c(md5, length, G2, str2);
                af(i2, G, 55);
                if (i3 == G) {
                    videoBlockUploadResult = d(a2, i3, G2, G);
                } else if (i3 % this.nAD == 0) {
                    videoBlockUploadResult = c(a2, i3, G2, G);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a2, G2, G);
                }
                af(i2, G, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.nyu != null) {
                        this.nyu.o(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.TO(md5);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new ar("c12024").dR("params", videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.w(md5, str2, i3);
                af(i2, G, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.TO(md5);
        videoFinishResult.setVideoMd5(md5);
        randomAccessFile.close();
        if (this.nyu != null) {
            this.nyu.dgP();
        }
        return videoFinishResult;
    }

    private void af(int i, int i2, int i3) {
        if (this.nAE != null) {
            this.nAE.ba((i + (i3 / 100.0f)) / i2);
        }
    }

    private byte[] a(RandomAccessFile randomAccessFile, int i, int i2, long j) {
        int i3;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == i2 - 1) {
            i3 = (int) (j - (this.nAu * i));
        } else {
            i3 = this.nAu;
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

    private int G(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fpC = true;
        if (this.nAC != null) {
            this.nAC.cancelNetConnect();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.nAD;
        int length = bArr.length;
        int i6 = (i / this.nAD) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.nAD);
        } else {
            i4 = this.nAD;
        }
        a(this.nAC, i5, length, i4, i6, bArr);
        this.nAC.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return c(this.nAC);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.nAD;
        int length = bArr.length;
        int i6 = i / this.nAD;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.nAD);
        } else {
            i4 = this.nAD;
        }
        a(this.nAC, i5, length, i4, i6, bArr);
        this.nAC.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return c(this.nAC);
    }

    private VideoBlockUploadResult d(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.nAD == 0) {
            i4 = i / this.nAD;
        } else {
            i4 = (i / this.nAD) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.nAD);
        } else {
            i5 = this.nAD;
        }
        a(this.nAC, i5, length, i5, i4, bArr);
        this.nAC.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return c(this.nAC);
    }

    private VideoBlockUploadResult c(aa aaVar) {
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        int i = 0;
        if (this.fpC) {
            i = aaVar.getServerErrorCode();
            errMsg = aaVar.getErrorString();
        } else {
            String postMultiNetData = aaVar.postMultiNetData();
            if (aaVar.bsr().btb().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(postMultiNetData, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        i = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                    }
                }
                errMsg = null;
            } else if (aaVar.getNetErrorCode() == 200) {
                i = aaVar.getServerErrorCode();
                errMsg = aaVar.getErrorString();
            } else {
                i = aaVar.getNetErrorCode();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(i);
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
