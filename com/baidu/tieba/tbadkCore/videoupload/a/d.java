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
    private long gzk;
    private String gzl;
    private final int gzm;
    private int gzn;
    private e gzo;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gzp;
    private h gzq;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gzm = i;
        this.gzq = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gzk = file.length();
            this.gzl = s.e(k.q(file));
            if (this.gzk % this.gzm == 0) {
                this.gzn = (int) (this.gzk / this.gzm);
            } else {
                this.gzn = ((int) (this.gzk / this.gzm)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aL(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gzk <= 0 || StringUtils.isNull(this.gzl) || i <= 0 || this.mCancelled) {
            return null;
        }
        tB(10);
        a a2 = a(this.gzn, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.dcA != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.dcA);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.dcA, a2.mErrorMessage);
            return videoFinishResult;
        }
        tB(30);
        if (!StringUtils.isNull(a2.baI)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gzl);
            videoFinishResult2.setVideoUrl(a2.baI);
            bta();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gzf;
            if (v.w(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gzn; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gzg;
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
            tB(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gzl);
                bta();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.gzn, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.dcA == 0) {
                    videoFinishResult5.setVideoUrl(a.baI);
                    videoFinishResult5.setVideoMd5(this.gzl);
                    bta();
                } else {
                    videoFinishResult5.setErrorNo(a.dcA);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.dcA, a.mErrorMessage);
                    TiebaStatic.log(new al("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tB(100);
                return videoFinishResult5;
            }
        }
    }

    private void tB(int i) {
        if (this.gzo != null) {
            this.gzo.as(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gzk));
        xVar.n("chunk_size", String.valueOf(this.gzm));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gzl);
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
            aVar2.dcA = xVar.vj().wj().ajG;
        } else {
            aVar2.dcA = xVar.vj().wj().tX;
        }
        aVar2.mErrorMessage = xVar.vj().wj().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.w(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gzp = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gzm, this.gzn, this.gzk, this.gzl);
        } else {
            this.gzp = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gzm, this.gzn, this.gzk, this.gzl);
        }
        this.gzp.a(this.gzo);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gzp.b(arrayList, str, i);
        this.gzp = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gzp != null) {
            this.gzp.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gzo = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gzq != null) {
            this.gzq.e(i, i2, str);
        }
    }

    private void bta() {
        if (this.gzq != null) {
            this.gzq.aRJ();
        }
    }
}
