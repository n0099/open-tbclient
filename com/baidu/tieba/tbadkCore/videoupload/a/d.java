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
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class d implements b {
    private long hlB;
    private String hlC;
    private final int hlD;
    private int hlE;
    private e hlF;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hlG;
    private h hlH;
    private String mFileName;
    private boolean oP;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hlD = i;
        this.hlH = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hlB = file.length();
            this.hlC = s.e(k.r(file));
            if (this.hlB % this.hlD == 0) {
                this.hlE = (int) (this.hlB / this.hlD);
            } else {
                this.hlE = ((int) (this.hlB / this.hlD)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aH(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hlB <= 0 || StringUtils.isNull(this.hlC) || i <= 0 || this.oP) {
            return null;
        }
        xv(10);
        a a2 = a(this.hlE, i, false, null);
        if (a2 == null || this.oP) {
            return null;
        }
        if (a2.hgZ != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.hgZ);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            j(HttpStatus.SC_MOVED_TEMPORARILY, a2.hgZ, a2.mErrorMessage);
            return videoFinishResult;
        }
        xv(30);
        if (!StringUtils.isNull(a2.bOw)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.hlC);
            videoFinishResult2.setVideoUrl(a2.bOw);
            bDn();
            return videoFinishResult2;
        } else if (this.oP) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.hlw;
            if (v.G(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hlE; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.hlx;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.oP) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                j(HttpStatus.SC_SEE_OTHER, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            xv(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.hlC);
                bDn();
                return videoFinishResult4;
            } else if (this.oP || (a = a(this.hlE, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.hgZ == 0) {
                    videoFinishResult5.setVideoUrl(a.bOw);
                    videoFinishResult5.setVideoMd5(this.hlC);
                    bDn();
                } else {
                    videoFinishResult5.setErrorNo(a.hgZ);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    j(HttpStatus.SC_NOT_MODIFIED, a.hgZ, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                xv(100);
                return videoFinishResult5;
            }
        }
    }

    private void xv(int i) {
        if (this.hlF != null) {
            this.hlF.aA(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.hlB));
        xVar.n("chunk_size", String.valueOf(this.hlD));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.hlC);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String BP = xVar.BP();
        if (xVar.Cn().Dl().isRequestSuccess()) {
            if (StringUtils.isNull(BP)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(BP);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Cn().Dl().Cq()) {
            aVar2.hgZ = xVar.Cn().Dl().aWC;
        } else {
            aVar2.hgZ = xVar.Cn().Dl().ajA;
        }
        aVar2.mErrorMessage = xVar.Cn().Dl().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.G(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hlG = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hlD, this.hlE, this.hlB, this.hlC);
        } else {
            this.hlG = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hlD, this.hlE, this.hlB, this.hlC);
        }
        this.hlG.a(this.hlF);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hlG.b(arrayList, str, i);
        this.hlG = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.oP = true;
        if (this.hlG != null) {
            this.hlG.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hlF = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.hlH != null) {
            this.hlH.h(i, i2, str);
        }
    }

    private void bDn() {
        if (this.hlH != null) {
            this.hlH.aUV();
        }
    }
}
