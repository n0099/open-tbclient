package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private long iIS;
    private String iIT;
    private final int iIU;
    private int iIV;
    private e iIW;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a iIX;
    private h iIY;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.iIU = i;
        this.iIY = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.iIS = file.length();
            this.iIT = s.j(m.F(file));
            if (this.iIS % this.iIU == 0) {
                this.iIV = (int) (this.iIS / this.iIU);
            } else {
                this.iIV = ((int) (this.iIS / this.iIU)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bs(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.iIS <= 0 || StringUtils.isNull(this.iIT) || i <= 0 || this.mCancelled) {
            return null;
        }
        zD(10);
        a b2 = b(this.iIV, i, false, null);
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
        zD(30);
        if (!StringUtils.isNull(b2.bNo)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.iIT);
            videoFinishResult2.setVideoUrl(b2.bNo);
            cfv();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.iIN;
            if (v.T(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.iIV; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.iIO;
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
            zD(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.iIT);
                cfv();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.iIV, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(b.bNo);
                    videoFinishResult5.setVideoMd5(this.iIT);
                    cfv();
                } else {
                    videoFinishResult5.setErrorNo(b.mErrorNo);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    i(304, b.mErrorNo, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").bJ("params", b.mErrorMessage));
                }
                zD(100);
                return videoFinishResult5;
            }
        }
    }

    private void zD(int i) {
        if (this.iIW != null) {
            this.iIW.aM(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.iIS));
        xVar.x("chunk_size", String.valueOf(this.iIU));
        xVar.x("is_merge", String.valueOf(z ? 1 : 0));
        xVar.x("video_md5", this.iIT);
        xVar.x("video_len", String.valueOf(j));
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.x("upload_id", str);
        }
        String acg = xVar.acg();
        if (xVar.acE().adD().isRequestSuccess()) {
            if (StringUtils.isNull(acg)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(acg);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.acE().adD().acH()) {
            aVar2.mErrorNo = xVar.acE().adD().bLV;
        } else {
            aVar2.mErrorNo = xVar.acE().adD().Dd;
        }
        aVar2.mErrorMessage = xVar.acE().adD().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.T(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.iIX = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.iIU, this.iIV, this.iIS, this.iIT);
        } else {
            this.iIX = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.iIU, this.iIV, this.iIS, this.iIT);
        }
        this.iIX.a(this.iIW);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.iIX.b(arrayList, str, i);
        this.iIX = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.iIX != null) {
            this.iIX.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.iIW = eVar;
    }

    private void i(int i, int i2, String str) {
        if (this.iIY != null) {
            this.iIY.g(i, i2, str);
        }
    }

    private void cfv() {
        if (this.iIY != null) {
            this.iIY.bEe();
        }
    }
}
