package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.l.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private boolean mCancelled;
    private long mFileLength;
    private String mFileName;
    private String nbn;
    private final int nbo;
    private int nbp;
    private e nbq;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a nbr;
    private h nbs;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.nbo = i;
        this.nbs = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.mFileLength = file.length();
            this.nbn = s.toMd5(n.GetStreamFromFile(file));
            if (this.mFileLength % this.nbo == 0) {
                this.nbp = (int) (this.mFileLength / this.nbo);
            } else {
                this.nbp = ((int) (this.mFileLength / this.nbo)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bL(String str, int i) {
        a a2;
        if (StringUtils.isNull(str) || this.mFileLength <= 0 || StringUtils.isNull(this.nbn) || i <= 0 || this.mCancelled) {
            return null;
        }
        Kw(10);
        a a3 = a(this.nbp, i, false, null);
        if (a3 == null || this.mCancelled) {
            return null;
        }
        if (a3.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a3.mErrorNo);
            videoFinishResult.setUserMessage(a3.mErrorMessage);
            o(302, a3.mErrorNo, a3.mErrorMessage);
            return videoFinishResult;
        }
        Kw(30);
        if (!StringUtils.isNull(a3.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.nbn);
            videoFinishResult2.setVideoUrl(a3.mVideoUrl);
            dLg();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a3.nbi;
            if (y.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.nbp; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a3.nbj;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d d = d(arrayList, str2, i);
            if (d == null || this.mCancelled) {
                return null;
            }
            if (d.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(d.errorNo);
                videoFinishResult3.setUserMessage(d.errorMessage);
                o(303, d.errorNo, d.errorMessage);
                return videoFinishResult3;
            }
            Kw(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.nbn);
                dLg();
                return videoFinishResult4;
            } else if (this.mCancelled || (a2 = a(this.nbp, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a2.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a2.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.nbn);
                    dLg();
                } else {
                    videoFinishResult5.setErrorNo(a2.mErrorNo);
                    videoFinishResult5.setUserMessage(a2.mErrorMessage);
                    o(304, a2.mErrorNo, a2.mErrorMessage);
                    TiebaStatic.log(new ar("c12024").dR("params", a2.mErrorMessage));
                }
                Kw(100);
                return videoFinishResult5;
            }
        }
    }

    private void Kw(int i) {
        if (this.nbq != null) {
            this.nbq.aU(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        aaVar.addPostData("chunk_sum", String.valueOf(i));
        aaVar.addPostData("video_size", String.valueOf(this.mFileLength));
        aaVar.addPostData("chunk_size", String.valueOf(this.nbo));
        aaVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        aaVar.addPostData("video_md5", this.nbn);
        aaVar.addPostData("video_len", String.valueOf(j));
        aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            aaVar.addPostData("upload_id", str);
        }
        String postNetData = aaVar.postNetData();
        if (aaVar.bqa().bqI().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (aaVar.bqa().bqI().isNetSuccess()) {
            aVar2.mErrorNo = aaVar.bqa().bqI().mServerErrorCode;
        } else {
            aVar2.mErrorNo = aaVar.bqa().bqI().mNetErrorCode;
        }
        aVar2.mErrorMessage = aaVar.bqa().bqI().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (y.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.nbr = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.nbo, this.nbp, this.mFileLength, this.nbn);
        } else {
            this.nbr = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.nbo, this.nbp, this.mFileLength, this.nbn);
        }
        this.nbr.a(this.nbq);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.nbr.d(arrayList, str, i);
        this.nbr = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.nbr != null) {
            this.nbr.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.nbq = eVar;
    }

    private void o(int i, int i2, String str) {
        if (this.nbs != null) {
            this.nbs.n(i, i2, str);
        }
    }

    private void dLg() {
        if (this.nbs != null) {
            this.nbs.ddA();
        }
    }
}
