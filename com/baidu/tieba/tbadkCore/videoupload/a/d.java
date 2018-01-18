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
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class d implements b {
    private long hbc;
    private String hbd;
    private final int hbe;
    private int hbf;
    private e hbg;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hbh;
    private h hbi;
    private String mFileName;
    private boolean oP;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hbe = i;
        this.hbi = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hbc = file.length();
            this.hbd = s.e(k.r(file));
            if (this.hbc % this.hbe == 0) {
                this.hbf = (int) (this.hbc / this.hbe);
            } else {
                this.hbf = ((int) (this.hbc / this.hbe)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aJ(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hbc <= 0 || StringUtils.isNull(this.hbd) || i <= 0 || this.oP) {
            return null;
        }
        vX(10);
        a a2 = a(this.hbf, i, false, null);
        if (a2 == null || this.oP) {
            return null;
        }
        if (a2.gWz != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gWz);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            j(HttpStatus.SC_MOVED_TEMPORARILY, a2.gWz, a2.mErrorMessage);
            return videoFinishResult;
        }
        vX(30);
        if (!StringUtils.isNull(a2.bOE)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.hbd);
            videoFinishResult2.setVideoUrl(a2.bOE);
            bwK();
            return videoFinishResult2;
        } else if (this.oP) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.haX;
            if (v.E(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hbf; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.haY;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.oP) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                j(HttpStatus.SC_SEE_OTHER, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            vX(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.hbd);
                bwK();
                return videoFinishResult4;
            } else if (this.oP || (a = a(this.hbf, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gWz == 0) {
                    videoFinishResult5.setVideoUrl(a.bOE);
                    videoFinishResult5.setVideoMd5(this.hbd);
                    bwK();
                } else {
                    videoFinishResult5.setErrorNo(a.gWz);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    j(HttpStatus.SC_NOT_MODIFIED, a.gWz, a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ab(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                vX(100);
                return videoFinishResult5;
            }
        }
    }

    private void vX(int i) {
        if (this.hbg != null) {
            this.hbg.ay(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.hbc));
        xVar.n("chunk_size", String.valueOf(this.hbe));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.hbd);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String BH = xVar.BH();
        if (xVar.Cf().Dc().isRequestSuccess()) {
            if (StringUtils.isNull(BH)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(BH);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Cf().Dc().Ci()) {
            aVar2.gWz = xVar.Cf().Dc().aWB;
        } else {
            aVar2.gWz = xVar.Cf().Dc().ajA;
        }
        aVar2.mErrorMessage = xVar.Cf().Dc().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.E(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hbh = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hbe, this.hbf, this.hbc, this.hbd);
        } else {
            this.hbh = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hbe, this.hbf, this.hbc, this.hbd);
        }
        this.hbh.a(this.hbg);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hbh.b(arrayList, str, i);
        this.hbh = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.oP = true;
        if (this.hbh != null) {
            this.hbh.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hbg = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.hbi != null) {
            this.hbi.h(i, i2, str);
        }
    }

    private void bwK() {
        if (this.hbi != null) {
            this.hbi.aVa();
        }
    }
}
