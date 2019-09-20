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
    private long jlM;
    private String jlN;
    private final int jlO;
    private int jlP;
    private e jlQ;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a jlR;
    private h jlS;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.jlO = i;
        this.jlS = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.jlM = file.length();
            this.jlN = s.h(m.z(file));
            if (this.jlM % this.jlO == 0) {
                this.jlP = (int) (this.jlM / this.jlO);
            } else {
                this.jlP = ((int) (this.jlM / this.jlO)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult br(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.jlM <= 0 || StringUtils.isNull(this.jlN) || i <= 0 || this.mCancelled) {
            return null;
        }
        Bx(10);
        a b2 = b(this.jlP, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.mErrorNo);
            videoFinishResult.setUserMessage(b2.btw);
            j(302, b2.mErrorNo, b2.btw);
            return videoFinishResult;
        }
        Bx(30);
        if (!StringUtils.isNull(b2.bXa)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.jlN);
            videoFinishResult2.setVideoUrl(b2.bXa);
            crF();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.jlH;
            if (v.aa(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.jlP; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.jlI;
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
            Bx(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.jlN);
                crF();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.jlP, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(b.bXa);
                    videoFinishResult5.setVideoMd5(this.jlN);
                    crF();
                } else {
                    videoFinishResult5.setErrorNo(b.mErrorNo);
                    videoFinishResult5.setUserMessage(b.btw);
                    j(304, b.mErrorNo, b.btw);
                    TiebaStatic.log(new an("c12024").bT("params", b.btw));
                }
                Bx(100);
                return videoFinishResult5;
            }
        }
    }

    private void Bx(int i) {
        if (this.jlQ != null) {
            this.jlQ.aS(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.o("chunk_sum", String.valueOf(i));
        xVar.o("video_size", String.valueOf(this.jlM));
        xVar.o("chunk_size", String.valueOf(this.jlO));
        xVar.o("is_merge", String.valueOf(z ? 1 : 0));
        xVar.o("video_md5", this.jlN);
        xVar.o("video_len", String.valueOf(j));
        xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.o("upload_id", str);
        }
        String aim = xVar.aim();
        if (xVar.aiK().ajN().isRequestSuccess()) {
            if (StringUtils.isNull(aim)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(aim);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aiK().ajN().aiN()) {
            aVar2.mErrorNo = xVar.aiK().ajN().bVr;
        } else {
            aVar2.mErrorNo = xVar.aiK().ajN().AR;
        }
        aVar2.btw = xVar.aiK().ajN().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.aa(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.jlR = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.jlO, this.jlP, this.jlM, this.jlN);
        } else {
            this.jlR = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.jlO, this.jlP, this.jlM, this.jlN);
        }
        this.jlR.a(this.jlQ);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.jlR.b(arrayList, str, i);
        this.jlR = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.jlR != null) {
            this.jlR.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jlQ = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.jlS != null) {
            this.jlS.h(i, i2, str);
        }
    }

    private void crF() {
        if (this.jlS != null) {
            this.jlS.bPC();
        }
    }
}
