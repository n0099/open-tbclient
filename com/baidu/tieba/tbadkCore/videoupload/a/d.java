package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gAn;
    private String gAo;
    private final int gAp;
    private int gAq;
    private e gAr;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gAs;
    private h gAt;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.gAp = i;
        this.gAt = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.gAn = file.length();
            this.gAo = s.e(k.q(file));
            if (this.gAn % this.gAp == 0) {
                this.gAq = (int) (this.gAn / this.gAp);
            } else {
                this.gAq = ((int) (this.gAn / this.gAp)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aL(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.gAn <= 0 || StringUtils.isNull(this.gAo) || i <= 0 || this.mCancelled) {
            return null;
        }
        tA(10);
        a b2 = b(this.gAq, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.ddI != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.ddI);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            h(302, b2.ddI, b2.mErrorMessage);
            return videoFinishResult;
        }
        tA(30);
        if (!StringUtils.isNull(b2.baJ)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gAo);
            videoFinishResult2.setVideoUrl(b2.baJ);
            bsY();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.gAi;
            if (v.w(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gAq; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.gAj;
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
            tA(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.gAo);
                bsY();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.gAq, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.ddI == 0) {
                    videoFinishResult5.setVideoUrl(b.baJ);
                    videoFinishResult5.setVideoMd5(this.gAo);
                    bsY();
                } else {
                    videoFinishResult5.setErrorNo(b.ddI);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    h(304, b.ddI, b.mErrorMessage);
                    TiebaStatic.log(new al("c12024").ac(LegoListActivityConfig.PARAMS, b.mErrorMessage));
                }
                tA(100);
                return videoFinishResult5;
            }
        }
    }

    private void tA(int i) {
        if (this.gAr != null) {
            this.gAr.as(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gAn));
        xVar.n("chunk_size", String.valueOf(this.gAp));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gAo);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String uK = xVar.uK();
        if (xVar.vi().wi().isRequestSuccess()) {
            if (StringUtils.isNull(uK)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uK);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.vi().wi().vl()) {
            aVar2.ddI = xVar.vi().wi().ajG;
        } else {
            aVar2.ddI = xVar.vi().wi().tW;
        }
        aVar2.mErrorMessage = xVar.vi().wi().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.w(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gAs = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gAp, this.gAq, this.gAn, this.gAo);
        } else {
            this.gAs = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gAp, this.gAq, this.gAn, this.gAo);
        }
        this.gAs.a(this.gAr);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gAs.b(arrayList, str, i);
        this.gAs = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.gAs != null) {
            this.gAs.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gAr = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.gAt != null) {
            this.gAt.e(i, i2, str);
        }
    }

    private void bsY() {
        if (this.gAt != null) {
            this.gAt.aRJ();
        }
    }
}
