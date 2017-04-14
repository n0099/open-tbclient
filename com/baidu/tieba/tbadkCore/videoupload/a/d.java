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
    private final int fyA;
    private int fyB;
    private e fyC;
    private boolean fyD;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fyE;
    private long fyy;
    private String fyz;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fyA = i;
        File file = new File(str);
        if (file.exists()) {
            this.fyy = file.length();
            this.fyz = t.k(l.o(file));
            if (this.fyy % this.fyA == 0) {
                this.fyB = (int) (this.fyy / this.fyA);
            } else {
                this.fyB = ((int) (this.fyy / this.fyA)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aw(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fyy <= 0 || StringUtils.isNull(this.fyz) || i <= 0 || this.fyD) {
            return null;
        }
        se(10);
        a a2 = a(this.fyB, i, false, null);
        if (a2 == null || this.fyD) {
            return null;
        }
        if (a2.fyu != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fyu);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        se(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fyz);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.fyD) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fys;
            if (x.q(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fyB; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fyt;
            f b = b(arrayList, str2, i);
            if (b == null || this.fyD) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            se(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fyz);
                return videoFinishResult4;
            } else if (this.fyD || (a = a(this.fyB, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fyu == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.fyz);
                } else {
                    videoFinishResult5.setErrorNo(a.fyu);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new as("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                se(100);
                return videoFinishResult5;
            }
        }
    }

    private void se(int i) {
        if (this.fyC != null) {
            this.fyC.ad(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fyy));
        zVar.n("chunk_size", String.valueOf(this.fyA));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fyz);
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
            aVar2.fyu = zVar.vw().wq().ahk;
        } else {
            aVar2.fyu = zVar.vw().wq().vM;
        }
        aVar2.mErrorMessage = zVar.vw().wq().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.q(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fyE = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fyA, this.fyB, this.fyy, this.fyz);
        } else {
            this.fyE = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fyA, this.fyB, this.fyy, this.fyz);
        }
        this.fyE.a(this.fyC);
        f b = this.fyE.b(arrayList, str, i);
        this.fyE = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fyD = true;
        if (this.fyE != null) {
            this.fyE.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fyC = eVar;
    }
}
