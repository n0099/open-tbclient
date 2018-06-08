package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private boolean azQ = false;
    private final int chunkLength;
    private final String forumId;
    private h gJZ;
    private y gLL;
    private final int gLM;
    private e gLN;

    public c(String str, int i, int i2, h hVar) {
        this.forumId = str;
        this.chunkLength = i;
        this.gLM = i2 / i;
        this.gJZ = hVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gLN = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aO(String str, int i) throws IOException {
        VideoBlockUploadResult videoBlockUploadResult;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        com.baidu.tieba.tbadkCore.videoupload.b.byc();
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        String g = s.g(l.q(file));
        if (!StringUtils.isNull(g)) {
            g = g.toLowerCase();
        }
        com.baidu.tieba.tbadkCore.videoupload.c ud = com.baidu.tieba.tbadkCore.videoupload.b.ud(g);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = file.length();
        int z = z(length, this.chunkLength);
        int z2 = z(z, this.gLM);
        String str2 = ud != null ? ud.gLH : null;
        VideoBlockUploadResult videoBlockUploadResult2 = null;
        int i2 = ud != null ? ud.gLI : 0;
        if (i2 < z && randomAccessFile.skipBytes(this.chunkLength * i2) < this.chunkLength * i2) {
            randomAccessFile.close();
            return null;
        }
        while (i2 < z) {
            Y(i2, z, 10);
            int i3 = i2 + 1;
            byte[] a = a(randomAccessFile, i2, z, length);
            Y(i2, z, 25);
            if (a == null) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else if (a.length <= 0) {
                videoBlockUploadResult = videoBlockUploadResult2;
            } else {
                Y(i2, z, 40);
                this.gLL = b(g, length, z2, str2);
                Y(i2, z, 55);
                if (i3 == z) {
                    videoBlockUploadResult = c(a, i3, z2, z);
                } else if (i3 % this.gLM == 0) {
                    videoBlockUploadResult = b(a, i3, z2, z);
                    str2 = videoBlockUploadResult.upload_id;
                } else {
                    videoBlockUploadResult = b(i3, a, z2, z);
                }
                Y(i2, z, 80);
                if (videoBlockUploadResult != null && !videoBlockUploadResult.isSuccess()) {
                    videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                    videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                    if (this.gJZ != null) {
                        this.gJZ.e(HttpStatus.SC_USE_PROXY, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                    }
                    if (videoFinishResult.getErrorNo() == 320033) {
                        com.baidu.tieba.tbadkCore.videoupload.b.uc(g);
                    }
                    randomAccessFile.close();
                    TiebaStatic.log(new am("c12024").ah(LegoListActivityConfig.PARAMS, videoBlockUploadResult.getErrorMessage()));
                    return videoFinishResult;
                }
                com.baidu.tieba.tbadkCore.videoupload.b.l(g, str2, i3);
                Y(i2, z, 100);
            }
            i2++;
            videoBlockUploadResult2 = videoBlockUploadResult;
        }
        videoFinishResult.setErrorMessage(null);
        videoFinishResult.setErrorNo(0);
        if (videoBlockUploadResult2 != null) {
            videoFinishResult.setVideoUrl(videoBlockUploadResult2.video_url);
        }
        com.baidu.tieba.tbadkCore.videoupload.b.uc(g);
        videoFinishResult.setVideoMd5(g);
        randomAccessFile.close();
        if (this.gJZ != null) {
            this.gJZ.aWG();
        }
        return videoFinishResult;
    }

    private void Y(int i, int i2, int i3) {
        if (this.gLN != null) {
            this.gLN.aC((i + (i3 / 100.0f)) / i2);
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
        this.azQ = true;
        if (this.gLL != null) {
            this.gLL.hN();
        }
    }

    private VideoBlockUploadResult b(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i % this.gLM;
        int length = bArr.length;
        int i6 = (i / this.gLM) + 1;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gLM);
        } else {
            i4 = this.gLM;
        }
        a(this.gLL, i5, length, i4, i6, bArr);
        this.gLL.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
        return b(this.gLL);
    }

    private VideoBlockUploadResult b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = this.gLM;
        int length = bArr.length;
        int i6 = i / this.gLM;
        if (i6 == i2) {
            i4 = i3 - ((i6 - 1) * this.gLM);
        } else {
            i4 = this.gLM;
        }
        a(this.gLL, i5, length, i4, i6, bArr);
        this.gLL.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
        return b(this.gLL);
    }

    private VideoBlockUploadResult c(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int length = bArr.length;
        if (i % this.gLM == 0) {
            i4 = i / this.gLM;
        } else {
            i4 = (i / this.gLM) + 1;
        }
        if (i4 == i2) {
            i5 = i3 - ((i4 - 1) * this.gLM);
        } else {
            i5 = this.gLM;
        }
        a(this.gLL, i5, length, i5, i4, bArr);
        this.gLL.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
        return b(this.gLL);
    }

    private VideoBlockUploadResult b(y yVar) {
        int yO;
        String errMsg;
        VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
        if (this.azQ) {
            yO = yVar.yN();
            errMsg = yVar.getErrorString();
        } else {
            String yo = yVar.yo();
            if (yVar.yJ().zJ().isRequestSuccess()) {
                OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(yo, VideoBlockUploadResult.class);
                if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                    VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                    if (videoBlockUploadResult2.isSuccess()) {
                        int errorCode = videoBlockUploadResult2.getErrorCode();
                        String errorMessage = videoBlockUploadResult2.getErrorMessage();
                        videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                        videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                        errMsg = errorMessage;
                        yO = errorCode;
                    }
                }
                errMsg = null;
                yO = 0;
            } else if (yVar.yO() == 200) {
                yO = yVar.yN();
                errMsg = yVar.getErrorString();
            } else {
                yO = yVar.yO();
                errMsg = TbErrInfo.getErrMsg(-7);
            }
        }
        videoBlockUploadResult.setErrorNo(yO);
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
