package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long jjr;
    private String jjs;
    private final int jjt;
    private int jju;
    private e jjv;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a jjw;
    private h jjx;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.jjt = i;
        this.jjx = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.jjr = file.length();
            this.jjs = s.h(m.z(file));
            if (this.jjr % this.jjt == 0) {
                this.jju = (int) (this.jjr / this.jjt);
            } else {
                this.jju = ((int) (this.jjr / this.jjt)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bp(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.jjr <= 0 || StringUtils.isNull(this.jjs) || i <= 0 || this.mCancelled) {
            return null;
        }
        Bt(10);
        a b2 = b(this.jju, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.mErrorNo);
            videoFinishResult.setUserMessage(b2.bsY);
            j(302, b2.mErrorNo, b2.bsY);
            return videoFinishResult;
        }
        Bt(30);
        if (!StringUtils.isNull(b2.bWh)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.jjs);
            videoFinishResult2.setVideoUrl(b2.bWh);
            cqR();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.jjm;
            if (v.aa(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.jju; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.jjn;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                j(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            Bt(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.jjs);
                cqR();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.jju, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(b.bWh);
                    videoFinishResult5.setVideoMd5(this.jjs);
                    cqR();
                } else {
                    videoFinishResult5.setErrorNo(b.mErrorNo);
                    videoFinishResult5.setUserMessage(b.bsY);
                    j(304, b.mErrorNo, b.bsY);
                    TiebaStatic.log(new an("c12024").bT("params", b.bsY));
                }
                Bt(100);
                return videoFinishResult5;
            }
        }
    }

    private void Bt(int i) {
        if (this.jjv != null) {
            this.jjv.aR(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.o("chunk_sum", String.valueOf(i));
        xVar.o("video_size", String.valueOf(this.jjr));
        xVar.o("chunk_size", String.valueOf(this.jjt));
        xVar.o("is_merge", String.valueOf(z ? 1 : 0));
        xVar.o("video_md5", this.jjs);
        xVar.o("video_len", String.valueOf(j));
        xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.o("upload_id", str);
        }
        String aii = xVar.aii();
        if (xVar.aiG().ajH().isRequestSuccess()) {
            if (StringUtils.isNull(aii)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(aii);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aiG().ajH().aiJ()) {
            aVar2.mErrorNo = xVar.aiG().ajH().bUO;
        } else {
            aVar2.mErrorNo = xVar.aiG().ajH().AR;
        }
        aVar2.bsY = xVar.aiG().ajH().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.aa(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.jjw = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.jjt, this.jju, this.jjr, this.jjs);
        } else {
            this.jjw = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.jjt, this.jju, this.jjr, this.jjs);
        }
        this.jjw.a(this.jjv);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.jjw.b(arrayList, str, i);
        this.jjw = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.jjw != null) {
            this.jjw.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jjv = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.jjx != null) {
            this.jjx.h(i, i2, str);
        }
    }

    private void cqR() {
        if (this.jjx != null) {
            this.jjx.bOP();
        }
    }
}
