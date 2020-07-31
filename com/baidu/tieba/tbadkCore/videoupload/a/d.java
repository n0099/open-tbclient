package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private e lQA;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a lQB;
    private h lQC;
    private long lQw;
    private String lQx;
    private final int lQy;
    private int lQz;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.lQy = i;
        this.lQC = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.lQw = file.length();
            this.lQx = s.toMd5(n.GetStreamFromFile(file));
            if (this.lQw % this.lQy == 0) {
                this.lQz = (int) (this.lQw / this.lQy);
            } else {
                this.lQz = ((int) (this.lQw / this.lQy)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bD(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.lQw <= 0 || StringUtils.isNull(this.lQx) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.lQz, i, false, null);
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
            videoFinishResult2.setVideoMd5(this.lQx);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            dmr();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.lQr;
            if (x.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.lQz; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.lQs;
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
                videoFinishResult4.setVideoMd5(this.lQx);
                dmr();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.lQz, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.lQx);
                    dmr();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    n(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new ap("c12024").dn("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.lQA != null) {
            this.lQA.ax(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.addPostData("chunk_sum", String.valueOf(i));
        zVar.addPostData("video_size", String.valueOf(this.lQw));
        zVar.addPostData("chunk_size", String.valueOf(this.lQy));
        zVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        zVar.addPostData("video_md5", this.lQx);
        zVar.addPostData("video_len", String.valueOf(j));
        zVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.addPostData("upload_id", str);
        }
        String postNetData = zVar.postNetData();
        if (zVar.bav().baX().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.bav().baX().isNetSuccess()) {
            aVar2.mErrorNo = zVar.bav().baX().mServerErrorCode;
        } else {
            aVar2.mErrorNo = zVar.bav().baX().mNetErrorCode;
        }
        aVar2.mErrorMessage = zVar.bav().baX().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (x.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.lQB = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.lQy, this.lQz, this.lQw, this.lQx);
        } else {
            this.lQB = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.lQy, this.lQz, this.lQw, this.lQx);
        }
        this.lQB.a(this.lQA);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.lQB.d(arrayList, str, i);
        this.lQB = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.lQB != null) {
            this.lQB.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.lQA = eVar;
    }

    private void n(int i, int i2, String str) {
        if (this.lQC != null) {
            this.lQC.m(i, i2, str);
        }
    }

    private void dmr() {
        if (this.lQC != null) {
            this.lQC.cGo();
        }
    }
}
