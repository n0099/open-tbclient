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
    private long jik;
    private String jil;
    private final int jim;
    private int jin;
    private e jio;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a jip;
    private h jiq;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.jim = i;
        this.jiq = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.jik = file.length();
            this.jil = s.h(m.z(file));
            if (this.jik % this.jim == 0) {
                this.jin = (int) (this.jik / this.jim);
            } else {
                this.jin = ((int) (this.jik / this.jim)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult bp(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.jik <= 0 || StringUtils.isNull(this.jil) || i <= 0 || this.mCancelled) {
            return null;
        }
        Br(10);
        a b2 = b(this.jin, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.mErrorNo != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.mErrorNo);
            videoFinishResult.setUserMessage(b2.bsY);
            j(302, b2.mErrorNo, b2.bsY);
            return videoFinishResult;
        }
        Br(30);
        if (!StringUtils.isNull(b2.bWb)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.jil);
            videoFinishResult2.setVideoUrl(b2.bWb);
            cqv();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.jif;
            if (v.aa(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.jin; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.jig;
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
            Br(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.jil);
                cqv();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.jin, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.mErrorNo == 0) {
                    videoFinishResult5.setVideoUrl(b.bWb);
                    videoFinishResult5.setVideoMd5(this.jil);
                    cqv();
                } else {
                    videoFinishResult5.setErrorNo(b.mErrorNo);
                    videoFinishResult5.setUserMessage(b.bsY);
                    j(304, b.mErrorNo, b.bsY);
                    TiebaStatic.log(new an("c12024").bT("params", b.bsY));
                }
                Br(100);
                return videoFinishResult5;
            }
        }
    }

    private void Br(int i) {
        if (this.jio != null) {
            this.jio.aR(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.o("chunk_sum", String.valueOf(i));
        xVar.o("video_size", String.valueOf(this.jik));
        xVar.o("chunk_size", String.valueOf(this.jim));
        xVar.o("is_merge", String.valueOf(z ? 1 : 0));
        xVar.o("video_md5", this.jil);
        xVar.o("video_len", String.valueOf(j));
        xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.o("upload_id", str);
        }
        String aig = xVar.aig();
        if (xVar.aiE().ajF().isRequestSuccess()) {
            if (StringUtils.isNull(aig)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(aig);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.aiE().ajF().aiH()) {
            aVar2.mErrorNo = xVar.aiE().ajF().bUI;
        } else {
            aVar2.mErrorNo = xVar.aiE().ajF().AR;
        }
        aVar2.bsY = xVar.aiE().ajF().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.aa(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.jip = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.jim, this.jin, this.jik, this.jil);
        } else {
            this.jip = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.jim, this.jin, this.jik, this.jil);
        }
        this.jip.a(this.jio);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.jip.b(arrayList, str, i);
        this.jip = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.jip != null) {
            this.jip.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.jio = eVar;
    }

    private void j(int i, int i2, String str) {
        if (this.jiq != null) {
            this.jiq.h(i, i2, str);
        }
    }

    private void cqv() {
        if (this.jiq != null) {
            this.jiq.bOB();
        }
    }
}
