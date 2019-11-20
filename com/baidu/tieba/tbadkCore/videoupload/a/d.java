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
    private long jkL;
    private String jkM;
    private final int jkN;
    private int jkO;
    private e jkP;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a jkQ;
    private h jkR;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.jkN = i;
        this.jkR = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.jkL = file.length();
            this.jkM = s.toMd5(m.GetStreamFromFile(file));
            if (this.jkL % this.jkN == 0) {
                this.jkO = (int) (this.jkL / this.jkN);
            } else {
                this.jkO = ((int) (this.jkL / this.jkN)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bm(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.jkL <= 0 || StringUtils.isNull(this.jkM) || i <= 0 || this.mCancelled) {
            return null;
        }
        notifyProgress(10);
        a a2 = a(this.jkO, i, false, null);
        if (a2 == null || this.mCancelled) {
            return null;
        }
        if (a2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.mErrorNo);
            videoFinishResult.setUserMessage(a2.bLq);
            j(302, a2.mErrorNo, a2.bLq);
            return videoFinishResult;
        }
        notifyProgress(30);
        if (!StringUtils.isNull(a2.cln)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.jkM);
            videoFinishResult2.setVideoUrl(a2.cln);
            cpw();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.jkG;
            if (v.isEmpty(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.jkO; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.jkH;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d c = c(arrayList, str2, i);
            if (c == null || this.mCancelled) {
                return null;
            }
            if (c.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(c.errorNo);
                videoFinishResult3.setUserMessage(c.errorMessage);
                j(303, c.errorNo, c.errorMessage);
                return videoFinishResult3;
            }
            notifyProgress(85);
            if (!StringUtils.isNull(c.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(c.videoUrl);
                videoFinishResult4.setVideoMd5(this.jkM);
                cpw();
                return videoFinishResult4;
            } else if (this.mCancelled || (a = a(this.jkO, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(a.cln);
                    videoFinishResult5.setVideoMd5(this.jkM);
                    cpw();
                } else {
                    videoFinishResult5.setErrorNo(a.mErrorNo);
                    videoFinishResult5.setUserMessage(a.bLq);
                    j(304, a.mErrorNo, a.bLq);
                    TiebaStatic.log(new an("c12024").bS("params", a.bLq));
                }
                notifyProgress(100);
                return videoFinishResult5;
            }
        }
    }

    private void notifyProgress(int i) {
        if (this.jkP != null) {
            this.jkP.av(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.addPostData("chunk_sum", String.valueOf(i));
        xVar.addPostData("video_size", String.valueOf(this.jkL));
        xVar.addPostData("chunk_size", String.valueOf(this.jkN));
        xVar.addPostData("is_merge", String.valueOf(z ? 1 : 0));
        xVar.addPostData("video_md5", this.jkM);
        xVar.addPostData("video_len", String.valueOf(j));
        xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.addPostData("upload_id", str);
        }
        String postNetData = xVar.postNetData();
        if (xVar.amp().amQ().isRequestSuccess()) {
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(postNetData);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.amp().amQ().isNetSuccess()) {
            aVar2.mErrorNo = xVar.amp().amQ().mServerErrorCode;
        } else {
            aVar2.mErrorNo = xVar.amp().amQ().mNetErrorCode;
        }
        aVar2.bLq = xVar.amp().amQ().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d c(ArrayList<Integer> arrayList, String str, int i) {
        if (v.isEmpty(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.jkQ = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.jkN, this.jkO, this.jkL, this.jkM);
        } else {
            this.jkQ = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.jkN, this.jkO, this.jkL, this.jkM);
        }
        this.jkQ.a(this.jkP);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d c = this.jkQ.c(arrayList, str, i);
        this.jkQ = null;
        return c;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.jkQ != null) {
            this.jkQ.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jkP = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.jkR != null) {
            this.jkR.h(i, i2, str);
        }
    }

    private void cpw() {
        if (this.jkR != null) {
            this.jkR.bMA();
        }
    }
}
