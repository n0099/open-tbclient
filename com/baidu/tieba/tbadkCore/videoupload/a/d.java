package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.a.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long fEY;
    private String fEZ;
    private final int fFa;
    private int fFb;
    private e fFc;
    private boolean fFd;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fFe;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fFa = i;
        File file = new File(str);
        if (file.exists()) {
            this.fEY = file.length();
            this.fEZ = t.k(m.n(file));
            if (this.fEY % this.fFa == 0) {
                this.fFb = (int) (this.fEY / this.fFa);
            } else {
                this.fFb = ((int) (this.fEY / this.fFa)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aG(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fEY <= 0 || StringUtils.isNull(this.fEZ) || i <= 0 || this.fFd) {
            return null;
        }
        st(10);
        a a2 = a(this.fFb, i, false, null);
        if (a2 == null || this.fFd) {
            return null;
        }
        if (a2.fEU != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fEU);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        st(30);
        if (!StringUtils.isNull(a2.aPS)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fEZ);
            videoFinishResult2.setVideoUrl(a2.aPS);
            return videoFinishResult2;
        } else if (this.fFd) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fES;
            if (x.t(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fFb; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fET;
            f b = b(arrayList, str2, i);
            if (b == null || this.fFd) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            st(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fEZ);
                return videoFinishResult4;
            } else if (this.fFd || (a = a(this.fFb, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fEU == 0) {
                    videoFinishResult5.setVideoUrl(a.aPS);
                    videoFinishResult5.setVideoMd5(this.fEZ);
                } else {
                    videoFinishResult5.setErrorNo(a.fEU);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                }
                st(100);
                return videoFinishResult5;
            }
        }
    }

    private void st(int i) {
        if (this.fFc != null) {
            this.fFc.as(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fEY));
        zVar.n("chunk_size", String.valueOf(this.fFa));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fEZ);
        zVar.n("video_len", String.valueOf(j));
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.n("upload_id", str);
        }
        String uy = zVar.uy();
        if (zVar.uW().vS().oH()) {
            if (StringUtils.isNull(uy)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uy);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.uW().vS().uZ()) {
            aVar2.fEU = zVar.uW().vS().adb;
        } else {
            aVar2.fEU = zVar.uW().vS().oF;
        }
        aVar2.mErrorMessage = zVar.uW().vS().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.t(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fFe = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fFa, this.fFb, this.fEY, this.fEZ);
        } else {
            this.fFe = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fFa, this.fFb, this.fEY, this.fEZ);
        }
        this.fFe.a(this.fFc);
        f b = this.fFe.b(arrayList, str, i);
        this.fFe = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fFd = true;
        if (this.fFe != null) {
            this.fFe.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fFc = eVar;
    }
}
