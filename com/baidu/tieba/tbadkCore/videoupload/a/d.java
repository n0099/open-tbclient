package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.a.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long fsr;
    private String fss;
    private final int fst;
    private int fsu;
    private e fsv;
    private boolean fsw;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fsx;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fst = i;
        File file = new File(str);
        if (file.exists()) {
            this.fsr = file.length();
            this.fss = t.k(l.n(file));
            if (this.fsr % this.fst == 0) {
                this.fsu = (int) (this.fsr / this.fst);
            } else {
                this.fsu = ((int) (this.fsr / this.fst)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aD(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fsr <= 0 || StringUtils.isNull(this.fss) || i <= 0 || this.fsw) {
            return null;
        }
        sh(10);
        a a2 = a(this.fsu, i, false, null);
        if (a2 == null || this.fsw) {
            return null;
        }
        if (a2.fsn != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fsn);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        sh(30);
        if (!StringUtils.isNull(a2.aOm)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fss);
            videoFinishResult2.setVideoUrl(a2.aOm);
            return videoFinishResult2;
        } else if (this.fsw) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fsl;
            if (w.s(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fsu; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fsm;
            f b = b(arrayList, str2, i);
            if (b == null || this.fsw) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            sh(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fss);
                return videoFinishResult4;
            } else if (this.fsw || (a = a(this.fsu, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fsn == 0) {
                    videoFinishResult5.setVideoUrl(a.aOm);
                    videoFinishResult5.setVideoMd5(this.fss);
                } else {
                    videoFinishResult5.setErrorNo(a.fsn);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                }
                sh(100);
                return videoFinishResult5;
            }
        }
    }

    private void sh(int i) {
        if (this.fsv != null) {
            this.fsv.ae(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        yVar.n("chunk_sum", String.valueOf(i));
        yVar.n("video_size", String.valueOf(this.fsr));
        yVar.n("chunk_size", String.valueOf(this.fst));
        yVar.n("is_merge", String.valueOf(z ? 1 : 0));
        yVar.n("video_md5", this.fss);
        yVar.n("video_len", String.valueOf(j));
        yVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            yVar.n("upload_id", str);
        }
        String ud = yVar.ud();
        if (yVar.uC().vw().isRequestSuccess()) {
            if (StringUtils.isNull(ud)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(ud);
            return aVar;
        }
        a aVar2 = new a();
        if (yVar.uC().vw().uF()) {
            aVar2.fsn = yVar.uC().vw().abG;
        } else {
            aVar2.fsn = yVar.uC().vw().oy;
        }
        aVar2.mErrorMessage = yVar.uC().vw().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (w.s(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fsx = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fst, this.fsu, this.fsr, this.fss);
        } else {
            this.fsx = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fst, this.fsu, this.fsr, this.fss);
        }
        this.fsx.a(this.fsv);
        f b = this.fsx.b(arrayList, str, i);
        this.fsx = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fsw = true;
        if (this.fsx != null) {
            this.fsx.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fsv = eVar;
    }
}
