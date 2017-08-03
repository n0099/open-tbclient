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
    private long gjt;
    private String gju;
    private final int gjv;
    private int gjw;
    private e gjx;
    private boolean gjy;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gjz;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gjv = i;
        File file = new File(str);
        if (file.exists()) {
            this.gjt = file.length();
            this.gju = r.k(k.q(file));
            if (this.gjt % this.gjv == 0) {
                this.gjw = (int) (this.gjt / this.gjv);
            } else {
                this.gjw = ((int) (this.gjt / this.gjv)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aA(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gjt <= 0 || StringUtils.isNull(this.gju) || i <= 0 || this.gjy) {
            return null;
        }
        tu(10);
        a a2 = a(this.gjw, i, false, null);
        if (a2 == null || this.gjy) {
            return null;
        }
        if (a2.gjp != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gjp);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tu(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gju);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.gjy) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gjn;
            if (u.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gjw; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gjo;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gjy) {
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
                videoFinishResult4.setVideoMd5(this.gju);
                return videoFinishResult4;
            } else if (this.gjy || (a = a(this.gjw, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gjp == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.gju);
                } else {
                    videoFinishResult5.setErrorNo(a.gjp);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new aj("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tu(100);
                return videoFinishResult5;
            }
        }
    }

    private void tu(int i) {
        if (this.gjx != null) {
            this.gjx.al(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        w wVar = new w(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        wVar.n("chunk_sum", String.valueOf(i));
        wVar.n("video_size", String.valueOf(this.gjt));
        wVar.n("chunk_size", String.valueOf(this.gjv));
        wVar.n("is_merge", String.valueOf(z ? 1 : 0));
        wVar.n("video_md5", this.gju);
        wVar.n("video_len", String.valueOf(j));
        wVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            wVar.n("upload_id", str);
        }
        String uE = wVar.uE();
        if (wVar.vb().vY().isRequestSuccess()) {
            if (StringUtils.isNull(uE)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uE);
            return aVar;
        }
        a aVar2 = new a();
        if (wVar.vb().vY().ve()) {
            aVar2.gjp = wVar.vb().vY().ahy;
        } else {
            aVar2.gjp = wVar.vb().vY().vR;
        }
        aVar2.mErrorMessage = wVar.vb().vY().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (u.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gjz = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gjv, this.gjw, this.gjt, this.gju);
        } else {
            this.gjz = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gjv, this.gjw, this.gjt, this.gju);
        }
        this.gjz.a(this.gjx);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gjz.b(arrayList, str, i);
        this.gjz = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gjy = true;
        if (this.gjz != null) {
            this.gjz.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gjx = eVar;
    }
}
