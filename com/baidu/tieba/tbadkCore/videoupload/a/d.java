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
    private long gjD;
    private String gjE;
    private final int gjF;
    private int gjG;
    private e gjH;
    private boolean gjI;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gjJ;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gjF = i;
        File file = new File(str);
        if (file.exists()) {
            this.gjD = file.length();
            this.gjE = s.e(k.r(file));
            if (this.gjD % this.gjF == 0) {
                this.gjG = (int) (this.gjD / this.gjF);
            } else {
                this.gjG = ((int) (this.gjD / this.gjF)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult az(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gjD <= 0 || StringUtils.isNull(this.gjE) || i <= 0 || this.gjI) {
            return null;
        }
        tN(10);
        a a2 = a(this.gjG, i, false, null);
        if (a2 == null || this.gjI) {
            return null;
        }
        if (a2.gjz != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gjz);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tN(30);
        if (!StringUtils.isNull(a2.aXr)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gjE);
            videoFinishResult2.setVideoUrl(a2.aXr);
            return videoFinishResult2;
        } else if (this.gjI) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gjx;
            if (v.u(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gjG; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gjy;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gjI) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            tN(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gjE);
                return videoFinishResult4;
            } else if (this.gjI || (a = a(this.gjG, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gjz == 0) {
                    videoFinishResult5.setVideoUrl(a.aXr);
                    videoFinishResult5.setVideoMd5(this.gjE);
                } else {
                    videoFinishResult5.setErrorNo(a.gjz);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ad(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tN(100);
                return videoFinishResult5;
            }
        }
    }

    private void tN(int i) {
        if (this.gjH != null) {
            this.gjH.ad(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gjD));
        xVar.n("chunk_size", String.valueOf(this.gjF));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gjE);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String up = xVar.up();
        if (xVar.uN().vK().isRequestSuccess()) {
            if (StringUtils.isNull(up)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(up);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.uN().vK().uQ()) {
            aVar2.gjz = xVar.uN().vK().ahO;
        } else {
            aVar2.gjz = xVar.uN().vK().vo;
        }
        aVar2.mErrorMessage = xVar.uN().vK().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.u(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gjJ = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gjF, this.gjG, this.gjD, this.gjE);
        } else {
            this.gjJ = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gjF, this.gjG, this.gjD, this.gjE);
        }
        this.gjJ.a(this.gjH);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gjJ.b(arrayList, str, i);
        this.gjJ = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gjI = true;
        if (this.gjJ != null) {
            this.gjJ.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gjH = eVar;
    }
}
