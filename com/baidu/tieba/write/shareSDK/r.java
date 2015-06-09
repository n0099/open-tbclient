package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.n {
    final /* synthetic */ q cAM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cAM = qVar;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        ShareSDKImageView shareSDKImageView;
        ShareSDKImageView shareSDKImageView2;
        ShareSDKImageView shareSDKImageView3;
        ShareSDKImageView shareSDKImageView4;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        int i;
        WriteShareActivity writeShareActivity5;
        int i2;
        if (z) {
            shareSDKImageView = this.cAM.cAH;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.cAM.cAH;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.cAM;
                    shareSDKImageView3 = this.cAM.cAH;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.cAM;
                    shareSDKImageView4 = this.cAM.cAH;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.cAM.cAK;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.cAM.cAK;
                        WriteData JT = writeShareActivity4.JT();
                        i = this.cAM.width;
                        JT.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.cAM.cAK;
                        WriteData JT2 = writeShareActivity5.JT();
                        i2 = this.cAM.height;
                        JT2.setShareSummaryImgHeight(i2);
                        this.cAM.cAL = true;
                        this.cAM.asG();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cAM.cAL = false;
        this.cAM.asG();
        writeShareActivity = this.cAM.cAK;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cAM.cAK;
            writeShareActivity2.jt(com.baidu.tieba.t.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.cAM.cAL = false;
        this.cAM.asG();
        writeShareActivity = this.cAM.cAK;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cAM.cAK;
            writeShareActivity2.jt(com.baidu.tieba.t.share_load_image_fail_tip);
        }
    }
}
