package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.widget.p {
    final /* synthetic */ p bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bJX = pVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void q(String str, boolean z) {
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
            shareSDKImageView = this.bJX.bJS;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.bJX.bJS;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    p pVar = this.bJX;
                    shareSDKImageView3 = this.bJX.bJS;
                    pVar.width = shareSDKImageView3.getLoadedWidth();
                    p pVar2 = this.bJX;
                    shareSDKImageView4 = this.bJX.bJS;
                    pVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.bJX.bJV;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.bJX.bJV;
                        WriteData EE = writeShareActivity4.EE();
                        i = this.bJX.width;
                        EE.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.bJX.bJV;
                        WriteData EE2 = writeShareActivity5.EE();
                        i2 = this.bJX.height;
                        EE2.setShareSummaryImgHeight(i2);
                        this.bJX.bJW = true;
                        this.bJX.acl();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bJX.bJW = false;
        this.bJX.acl();
        writeShareActivity = this.bJX.bJV;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.bJX.bJV;
            writeShareActivity2.ace();
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        this.bJX.bJW = false;
        this.bJX.acl();
        writeShareActivity = this.bJX.bJV;
        writeShareActivity.ace();
    }
}
