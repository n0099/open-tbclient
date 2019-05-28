package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long jbN;
    private String jbO;
    private final int jbP;
    private int jbQ;
    private e jbR;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a jbS;
    private h jbT;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.jbP = i;
        this.jbT = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.jbN = file.length();
            this.jbO = s.h(m.z(file));
            if (this.jbN % this.jbP == 0) {
                this.jbQ = (int) (this.jbN / this.jbP);
            } else {
                this.jbQ = ((int) (this.jbN / this.jbP)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bo(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.jbN <= 0 || StringUtils.isNull(this.jbO) || i <= 0 || this.mCancelled) {
            return null;
        }
        AL(10);
        a b2 = b(this.jbQ, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.mErrorNo);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            j(302, b2.mErrorNo, b2.mErrorMessage);
            return videoFinishResult;
        }
        AL(30);
        if (!StringUtils.isNull(b2.bUZ)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.jbO);
            videoFinishResult2.setVideoUrl(b2.bUZ);
            cnB();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.jbI;
            if (v.aa(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.jbQ; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.jbJ;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                j(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            AL(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.jbO);
                cnB();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.jbQ, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(b.bUZ);
                    videoFinishResult5.setVideoMd5(this.jbO);
                    cnB();
                } else {
                    videoFinishResult5.setErrorNo(b.mErrorNo);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    j(304, b.mErrorNo, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").bT("params", b.mErrorMessage));
                }
                AL(100);
                return videoFinishResult5;
            }
        }
    }

    private void AL(int i) {
        if (this.jbR != null) {
            this.jbR.aQ(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.o("chunk_sum", String.valueOf(i));
        xVar.o("video_size", String.valueOf(this.jbN));
        xVar.o("chunk_size", String.valueOf(this.jbP));
        xVar.o("is_merge", String.valueOf(z ? 1 : 0));
        xVar.o("video_md5", this.jbO);
        xVar.o("video_len", String.valueOf(j));
        xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.o("upload_id", str);
        }
        String ahe = xVar.ahe();
        if (xVar.ahC().aiC().isRequestSuccess()) {
            if (StringUtils.isNull(ahe)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(ahe);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.ahC().aiC().ahF()) {
            aVar2.mErrorNo = xVar.ahC().aiC().bTG;
        } else {
            aVar2.mErrorNo = xVar.ahC().aiC().AM;
        }
        aVar2.mErrorMessage = xVar.ahC().aiC().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.aa(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.jbS = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.jbP, this.jbQ, this.jbN, this.jbO);
        } else {
            this.jbS = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.jbP, this.jbQ, this.jbN, this.jbO);
        }
        this.jbS.a(this.jbR);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.jbS.b(arrayList, str, i);
        this.jbS = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.jbS != null) {
            this.jbS.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jbR = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.jbT != null) {
            this.jbT.h(i, i2, str);
        }
    }

    private void cnB() {
        if (this.jbT != null) {
            this.jbT.bLS();
        }
    }
}
