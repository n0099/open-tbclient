package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.l.g;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long mFileLength;
    private String mFileMd5;
    private String mFileName;
    private final int nvc;
    private int nvd;
    private e nve;
    private boolean nvf;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a nvg;
    private g nvh;

    public d(String str, int i, g gVar) {
        this.mFileName = str;
        this.nvc = i;
        this.nvh = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.mFileLength = file.length();
            this.mFileMd5 = s.toMd5(n.GetStreamFromFile(file));
            if (this.mFileLength % this.nvc == 0) {
                this.nvd = (int) (this.mFileLength / this.nvc);
            } else {
                this.nvd = ((int) (this.mFileLength / this.nvc)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bV(String str, int i) {
        a a2;
        if (StringUtils.isNull(str) || this.mFileLength <= 0 || StringUtils.isNull(this.mFileMd5) || i <= 0 || this.nvf) {
            return null;
        }
        Li(10);
        a a3 = a(this.nvd, i, false, null);
        if (a3 == null || this.nvf) {
            return null;
        }
        if (a3.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a3.mErrorNo);
            videoFinishResult.setUserMessage(a3.mErrorMessage);
            q(302, a3.mErrorNo, a3.mErrorMessage);
            return videoFinishResult;
        }
        Li(30);
        if (!StringUtils.isNull(a3.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.mFileMd5);
            videoFinishResult2.setVideoUrl(a3.mVideoUrl);
            dQv();
            return videoFinishResult2;
        } else if (this.nvf) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a3.nuX;
            if (x.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.nvd; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a3.nuY;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d d = d(arrayList, str2, i);
            if (d == null || this.nvf) {
                return null;
            }
            if (d.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(d.errorNo);
                videoFinishResult3.setUserMessage(d.errorMessage);
                q(303, d.errorNo, d.errorMessage);
                return videoFinishResult3;
            }
            Li(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.mFileMd5);
                dQv();
                return videoFinishResult4;
            } else if (this.nvf || (a2 = a(this.nvd, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a2.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a2.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.mFileMd5);
                    dQv();
                } else {
                    videoFinishResult5.setErrorNo(a2.mErrorNo);
                    videoFinishResult5.setUserMessage(a2.mErrorMessage);
                    q(304, a2.mErrorNo, a2.mErrorMessage);
                    TiebaStatic.log(new aq("c12024").dX("params", a2.mErrorMessage));
                }
                Li(100);
                return videoFinishResult5;
            }
        }
    }

    private void Li(int i) {
        if (this.nve != null) {
            this.nve.aX(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.addPostData("chunk_sum", String.valueOf(i));
        zVar.addPostData("video_size", String.valueOf(this.mFileLength));
        zVar.addPostData("chunk_size", String.valueOf(this.nvc));
        zVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        zVar.addPostData("video_md5", this.mFileMd5);
        zVar.addPostData("video_len", String.valueOf(j));
        zVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.addPostData("upload_id", str);
        }
        String postNetData = zVar.postNetData();
        if (zVar.bvQ().bwA().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.bvQ().bwA().isNetSuccess()) {
            aVar2.mErrorNo = zVar.bvQ().bwA().mServerErrorCode;
        } else {
            aVar2.mErrorNo = zVar.bvQ().bwA().mNetErrorCode;
        }
        aVar2.mErrorMessage = zVar.bvQ().bwA().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (x.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.nvg = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.nvc, this.nvd, this.mFileLength, this.mFileMd5);
        } else {
            this.nvg = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.nvc, this.nvd, this.mFileLength, this.mFileMd5);
        }
        this.nvg.a(this.nve);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.nvg.d(arrayList, str, i);
        this.nvg = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.nvf = true;
        if (this.nvg != null) {
            this.nvg.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.nve = eVar;
    }

    private void q(int i, int i2, String str) {
        if (this.nvh != null) {
            this.nvh.p(i, i2, str);
        }
    }

    private void dQv() {
        if (this.nvh != null) {
            this.nvh.diz();
        }
    }
}
