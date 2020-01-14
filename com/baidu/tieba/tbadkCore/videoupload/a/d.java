package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.searchbox.ugc.listener.PublishLimitUpdateListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private String Tm;
    private long kiK;
    private final int kiL;
    private int kiM;
    private e kiN;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a kiO;
    private h kiP;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.kiL = i;
        this.kiP = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.kiK = file.length();
            this.Tm = s.toMd5(m.GetStreamFromFile(file));
            if (this.kiK % this.kiL == 0) {
                this.kiM = (int) (this.kiK / this.kiL);
            } else {
                this.kiM = ((int) (this.kiK / this.kiL)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bw(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.kiK <= 0 || StringUtils.isNull(this.Tm) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.kiM, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.mErrorNo);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            n(302, a2.mErrorNo, a2.mErrorMessage);
            return videoFinishResult;
        }
        notifyProgress(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.Tm);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            cKH();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.kiF;
            if (v.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.kiM; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.kiG;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d c = c(arrayList, str2, i);
            if (c == null || this.mCancelled) {
                return null;
            }
            if (c.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(c.errorNo);
                videoFinishResult3.setUserMessage(c.errorMessage);
                n(303, c.errorNo, c.errorMessage);
                return videoFinishResult3;
            }
            notifyProgress(85);
            if (!StringUtils.isNull(c.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(c.videoUrl);
                videoFinishResult4.setVideoMd5(this.Tm);
                cKH();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.kiM, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.Tm);
                    cKH();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    n(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new an("c12024").cp("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.kiN != null) {
            this.kiN.aL(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.addPostData("chunk_sum", String.valueOf(i));
        xVar.addPostData("video_size", String.valueOf(this.kiK));
        xVar.addPostData("chunk_size", String.valueOf(this.kiL));
        xVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        xVar.addPostData("video_md5", this.Tm);
        xVar.addPostData(PublishLimitUpdateListener.KEY_VIDEO_LEN, String.valueOf(j));
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.addPostData("upload_id", str);
        }
        String postNetData = xVar.postNetData();
        if (xVar.aDU().aEv().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aDU().aEv().isNetSuccess()) {
            aVar2.mErrorNo = xVar.aDU().aEv().mServerErrorCode;
        } else {
            aVar2.mErrorNo = xVar.aDU().aEv().mNetErrorCode;
        }
        aVar2.mErrorMessage = xVar.aDU().aEv().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d c(ArrayList<Integer> arrayList, String str, int i) {
        if (v.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.kiO = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.kiL, this.kiM, this.kiK, this.Tm);
        } else {
            this.kiO = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.kiL, this.kiM, this.kiK, this.Tm);
        }
        this.kiO.a(this.kiN);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d c = this.kiO.c(arrayList, str, i);
        this.kiO = null;
        return c;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.kiO != null) {
            this.kiO.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.kiN = eVar;
    }

    private void n(int i, int i2, String str) {
        if (this.kiP != null) {
            this.kiP.l(i, i2, str);
        }
    }

    private void cKH() {
        if (this.kiP != null) {
            this.kiP.ceV();
        }
    }
}
