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
    private long hom;
    private final int hon;
    private int hoo;
    private e hop;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hoq;
    private h hor;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hon = i;
        this.hor = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hom = file.length();
            this.WW = s.i(l.x(file));
            if (this.hom % this.hon == 0) {
                this.hoo = (int) (this.hom / this.hon);
            } else {
                this.hoo = ((int) (this.hom / this.hon)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aV(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.hom <= 0 || StringUtils.isNull(this.WW) || i <= 0 || this.mCancelled) {
            return null;
        }
        vI(10);
        a b2 = b(this.hoo, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dPc != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dPc);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            g(302, b2.dPc, b2.mErrorMessage);
            return videoFinishResult;
        }
        vI(30);
        if (!StringUtils.isNull(b2.aEN)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.WW);
            videoFinishResult2.setVideoUrl(b2.aEN);
            bEw();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.hoh;
            if (v.I(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hoo; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.hoi;
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
            vI(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.WW);
                bEw();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.hoo, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dPc == 0) {
                    videoFinishResult5.setVideoUrl(b.aEN);
                    videoFinishResult5.setVideoMd5(this.WW);
                    bEw();
                } else {
                    videoFinishResult5.setErrorNo(b.dPc);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    g(304, b.dPc, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").aA("params", b.mErrorMessage));
                }
                vI(100);
                return videoFinishResult5;
            }
        }
    }

    private void vI(int i) {
        if (this.hop != null) {
            this.hop.az(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.hom));
        xVar.x("chunk_size", String.valueOf(this.hon));
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
            aVar2.dPc = xVar.Dj().Ei().aDt;
        } else {
            aVar2.dPc = xVar.Dj().Ei().De;
        }
        aVar2.mErrorMessage = xVar.Dj().Ei().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.I(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hoq = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hon, this.hoo, this.hom, this.WW);
        } else {
            this.hoq = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hon, this.hoo, this.hom, this.WW);
        }
        this.hoq.a(this.hop);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hoq.b(arrayList, str, i);
        this.hoq = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.hoq != null) {
            this.hoq.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hop = eVar;
    }

    private void g(int i, int i2, String str) {
        if (this.hor != null) {
            this.hor.e(i, i2, str);
        }
    }

    private void bEw() {
        if (this.hor != null) {
            this.hor.bcq();
        }
    }
}
