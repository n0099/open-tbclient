package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gQO;
    private String gQP;
    private final int gQQ;
    private int gQR;
    private e gQS;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gQT;
    private h gQU;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gQQ = i;
        this.gQU = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gQO = file.length();
            this.gQP = s.g(l.q(file));
            if (this.gQO % this.gQQ == 0) {
                this.gQR = (int) (this.gQO / this.gQQ);
            } else {
                this.gQR = ((int) (this.gQO / this.gQQ)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aL(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gQO <= 0 || StringUtils.isNull(this.gQP) || i <= 0 || this.mCancelled) {
            return null;
        }
        tW(10);
        a a2 = a(this.gQR, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.dsU != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.dsU);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.dsU, a2.mErrorMessage);
            return videoFinishResult;
        }
        tW(30);
        if (!StringUtils.isNull(a2.bdb)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gQP);
            videoFinishResult2.setVideoUrl(a2.bdb);
            bxk();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gQJ;
            if (w.z(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gQR; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gQK;
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
            tW(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gQP);
                bxk();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.gQR, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.dsU == 0) {
                    videoFinishResult5.setVideoUrl(a.bdb);
                    videoFinishResult5.setVideoMd5(this.gQP);
                    bxk();
                } else {
                    videoFinishResult5.setErrorNo(a.dsU);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.dsU, a.mErrorMessage);
                    TiebaStatic.log(new an("c12024").af(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tW(100);
                return videoFinishResult5;
            }
        }
    }

    private void tW(int i) {
        if (this.gQS != null) {
            this.gQS.aD(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        yVar.o("chunk_sum", String.valueOf(i));
        yVar.o("video_size", String.valueOf(this.gQO));
        yVar.o("chunk_size", String.valueOf(this.gQQ));
        yVar.o("is_merge", String.valueOf(z ? 1 : 0));
        yVar.o("video_md5", this.gQP);
        yVar.o("video_len", String.valueOf(j));
        yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            yVar.o("upload_id", str);
        }
        String yq = yVar.yq();
        if (yVar.yO().zN().isRequestSuccess()) {
            if (StringUtils.isNull(yq)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(yq);
            return aVar;
        }
        a aVar2 = new a();
        if (yVar.yO().zN().yR()) {
            aVar2.dsU = yVar.yO().zN().arU;
        } else {
            aVar2.dsU = yVar.yO().zN().zU;
        }
        aVar2.mErrorMessage = yVar.yO().zN().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (w.z(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gQT = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gQQ, this.gQR, this.gQO, this.gQP);
        } else {
            this.gQT = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gQQ, this.gQR, this.gQO, this.gQP);
        }
        this.gQT.a(this.gQS);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gQT.b(arrayList, str, i);
        this.gQT = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gQT != null) {
            this.gQT.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gQS = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gQU != null) {
            this.gQU.e(i, i2, str);
        }
    }

    private void bxk() {
        if (this.gQU != null) {
            this.gQU.aVG();
        }
    }
}
