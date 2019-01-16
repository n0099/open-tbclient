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
    private long hsG;
    private final int hsH;
    private int hsI;
    private e hsJ;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hsK;
    private h hsL;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hsH = i;
        this.hsL = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hsG = file.length();
            this.Xf = s.i(l.x(file));
            if (this.hsG % this.hsH == 0) {
                this.hsI = (int) (this.hsG / this.hsH);
            } else {
                this.hsI = ((int) (this.hsG / this.hsH)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aW(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.hsG <= 0 || StringUtils.isNull(this.Xf) || i <= 0 || this.mCancelled) {
            return null;
        }
        vY(10);
        a b2 = b(this.hsI, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dSz != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dSz);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            g(302, b2.dSz, b2.mErrorMessage);
            return videoFinishResult;
        }
        vY(30);
        if (!StringUtils.isNull(b2.aFq)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.Xf);
            videoFinishResult2.setVideoUrl(b2.aFq);
            bFX();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.hsB;
            if (v.I(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hsI; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.hsC;
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
            } else if (this.mCancelled || (b = b(this.hsI, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dSz == 0) {
                    videoFinishResult5.setVideoUrl(b.aFq);
                    videoFinishResult5.setVideoMd5(this.Xf);
                    bFX();
                } else {
                    videoFinishResult5.setErrorNo(b.dSz);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    g(304, b.dSz, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").aB("params", b.mErrorMessage));
                }
                vY(100);
                return videoFinishResult5;
            }
        }
    }

    private void vY(int i) {
        if (this.hsJ != null) {
            this.hsJ.az(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.hsG));
        xVar.x("chunk_size", String.valueOf(this.hsH));
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
            aVar2.dSz = xVar.Dw().Ev().aDW;
        } else {
            aVar2.dSz = xVar.Dw().Ev().De;
        }
        aVar2.mErrorMessage = xVar.Dw().Ev().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.I(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hsK = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hsH, this.hsI, this.hsG, this.Xf);
        } else {
            this.hsK = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hsH, this.hsI, this.hsG, this.Xf);
        }
        this.hsK.a(this.hsJ);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hsK.b(arrayList, str, i);
        this.hsK = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.hsK != null) {
            this.hsK.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hsJ = eVar;
    }

    private void g(int i, int i2, String str) {
        if (this.hsL != null) {
            this.hsL.e(i, i2, str);
        }
    }

    private void bFX() {
        if (this.hsL != null) {
            this.hsL.bdE();
        }
    }
}
