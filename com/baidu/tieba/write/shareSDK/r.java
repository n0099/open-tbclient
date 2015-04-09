package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.n {
    final /* synthetic */ q cwv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cwv = qVar;
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
            shareSDKImageView = this.cwv.cwq;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.cwv.cwq;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.cwv;
                    shareSDKImageView3 = this.cwv.cwq;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.cwv;
                    shareSDKImageView4 = this.cwv.cwq;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.cwv.cwt;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.cwv.cwt;
                        WriteData IS = writeShareActivity4.IS();
                        i = this.cwv.width;
                        IS.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.cwv.cwt;
                        WriteData IS2 = writeShareActivity5.IS();
                        i2 = this.cwv.height;
                        IS2.setShareSummaryImgHeight(i2);
                        this.cwv.cwu = true;
                        this.cwv.aqP();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cwv.cwu = false;
        this.cwv.aqP();
        writeShareActivity = this.cwv.cwt;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cwv.cwt;
            writeShareActivity2.iX(com.baidu.tieba.y.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.cwv.cwu = false;
        this.cwv.aqP();
        writeShareActivity = this.cwv.cwt;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cwv.cwt;
            writeShareActivity2.iX(com.baidu.tieba.y.share_load_image_fail_tip);
        }
    }
}
