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
    private long gkY;
    private String gkZ;
    private final int gla;
    private int glb;
    private e glc;
    private boolean gld;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gle;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gla = i;
        File file = new File(str);
        if (file.exists()) {
            this.gkY = file.length();
            this.gkZ = r.e(k.s(file));
            if (this.gkY % this.gla == 0) {
                this.glb = (int) (this.gkY / this.gla);
            } else {
                this.glb = ((int) (this.gkY / this.gla)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aA(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gkY <= 0 || StringUtils.isNull(this.gkZ) || i <= 0 || this.gld) {
            return null;
        }
        tG(10);
        a a2 = a(this.glb, i, false, null);
        if (a2 == null || this.gld) {
            return null;
        }
        if (a2.gkU != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gkU);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tG(30);
        if (!StringUtils.isNull(a2.aVG)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gkZ);
            videoFinishResult2.setVideoUrl(a2.aVG);
            return videoFinishResult2;
        } else if (this.gld) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gkS;
            if (v.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.glb; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gkT;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gld) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            tG(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gkZ);
                return videoFinishResult4;
            } else if (this.gld || (a = a(this.glb, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gkU == 0) {
                    videoFinishResult5.setVideoUrl(a.aVG);
                    videoFinishResult5.setVideoMd5(this.gkZ);
                } else {
                    videoFinishResult5.setErrorNo(a.gkU);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ad(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tG(100);
                return videoFinishResult5;
            }
        }
    }

    private void tG(int i) {
        if (this.glc != null) {
            this.glc.aa(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gkY));
        xVar.n("chunk_size", String.valueOf(this.gla));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gkZ);
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
            aVar2.gkU = xVar.vj().wg().ain;
        } else {
            aVar2.gkU = xVar.vj().wg().vm;
        }
        aVar2.mErrorMessage = xVar.vj().wg().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gle = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gla, this.glb, this.gkY, this.gkZ);
        } else {
            this.gle = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gla, this.glb, this.gkY, this.gkZ);
        }
        this.gle.a(this.glc);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gle.b(arrayList, str, i);
        this.gle = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gld = true;
        if (this.gle != null) {
            this.gle.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.glc = eVar;
    }
}
