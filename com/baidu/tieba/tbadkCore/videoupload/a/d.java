package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long lJi;
    private String lJj;
    private final int lJk;
    private int lJl;
    private e lJm;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a lJn;
    private h lJo;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.lJk = i;
        this.lJo = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.lJi = file.length();
            this.lJj = s.toMd5(n.GetStreamFromFile(file));
            if (this.lJi % this.lJk == 0) {
                this.lJl = (int) (this.lJi / this.lJk);
            } else {
                this.lJl = ((int) (this.lJi / this.lJk)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bF(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.lJi <= 0 || StringUtils.isNull(this.lJj) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.lJl, i, false, null);
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
            videoFinishResult2.setVideoMd5(this.lJj);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            djj();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.lJd;
            if (w.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.lJl; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.lJe;
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
                videoFinishResult4.setVideoMd5(this.lJj);
                djj();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.lJl, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.lJj);
                    djj();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    n(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new ao("c12024").dk("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.lJm != null) {
            this.lJm.ay(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        yVar.addPostData("chunk_sum", String.valueOf(i));
        yVar.addPostData("video_size", String.valueOf(this.lJi));
        yVar.addPostData("chunk_size", String.valueOf(this.lJk));
        yVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        yVar.addPostData("video_md5", this.lJj);
        yVar.addPostData("video_len", String.valueOf(j));
        yVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            yVar.addPostData("upload_id", str);
        }
        String postNetData = yVar.postNetData();
        if (yVar.aWu().aWW().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (yVar.aWu().aWW().isNetSuccess()) {
            aVar2.mErrorNo = yVar.aWu().aWW().mServerErrorCode;
        } else {
            aVar2.mErrorNo = yVar.aWu().aWW().mNetErrorCode;
        }
        aVar2.mErrorMessage = yVar.aWu().aWW().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (w.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.lJn = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.lJk, this.lJl, this.lJi, this.lJj);
        } else {
            this.lJn = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.lJk, this.lJl, this.lJi, this.lJj);
        }
        this.lJn.a(this.lJm);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.lJn.d(arrayList, str, i);
        this.lJn = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.lJn != null) {
            this.lJn.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.lJm = eVar;
    }

    private void n(int i, int i2, String str) {
        if (this.lJo != null) {
            this.lJo.l(i, i2, str);
        }
    }

    private void djj() {
        if (this.lJo != null) {
            this.lJo.cCt();
        }
    }
}
