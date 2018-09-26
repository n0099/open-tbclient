package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gYA;
    private String gYB;
    private final int gYC;
    private int gYD;
    private e gYE;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gYF;
    private h gYG;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gYC = i;
        this.gYG = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gYA = file.length();
            this.gYB = s.i(l.w(file));
            if (this.gYA % this.gYC == 0) {
                this.gYD = (int) (this.gYA / this.gYC);
            } else {
                this.gYD = ((int) (this.gYA / this.gYC)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aQ(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gYA <= 0 || StringUtils.isNull(this.gYB) || i <= 0 || this.mCancelled) {
            return null;
        }
        uw(10);
        a a2 = a(this.gYD, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.dzx != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.dzx);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.dzx, a2.mErrorMessage);
            return videoFinishResult;
        }
        uw(30);
        if (!StringUtils.isNull(a2.avN)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gYB);
            videoFinishResult2.setVideoUrl(a2.avN);
            bzT();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gYv;
            if (v.z(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gYD; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gYw;
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
            uw(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gYB);
                bzT();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.gYD, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.dzx == 0) {
                    videoFinishResult5.setVideoUrl(a.avN);
                    videoFinishResult5.setVideoMd5(this.gYB);
                    bzT();
                } else {
                    videoFinishResult5.setErrorNo(a.dzx);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.dzx, a.mErrorMessage);
                    TiebaStatic.log(new am("c12024").al(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                uw(100);
                return videoFinishResult5;
            }
        }
    }

    private void uw(int i) {
        if (this.gYE != null) {
            this.gYE.aw(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.u("chunk_sum", String.valueOf(i));
        xVar.u("video_size", String.valueOf(this.gYA));
        xVar.u("chunk_size", String.valueOf(this.gYC));
        xVar.u("is_merge", String.valueOf(z ? 1 : 0));
        xVar.u("video_md5", this.gYB);
        xVar.u("video_len", String.valueOf(j));
        xVar.u("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.u("upload_id", str);
        }
        String zt = xVar.zt();
        if (xVar.zR().AQ().isRequestSuccess()) {
            if (StringUtils.isNull(zt)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(zt);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.zR().AQ().zU()) {
            aVar2.dzx = xVar.zR().AQ().aut;
        } else {
            aVar2.dzx = xVar.zR().AQ().Cq;
        }
        aVar2.mErrorMessage = xVar.zR().AQ().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.z(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gYF = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gYC, this.gYD, this.gYA, this.gYB);
        } else {
            this.gYF = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gYC, this.gYD, this.gYA, this.gYB);
        }
        this.gYF.a(this.gYE);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gYF.b(arrayList, str, i);
        this.gYF = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gYF != null) {
            this.gYF.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gYE = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gYG != null) {
            this.gYG.e(i, i2, str);
        }
    }

    private void bzT() {
        if (this.gYG != null) {
            this.gYG.aXQ();
        }
    }
}
