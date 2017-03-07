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
    private long fwO;
    private String fwP;
    private final int fwQ;
    private int fwR;
    private e fwS;
    private boolean fwT;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fwU;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fwQ = i;
        File file = new File(str);
        if (file.exists()) {
            this.fwO = file.length();
            this.fwP = t.k(l.n(file));
            if (this.fwO % this.fwQ == 0) {
                this.fwR = (int) (this.fwO / this.fwQ);
            } else {
                this.fwR = ((int) (this.fwO / this.fwQ)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aw(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fwO <= 0 || StringUtils.isNull(this.fwP) || i <= 0 || this.fwT) {
            return null;
        }
        sg(10);
        a a2 = a(this.fwR, i, false, null);
        if (a2 == null || this.fwT) {
            return null;
        }
        if (a2.fwK != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fwK);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        sg(30);
        if (!StringUtils.isNull(a2.aTZ)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fwP);
            videoFinishResult2.setVideoUrl(a2.aTZ);
            return videoFinishResult2;
        } else if (this.fwT) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fwI;
            if (x.q(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fwR; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fwJ;
            f b = b(arrayList, str2, i);
            if (b == null || this.fwT) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            sg(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fwP);
                return videoFinishResult4;
            } else if (this.fwT || (a = a(this.fwR, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fwK == 0) {
                    videoFinishResult5.setVideoUrl(a.aTZ);
                    videoFinishResult5.setVideoMd5(this.fwP);
                } else {
                    videoFinishResult5.setErrorNo(a.fwK);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new as("c12024").Z(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                sg(100);
                return videoFinishResult5;
            }
        }
    }

    private void sg(int i) {
        if (this.fwS != null) {
            this.fwS.ac(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fwO));
        zVar.n("chunk_size", String.valueOf(this.fwQ));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fwP);
        zVar.n("video_len", String.valueOf(j));
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.n("upload_id", str);
        }
        String uB = zVar.uB();
        if (zVar.uZ().vT().isRequestSuccess()) {
            if (StringUtils.isNull(uB)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uB);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.uZ().vT().vc()) {
            aVar2.fwK = zVar.uZ().vT().agW;
        } else {
            aVar2.fwK = zVar.uZ().vT().wj;
        }
        aVar2.mErrorMessage = zVar.uZ().vT().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.q(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fwU = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fwQ, this.fwR, this.fwO, this.fwP);
        } else {
            this.fwU = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fwQ, this.fwR, this.fwO, this.fwP);
        }
        this.fwU.a(this.fwS);
        f b = this.fwU.b(arrayList, str, i);
        this.fwU = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fwT = true;
        if (this.fwU != null) {
            this.fwU.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fwS = eVar;
    }
}
