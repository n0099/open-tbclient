package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cSC = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
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
            shareSDKImageView = this.cSC.cSw;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.cSC.cSw;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.cSC;
                    shareSDKImageView3 = this.cSC.cSw;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.cSC;
                    shareSDKImageView4 = this.cSC.cSw;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.cSC.cSz;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.cSC.cSz;
                        WriteData ard = writeShareActivity4.ard();
                        i = this.cSC.width;
                        ard.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.cSC.cSz;
                        WriteData ard2 = writeShareActivity5.ard();
                        i2 = this.cSC.height;
                        ard2.setShareSummaryImgHeight(i2);
                        this.cSC.cSB = true;
                        this.cSC.auw();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cSC.cSB = false;
        this.cSC.auw();
        writeShareActivity = this.cSC.cSz;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cSC.cSz;
            writeShareActivity2.ko(i.C0057i.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.cSC.cSB = false;
        this.cSC.auw();
        writeShareActivity = this.cSC.cSz;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cSC.cSz;
            writeShareActivity2.ko(i.C0057i.share_load_image_fail_tip);
        }
    }
}
