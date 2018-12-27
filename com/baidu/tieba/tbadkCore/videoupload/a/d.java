package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private String WW;
    private int hrA;
    private e hrB;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hrC;
    private h hrD;
    private long hry;
    private final int hrz;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hrz = i;
        this.hrD = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hry = file.length();
            this.WW = s.i(l.x(file));
            if (this.hry % this.hrz == 0) {
                this.hrA = (int) (this.hry / this.hrz);
            } else {
                this.hrA = ((int) (this.hry / this.hrz)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aW(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.hry <= 0 || StringUtils.isNull(this.WW) || i <= 0 || this.mCancelled) {
            return null;
        }
        vV(10);
        a b2 = b(this.hrA, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dRQ != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dRQ);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            g(302, b2.dRQ, b2.mErrorMessage);
            return videoFinishResult;
        }
        vV(30);
        if (!StringUtils.isNull(b2.aEO)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.WW);
            videoFinishResult2.setVideoUrl(b2.aEO);
            bFo();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.hrt;
            if (v.I(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hrA; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.hru;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                g(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            vV(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.WW);
                bFo();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.hrA, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dRQ == 0) {
                    videoFinishResult5.setVideoUrl(b.aEO);
                    videoFinishResult5.setVideoMd5(this.WW);
                    bFo();
                } else {
                    videoFinishResult5.setErrorNo(b.dRQ);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    g(304, b.dRQ, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").aA("params", b.mErrorMessage));
                }
                vV(100);
                return videoFinishResult5;
            }
        }
    }

    private void vV(int i) {
        if (this.hrB != null) {
            this.hrB.az(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.hry));
        xVar.x("chunk_size", String.valueOf(this.hrz));
        xVar.x("is_merge", String.valueOf(z ? 1 : 0));
        xVar.x("video_md5", this.WW);
        xVar.x("video_len", String.valueOf(j));
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.x("upload_id", str);
        }
        String CL = xVar.CL();
        if (xVar.Dj().Ei().isRequestSuccess()) {
            if (StringUtils.isNull(CL)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(CL);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Dj().Ei().Dm()) {
            aVar2.dRQ = xVar.Dj().Ei().aDu;
        } else {
            aVar2.dRQ = xVar.Dj().Ei().De;
        }
        aVar2.mErrorMessage = xVar.Dj().Ei().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.I(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hrC = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hrz, this.hrA, this.hry, this.WW);
        } else {
            this.hrC = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hrz, this.hrA, this.hry, this.WW);
        }
        this.hrC.a(this.hrB);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hrC.b(arrayList, str, i);
        this.hrC = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.hrC != null) {
            this.hrC.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hrB = eVar;
    }

    private void g(int i, int i2, String str) {
        if (this.hrD != null) {
            this.hrD.e(i, i2, str);
        }
    }

    private void bFo() {
        if (this.hrD != null) {
            this.hrD.bde();
        }
    }
}
