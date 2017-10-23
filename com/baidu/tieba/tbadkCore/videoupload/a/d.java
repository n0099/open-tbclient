package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gjp;
    private String gjq;
    private final int gjr;
    private int gjs;
    private e gjt;
    private boolean gju;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gjv;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gjr = i;
        File file = new File(str);
        if (file.exists()) {
            this.gjp = file.length();
            this.gjq = s.e(k.r(file));
            if (this.gjp % this.gjr == 0) {
                this.gjs = (int) (this.gjp / this.gjr);
            } else {
                this.gjs = ((int) (this.gjp / this.gjr)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult az(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gjp <= 0 || StringUtils.isNull(this.gjq) || i <= 0 || this.gju) {
            return null;
        }
        tM(10);
        a a2 = a(this.gjs, i, false, null);
        if (a2 == null || this.gju) {
            return null;
        }
        if (a2.gjl != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gjl);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tM(30);
        if (!StringUtils.isNull(a2.aXe)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gjq);
            videoFinishResult2.setVideoUrl(a2.aXe);
            return videoFinishResult2;
        } else if (this.gju) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gjj;
            if (v.u(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gjs; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gjk;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gju) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            tM(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gjq);
                return videoFinishResult4;
            } else if (this.gju || (a = a(this.gjs, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gjl == 0) {
                    videoFinishResult5.setVideoUrl(a.aXe);
                    videoFinishResult5.setVideoMd5(this.gjq);
                } else {
                    videoFinishResult5.setErrorNo(a.gjl);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tM(100);
                return videoFinishResult5;
            }
        }
    }

    private void tM(int i) {
        if (this.gjt != null) {
            this.gjt.ad(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gjp));
        xVar.n("chunk_size", String.valueOf(this.gjr));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gjq);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String ui = xVar.ui();
        if (xVar.uG().vD().isRequestSuccess()) {
            if (StringUtils.isNull(ui)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(ui);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.uG().vD().uJ()) {
            aVar2.gjl = xVar.uG().vD().ahC;
        } else {
            aVar2.gjl = xVar.uG().vD().vp;
        }
        aVar2.mErrorMessage = xVar.uG().vD().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.u(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gjv = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gjr, this.gjs, this.gjp, this.gjq);
        } else {
            this.gjv = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gjr, this.gjs, this.gjp, this.gjq);
        }
        this.gjv.a(this.gjt);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gjv.b(arrayList, str, i);
        this.gjv = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gju = true;
        if (this.gjv != null) {
            this.gjv.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gjt = eVar;
    }
}
