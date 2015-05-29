package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.widget.n {
    final /* synthetic */ q cAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cAL = qVar;
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
            shareSDKImageView = this.cAL.cAG;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.cAL.cAG;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    q qVar = this.cAL;
                    shareSDKImageView3 = this.cAL.cAG;
                    qVar.width = shareSDKImageView3.getLoadedWidth();
                    q qVar2 = this.cAL;
                    shareSDKImageView4 = this.cAL.cAG;
                    qVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.cAL.cAJ;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.cAL.cAJ;
                        WriteData JS = writeShareActivity4.JS();
                        i = this.cAL.width;
                        JS.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.cAL.cAJ;
                        WriteData JS2 = writeShareActivity5.JS();
                        i2 = this.cAL.height;
                        JS2.setShareSummaryImgHeight(i2);
                        this.cAL.cAK = true;
                        this.cAL.asF();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cAL.cAK = false;
        this.cAL.asF();
        writeShareActivity = this.cAL.cAJ;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cAL.cAJ;
            writeShareActivity2.jt(com.baidu.tieba.t.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.cAL.cAK = false;
        this.cAL.asF();
        writeShareActivity = this.cAL.cAJ;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.cAL.cAJ;
            writeShareActivity2.jt(com.baidu.tieba.t.share_load_image_fail_tip);
        }
    }
}
