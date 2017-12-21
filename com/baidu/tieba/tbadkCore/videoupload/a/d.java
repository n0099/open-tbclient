package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gEN;
    private String gEO;
    private final int gEP;
    private int gEQ;
    private e gER;
    private boolean gES;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gET;
    private h gEU;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gEP = i;
        this.gEU = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gEN = file.length();
            this.gEO = s.e(k.q(file));
            if (this.gEN % this.gEP == 0) {
                this.gEQ = (int) (this.gEN / this.gEP);
            } else {
                this.gEQ = ((int) (this.gEN / this.gEP)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aH(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gEN <= 0 || StringUtils.isNull(this.gEO) || i <= 0 || this.gES) {
            return null;
        }
        uI(10);
        a a2 = a(this.gEQ, i, false, null);
        if (a2 == null || this.gES) {
            return null;
        }
        if (a2.gAn != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gAn);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.gAn, a2.mErrorMessage);
            return videoFinishResult;
        }
        uI(30);
        if (!StringUtils.isNull(a2.baM)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gEO);
            videoFinishResult2.setVideoUrl(a2.baM);
            bxX();
            return videoFinishResult2;
        } else if (this.gES) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gEI;
            if (v.w(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gEQ; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gEJ;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gES) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                h(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            uI(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gEO);
                bxX();
                return videoFinishResult4;
            } else if (this.gES || (a = a(this.gEQ, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gAn == 0) {
                    videoFinishResult5.setVideoUrl(a.baM);
                    videoFinishResult5.setVideoMd5(this.gEO);
                    bxX();
                } else {
                    videoFinishResult5.setErrorNo(a.gAn);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.gAn, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                uI(100);
                return videoFinishResult5;
            }
        }
    }

    private void uI(int i) {
        if (this.gER != null) {
            this.gER.am(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gEN));
        xVar.n("chunk_size", String.valueOf(this.gEP));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gEO);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String up = xVar.up();
        if (xVar.uN().vL().isRequestSuccess()) {
            if (StringUtils.isNull(up)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(up);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.uN().vL().uQ()) {
            aVar2.gAn = xVar.uN().vL().ait;
        } else {
            aVar2.gAn = xVar.uN().vL().vn;
        }
        aVar2.mErrorMessage = xVar.uN().vL().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.w(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gET = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gEP, this.gEQ, this.gEN, this.gEO);
        } else {
            this.gET = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gEP, this.gEQ, this.gEN, this.gEO);
        }
        this.gET.a(this.gER);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gET.b(arrayList, str, i);
        this.gET = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gES = true;
        if (this.gET != null) {
            this.gET.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gER = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gEU != null) {
            this.gEU.f(i, i2, str);
        }
    }

    private void bxX() {
        if (this.gEU != null) {
            this.gEU.aNT();
        }
    }
}
