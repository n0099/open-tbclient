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
    private e gmA;
    private boolean gmB;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gmC;
    private long gmw;
    private String gmx;
    private final int gmy;
    private int gmz;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gmy = i;
        File file = new File(str);
        if (file.exists()) {
            this.gmw = file.length();
            this.gmx = r.q(k.q(file));
            if (this.gmw % this.gmy == 0) {
                this.gmz = (int) (this.gmw / this.gmy);
            } else {
                this.gmz = ((int) (this.gmw / this.gmy)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aA(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gmw <= 0 || StringUtils.isNull(this.gmx) || i <= 0 || this.gmB) {
            return null;
        }
        tE(10);
        a a2 = a(this.gmz, i, false, null);
        if (a2 == null || this.gmB) {
            return null;
        }
        if (a2.gms != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.gms);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        tE(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gmx);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.gmB) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.gmq;
            if (u.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gmz; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.gmr;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gmB) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            tE(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gmx);
                return videoFinishResult4;
            } else if (this.gmB || (a = a(this.gmz, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.gms == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.gmx);
                } else {
                    videoFinishResult5.setErrorNo(a.gms);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new aj("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                tE(100);
                return videoFinishResult5;
            }
        }
    }

    private void tE(int i) {
        if (this.gmA != null) {
            this.gmA.al(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        w wVar = new w(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        wVar.n("chunk_sum", String.valueOf(i));
        wVar.n("video_size", String.valueOf(this.gmw));
        wVar.n("chunk_size", String.valueOf(this.gmy));
        wVar.n("is_merge", String.valueOf(z ? 1 : 0));
        wVar.n("video_md5", this.gmx);
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
            aVar2.gms = wVar.vl().wi().aiT;
        } else {
            aVar2.gms = wVar.vl().wi().xv;
        }
        aVar2.mErrorMessage = wVar.vl().wi().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (u.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gmC = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gmy, this.gmz, this.gmw, this.gmx);
        } else {
            this.gmC = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gmy, this.gmz, this.gmw, this.gmx);
        }
        this.gmC.a(this.gmA);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gmC.b(arrayList, str, i);
        this.gmC = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gmB = true;
        if (this.gmC != null) {
            this.gmC.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gmA = eVar;
    }
}
