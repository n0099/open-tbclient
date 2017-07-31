package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long gkE;
    private String gkF;
    private final int gkG;
    private int gkH;
    private e gkI;
    private boolean gkJ;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gkK;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gkG = i;
        File file = new File(str);
        if (file.exists()) {
            this.gkE = file.length();
            this.gkF = r.q(k.q(file));
            if (this.gkE % this.gkG == 0) {
                this.gkH = (int) (this.gkE / this.gkG);
            } else {
                this.gkH = ((int) (this.gkE / this.gkG)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aA(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gkE <= 0 || StringUtils.isNull(this.gkF) || i <= 0 || this.gkJ) {
            return null;
        }
        tu(10);
        a a2 = a(this.gkH, i, false, null);
        if (a2 == null || this.gkJ) {
            return null;
        }
        if (a2.gkA != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gkA);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tu(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gkF);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.gkJ) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gky;
            if (u.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gkH; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gkz;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gkJ) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            tu(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gkF);
                return videoFinishResult4;
            } else if (this.gkJ || (a = a(this.gkH, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gkA == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.gkF);
                } else {
                    videoFinishResult5.setErrorNo(a.gkA);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new aj("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tu(100);
                return videoFinishResult5;
            }
        }
    }

    private void tu(int i) {
        if (this.gkI != null) {
            this.gkI.al(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        w wVar = new w(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        wVar.n("chunk_sum", String.valueOf(i));
        wVar.n("video_size", String.valueOf(this.gkE));
        wVar.n("chunk_size", String.valueOf(this.gkG));
        wVar.n("is_merge", String.valueOf(z ? 1 : 0));
        wVar.n("video_md5", this.gkF);
        wVar.n("video_len", String.valueOf(j));
        wVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            wVar.n("upload_id", str);
        }
        String uO = wVar.uO();
        if (wVar.vl().wi().isRequestSuccess()) {
            if (StringUtils.isNull(uO)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uO);
            return aVar;
        }
        a aVar2 = new a();
        if (wVar.vl().wi().vo()) {
            aVar2.gkA = wVar.vl().wi().aiR;
        } else {
            aVar2.gkA = wVar.vl().wi().xt;
        }
        aVar2.mErrorMessage = wVar.vl().wi().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (u.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gkK = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gkG, this.gkH, this.gkE, this.gkF);
        } else {
            this.gkK = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gkG, this.gkH, this.gkE, this.gkF);
        }
        this.gkK.a(this.gkI);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gkK.b(arrayList, str, i);
        this.gkK = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gkJ = true;
        if (this.gkK != null) {
            this.gkK.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gkI = eVar;
    }
}
