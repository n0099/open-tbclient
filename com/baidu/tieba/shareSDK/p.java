package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.widget.p {
    final /* synthetic */ o bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bJI = oVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void q(String str, boolean z) {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        ShareSDKImageView shareSDKImageView;
        ShareSDKImageView shareSDKImageView2;
        ShareSDKImageView shareSDKImageView3;
        WriteShareActivity writeShareActivity3;
        WriteShareActivity writeShareActivity4;
        int i;
        WriteShareActivity writeShareActivity5;
        int i2;
        if (z) {
            shareSDKImageView = this.bJI.bJD;
            if (shareSDKImageView.getLoadedBdImage() != null) {
                o oVar = this.bJI;
                shareSDKImageView2 = this.bJI.bJD;
                oVar.width = shareSDKImageView2.getLoadedBdImage().getWidth();
                o oVar2 = this.bJI;
                shareSDKImageView3 = this.bJI.bJD;
                oVar2.height = shareSDKImageView3.getLoadedBdImage().getHeight();
                writeShareActivity3 = this.bJI.bJG;
                if (writeShareActivity3 != null) {
                    writeShareActivity4 = this.bJI.bJG;
                    WriteData EC = writeShareActivity4.EC();
                    i = this.bJI.width;
                    EC.setShareSummaryImgWidth(i);
                    writeShareActivity5 = this.bJI.bJG;
                    WriteData EC2 = writeShareActivity5.EC();
                    i2 = this.bJI.height;
                    EC2.setShareSummaryImgHeight(i2);
                    this.bJI.bJH = true;
                    this.bJI.aci();
                    return;
                }
                return;
            }
            return;
        }
        this.bJI.bJH = false;
        this.bJI.aci();
        writeShareActivity = this.bJI.bJG;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.bJI.bJG;
            writeShareActivity2.acb();
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        this.bJI.bJH = false;
        this.bJI.aci();
        writeShareActivity = this.bJI.bJG;
        writeShareActivity.acb();
    }
}
