package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class c implements b {
    private boolean aAC = false;
    private final int chunkLength;
    private final String forumId;
    private h gOY;
    private y gQL;
    private final int gQM;
    private e gQN;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.gQM = i2 / i;
        this.gOY = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gQN = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aL(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.bxj();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String g = s.g(l.q(file));
        if (!StringUtils.isNull(g)) {
            g = g.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c ub = com.baidu.tieba.tbadkCore.videoupload.b.ub(g);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int l = l(length, this.chunkLength);
        int l2 = l(l, this.gQM);
        String str2 = ub != null ? ub.gQH : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = ub != null ? ub.gQI : 0;
        if (i2 < l && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < l) {
            X(i2, l, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, l, length);
            X(i2, l, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                X(i2, l, 40);
                this.gQL = b(g, length, l2, str2);
                X(i2, l, 55);
                if (i3 == l) {
                    videoBlockUploadResult = c(a, i3, l2, l);
                } else if (i3 % this.gQM == 0) {
                    videoBlockUploadResult = b(a, i3, l2, l);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, l2, l);
                }
                X(i2, l, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.gOY != null) {
                        this.gOY.e(HttpStatus.SC_USE_PROXY, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.ua(g);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new an("c12024").af(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.l(g, str2, i3);
                X(i2, l, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.ua(g);
        videoFinishResult.setVideoMd5(g);
        randomAccessFile.close();
        if (this.gOY != null) {
            this.gOY.aVG();
        }
        return videoFinishResult;
    }

    private void X(int i, int i2, int i3) {
        if (this.gQN != null) {
            this.gQN.aD((i + (i3 / 100.0f)) / i2);
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

    private int l(long j, int i) {
        return j % ((long) i) == 0 ? (int) (j / i) : (int) ((j / i) + 1);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.aAC = true;
        if (this.gQL != null) {
            this.gQL.hN();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.gQM;
        int length = bArr.length;
        int i6 = (i / this.gQM) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gQM);
        } else {
            i4 = this.gQM;
        }
        a(this.gQL, i5, length, i4, i6, bArr);
        this.gQL.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.gQL);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.gQM;
        int length = bArr.length;
        int i6 = i / this.gQM;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gQM);
        } else {
            i4 = this.gQM;
        }
        a(this.gQL, i5, length, i4, i6, bArr);
        this.gQL.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.gQL);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.gQM == 0) {
            i4 = i / this.gQM;
        } else {
            i4 = (i / this.gQM) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.gQM);
        } else {
            i5 = this.gQM;
        }
        a(this.gQL, i5, length, i5, i4, bArr);
        this.gQL.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.gQL);
    }

    private VideoBlockUploadResult b(y yVar) {
        int yT;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.aAC) {
            yT = yVar.yS();
            errMsg = yVar.getErrorString();
        } else {
            String yt = yVar.yt();
            if (yVar.yO().zN().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(yt, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        yT = errorCode;
                    }
                }
                errMsg = null;
                yT = 0;
            } else if (yVar.yT() == 200) {
                yT = yVar.yS();
                errMsg = yVar.getErrorString();
            } else {
                yT = yVar.yT();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(yT);
        videoBlockUploadResult.setErrorMessage(errMsg);
        return videoBlockUploadResult;
    }

    private y b(String str, long j, int i, String str2) {
        y yVar = new y();
        yVar.o("forum_id", this.forumId);
        yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        yVar.o("total_length", String.valueOf(j));
        yVar.o("video_md5", str);
        yVar.o("block_num", String.valueOf(i));
        yVar.o("upload_id", str2);
        return yVar;
    }

    private void a(y yVar, int i, long j, int i2, int i3, byte[] bArr) {
        if (yVar != null) {
            yVar.o("chunk_no", String.valueOf(i));
            yVar.o("chunk_length", String.valueOf(j));
            yVar.o("chunk_num", String.valueOf(i2));
            yVar.o("block_no", String.valueOf(i3));
            yVar.d("video_chunk", bArr);
        }
    }
}
