package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.a.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long fOU;
    private String fOV;
    private final int fOW;
    private int fOX;
    private e fOY;
    private boolean fOZ;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fPa;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fOW = i;
        File file = new File(str);
        if (file.exists()) {
            this.fOU = file.length();
            this.fOV = t.k(n.q(file));
            if (this.fOU % this.fOW == 0) {
                this.fOX = (int) (this.fOU / this.fOW);
            } else {
                this.fOX = ((int) (this.fOU / this.fOW)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult ay(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fOU <= 0 || StringUtils.isNull(this.fOV) || i <= 0 || this.fOZ) {
            return null;
        }
        sR(10);
        a a2 = a(this.fOX, i, false, null);
        if (a2 == null || this.fOZ) {
            return null;
        }
        if (a2.fOQ != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fOQ);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        sR(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fOV);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.fOZ) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fOO;
            if (z.t(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fOX; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fOP;
            f b = b(arrayList, str2, i);
            if (b == null || this.fOZ) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            sR(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fOV);
                return videoFinishResult4;
            } else if (this.fOZ || (a = a(this.fOX, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fOQ == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.fOV);
                } else {
                    videoFinishResult5.setErrorNo(a.fOQ);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new au("c12024").Z(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                sR(100);
                return videoFinishResult5;
            }
        }
    }

    private void sR(int i) {
        if (this.fOY != null) {
            this.fOY.aj(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        abVar.n("chunk_sum", String.valueOf(i));
        abVar.n("video_size", String.valueOf(this.fOU));
        abVar.n("chunk_size", String.valueOf(this.fOW));
        abVar.n("is_merge", String.valueOf(z ? 1 : 0));
        abVar.n("video_md5", this.fOV);
        abVar.n("video_len", String.valueOf(j));
        abVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            abVar.n("upload_id", str);
        }
        String uy = abVar.uy();
        if (abVar.uV().vS().isRequestSuccess()) {
            if (StringUtils.isNull(uy)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uy);
            return aVar;
        }
        a aVar2 = new a();
        if (abVar.uV().vS().uY()) {
            aVar2.fOQ = abVar.uV().vS().ahc;
        } else {
            aVar2.fOQ = abVar.uV().vS().vQ;
        }
        aVar2.mErrorMessage = abVar.uV().vS().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (z.t(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fPa = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fOW, this.fOX, this.fOU, this.fOV);
        } else {
            this.fPa = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fOW, this.fOX, this.fOU, this.fOV);
        }
        this.fPa.a(this.fOY);
        f b = this.fPa.b(arrayList, str, i);
        this.fPa = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fOZ = true;
        if (this.fPa != null) {
            this.fPa.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fOY = eVar;
    }
}
