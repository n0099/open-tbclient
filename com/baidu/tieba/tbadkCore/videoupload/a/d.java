package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.a.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long fjf;
    private String fjg;
    private final int fjh;
    private int fji;
    private e fjj;
    private boolean fjk;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fjl;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fjh = i;
        File file = new File(str);
        if (file.exists()) {
            this.fjf = file.length();
            this.fjg = t.k(m.n(file));
            if (this.fjf % this.fjh == 0) {
                this.fji = (int) (this.fjf / this.fjh);
            } else {
                this.fji = ((int) (this.fjf / this.fjh)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aC(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fjf <= 0 || StringUtils.isNull(this.fjg) || i <= 0 || this.fjk) {
            return null;
        }
        rw(10);
        a a2 = a(this.fji, i, false, null);
        if (a2 == null || this.fjk) {
            return null;
        }
        if (a2.fjb != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fjb);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        rw(30);
        if (!StringUtils.isNull(a2.aPj)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fjg);
            videoFinishResult2.setVideoUrl(a2.aPj);
            return videoFinishResult2;
        } else if (this.fjk) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fiZ;
            if (x.t(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fji; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fja;
            f b = b(arrayList, str2, i);
            if (b == null || this.fjk) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            rw(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fjg);
                return videoFinishResult4;
            } else if (this.fjk || (a = a(this.fji, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fjb == 0) {
                    videoFinishResult5.setVideoUrl(a.aPj);
                    videoFinishResult5.setVideoMd5(this.fjg);
                } else {
                    videoFinishResult5.setErrorNo(a.fjb);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                }
                rw(100);
                return videoFinishResult5;
            }
        }
    }

    private void rw(int i) {
        if (this.fjj != null) {
            this.fjj.al(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fjf));
        zVar.n("chunk_size", String.valueOf(this.fjh));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fjg);
        zVar.n("video_len", String.valueOf(j));
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.n("upload_id", str);
        }
        String uk = zVar.uk();
        if (zVar.uI().vC().oH()) {
            if (StringUtils.isNull(uk)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(uk);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.uI().vC().uL()) {
            aVar2.fjb = zVar.uI().vC().acu;
        } else {
            aVar2.fjb = zVar.uI().vC().oF;
        }
        aVar2.mErrorMessage = zVar.uI().vC().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.t(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fjl = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fjh, this.fji, this.fjf, this.fjg);
        } else {
            this.fjl = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fjh, this.fji, this.fjf, this.fjg);
        }
        this.fjl.a(this.fjj);
        f b = this.fjl.b(arrayList, str, i);
        this.fjl = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fjk = true;
        if (this.fjl != null) {
            this.fjl.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fjj = eVar;
    }
}
