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
    private String Tj;
    private long kfc;
    private final int kfd;
    private int kfe;
    private e kff;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a kfg;
    private h kfh;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.kfd = i;
        this.kfh = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.kfc = file.length();
            this.Tj = s.toMd5(m.GetStreamFromFile(file));
            if (this.kfc % this.kfd == 0) {
                this.kfe = (int) (this.kfc / this.kfd);
            } else {
                this.kfe = ((int) (this.kfc / this.kfd)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bv(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.kfc <= 0 || StringUtils.isNull(this.Tj) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.kfe, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.mErrorNo);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            l(302, a2.mErrorNo, a2.mErrorMessage);
            return videoFinishResult;
        }
        notifyProgress(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.Tj);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            cJB();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.keX;
            if (v.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.kfe; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.keY;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d c = c(arrayList, str2, i);
            if (c == null || this.mCancelled) {
                return null;
            }
            if (c.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(c.errorNo);
                videoFinishResult3.setUserMessage(c.errorMessage);
                l(303, c.errorNo, c.errorMessage);
                return videoFinishResult3;
            }
            notifyProgress(85);
            if (!StringUtils.isNull(c.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(c.videoUrl);
                videoFinishResult4.setVideoMd5(this.Tj);
                cJB();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.kfe, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.Tj);
                    cJB();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    l(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new an("c12024").cp("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.kff != null) {
            this.kff.aM(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.addPostData("chunk_sum", String.valueOf(i));
        xVar.addPostData("video_size", String.valueOf(this.kfc));
        xVar.addPostData("chunk_size", String.valueOf(this.kfd));
        xVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        xVar.addPostData("video_md5", this.Tj);
        xVar.addPostData(PublishLimitUpdateListener.KEY_VIDEO_LEN, String.valueOf(j));
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.addPostData("upload_id", str);
        }
        String postNetData = xVar.postNetData();
        if (xVar.aDB().aEc().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aDB().aEc().isNetSuccess()) {
            aVar2.mErrorNo = xVar.aDB().aEc().mServerErrorCode;
        } else {
            aVar2.mErrorNo = xVar.aDB().aEc().mNetErrorCode;
        }
        aVar2.mErrorMessage = xVar.aDB().aEc().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d c(ArrayList<Integer> arrayList, String str, int i) {
        if (v.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.kfg = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.kfd, this.kfe, this.kfc, this.Tj);
        } else {
            this.kfg = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.kfd, this.kfe, this.kfc, this.Tj);
        }
        this.kfg.a(this.kff);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d c = this.kfg.c(arrayList, str, i);
        this.kfg = null;
        return c;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.kfg != null) {
            this.kfg.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.kff = eVar;
    }

    private void l(int i, int i2, String str) {
        if (this.kfh != null) {
            this.kfh.j(i, i2, str);
        }
    }

    private void cJB() {
        if (this.kfh != null) {
            this.kfh.cdM();
        }
    }
}
