package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long iJn;
    private String iJo;
    private final int iJp;
    private int iJq;
    private e iJr;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a iJs;
    private h iJt;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.iJp = i;
        this.iJt = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.iJn = file.length();
            this.iJo = s.j(m.F(file));
            if (this.iJn % this.iJp == 0) {
                this.iJq = (int) (this.iJn / this.iJp);
            } else {
                this.iJq = ((int) (this.iJn / this.iJp)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bs(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.iJn <= 0 || StringUtils.isNull(this.iJo) || i <= 0 || this.mCancelled) {
            return null;
        }
        zH(10);
        a b2 = b(this.iJq, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.mErrorNo);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            i(302, b2.mErrorNo, b2.mErrorMessage);
            return videoFinishResult;
        }
        zH(30);
        if (!StringUtils.isNull(b2.bNk)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.iJo);
            videoFinishResult2.setVideoUrl(b2.bNk);
            cfw();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.iJi;
            if (v.T(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.iJq; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.iJj;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                i(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            zH(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.iJo);
                cfw();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.iJq, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(b.bNk);
                    videoFinishResult5.setVideoMd5(this.iJo);
                    cfw();
                } else {
                    videoFinishResult5.setErrorNo(b.mErrorNo);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    i(304, b.mErrorNo, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").bJ(LegoListActivityConfig.PARAMS, b.mErrorMessage));
                }
                zH(100);
                return videoFinishResult5;
            }
        }
    }

    private void zH(int i) {
        if (this.iJr != null) {
            this.iJr.aM(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.iJn));
        xVar.x("chunk_size", String.valueOf(this.iJp));
        xVar.x("is_merge", String.valueOf(z ? 1 : 0));
        xVar.x("video_md5", this.iJo);
        xVar.x("video_len", String.valueOf(j));
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.x("upload_id", str);
        }
        String acj = xVar.acj();
        if (xVar.acH().adG().isRequestSuccess()) {
            if (StringUtils.isNull(acj)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(acj);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.acH().adG().acK()) {
            aVar2.mErrorNo = xVar.acH().adG().bLR;
        } else {
            aVar2.mErrorNo = xVar.acH().adG().Dd;
        }
        aVar2.mErrorMessage = xVar.acH().adG().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.T(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.iJs = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.iJp, this.iJq, this.iJn, this.iJo);
        } else {
            this.iJs = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.iJp, this.iJq, this.iJn, this.iJo);
        }
        this.iJs.a(this.iJr);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.iJs.b(arrayList, str, i);
        this.iJs = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.iJs != null) {
            this.iJs.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.iJr = eVar;
    }

    private void i(int i, int i2, String str) {
        if (this.iJt != null) {
            this.iJt.g(i, i2, str);
        }
    }

    private void cfw() {
        if (this.iJt != null) {
            this.iJt.bEh();
        }
    }
}
