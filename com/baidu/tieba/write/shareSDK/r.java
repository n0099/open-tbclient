package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.n {
    final /* synthetic */ q cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cwf = qVar;
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
            shareSDKImageView = this.cwf.cwa;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.cwf.cwa;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.cwf;
                    shareSDKImageView3 = this.cwf.cwa;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.cwf;
                    shareSDKImageView4 = this.cwf.cwa;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.cwf.cwd;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.cwf.cwd;
                        WriteData IM = writeShareActivity4.IM();
                        i = this.cwf.width;
                        IM.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.cwf.cwd;
                        WriteData IM2 = writeShareActivity5.IM();
                        i2 = this.cwf.height;
                        IM2.setShareSummaryImgHeight(i2);
                        this.cwf.cwe = true;
                        this.cwf.aqA();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cwf.cwe = false;
        this.cwf.aqA();
        writeShareActivity = this.cwf.cwd;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cwf.cwd;
            writeShareActivity2.iU(com.baidu.tieba.y.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.cwf.cwe = false;
        this.cwf.aqA();
        writeShareActivity = this.cwf.cwd;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cwf.cwd;
            writeShareActivity2.iU(com.baidu.tieba.y.share_load_image_fail_tip);
        }
    }
}
