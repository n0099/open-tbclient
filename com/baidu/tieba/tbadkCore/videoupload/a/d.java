package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.a.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements b {
    private long fwX;
    private String fwY;
    private final int fwZ;
    private int fxa;
    private e fxb;
    private boolean fxc;
    private com.baidu.tieba.tbadkCore.videoupload.a.a.a fxd;
    private String mFileName;

    public d(String str, int i) {
        this.mFileName = str;
        this.fwZ = i;
        File file = new File(str);
        if (file.exists()) {
            this.fwX = file.length();
            this.fwY = t.k(l.o(file));
            if (this.fwX % this.fwZ == 0) {
                this.fxa = (int) (this.fwX / this.fwZ);
            } else {
                this.fxa = ((int) (this.fwX / this.fwZ)) + 1;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult ay(String str, int i) {
        a a;
        if (StringUtils.isNull(str) || this.fwX <= 0 || StringUtils.isNull(this.fwY) || i <= 0 || this.fxc) {
            return null;
        }
        sc(10);
        a a2 = a(this.fxa, i, false, null);
        if (a2 == null || this.fxc) {
            return null;
        }
        if (a2.fwT != 0) {
            VideoFinishResult videoFinishResult = new VideoFinishResult();
            videoFinishResult.setErrorNo(a2.fwT);
            videoFinishResult.setUserMessage(a2.mErrorMessage);
            return videoFinishResult;
        }
        sc(30);
        if (!StringUtils.isNull(a2.mVideoUrl)) {
            VideoFinishResult videoFinishResult2 = new VideoFinishResult();
            videoFinishResult2.setVideoMd5(this.fwY);
            videoFinishResult2.setVideoUrl(a2.mVideoUrl);
            return videoFinishResult2;
        } else if (this.fxc) {
            return null;
        } else {
            ArrayList<Integer> arrayList = a2.fwR;
            if (x.r(arrayList)) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.fxa; i2++) {
                    arrayList.add(Integer.valueOf(i2 + 1));
                }
            }
            String str2 = a2.fwS;
            f b = b(arrayList, str2, i);
            if (b == null || this.fxc) {
                return null;
            }
            if (b.errorNo != 0) {
                VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                videoFinishResult3.setErrorNo(b.errorNo);
                videoFinishResult3.setUserMessage(b.errorMessage);
                return videoFinishResult3;
            }
            sc(85);
            if (!StringUtils.isNull(b.videoUrl)) {
                VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                videoFinishResult4.setVideoUrl(b.videoUrl);
                videoFinishResult4.setVideoMd5(this.fwY);
                return videoFinishResult4;
            } else if (this.fxc || (a = a(this.fxa, i, true, str2)) == null) {
                return null;
            } else {
                VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                if (a.fwT == 0) {
                    videoFinishResult5.setVideoUrl(a.mVideoUrl);
                    videoFinishResult5.setVideoMd5(this.fwY);
                } else {
                    videoFinishResult5.setErrorNo(a.fwT);
                    videoFinishResult5.setUserMessage(a.mErrorMessage);
                    TiebaStatic.log(new as("c12024").aa(LegoListActivityConfig.PARAMS, a.mErrorMessage));
                }
                sc(100);
                return videoFinishResult5;
            }
        }
    }

    private void sc(int i) {
        if (this.fxb != null) {
            this.fxb.ac(i / 100.0f);
        }
    }

    private a a(int i, long j, boolean z, String str) {
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_CHECK_VIDEO_STATUS);
        zVar.n("chunk_sum", String.valueOf(i));
        zVar.n("video_size", String.valueOf(this.fwX));
        zVar.n("chunk_size", String.valueOf(this.fwZ));
        zVar.n("is_merge", String.valueOf(z ? 1 : 0));
        zVar.n("video_md5", this.fwY);
        zVar.n("video_len", String.valueOf(j));
        zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (!StringUtils.isNull(str)) {
            zVar.n("upload_id", str);
        }
        String ul = zVar.ul();
        if (zVar.uJ().vE().isRequestSuccess()) {
            if (StringUtils.isNull(ul)) {
                return null;
            }
            a aVar = new a();
            aVar.parseJson(ul);
            return aVar;
        }
        a aVar2 = new a();
        if (zVar.uJ().vE().uM()) {
            aVar2.fwT = zVar.uJ().vE().agD;
        } else {
            aVar2.fwT = zVar.uJ().vE().vR;
        }
        aVar2.mErrorMessage = zVar.uJ().vE().mErrorString;
        return aVar2;
    }

    private f b(ArrayList<Integer> arrayList, String str, int i) {
        if (x.r(arrayList) || StringUtils.isNull(str)) {
            return null;
        }
        if (arrayList.size() > 3) {
            this.fxd = new com.baidu.tieba.tbadkCore.videoupload.a.a.b(this.mFileName, this.fwZ, this.fxa, this.fwX, this.fwY);
        } else {
            this.fxd = new com.baidu.tieba.tbadkCore.videoupload.a.a.e(this.mFileName, this.fwZ, this.fxa, this.fwX, this.fwY);
        }
        this.fxd.a(this.fxb);
        f b = this.fxd.b(arrayList, str, i);
        this.fxd = null;
        return b;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.fxc = true;
        if (this.fxd != null) {
            this.fxd.cancel();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void a(e eVar) {
        this.fxb = eVar;
    }
}
