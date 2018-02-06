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
    private long hdK;
    private String hdL;
    private final int hdM;
    private int hdN;
    private e hdO;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hdP;
    private h hdQ;
    private String mFileName;
    private boolean oP;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hdM = i;
        this.hdQ = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hdK = file.length();
            this.hdL = s.e(k.r(file));
            if (this.hdK % this.hdM == 0) {
                this.hdN = (int) (this.hdK / this.hdM);
            } else {
                this.hdN = ((int) (this.hdK / this.hdM)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aK(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hdK <= 0 || StringUtils.isNull(this.hdL) || i <= 0 || this.oP) {
            return null;
        }
        vY(10);
        a a2 = a(this.hdN, i, false, null);
        if (a2 == null || this.oP) {
            return null;
        }
        if (a2.gZm != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gZm);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            k(302, a2.gZm, a2.mErrorMessage);
            return videoFinishResult;
        }
        vY(30);
        if (!StringUtils.isNull(a2.bQV)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.hdL);
            videoFinishResult2.setVideoUrl(a2.bQV);
            bxW();
            return videoFinishResult2;
        } else if (this.oP) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.hdF;
            if (v.E(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hdN; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.hdG;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.oP) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                k(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            vY(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.hdL);
                bxW();
                return videoFinishResult4;
            } else if (this.oP || (a = a(this.hdN, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gZm == 0) {
                    videoFinishResult5.setVideoUrl(a.bQV);
                    videoFinishResult5.setVideoMd5(this.hdL);
                    bxW();
                } else {
                    videoFinishResult5.setErrorNo(a.gZm);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    k(304, a.gZm, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                vY(100);
                return videoFinishResult5;
            }
        }
    }

    private void vY(int i) {
        if (this.hdO != null) {
            this.hdO.aE(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.hdK));
        xVar.n("chunk_size", String.valueOf(this.hdM));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.hdL);
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
            aVar2.gZm = xVar.Cz().Dx().aYn;
        } else {
            aVar2.gZm = xVar.Cz().Dx().ajC;
        }
        aVar2.mErrorMessage = xVar.Cz().Dx().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.E(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hdP = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hdM, this.hdN, this.hdK, this.hdL);
        } else {
            this.hdP = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hdM, this.hdN, this.hdK, this.hdL);
        }
        this.hdP.a(this.hdO);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hdP.b(arrayList, str, i);
        this.hdP = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.oP = true;
        if (this.hdP != null) {
            this.hdP.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hdO = eVar;
    }

    private void k(int i, int i2, String str) {
        if (this.hdQ != null) {
            this.hdQ.h(i, i2, str);
        }
    }

    private void bxW() {
        if (this.hdQ != null) {
            this.hdQ.aWO();
        }
    }
}
