package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private boolean mCancelled;
    private long mFileLength;
    private String mFileName;
    private String nam;
    private final int nan;
    private int nao;
    private e nap;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a naq;
    private h nar;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.nan = i;
        this.nar = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.mFileLength = file.length();
            this.nam = s.toMd5(n.GetStreamFromFile(file));
            if (this.mFileLength % this.nan == 0) {
                this.nao = (int) (this.mFileLength / this.nan);
            } else {
                this.nao = ((int) (this.mFileLength / this.nan)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bM(String str, int i) {
        a a2;
        if (StringUtils.isNull(str) || this.mFileLength <= 0 || StringUtils.isNull(this.nam) || i <= 0 || this.mCancelled) {
            return null;
        }
        JT(10);
        a a3 = a(this.nao, i, false, null);
        if (a3 == null || this.mCancelled) {
            return null;
        }
        if (a3.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a3.mErrorNo);
            videoFinishResult.setUserMessage(a3.mErrorMessage);
            p(302, a3.mErrorNo, a3.mErrorMessage);
            return videoFinishResult;
        }
        JT(30);
        if (!StringUtils.isNull(a3.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.nam);
            videoFinishResult2.setVideoUrl(a3.mVideoUrl);
            dLh();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a3.nah;
            if (y.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.nao; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a3.nai;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d d = d(arrayList, str2, i);
            if (d == null || this.mCancelled) {
                return null;
            }
            if (d.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(d.errorNo);
                videoFinishResult3.setUserMessage(d.errorMessage);
                p(303, d.errorNo, d.errorMessage);
                return videoFinishResult3;
            }
            JT(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.nam);
                dLh();
                return videoFinishResult4;
            } else if (this.mCancelled || (a2 = a(this.nao, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a2.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a2.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.nam);
                    dLh();
                } else {
                    videoFinishResult5.setErrorNo(a2.mErrorNo);
                    videoFinishResult5.setUserMessage(a2.mErrorMessage);
                    p(304, a2.mErrorNo, a2.mErrorMessage);
                    TiebaStatic.log(new aq("c12024").dR("params", a2.mErrorMessage));
                }
                JT(100);
                return videoFinishResult5;
            }
        }
    }

    private void JT(int i) {
        if (this.nap != null) {
            this.nap.aN(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        aaVar.addPostData("chunk_sum", String.valueOf(i));
        aaVar.addPostData("video_size", String.valueOf(this.mFileLength));
        aaVar.addPostData("chunk_size", String.valueOf(this.nan));
        aaVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        aaVar.addPostData("video_md5", this.nam);
        aaVar.addPostData("video_len", String.valueOf(j));
        aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            aaVar.addPostData("upload_id", str);
        }
        String postNetData = aaVar.postNetData();
        if (aaVar.bqN().bru().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (aaVar.bqN().bru().isNetSuccess()) {
            aVar2.mErrorNo = aaVar.bqN().bru().mServerErrorCode;
        } else {
            aVar2.mErrorNo = aaVar.bqN().bru().mNetErrorCode;
        }
        aVar2.mErrorMessage = aaVar.bqN().bru().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (y.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.naq = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.nan, this.nao, this.mFileLength, this.nam);
        } else {
            this.naq = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.nan, this.nao, this.mFileLength, this.nam);
        }
        this.naq.a(this.nap);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.naq.d(arrayList, str, i);
        this.naq = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.naq != null) {
            this.naq.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.nap = eVar;
    }

    private void p(int i, int i2, String str) {
        if (this.nar != null) {
            this.nar.o(i, i2, str);
        }
    }

    private void dLh() {
        if (this.nar != null) {
            this.nar.ded();
        }
    }
}
