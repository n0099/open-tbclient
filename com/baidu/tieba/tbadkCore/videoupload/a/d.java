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
    private String Vc;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a klA;
    private h klB;
    private long klw;
    private final int klx;
    private int kly;
    private e klz;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.klx = i;
        this.klB = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.klw = file.length();
            this.Vc = s.toMd5(m.GetStreamFromFile(file));
            if (this.klw % this.klx == 0) {
                this.kly = (int) (this.klw / this.klx);
            } else {
                this.kly = ((int) (this.klw / this.klx)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bv(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.klw <= 0 || StringUtils.isNull(this.Vc) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.kly, i, false, null);
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
            videoFinishResult2.setVideoMd5(this.Vc);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            cMz();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.klr;
            if (v.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.kly; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.kls;
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
                videoFinishResult4.setVideoMd5(this.Vc);
                cMz();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.kly, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.Vc);
                    cMz();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    n(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new an("c12024").cx("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.klz != null) {
            this.klz.aK(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.addPostData("chunk_sum", String.valueOf(i));
        xVar.addPostData("video_size", String.valueOf(this.klw));
        xVar.addPostData("chunk_size", String.valueOf(this.klx));
        xVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        xVar.addPostData("video_md5", this.Vc);
        xVar.addPostData(PublishLimitUpdateListener.KEY_VIDEO_LEN, String.valueOf(j));
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.addPostData("upload_id", str);
        }
        String postNetData = xVar.postNetData();
        if (xVar.aGk().aGM().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aGk().aGM().isNetSuccess()) {
            aVar2.mErrorNo = xVar.aGk().aGM().mServerErrorCode;
        } else {
            aVar2.mErrorNo = xVar.aGk().aGM().mNetErrorCode;
        }
        aVar2.mErrorMessage = xVar.aGk().aGM().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (v.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.klA = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.klx, this.kly, this.klw, this.Vc);
        } else {
            this.klA = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.klx, this.kly, this.klw, this.Vc);
        }
        this.klA.a(this.klz);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.klA.d(arrayList, str, i);
        this.klA = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.klA != null) {
            this.klA.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.klz = eVar;
    }

    private void n(int i, int i2, String str) {
        if (this.klB != null) {
            this.klB.l(i, i2, str);
        }
    }

    private void cMz() {
        if (this.klB != null) {
            this.klB.cgW();
        }
    }
}
