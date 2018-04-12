package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gzn;
    private String gzo;
    private final int gzp;
    private int gzq;
    private e gzr;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gzs;
    private h gzt;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gzp = i;
        this.gzt = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gzn = file.length();
            this.gzo = s.e(k.q(file));
            if (this.gzn % this.gzp == 0) {
                this.gzq = (int) (this.gzn / this.gzp);
            } else {
                this.gzq = ((int) (this.gzn / this.gzp)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aL(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gzn <= 0 || StringUtils.isNull(this.gzo) || i <= 0 || this.mCancelled) {
            return null;
        }
        tC(10);
        a a2 = a(this.gzq, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.dcD != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.dcD);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.dcD, a2.mErrorMessage);
            return videoFinishResult;
        }
        tC(30);
        if (!StringUtils.isNull(a2.baI)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gzo);
            videoFinishResult2.setVideoUrl(a2.baI);
            bta();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gzi;
            if (v.w(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gzq; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gzj;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.mCancelled) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                h(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            tC(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gzo);
                bta();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.gzq, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.dcD == 0) {
                    videoFinishResult5.setVideoUrl(a.baI);
                    videoFinishResult5.setVideoMd5(this.gzo);
                    bta();
                } else {
                    videoFinishResult5.setErrorNo(a.dcD);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.dcD, a.mErrorMessage);
                    TiebaStatic.log(new al("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tC(100);
                return videoFinishResult5;
            }
        }
    }

    private void tC(int i) {
        if (this.gzr != null) {
            this.gzr.as(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gzn));
        xVar.n("chunk_size", String.valueOf(this.gzp));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gzo);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String uL = xVar.uL();
        if (xVar.vj().wj().isRequestSuccess()) {
            if (StringUtils.isNull(uL)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uL);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.vj().wj().vm()) {
            aVar2.dcD = xVar.vj().wj().ajG;
        } else {
            aVar2.dcD = xVar.vj().wj().tX;
        }
        aVar2.mErrorMessage = xVar.vj().wj().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.w(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gzs = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gzp, this.gzq, this.gzn, this.gzo);
        } else {
            this.gzs = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gzp, this.gzq, this.gzn, this.gzo);
        }
        this.gzs.a(this.gzr);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gzs.b(arrayList, str, i);
        this.gzs = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gzs != null) {
            this.gzs.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gzr = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gzt != null) {
            this.gzt.e(i, i2, str);
        }
    }

    private void bta() {
        if (this.gzt != null) {
            this.gzt.aRJ();
        }
    }
}
