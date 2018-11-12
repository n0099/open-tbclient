package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private String WW;
    private long hhs;
    private final int hht;
    private int hhu;
    private e hhv;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a hhw;
    private h hhx;
    private boolean mCancelled;
    private String mFileName;

    public d(String str, int i, h hVar) {
        this.mFileName = str;
        this.hht = i;
        this.hhx = hVar;
        File file = new File(str);
        if (file.exists()) {
            this.hhs = file.length();
            this.WW = s.i(l.w(file));
            if (this.hhs % this.hht == 0) {
                this.hhu = (int) (this.hhs / this.hht);
            } else {
                this.hhu = ((int) (this.hhs / this.hht)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult aU(String str, int i) {
        a b;
        if (StringUtils.isNull(str) || this.hhs <= 0 || StringUtils.isNull(this.WW) || i <= 0 || this.mCancelled) {
            return null;
        }
        vm(10);
        a b2 = b(this.hhu, i, false, null);
        if (b2 == null || this.mCancelled) {
            return null;
        }
        if (b2.dID != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(b2.dID);
            videoFinishResult.setUserMessage(b2.mErrorMessage);
            h(302, b2.dID, b2.mErrorMessage);
            return videoFinishResult;
        }
        vm(30);
        if (!StringUtils.isNull(b2.aBn)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.WW);
            videoFinishResult2.setVideoUrl(b2.aBn);
            bCC();
            return videoFinishResult2;
        } else if (this.mCancelled) {
            return null;
        } else {
            ArrayList<Integer> arrayList = b2.hhn;
            if (v.I(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.hhu; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = b2.hho;
            com.baidu.tieba.tbadkCore.videoupload.a.a.d b3 = b(arrayList, str2, i);
            if (b3 == null || this.mCancelled) {
                return null;
            }
            if (b3.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b3.errorNo);
                videoFinishResult3.setUserMessage(b3.errorMessage);
                h(303, b3.errorNo, b3.errorMessage);
                return videoFinishResult3;
            }
            vm(85);
            if (!StringUtils.isNull(b3.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b3.videoUrl);
                videoFinishResult4.setVideoMd5(this.WW);
                bCC();
                return videoFinishResult4;
            } else if (this.mCancelled || (b = b(this.hhu, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (b.dID == 0) {
                    videoFinishResult5.setVideoUrl(b.aBn);
                    videoFinishResult5.setVideoMd5(this.WW);
                    bCC();
                } else {
                    videoFinishResult5.setErrorNo(b.dID);
                    videoFinishResult5.setUserMessage(b.mErrorMessage);
                    h(304, b.dID, b.mErrorMessage);
                    TiebaStatic.log(new am("c12024").ax("params", b.mErrorMessage));
                }
                vm(100);
                return videoFinishResult5;
            }
        }
    }

    private void vm(int i) {
        if (this.hhv != null) {
            this.hhv.az(i / 100.0f);
        }
    }

    private a b(int i, long j, boolean z, String str) {
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
        xVar.x("chunk_sum", String.valueOf(i));
        xVar.x("video_size", String.valueOf(this.hhs));
        xVar.x("chunk_size", String.valueOf(this.hht));
        xVar.x("is_merge", String.valueOf(z ? 1 : 0));
        xVar.x("video_md5", this.WW);
        xVar.x("video_len", String.valueOf(j));
        xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            xVar.x("upload_id", str);
        }
        String BH = xVar.BH();
        if (xVar.Cf().De().isRequestSuccess()) {
            if (StringUtils.isNull(BH)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(BH);
            return aVar;
        }
        a aVar2 = new a();
        if (xVar.Cf().De().Ci()) {
            aVar2.dID = xVar.Cf().De().azT;
        } else {
            aVar2.dID = xVar.Cf().De().De;
        }
        aVar2.mErrorMessage = xVar.Cf().De().mErrorString;
        return aVar2;
    }

    private com.baidu.tieba.tbadkCore.videoupload.a.a.d b(ArrayList<Integer> arrayList, String str, int i) {
        if (v.I(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.hhw = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.hht, this.hhu, this.hhs, this.WW);
        } else {
            this.hhw = new com.baidu.tieba.tbadkCore.videoupload.a.a.c(this.mFileName, this.hht, this.hhu, this.hhs, this.WW);
        }
        this.hhw.a(this.hhv);
        com.baidu.tieba.tbadkCore.videoupload.a.a.d b = this.hhw.b(arrayList, str, i);
        this.hhw = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.mCancelled = true;
        if (this.hhw != null) {
            this.hhw.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.hhv = eVar;
    }

    private void h(int i, int i2, String str) {
        if (this.hhx != null) {
            this.hhx.e(i, i2, str);
        }
    }

    private void bCC() {
        if (this.hhx != null) {
            this.hhx.baA();
        }
    }
}
