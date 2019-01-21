package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private String Xf;
    private long hsH;
    private final int hsI;
    private int hsJ;
    private e hsK;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hsL;
    private h hsM;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hsI = i;
        this.hsM = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hsH = file.length();
            this.Xf = s.i(l.x(file));
            if (this.hsH % this.hsI == 0) {
                this.hsJ = (int) (this.hsH / this.hsI);
            } else {
                this.hsJ = ((int) (this.hsH / this.hsI)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aW(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.hsH <= 0 || StringUtils.isNull(this.Xf) || i <= 0 || this.mCancelled) {
            return null;
        }
        vY(10);
        a b2 = b(this.hsJ, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dSA != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dSA);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            g(302, b2.dSA, b2.mErrorMessage);
            return videoFinishResult;
        }
        vY(30);
        if (!StringUtils.isNull(b2.aFr)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.Xf);
            videoFinishResult2.setVideoUrl(b2.aFr);
            bFX();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.hsC;
            if (v.I(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hsJ; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.hsD;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                g(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            vY(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.Xf);
                bFX();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.hsJ, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dSA == 0) {
                    videoFinishResult5.setVideoUrl(b.aFr);
                    videoFinishResult5.setVideoMd5(this.Xf);
                    bFX();
                } else {
                    videoFinishResult5.setErrorNo(b.dSA);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    g(304, b.dSA, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").aB("params", b.mErrorMessage));
                }
                vY(100);
                return videoFinishResult5;
            }
        }
    }

    private void vY(int i) {
        if (this.hsK != null) {
            this.hsK.az(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.hsH));
        xVar.x("chunk_size", String.valueOf(this.hsI));
        xVar.x("is_merge", String.valueOf(z ? 1 : 0));
        xVar.x("video_md5", this.Xf);
        xVar.x("video_len", String.valueOf(j));
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.x("upload_id", str);
        }
        String CY = xVar.CY();
        if (xVar.Dw().Ev().isRequestSuccess()) {
            if (StringUtils.isNull(CY)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(CY);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Dw().Ev().Dz()) {
            aVar2.dSA = xVar.Dw().Ev().aDX;
        } else {
            aVar2.dSA = xVar.Dw().Ev().De;
        }
        aVar2.mErrorMessage = xVar.Dw().Ev().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.I(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hsL = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hsI, this.hsJ, this.hsH, this.Xf);
        } else {
            this.hsL = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hsI, this.hsJ, this.hsH, this.Xf);
        }
        this.hsL.a(this.hsK);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hsL.b(arrayList, str, i);
        this.hsL = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.hsL != null) {
            this.hsL.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hsK = eVar;
    }

    private void g(int i, int i2, String str) {
        if (this.hsM != null) {
            this.hsM.e(i, i2, str);
        }
    }

    private void bFX() {
        if (this.hsM != null) {
            this.hsM.bdE();
        }
    }
}
