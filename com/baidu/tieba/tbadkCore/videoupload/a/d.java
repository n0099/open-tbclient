package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
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
    private long jlC;
    private String jlD;
    private final int jlE;
    private int jlF;
    private e jlG;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a jlH;
    private h jlI;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.jlE = i;
        this.jlI = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.jlC = file.length();
            this.jlD = s.toMd5(m.GetStreamFromFile(file));
            if (this.jlC % this.jlE == 0) {
                this.jlF = (int) (this.jlC / this.jlE);
            } else {
                this.jlF = ((int) (this.jlC / this.jlE)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bm(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.jlC <= 0 || StringUtils.isNull(this.jlD) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.jlF, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.mErrorNo);
            videoFinishResult.setUserMessage(a2.bMh);
            j(302, a2.mErrorNo, a2.bMh);
            return videoFinishResult;
        }
        notifyProgress(30);
        if (!StringUtils.isNull(a2.cmf)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.jlD);
            videoFinishResult2.setVideoUrl(a2.cmf);
            cpy();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.jlx;
            if (v.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.jlF; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.jly;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b = b(arrayList, str2, i);
            if (b == null || this.mCancelled) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                j(303, b.errorNo, b.errorMessage);
                return videoFinishResult3;
            }
            notifyProgress(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.jlD);
                cpy();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.jlF, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.cmf);
                    videoFinishResult5.setVideoMd5(this.jlD);
                    cpy();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.bMh);
                    j(304, a.mErrorNo, a.bMh);
                    TiebaStatic.log(new an("c12024").bS("params", a.bMh));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.jlG != null) {
            this.jlG.av(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.addPostData("chunk_sum", String.valueOf(i));
        xVar.addPostData("video_size", String.valueOf(this.jlC));
        xVar.addPostData("chunk_size", String.valueOf(this.jlE));
        xVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        xVar.addPostData("video_md5", this.jlD);
        xVar.addPostData("video_len", String.valueOf(j));
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.addPostData("upload_id", str);
        }
        String postNetData = xVar.postNetData();
        if (xVar.amr().amS().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.amr().amS().isNetSuccess()) {
            aVar2.mErrorNo = xVar.amr().amS().mServerErrorCode;
        } else {
            aVar2.mErrorNo = xVar.amr().amS().mNetErrorCode;
        }
        aVar2.bMh = xVar.amr().amS().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.jlH = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.jlE, this.jlF, this.jlC, this.jlD);
        } else {
            this.jlH = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.jlE, this.jlF, this.jlC, this.jlD);
        }
        this.jlH.a(this.jlG);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.jlH.b(arrayList, str, i);
        this.jlH = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.jlH != null) {
            this.jlH.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jlG = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.jlI != null) {
            this.jlI.h(i, i2, str);
        }
    }

    private void cpy() {
        if (this.jlI != null) {
            this.jlI.bMC();
        }
    }
}
