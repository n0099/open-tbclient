package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.p {
    final /* synthetic */ q bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bOn = qVar;
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
            shareSDKImageView = this.bOn.bOi;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.bOn.bOi;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.bOn;
                    shareSDKImageView3 = this.bOn.bOi;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.bOn;
                    shareSDKImageView4 = this.bOn.bOi;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.bOn.bOl;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.bOn.bOl;
                        WriteData EV = writeShareActivity4.EV();
                        i = this.bOn.width;
                        EV.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.bOn.bOl;
                        WriteData EV2 = writeShareActivity5.EV();
                        i2 = this.bOn.height;
                        EV2.setShareSummaryImgHeight(i2);
                        this.bOn.bOm = true;
                        this.bOn.acG();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bOn.bOm = false;
        this.bOn.acG();
        writeShareActivity = this.bOn.bOl;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.bOn.bOl;
            writeShareActivity2.acz();
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        this.bOn.bOm = false;
        this.bOn.acG();
        writeShareActivity = this.bOn.bOl;
        writeShareActivity.acz();
    }
}
