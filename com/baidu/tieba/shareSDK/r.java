package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.p {
    final /* synthetic */ q bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bPW = qVar;
    }

    @Override // com.baidu.tbadk.widget.p
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
            shareSDKImageView = this.bPW.bPR;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.bPW.bPR;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.bPW;
                    shareSDKImageView3 = this.bPW.bPR;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.bPW;
                    shareSDKImageView4 = this.bPW.bPR;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.bPW.bPU;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.bPW.bPU;
                        WriteData Fn = writeShareActivity4.Fn();
                        i = this.bPW.width;
                        Fn.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.bPW.bPU;
                        WriteData Fn2 = writeShareActivity5.Fn();
                        i2 = this.bPW.height;
                        Fn2.setShareSummaryImgHeight(i2);
                        this.bPW.bPV = true;
                        this.bPW.adf();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bPW.bPV = false;
        this.bPW.adf();
        writeShareActivity = this.bPW.bPU;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.bPW.bPU;
            writeShareActivity2.acY();
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        this.bPW.bPV = false;
        this.bPW.adf();
        writeShareActivity = this.bPW.bPU;
        writeShareActivity.acY();
    }
}
