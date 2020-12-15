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
    private String nps;
    private final int npt;
    private int npu;
    private e npv;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a npw;
    private h npx;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.npt = i;
        this.npx = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.mFileLength = file.length();
            this.nps = s.toMd5(n.GetStreamFromFile(file));
            if (this.mFileLength % this.npt == 0) {
                this.npu = (int) (this.mFileLength / this.npt);
            } else {
                this.npu = ((int) (this.mFileLength / this.npt)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bO(String str, int i) {
        a a2;
        if (StringUtils.isNull(str) || this.mFileLength <= 0 || StringUtils.isNull(this.nps) || i <= 0 || this.mCancelled) {
            return null;
        }
        Lm(10);
        a a3 = a(this.npu, i, false, null);
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
        Lm(30);
        if (!StringUtils.isNull(a3.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.nps);
            videoFinishResult2.setVideoUrl(a3.mVideoUrl);
            dQz();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a3.npn;
            if (y.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.npu; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a3.npo;
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
            Lm(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.nps);
                dQz();
                return videoFinishResult4;
            } else if (this.mCancelled || (a2 = a(this.npu, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a2.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a2.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.nps);
                    dQz();
                } else {
                    videoFinishResult5.setErrorNo(a2.mErrorNo);
                    videoFinishResult5.setUserMessage(a2.mErrorMessage);
                    p(304, a2.mErrorNo, a2.mErrorMessage);
                    TiebaStatic.log(new ar("c12024").dY("params", a2.mErrorMessage));
                }
                Lm(100);
                return videoFinishResult5;
            }
        }
    }

    private void Lm(int i) {
        if (this.npv != null) {
            this.npv.aV(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        aaVar.addPostData("chunk_sum", String.valueOf(i));
        aaVar.addPostData("video_size", String.valueOf(this.mFileLength));
        aaVar.addPostData("chunk_size", String.valueOf(this.npt));
        aaVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        aaVar.addPostData("video_md5", this.nps);
        aaVar.addPostData("video_len", String.valueOf(j));
        aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            aaVar.addPostData("upload_id", str);
        }
        String postNetData = aaVar.postNetData();
        if (aaVar.btv().buf().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (aaVar.btv().buf().isNetSuccess()) {
            aVar2.mErrorNo = aaVar.btv().buf().mServerErrorCode;
        } else {
            aVar2.mErrorNo = aaVar.btv().buf().mNetErrorCode;
        }
        aVar2.mErrorMessage = aaVar.btv().buf().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (y.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.npw = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.npt, this.npu, this.mFileLength, this.nps);
        } else {
            this.npw = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.npt, this.npu, this.mFileLength, this.nps);
        }
        this.npw.a(this.npv);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.npw.d(arrayList, str, i);
        this.npw = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.npw != null) {
            this.npw.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.npv = eVar;
    }

    private void p(int i, int i2, String str) {
        if (this.npx != null) {
            this.npx.o(i, i2, str);
        }
    }

    private void dQz() {
        if (this.npx != null) {
            this.npx.diM();
        }
    }
}
