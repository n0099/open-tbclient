package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.p {
    final /* synthetic */ q bPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bPX = qVar;
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
            shareSDKImageView = this.bPX.bPS;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.bPX.bPS;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.bPX;
                    shareSDKImageView3 = this.bPX.bPS;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.bPX;
                    shareSDKImageView4 = this.bPX.bPS;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.bPX.bPV;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.bPX.bPV;
                        WriteData Ft = writeShareActivity4.Ft();
                        i = this.bPX.width;
                        Ft.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.bPX.bPV;
                        WriteData Ft2 = writeShareActivity5.Ft();
                        i2 = this.bPX.height;
                        Ft2.setShareSummaryImgHeight(i2);
                        this.bPX.bPW = true;
                        this.bPX.adk();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bPX.bPW = false;
        this.bPX.adk();
        writeShareActivity = this.bPX.bPV;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.bPX.bPV;
            writeShareActivity2.add();
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        this.bPX.bPW = false;
        this.bPX.adk();
        writeShareActivity = this.bPX.bPV;
        writeShareActivity.add();
    }
}
