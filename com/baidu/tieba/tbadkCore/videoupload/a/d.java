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
    private long gjE;
    private String gjF;
    private final int gjG;
    private int gjH;
    private e gjI;
    private boolean gjJ;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gjK;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gjG = i;
        File file = new File(str);
        if (file.exists()) {
            this.gjE = file.length();
            this.gjF = s.e(k.r(file));
            if (this.gjE % this.gjG == 0) {
                this.gjH = (int) (this.gjE / this.gjG);
            } else {
                this.gjH = ((int) (this.gjE / this.gjG)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult az(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gjE <= 0 || StringUtils.isNull(this.gjF) || i <= 0 || this.gjJ) {
            return null;
        }
        tN(10);
        a a2 = a(this.gjH, i, false, null);
        if (a2 == null || this.gjJ) {
            return null;
        }
        if (a2.gjA != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gjA);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tN(30);
        if (!StringUtils.isNull(a2.aXr)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gjF);
            videoFinishResult2.setVideoUrl(a2.aXr);
            return videoFinishResult2;
        } else if (this.gjJ) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gjy;
            if (v.u(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gjH; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gjz;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gjJ) {
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
                videoFinishResult4.setVideoMd5(this.gjF);
                return videoFinishResult4;
            } else if (this.gjJ || (a = a(this.gjH, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gjA == 0) {
                    videoFinishResult5.setVideoUrl(a.aXr);
                    videoFinishResult5.setVideoMd5(this.gjF);
                } else {
                    videoFinishResult5.setErrorNo(a.gjA);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ad(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tN(100);
                return videoFinishResult5;
            }
        }
    }

    private void tN(int i) {
        if (this.gjI != null) {
            this.gjI.ad(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gjE));
        xVar.n("chunk_size", String.valueOf(this.gjG));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gjF);
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
            aVar2.gjA = xVar.uN().vK().ahO;
        } else {
            aVar2.gjA = xVar.uN().vK().vo;
        }
        aVar2.mErrorMessage = xVar.uN().vK().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.u(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gjK = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gjG, this.gjH, this.gjE, this.gjF);
        } else {
            this.gjK = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gjG, this.gjH, this.gjE, this.gjF);
        }
        this.gjK.a(this.gjI);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gjK.b(arrayList, str, i);
        this.gjK = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gjJ = true;
        if (this.gjK != null) {
            this.gjK.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gjI = eVar;
    }
}
