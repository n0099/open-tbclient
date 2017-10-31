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
    private long gsa;
    private String gsb;
    private final int gsc;
    private int gsd;
    private e gse;
    private boolean gsf;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a gsg;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.gsc = i;
        File file = new File(str);
        if (file.exists()) {
            this.gsa = file.length();
            this.gsb = s.e(k.q(file));
            if (this.gsa % this.gsc == 0) {
                this.gsd = (int) (this.gsa / this.gsc);
            } else {
                this.gsd = ((int) (this.gsa / this.gsc)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aF(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.gsa <= 0 || StringUtils.isNull(this.gsb) || i <= 0 || this.gsf) {
            return null;
        }
        ud(10);
        a a2 = a(this.gsd, i, false, null);
        if (a2 == null || this.gsf) {
            return null;
        }
        if (a2.grW != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.grW);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        ud(30);
        if (!StringUtils.isNull(a2.aXu)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.gsb);
            videoFinishResult2.setVideoUrl(a2.aXu);
            return videoFinishResult2;
        } else if (this.gsf) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.grU;
            if (v.v(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.gsd; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.grV;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.gsf) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            ud(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.gsb);
                return videoFinishResult4;
            } else if (this.gsf || (a = a(this.gsd, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.grW == 0) {
                    videoFinishResult5.setVideoUrl(a.aXu);
                    videoFinishResult5.setVideoMd5(this.gsb);
                } else {
                    videoFinishResult5.setErrorNo(a.grW);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new ak("c12024").ac(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                ud(100);
                return videoFinishResult5;
            }
        }
    }

    private void ud(int i) {
        if (this.gse != null) {
            this.gse.ac(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.n("chunk_sum", String.valueOf(i));
        xVar.n("video_size", String.valueOf(this.gsa));
        xVar.n("chunk_size", String.valueOf(this.gsc));
        xVar.n("is_merge", String.valueOf(z ? 1 : 0));
        xVar.n("video_md5", this.gsb);
        xVar.n("video_len", String.valueOf(j));
        xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.n("upload_id", str);
        }
        String up = xVar.up();
        if (xVar.uN().vL().isRequestSuccess()) {
            if (StringUtils.isNull(up)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(up);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.uN().vL().uQ()) {
            aVar2.grW = xVar.uN().vL().ahZ;
        } else {
            aVar2.grW = xVar.uN().vL().vp;
        }
        aVar2.mErrorMessage = xVar.uN().vL().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.v(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.gsg = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.gsc, this.gsd, this.gsa, this.gsb);
        } else {
            this.gsg = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.gsc, this.gsd, this.gsa, this.gsb);
        }
        this.gsg.a(this.gse);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.gsg.b(arrayList, str, i);
        this.gsg = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.gsf = true;
        if (this.gsg != null) {
            this.gsg.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.gse = eVar;
    }
}
