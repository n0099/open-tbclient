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
    private long gBZ;
    private String gCa;
    private final int gCb;
    private int gCc;
    private e gCd;
    private boolean gCe;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gCf;
    private h gCg;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gCb = i;
        this.gCg = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gBZ = file.length();
            this.gCa = s.e(k.q(file));
            if (this.gBZ % this.gCb == 0) {
                this.gCc = (int) (this.gBZ / this.gCb);
            } else {
                this.gCc = ((int) (this.gBZ / this.gCb)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aG(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gBZ <= 0 || StringUtils.isNull(this.gCa) || i <= 0 || this.gCe) {
            return null;
        }
        ux(10);
        a a2 = a(this.gCc, i, false, null);
        if (a2 == null || this.gCe) {
            return null;
        }
        if (a2.gBV != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gBV);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.gBV, a2.mErrorMessage);
            return videoFinishResult;
        }
        ux(30);
        if (!StringUtils.isNull(a2.baH)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gCa);
            videoFinishResult2.setVideoUrl(a2.baH);
            bxq();
            return videoFinishResult2;
        } else if (this.gCe) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gBT;
            if (v.w(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gCc; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gBU;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gCe) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                h(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            ux(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gCa);
                bxq();
                return videoFinishResult4;
            } else if (this.gCe || (a = a(this.gCc, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gBV == 0) {
                    videoFinishResult5.setVideoUrl(a.baH);
                    videoFinishResult5.setVideoMd5(this.gCa);
                    bxq();
                } else {
                    videoFinishResult5.setErrorNo(a.gBV);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.gBV, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                ux(100);
                return videoFinishResult5;
            }
        }
    }

    private void ux(int i) {
        if (this.gCd != null) {
            this.gCd.am(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gBZ));
        xVar.n("chunk_size", String.valueOf(this.gCb));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gCa);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String us = xVar.us();
        if (xVar.uQ().vO().isRequestSuccess()) {
            if (StringUtils.isNull(us)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(us);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.uQ().vO().uT()) {
            aVar2.gBV = xVar.uQ().vO().aiw;
        } else {
            aVar2.gBV = xVar.uQ().vO().vp;
        }
        aVar2.mErrorMessage = xVar.uQ().vO().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.w(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gCf = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gCb, this.gCc, this.gBZ, this.gCa);
        } else {
            this.gCf = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gCb, this.gCc, this.gBZ, this.gCa);
        }
        this.gCf.a(this.gCd);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gCf.b(arrayList, str, i);
        this.gCf = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gCe = true;
        if (this.gCf != null) {
            this.gCf.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gCd = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gCg != null) {
            this.gCg.f(i, i2, str);
        }
    }

    private void bxq() {
        if (this.gCg != null) {
            this.gCg.aNK();
        }
    }
}
