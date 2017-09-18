package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.r;
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
    private long glS;
    private String glT;
    private final int glU;
    private int glV;
    private e glW;
    private boolean glX;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a glY;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.glU = i;
        File file = new File(str);
        if (file.exists()) {
            this.glS = file.length();
            this.glT = r.e(k.s(file));
            if (this.glS % this.glU == 0) {
                this.glV = (int) (this.glS / this.glU);
            } else {
                this.glV = ((int) (this.glS / this.glU)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aA(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.glS <= 0 || StringUtils.isNull(this.glT) || i <= 0 || this.glX) {
            return null;
        }
        tI(10);
        a a2 = a(this.glV, i, false, null);
        if (a2 == null || this.glX) {
            return null;
        }
        if (a2.glO != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.glO);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tI(30);
        if (!StringUtils.isNull(a2.aVD)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.glT);
            videoFinishResult2.setVideoUrl(a2.aVD);
            return videoFinishResult2;
        } else if (this.glX) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.glM;
            if (v.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.glV; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.glN;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.glX) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            tI(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.glT);
                return videoFinishResult4;
            } else if (this.glX || (a = a(this.glV, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.glO == 0) {
                    videoFinishResult5.setVideoUrl(a.aVD);
                    videoFinishResult5.setVideoMd5(this.glT);
                } else {
                    videoFinishResult5.setErrorNo(a.glO);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ad(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tI(100);
                return videoFinishResult5;
            }
        }
    }

    private void tI(int i) {
        if (this.glW != null) {
            this.glW.aa(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.glS));
        xVar.n("chunk_size", String.valueOf(this.glU));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.glT);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String uM = xVar.uM();
        if (xVar.vj().wg().isRequestSuccess()) {
            if (StringUtils.isNull(uM)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uM);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.vj().wg().vm()) {
            aVar2.glO = xVar.vj().wg().aim;
        } else {
            aVar2.glO = xVar.vj().wg().vm;
        }
        aVar2.mErrorMessage = xVar.vj().wg().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.glY = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.glU, this.glV, this.glS, this.glT);
        } else {
            this.glY = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.glU, this.glV, this.glS, this.glT);
        }
        this.glY.a(this.glW);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.glY.b(arrayList, str, i);
        this.glY = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.glX = true;
        if (this.glY != null) {
            this.glY.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.glW = eVar;
    }
}
