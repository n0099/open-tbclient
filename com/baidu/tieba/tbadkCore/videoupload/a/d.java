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
    private long gEI;
    private String gEJ;
    private final int gEK;
    private int gEL;
    private e gEM;
    private boolean gEN;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gEO;
    private h gEP;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gEK = i;
        this.gEP = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gEI = file.length();
            this.gEJ = s.e(k.q(file));
            if (this.gEI % this.gEK == 0) {
                this.gEL = (int) (this.gEI / this.gEK);
            } else {
                this.gEL = ((int) (this.gEI / this.gEK)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aH(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gEI <= 0 || StringUtils.isNull(this.gEJ) || i <= 0 || this.gEN) {
            return null;
        }
        uI(10);
        a a2 = a(this.gEL, i, false, null);
        if (a2 == null || this.gEN) {
            return null;
        }
        if (a2.gAi != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gAi);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.gAi, a2.mErrorMessage);
            return videoFinishResult;
        }
        uI(30);
        if (!StringUtils.isNull(a2.baI)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gEJ);
            videoFinishResult2.setVideoUrl(a2.baI);
            bxW();
            return videoFinishResult2;
        } else if (this.gEN) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gED;
            if (v.w(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gEL; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gEE;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gEN) {
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
                videoFinishResult4.setVideoMd5(this.gEJ);
                bxW();
                return videoFinishResult4;
            } else if (this.gEN || (a = a(this.gEL, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gAi == 0) {
                    videoFinishResult5.setVideoUrl(a.baI);
                    videoFinishResult5.setVideoMd5(this.gEJ);
                    bxW();
                } else {
                    videoFinishResult5.setErrorNo(a.gAi);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.gAi, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                uI(100);
                return videoFinishResult5;
            }
        }
    }

    private void uI(int i) {
        if (this.gEM != null) {
            this.gEM.am(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gEI));
        xVar.n("chunk_size", String.valueOf(this.gEK));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gEJ);
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
            aVar2.gAi = xVar.uN().vL().aiq;
        } else {
            aVar2.gAi = xVar.uN().vL().vm;
        }
        aVar2.mErrorMessage = xVar.uN().vL().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.w(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gEO = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gEK, this.gEL, this.gEI, this.gEJ);
        } else {
            this.gEO = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gEK, this.gEL, this.gEI, this.gEJ);
        }
        this.gEO.a(this.gEM);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gEO.b(arrayList, str, i);
        this.gEO = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gEN = true;
        if (this.gEO != null) {
            this.gEO.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gEM = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gEP != null) {
            this.gEP.f(i, i2, str);
        }
    }

    private void bxW() {
        if (this.gEP != null) {
            this.gEP.aNS();
        }
    }
}
