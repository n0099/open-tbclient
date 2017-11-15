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
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gtd;
    private String gte;
    private final int gtf;
    private int gtg;
    private e gth;
    private boolean gti;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gtj;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gtf = i;
        File file = new File(str);
        if (file.exists()) {
            this.gtd = file.length();
            this.gte = s.e(k.q(file));
            if (this.gtd % this.gtf == 0) {
                this.gtg = (int) (this.gtd / this.gtf);
            } else {
                this.gtg = ((int) (this.gtd / this.gtf)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aF(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gtd <= 0 || StringUtils.isNull(this.gte) || i <= 0 || this.gti) {
            return null;
        }
        uh(10);
        a a2 = a(this.gtg, i, false, null);
        if (a2 == null || this.gti) {
            return null;
        }
        if (a2.gsZ != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gsZ);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        uh(30);
        if (!StringUtils.isNull(a2.aXD)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gte);
            videoFinishResult2.setVideoUrl(a2.aXD);
            return videoFinishResult2;
        } else if (this.gti) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gsX;
            if (v.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gtg; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gsY;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gti) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            uh(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gte);
                return videoFinishResult4;
            } else if (this.gti || (a = a(this.gtg, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gsZ == 0) {
                    videoFinishResult5.setVideoUrl(a.aXD);
                    videoFinishResult5.setVideoMd5(this.gte);
                } else {
                    videoFinishResult5.setErrorNo(a.gsZ);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                uh(100);
                return videoFinishResult5;
            }
        }
    }

    private void uh(int i) {
        if (this.gth != null) {
            this.gth.ac(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gtd));
        xVar.n("chunk_size", String.valueOf(this.gtf));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gte);
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
            aVar2.gsZ = xVar.uN().vL().ahZ;
        } else {
            aVar2.gsZ = xVar.uN().vL().vp;
        }
        aVar2.mErrorMessage = xVar.uN().vL().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gtj = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gtf, this.gtg, this.gtd, this.gte);
        } else {
            this.gtj = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gtf, this.gtg, this.gtd, this.gte);
        }
        this.gtj.a(this.gth);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gtj.b(arrayList, str, i);
        this.gtj = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gti = true;
        if (this.gtj != null) {
            this.gtj.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gth = eVar;
    }
}
