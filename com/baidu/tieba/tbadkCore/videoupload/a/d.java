package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.a.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long fAO;
    private String fAP;
    private final int fAQ;
    private int fAR;
    private e fAS;
    private boolean fAT;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fAU;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fAQ = i;
        File file = new File(str);
        if (file.exists()) {
            this.fAO = file.length();
            this.fAP = t.k(l.o(file));
            if (this.fAO % this.fAQ == 0) {
                this.fAR = (int) (this.fAO / this.fAQ);
            } else {
                this.fAR = ((int) (this.fAO / this.fAQ)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aw(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fAO <= 0 || StringUtils.isNull(this.fAP) || i <= 0 || this.fAT) {
            return null;
        }
        sk(10);
        a a2 = a(this.fAR, i, false, null);
        if (a2 == null || this.fAT) {
            return null;
        }
        if (a2.fAK != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fAK);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        sk(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fAP);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.fAT) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fAI;
            if (x.q(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fAR; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fAJ;
            f b = b(arrayList, str2, i);
            if (b == null || this.fAT) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            sk(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fAP);
                return videoFinishResult4;
            } else if (this.fAT || (a = a(this.fAR, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fAK == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.fAP);
                } else {
                    videoFinishResult5.setErrorNo(a.fAK);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new as("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                sk(100);
                return videoFinishResult5;
            }
        }
    }

    private void sk(int i) {
        if (this.fAS != null) {
            this.fAS.ad(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fAO));
        zVar.n("chunk_size", String.valueOf(this.fAQ));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fAP);
        zVar.n("video_len", String.valueOf(j));
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.n("upload_id", str);
        }
        String uY = zVar.uY();
        if (zVar.vw().wq().isRequestSuccess()) {
            if (StringUtils.isNull(uY)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uY);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.vw().wq().vz()) {
            aVar2.fAK = zVar.vw().wq().ahl;
        } else {
            aVar2.fAK = zVar.vw().wq().vQ;
        }
        aVar2.mErrorMessage = zVar.vw().wq().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.q(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fAU = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fAQ, this.fAR, this.fAO, this.fAP);
        } else {
            this.fAU = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fAQ, this.fAR, this.fAO, this.fAP);
        }
        this.fAU.a(this.fAS);
        f b = this.fAU.b(arrayList, str, i);
        this.fAU = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fAT = true;
        if (this.fAU != null) {
            this.fAU.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fAS = eVar;
    }
}
