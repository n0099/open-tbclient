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
    private e hbA;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hbB;
    private h hbC;
    private long hbw;
    private String hbx;
    private final int hby;
    private int hbz;
    private String mFileName;
    private boolean oP;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hby = i;
        this.hbC = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hbw = file.length();
            this.hbx = s.e(k.r(file));
            if (this.hbw % this.hby == 0) {
                this.hbz = (int) (this.hbw / this.hby);
            } else {
                this.hbz = ((int) (this.hbw / this.hby)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aJ(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hbw <= 0 || StringUtils.isNull(this.hbx) || i <= 0 || this.oP) {
            return null;
        }
        vX(10);
        a a2 = a(this.hbz, i, false, null);
        if (a2 == null || this.oP) {
            return null;
        }
        if (a2.gWT != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gWT);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            j(HttpStatus.SC_MOVED_TEMPORARILY, a2.gWT, a2.mErrorMessage);
            return videoFinishResult;
        }
        vX(30);
        if (!StringUtils.isNull(a2.bON)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.hbx);
            videoFinishResult2.setVideoUrl(a2.bON);
            bwM();
            return videoFinishResult2;
        } else if (this.oP) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.hbr;
            if (v.E(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hbz; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.hbs;
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
            vX(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.hbx);
                bwM();
                return videoFinishResult4;
            } else if (this.oP || (a = a(this.hbz, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gWT == 0) {
                    videoFinishResult5.setVideoUrl(a.bON);
                    videoFinishResult5.setVideoMd5(this.hbx);
                    bwM();
                } else {
                    videoFinishResult5.setErrorNo(a.gWT);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    j(HttpStatus.SC_NOT_MODIFIED, a.gWT, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                vX(100);
                return videoFinishResult5;
            }
        }
    }

    private void vX(int i) {
        if (this.hbA != null) {
            this.hbA.ay(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.hbw));
        xVar.n("chunk_size", String.valueOf(this.hby));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.hbx);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String BI = xVar.BI();
        if (xVar.Cg().Dd().isRequestSuccess()) {
            if (StringUtils.isNull(BI)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(BI);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Cg().Dd().Cj()) {
            aVar2.gWT = xVar.Cg().Dd().aWE;
        } else {
            aVar2.gWT = xVar.Cg().Dd().ajD;
        }
        aVar2.mErrorMessage = xVar.Cg().Dd().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.E(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hbB = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hby, this.hbz, this.hbw, this.hbx);
        } else {
            this.hbB = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hby, this.hbz, this.hbw, this.hbx);
        }
        this.hbB.a(this.hbA);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hbB.b(arrayList, str, i);
        this.hbB = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.oP = true;
        if (this.hbB != null) {
            this.hbB.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hbA = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.hbC != null) {
            this.hbC.h(i, i2, str);
        }
    }

    private void bwM() {
        if (this.hbC != null) {
            this.hbC.aVf();
        }
    }
}
