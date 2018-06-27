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
    private long gPQ;
    private String gPR;
    private final int gPS;
    private int gPT;
    private e gPU;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gPV;
    private h gPW;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gPS = i;
        this.gPW = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gPQ = file.length();
            this.gPR = s.g(l.q(file));
            if (this.gPQ % this.gPS == 0) {
                this.gPT = (int) (this.gPQ / this.gPS);
            } else {
                this.gPT = ((int) (this.gPQ / this.gPS)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aP(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.gPQ <= 0 || StringUtils.isNull(this.gPR) || i <= 0 || this.mCancelled) {
            return null;
        }
        tY(10);
        a b2 = b(this.gPT, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dqh != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dqh);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            h(302, b2.dqh, b2.mErrorMessage);
            return videoFinishResult;
        }
        tY(30);
        if (!StringUtils.isNull(b2.bcS)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gPR);
            videoFinishResult2.setVideoUrl(b2.bcS);
            byH();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.gPL;
            if (w.A(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gPT; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.gPM;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                h(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            tY(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.gPR);
                byH();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.gPT, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dqh == 0) {
                    videoFinishResult5.setVideoUrl(b.bcS);
                    videoFinishResult5.setVideoMd5(this.gPR);
                    byH();
                } else {
                    videoFinishResult5.setErrorNo(b.dqh);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    h(304, b.dqh, b.mErrorMessage);
                    TiebaStatic.log(new an("c12024").ah(LegoListActivityConfig.PARAMS, b.mErrorMessage));
                }
                tY(100);
                return videoFinishResult5;
            }
        }
    }

    private void tY(int i) {
        if (this.gPU != null) {
            this.gPU.aC(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        yVar.o("chunk_sum", String.valueOf(i));
        yVar.o("video_size", String.valueOf(this.gPQ));
        yVar.o("chunk_size", String.valueOf(this.gPS));
        yVar.o("is_merge", String.valueOf(z ? 1 : 0));
        yVar.o("video_md5", this.gPR);
        yVar.o("video_len", String.valueOf(j));
        yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            yVar.o("upload_id", str);
        }
        String yz = yVar.yz();
        if (yVar.yX().zY().isRequestSuccess()) {
            if (StringUtils.isNull(yz)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(yz);
            return aVar;
        }
        a aVar2 = new a();
        if (yVar.yX().zY().za()) {
            aVar2.dqh = yVar.yX().zY().asr;
        } else {
            aVar2.dqh = yVar.yX().zY().zZ;
        }
        aVar2.mErrorMessage = yVar.yX().zY().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (w.A(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gPV = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gPS, this.gPT, this.gPQ, this.gPR);
        } else {
            this.gPV = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gPS, this.gPT, this.gPQ, this.gPR);
        }
        this.gPV.a(this.gPU);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gPV.b(arrayList, str, i);
        this.gPV = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gPV != null) {
            this.gPV.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gPU = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gPW != null) {
            this.gPW.e(i, i2, str);
        }
    }

    private void byH() {
        if (this.gPW != null) {
            this.gPW.aXn();
        }
    }
}
