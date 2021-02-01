package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.l.g;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long mFileLength;
    private String mFileMd5;
    private String mFileName;
    private final int nAf;
    private int nAg;
    private e nAh;
    private boolean nAi;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a nAj;
    private g nAk;

    public d(String str, int i, g gVar) {
        this.mFileName = str;
        this.nAf = i;
        this.nAk = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.mFileLength = file.length();
            this.mFileMd5 = s.toMd5(o.GetStreamFromFile(file));
            if (this.mFileLength % this.nAf == 0) {
                this.nAg = (int) (this.mFileLength / this.nAf);
            } else {
                this.nAg = ((int) (this.mFileLength / this.nAf)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bW(String str, int i) {
        a a2;
        if (StringUtils.isNull(str) || this.mFileLength <= 0 || StringUtils.isNull(this.mFileMd5) || i <= 0 || this.nAi) {
            return null;
        }
        JV(10);
        a a3 = a(this.nAg, i, false, null);
        if (a3 == null || this.nAi) {
            return null;
        }
        if (a3.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a3.mErrorNo);
            videoFinishResult.setUserMessage(a3.mErrorMessage);
            p(302, a3.mErrorNo, a3.mErrorMessage);
            return videoFinishResult;
        }
        JV(30);
        if (!StringUtils.isNull(a3.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.mFileMd5);
            videoFinishResult2.setVideoUrl(a3.mVideoUrl);
            dOP();
            return videoFinishResult2;
        } else if (this.nAi) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a3.nAa;
            if (y.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.nAg; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a3.nAb;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d d = d(arrayList, str2, i);
            if (d == null || this.nAi) {
                return null;
            }
            if (d.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(d.errorNo);
                videoFinishResult3.setUserMessage(d.errorMessage);
                p(303, d.errorNo, d.errorMessage);
                return videoFinishResult3;
            }
            JV(85);
            if (!StringUtils.isNull(d.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(d.videoUrl);
                videoFinishResult4.setVideoMd5(this.mFileMd5);
                dOP();
                return videoFinishResult4;
            } else if (this.nAi || (a2 = a(this.nAg, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a2.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a2.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.mFileMd5);
                    dOP();
                } else {
                    videoFinishResult5.setErrorNo(a2.mErrorNo);
                    videoFinishResult5.setUserMessage(a2.mErrorMessage);
                    p(304, a2.mErrorNo, a2.mErrorMessage);
                    TiebaStatic.log(new ar("c12024").dR("params", a2.mErrorMessage));
                }
                JV(100);
                return videoFinishResult5;
            }
        }
    }

    private void JV(int i) {
        if (this.nAh != null) {
            this.nAh.ba(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        aaVar.addPostData("chunk_sum", String.valueOf(i));
        aaVar.addPostData("video_size", String.valueOf(this.mFileLength));
        aaVar.addPostData("chunk_size", String.valueOf(this.nAf));
        aaVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        aaVar.addPostData("video_md5", this.mFileMd5);
        aaVar.addPostData("video_len", String.valueOf(j));
        aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            aaVar.addPostData("upload_id", str);
        }
        String postNetData = aaVar.postNetData();
        if (aaVar.bsr().btb().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (aaVar.bsr().btb().isNetSuccess()) {
            aVar2.mErrorNo = aaVar.bsr().btb().mServerErrorCode;
        } else {
            aVar2.mErrorNo = aaVar.bsr().btb().mNetErrorCode;
        }
        aVar2.mErrorMessage = aaVar.bsr().btb().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d d(ArrayList<Integer> arrayList, String str, int i) {
        if (y.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.nAj = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.nAf, this.nAg, this.mFileLength, this.mFileMd5);
        } else {
            this.nAj = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.nAf, this.nAg, this.mFileLength, this.mFileMd5);
        }
        this.nAj.a(this.nAh);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d d = this.nAj.d(arrayList, str, i);
        this.nAj = null;
        return d;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.nAi = true;
        if (this.nAj != null) {
            this.nAj.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.nAh = eVar;
    }

    private void p(int i, int i2, String str) {
        if (this.nAk != null) {
            this.nAk.o(i, i2, str);
        }
    }

    private void dOP() {
        if (this.nAk != null) {
            this.nAk.dgI();
        }
    }
}
