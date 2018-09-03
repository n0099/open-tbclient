package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gQP;
    private String gQQ;
    private final int gQR;
    private int gQS;
    private e gQT;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gQU;
    private h gQV;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gQR = i;
        this.gQV = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gQP = file.length();
            this.gQQ = s.g(l.q(file));
            if (this.gQP % this.gQR == 0) {
                this.gQS = (int) (this.gQP / this.gQR);
            } else {
                this.gQS = ((int) (this.gQP / this.gQR)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aL(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gQP <= 0 || StringUtils.isNull(this.gQQ) || i <= 0 || this.mCancelled) {
            return null;
        }
        tW(10);
        a a2 = a(this.gQS, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.dsR != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.dsR);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.dsR, a2.mErrorMessage);
            return videoFinishResult;
        }
        tW(30);
        if (!StringUtils.isNull(a2.bdb)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gQQ);
            videoFinishResult2.setVideoUrl(a2.bdb);
            bxl();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gQK;
            if (w.z(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gQS; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gQL;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.mCancelled) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                h(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            tW(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gQQ);
                bxl();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.gQS, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.dsR == 0) {
                    videoFinishResult5.setVideoUrl(a.bdb);
                    videoFinishResult5.setVideoMd5(this.gQQ);
                    bxl();
                } else {
                    videoFinishResult5.setErrorNo(a.dsR);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.dsR, a.mErrorMessage);
                    TiebaStatic.log(new an("c12024").ae(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tW(100);
                return videoFinishResult5;
            }
        }
    }

    private void tW(int i) {
        if (this.gQT != null) {
            this.gQT.aC(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        yVar.o("chunk_sum", String.valueOf(i));
        yVar.o("video_size", String.valueOf(this.gQP));
        yVar.o("chunk_size", String.valueOf(this.gQR));
        yVar.o("is_merge", String.valueOf(z ? 1 : 0));
        yVar.o("video_md5", this.gQQ);
        yVar.o("video_len", String.valueOf(j));
        yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            yVar.o("upload_id", str);
        }
        String yo = yVar.yo();
        if (yVar.yM().zL().isRequestSuccess()) {
            if (StringUtils.isNull(yo)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(yo);
            return aVar;
        }
        a aVar2 = new a();
        if (yVar.yM().zL().yP()) {
            aVar2.dsR = yVar.yM().zL().arV;
        } else {
            aVar2.dsR = yVar.yM().zL().zV;
        }
        aVar2.mErrorMessage = yVar.yM().zL().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (w.z(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gQU = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gQR, this.gQS, this.gQP, this.gQQ);
        } else {
            this.gQU = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gQR, this.gQS, this.gQP, this.gQQ);
        }
        this.gQU.a(this.gQT);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gQU.b(arrayList, str, i);
        this.gQU = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gQU != null) {
            this.gQU.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gQT = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gQV != null) {
            this.gQV.e(i, i2, str);
        }
    }

    private void bxl() {
        if (this.gQV != null) {
            this.gQV.aVC();
        }
    }
}
