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
    private String WU;
    private long hfU;
    private final int hfV;
    private int hfW;
    private e hfX;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hfY;
    private h hfZ;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hfV = i;
        this.hfZ = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hfU = file.length();
            this.WU = s.i(l.w(file));
            if (this.hfU % this.hfV == 0) {
                this.hfW = (int) (this.hfU / this.hfV);
            } else {
                this.hfW = ((int) (this.hfU / this.hfV)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aU(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.hfU <= 0 || StringUtils.isNull(this.WU) || i <= 0 || this.mCancelled) {
            return null;
        }
        uT(10);
        a a2 = a(this.hfW, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.dHx != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.dHx);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            h(302, a2.dHx, a2.mErrorMessage);
            return videoFinishResult;
        }
        uT(30);
        if (!StringUtils.isNull(a2.aAy)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.WU);
            videoFinishResult2.setVideoUrl(a2.aAy);
            bDh();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.hfP;
            if (v.J(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hfW; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.hfQ;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.mCancelled) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                h(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            uT(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.WU);
                bDh();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.hfW, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.dHx == 0) {
                    videoFinishResult5.setVideoUrl(a.aAy);
                    videoFinishResult5.setVideoMd5(this.WU);
                    bDh();
                } else {
                    videoFinishResult5.setErrorNo(a.dHx);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    h(304, a.dHx, a.mErrorMessage);
                    TiebaStatic.log(new am("c12024").ax("params", a.mErrorMessage));
                }
                uT(100);
                return videoFinishResult5;
            }
        }
    }

    private void uT(int i) {
        if (this.hfX != null) {
            this.hfX.ax(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.hfU));
        xVar.x("chunk_size", String.valueOf(this.hfV));
        xVar.x("is_merge", String.valueOf(z ? 1 : 0));
        xVar.x("video_md5", this.WU);
        xVar.x("video_len", String.valueOf(j));
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.x("upload_id", str);
        }
        String BA = xVar.BA();
        if (xVar.BY().CX().isRequestSuccess()) {
            if (StringUtils.isNull(BA)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(BA);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.BY().CX().Cb()) {
            aVar2.dHx = xVar.BY().CX().aze;
        } else {
            aVar2.dHx = xVar.BY().CX().Da;
        }
        aVar2.mErrorMessage = xVar.BY().CX().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.J(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hfY = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hfV, this.hfW, this.hfU, this.WU);
        } else {
            this.hfY = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hfV, this.hfW, this.hfU, this.WU);
        }
        this.hfY.a(this.hfX);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hfY.b(arrayList, str, i);
        this.hfY = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.hfY != null) {
            this.hfY.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hfX = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.hfZ != null) {
            this.hfZ.e(i, i2, str);
        }
    }

    private void bDh() {
        if (this.hfZ != null) {
            this.hfZ.bbd();
        }
    }
}
