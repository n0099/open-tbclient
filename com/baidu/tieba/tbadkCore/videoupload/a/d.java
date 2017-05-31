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
    private long fEP;
    private String fEQ;
    private final int fER;
    private int fES;
    private e fET;
    private boolean fEU;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fEV;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fER = i;
        File file = new File(str);
        if (file.exists()) {
            this.fEP = file.length();
            this.fEQ = t.k(l.o(file));
            if (this.fEP % this.fER == 0) {
                this.fES = (int) (this.fEP / this.fER);
            } else {
                this.fES = ((int) (this.fEP / this.fER)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult ax(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fEP <= 0 || StringUtils.isNull(this.fEQ) || i <= 0 || this.fEU) {
            return null;
        }
        sy(10);
        a a2 = a(this.fES, i, false, null);
        if (a2 == null || this.fEU) {
            return null;
        }
        if (a2.fEL != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fEL);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        sy(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fEQ);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.fEU) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fEJ;
            if (x.r(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fES; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fEK;
            f b = b(arrayList, str2, i);
            if (b == null || this.fEU) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            sy(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fEQ);
                return videoFinishResult4;
            } else if (this.fEU || (a = a(this.fES, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fEL == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.fEQ);
                } else {
                    videoFinishResult5.setErrorNo(a.fEL);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new as("c12024").Z(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                sy(100);
                return videoFinishResult5;
            }
        }
    }

    private void sy(int i) {
        if (this.fET != null) {
            this.fET.ad(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fEP));
        zVar.n("chunk_size", String.valueOf(this.fER));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fEQ);
        zVar.n("video_len", String.valueOf(j));
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.n("upload_id", str);
        }
        String ug = zVar.ug();
        if (zVar.uF().vB().isRequestSuccess()) {
            if (StringUtils.isNull(ug)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(ug);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.uF().vB().uI()) {
            aVar2.fEL = zVar.uF().vB().agu;
        } else {
            aVar2.fEL = zVar.uF().vB().vR;
        }
        aVar2.mErrorMessage = zVar.uF().vB().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.r(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fEV = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fER, this.fES, this.fEP, this.fEQ);
        } else {
            this.fEV = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fER, this.fES, this.fEP, this.fEQ);
        }
        this.fEV.a(this.fET);
        f b = this.fEV.b(arrayList, str, i);
        this.fEV = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fEU = true;
        if (this.fEV != null) {
            this.fEV.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fET = eVar;
    }
}
