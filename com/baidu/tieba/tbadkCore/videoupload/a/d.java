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
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private String US;
    private long kjI;
    private final int kjJ;
    private int kjK;
    private e kjL;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a kjM;
    private h kjN;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.kjJ = i;
        this.kjN = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.kjI = file.length();
            this.US = s.toMd5(m.GetStreamFromFile(file));
            if (this.kjI % this.kjJ == 0) {
                this.kjK = (int) (this.kjI / this.kjJ);
            } else {
                this.kjK = ((int) (this.kjI / this.kjJ)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bv(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.kjI <= 0 || StringUtils.isNull(this.US) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.kjK, i, false, null);
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
            videoFinishResult2.setVideoMd5(this.US);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            cMe();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.kjD;
            if (v.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.kjK; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.kjE;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d d = d(arrayList, str2, i);
            if (d == null || this.mCancelled) {
                return null;
            }
            if (d.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(d.errorNo);
                videoFinishResult3.setUserMessage(d.errorMessage);
                n(303, d.errorNo, d.errorMessage);
                return videoFinishResult3;
            }
            notifyProgress(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.US);
                cMe();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.kjK, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.US);
                    cMe();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    n(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new an("c12024").cy("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.kjL != null) {
            this.kjL.aK(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.addPostData("chunk_sum", String.valueOf(i));
        xVar.addPostData("video_size", String.valueOf(this.kjI));
        xVar.addPostData("chunk_size", String.valueOf(this.kjJ));
        xVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        xVar.addPostData("video_md5", this.US);
        xVar.addPostData(PublishLimitUpdateListener.KEY_VIDEO_LEN, String.valueOf(j));
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.addPostData("upload_id", str);
        }
        String postNetData = xVar.postNetData();
        if (xVar.aGg().aGI().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aGg().aGI().isNetSuccess()) {
            aVar2.mErrorNo = xVar.aGg().aGI().mServerErrorCode;
        } else {
            aVar2.mErrorNo = xVar.aGg().aGI().mNetErrorCode;
        }
        aVar2.mErrorMessage = xVar.aGg().aGI().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (v.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.kjM = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.kjJ, this.kjK, this.kjI, this.US);
        } else {
            this.kjM = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.kjJ, this.kjK, this.kjI, this.US);
        }
        this.kjM.a(this.kjL);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.kjM.d(arrayList, str, i);
        this.kjM = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.kjM != null) {
            this.kjM.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.kjL = eVar;
    }

    private void n(int i, int i2, String str) {
        if (this.kjN != null) {
            this.kjN.l(i, i2, str);
        }
    }

    private void cMe() {
        if (this.kjN != null) {
            this.kjN.cgB();
        }
    }
}
