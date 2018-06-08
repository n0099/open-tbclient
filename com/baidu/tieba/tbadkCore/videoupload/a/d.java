package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gLO;
    private String gLP;
    private final int gLQ;
    private int gLR;
    private e gLS;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gLT;
    private h gLU;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gLQ = i;
        this.gLU = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gLO = file.length();
            this.gLP = s.g(l.q(file));
            if (this.gLO % this.gLQ == 0) {
                this.gLR = (int) (this.gLO / this.gLQ);
            } else {
                this.gLR = ((int) (this.gLO / this.gLQ)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aO(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.gLO <= 0 || StringUtils.isNull(this.gLP) || i <= 0 || this.mCancelled) {
            return null;
        }
        tM(10);
        a b2 = b(this.gLR, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dmW != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dmW);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            h(302, b2.dmW, b2.mErrorMessage);
            return videoFinishResult;
        }
        tM(30);
        if (!StringUtils.isNull(b2.biU)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gLP);
            videoFinishResult2.setVideoUrl(b2.biU);
            byd();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.gLJ;
            if (w.z(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gLR; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.gLK;
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
            tM(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.gLP);
                byd();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.gLR, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dmW == 0) {
                    videoFinishResult5.setVideoUrl(b.biU);
                    videoFinishResult5.setVideoMd5(this.gLP);
                    byd();
                } else {
                    videoFinishResult5.setErrorNo(b.dmW);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    h(304, b.dmW, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").ah(LegoListActivityConfig.PARAMS, b.mErrorMessage));
                }
                tM(100);
                return videoFinishResult5;
            }
        }
    }

    private void tM(int i) {
        if (this.gLS != null) {
            this.gLS.aC(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        yVar.o("chunk_sum", String.valueOf(i));
        yVar.o("video_size", String.valueOf(this.gLO));
        yVar.o("chunk_size", String.valueOf(this.gLQ));
        yVar.o("is_merge", String.valueOf(z ? 1 : 0));
        yVar.o("video_md5", this.gLP);
        yVar.o("video_len", String.valueOf(j));
        yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            yVar.o("upload_id", str);
        }
        String yl = yVar.yl();
        if (yVar.yJ().zJ().isRequestSuccess()) {
            if (StringUtils.isNull(yl)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(yl);
            return aVar;
        }
        a aVar2 = new a();
        if (yVar.yJ().zJ().yM()) {
            aVar2.dmW = yVar.yJ().zJ().arO;
        } else {
            aVar2.dmW = yVar.yJ().zJ().Ab;
        }
        aVar2.mErrorMessage = yVar.yJ().zJ().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (w.z(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gLT = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gLQ, this.gLR, this.gLO, this.gLP);
        } else {
            this.gLT = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gLQ, this.gLR, this.gLO, this.gLP);
        }
        this.gLT.a(this.gLS);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gLT.b(arrayList, str, i);
        this.gLT = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gLT != null) {
            this.gLT.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gLS = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gLU != null) {
            this.gLU.e(i, i2, str);
        }
    }

    private void byd() {
        if (this.gLU != null) {
            this.gLU.aWG();
        }
    }
}
