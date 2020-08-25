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
/* loaded from: classes2.dex */
public class d implements b {
    private boolean mCancelled;
    private String mFileName;
    private long mii;
    private String mij;
    private final int mik;
    private int mil;
    private e mim;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a mio;
    private h mip;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.mik = i;
        this.mip = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.mii = file.length();
            this.mij = s.toMd5(n.GetStreamFromFile(file));
            if (this.mii % this.mik == 0) {
                this.mil = (int) (this.mii / this.mik);
            } else {
                this.mil = ((int) (this.mii / this.mik)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bI(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.mii <= 0 || StringUtils.isNull(this.mij) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.mil, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.mErrorNo);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            m(302, a2.mErrorNo, a2.mErrorMessage);
            return videoFinishResult;
        }
        notifyProgress(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.mij);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            dxN();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.mic;
            if (y.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.mil; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.mie;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d d = d(arrayList, str2, i);
            if (d == null || this.mCancelled) {
                return null;
            }
            if (d.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(d.errorNo);
                videoFinishResult3.setUserMessage(d.errorMessage);
                m(303, d.errorNo, d.errorMessage);
                return videoFinishResult3;
            }
            notifyProgress(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.mij);
                dxN();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.mil, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.mij);
                    dxN();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    m(304, a.mErrorNo, a.mErrorMessage);
                    TiebaStatic.log(new aq("c12024").dD("params", a.mErrorMessage));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.mim != null) {
            this.mim.aD(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        aaVar.addPostData("chunk_sum", String.valueOf(i));
        aaVar.addPostData("video_size", String.valueOf(this.mii));
        aaVar.addPostData("chunk_size", String.valueOf(this.mik));
        aaVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        aaVar.addPostData("video_md5", this.mij);
        aaVar.addPostData("video_len", String.valueOf(j));
        aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            aaVar.addPostData("upload_id", str);
        }
        String postNetData = aaVar.postNetData();
        if (aaVar.biQ().bjw().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (aaVar.biQ().bjw().isNetSuccess()) {
            aVar2.mErrorNo = aaVar.biQ().bjw().mServerErrorCode;
        } else {
            aVar2.mErrorNo = aaVar.biQ().bjw().mNetErrorCode;
        }
        aVar2.mErrorMessage = aaVar.biQ().bjw().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (y.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.mio = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.mik, this.mil, this.mii, this.mij);
        } else {
            this.mio = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.mik, this.mil, this.mii, this.mij);
        }
        this.mio.a(this.mim);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.mio.d(arrayList, str, i);
        this.mio = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.mio != null) {
            this.mio.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.mim = eVar;
    }

    private void m(int i, int i2, String str) {
        if (this.mip != null) {
            this.mip.l(i, i2, str);
        }
    }

    private void dxN() {
        if (this.mip != null) {
            this.mip.cRd();
        }
    }
}
