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
    private long hdT;
    private String hdU;
    private final int hdV;
    private int hdW;
    private e hdX;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hdY;
    private h hdZ;
    private String mFileName;
    private boolean oO;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hdV = i;
        this.hdZ = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hdT = file.length();
            this.hdU = s.e(k.r(file));
            if (this.hdT % this.hdV == 0) {
                this.hdW = (int) (this.hdT / this.hdV);
            } else {
                this.hdW = ((int) (this.hdT / this.hdV)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aK(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hdT <= 0 || StringUtils.isNull(this.hdU) || i <= 0 || this.oO) {
            return null;
        }
        vZ(10);
        a a2 = a(this.hdW, i, false, null);
        if (a2 == null || this.oO) {
            return null;
        }
        if (a2.gZs != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gZs);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            k(302, a2.gZs, a2.mErrorMessage);
            return videoFinishResult;
        }
        vZ(30);
        if (!StringUtils.isNull(a2.bQL)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.hdU);
            videoFinishResult2.setVideoUrl(a2.bQL);
            bya();
            return videoFinishResult2;
        } else if (this.oO) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.hdO;
            if (v.E(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hdW; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.hdP;
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
                videoFinishResult4.setVideoMd5(this.hdU);
                bya();
                return videoFinishResult4;
            } else if (this.oO || (a = a(this.hdW, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gZs == 0) {
                    videoFinishResult5.setVideoUrl(a.bQL);
                    videoFinishResult5.setVideoMd5(this.hdU);
                    bya();
                } else {
                    videoFinishResult5.setErrorNo(a.gZs);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    k(304, a.gZs, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                vZ(100);
                return videoFinishResult5;
            }
        }
    }

    private void vZ(int i) {
        if (this.hdX != null) {
            this.hdX.aE(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.hdT));
        xVar.n("chunk_size", String.valueOf(this.hdV));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.hdU);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String Cb = xVar.Cb();
        if (xVar.Cz().Dx().isRequestSuccess()) {
            if (StringUtils.isNull(Cb)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(Cb);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Cz().Dx().CC()) {
            aVar2.gZs = xVar.Cz().Dx().aYd;
        } else {
            aVar2.gZs = xVar.Cz().Dx().ajw;
        }
        aVar2.mErrorMessage = xVar.Cz().Dx().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.E(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hdY = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hdV, this.hdW, this.hdT, this.hdU);
        } else {
            this.hdY = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hdV, this.hdW, this.hdT, this.hdU);
        }
        this.hdY.a(this.hdX);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hdY.b(arrayList, str, i);
        this.hdY = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.oO = true;
        if (this.hdY != null) {
            this.hdY.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hdX = eVar;
    }

    private void k(int i, int i2, String str) {
        if (this.hdZ != null) {
            this.hdZ.h(i, i2, str);
        }
    }

    private void bya() {
        if (this.hdZ != null) {
            this.hdZ.aWO();
        }
    }
}
