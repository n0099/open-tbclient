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
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hdA;
    private h hdB;
    private long hdv;
    private String hdw;
    private final int hdx;
    private int hdy;
    private e hdz;
    private String mFileName;
    private boolean oO;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hdx = i;
        this.hdB = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hdv = file.length();
            this.hdw = s.e(k.r(file));
            if (this.hdv % this.hdx == 0) {
                this.hdy = (int) (this.hdv / this.hdx);
            } else {
                this.hdy = ((int) (this.hdv / this.hdx)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aK(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hdv <= 0 || StringUtils.isNull(this.hdw) || i <= 0 || this.oO) {
            return null;
        }
        vZ(10);
        a a2 = a(this.hdy, i, false, null);
        if (a2 == null || this.oO) {
            return null;
        }
        if (a2.gYX != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gYX);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            k(302, a2.gYX, a2.mErrorMessage);
            return videoFinishResult;
        }
        vZ(30);
        if (!StringUtils.isNull(a2.bQI)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.hdw);
            videoFinishResult2.setVideoUrl(a2.bQI);
            bxV();
            return videoFinishResult2;
        } else if (this.oO) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.hdq;
            if (v.E(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hdy; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.hdr;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.oO) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                k(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            vZ(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.hdw);
                bxV();
                return videoFinishResult4;
            } else if (this.oO || (a = a(this.hdy, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gYX == 0) {
                    videoFinishResult5.setVideoUrl(a.bQI);
                    videoFinishResult5.setVideoMd5(this.hdw);
                    bxV();
                } else {
                    videoFinishResult5.setErrorNo(a.gYX);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    k(304, a.gYX, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                vZ(100);
                return videoFinishResult5;
            }
        }
    }

    private void vZ(int i) {
        if (this.hdz != null) {
            this.hdz.aE(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.hdv));
        xVar.n("chunk_size", String.valueOf(this.hdx));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.hdw);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String Ca = xVar.Ca();
        if (xVar.Cy().Dw().isRequestSuccess()) {
            if (StringUtils.isNull(Ca)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(Ca);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Cy().Dw().CB()) {
            aVar2.gYX = xVar.Cy().Dw().aYb;
        } else {
            aVar2.gYX = xVar.Cy().Dw().ajw;
        }
        aVar2.mErrorMessage = xVar.Cy().Dw().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.E(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hdA = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hdx, this.hdy, this.hdv, this.hdw);
        } else {
            this.hdA = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hdx, this.hdy, this.hdv, this.hdw);
        }
        this.hdA.a(this.hdz);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hdA.b(arrayList, str, i);
        this.hdA = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.oO = true;
        if (this.hdA != null) {
            this.hdA.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hdz = eVar;
    }

    private void k(int i, int i2, String str) {
        if (this.hdB != null) {
            this.hdB.h(i, i2, str);
        }
    }

    private void bxV() {
        if (this.hdB != null) {
            this.hdB.aWN();
        }
    }
}
