package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.File;
/* loaded from: classes.dex */
public class c implements b {
    private a dJp;

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult d(String str, File file) {
        String f = t.f(n.o(file));
        if (f != null && f.length() > 0) {
            f = f.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.c mG = com.baidu.tieba.tbadkCore.videoupload.b.mG(f);
        if (mG == null) {
            mG = new com.baidu.tbadk.coreExtra.data.c();
            mG.dW(f);
            mG.dc(0);
            mG.G(file.length());
        }
        this.dJp = new a();
        com.baidu.tieba.tbadkCore.videoupload.c b = this.dJp.b(str, mG);
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        if (b.isSuccess()) {
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_FINISH_ADDRESS);
            abVar.o("total_num", String.valueOf(b.aGt()));
            abVar.o("video_md5", f);
            String tV = abVar.tV();
            if (abVar.uw().vq().qO()) {
                videoFinishResult.parseJson(tV);
                boolean isSuccess = videoFinishResult.isSuccess();
                if (isSuccess || videoFinishResult.getErrorNo() == 320033) {
                    com.baidu.tieba.tbadkCore.videoupload.b.mF(f);
                }
                videoFinishResult.setSuccess(isSuccess);
                if (!isSuccess) {
                    videoFinishResult.setErrorNo(videoFinishResult.getErrorNo());
                    videoFinishResult.setUserMessage(videoFinishResult.getUserMessage());
                }
            } else {
                videoFinishResult.setErrorNo(abVar.uA());
                videoFinishResult.setUserMessage(abVar.getErrorString());
                videoFinishResult.setSuccess(false);
            }
        } else {
            videoFinishResult.setUserMessage(b.getErrorMessage());
            videoFinishResult.setErrorNo(b.getErrorNo());
            videoFinishResult.setSuccess(false);
        }
        return videoFinishResult;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        if (this.dJp != null) {
            this.dJp.cancel();
        }
    }
}
