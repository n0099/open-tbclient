package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o dmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.dmR = oVar;
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
            shareSDKImageView = this.dmR.dmL;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.dmR.dmL;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.dmR;
                    shareSDKImageView3 = this.dmR.dmL;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.dmR;
                    shareSDKImageView4 = this.dmR.dmL;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.dmR.dmO;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.dmR.dmO;
                        WriteData axK = writeShareActivity4.axK();
                        i = this.dmR.width;
                        axK.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.dmR.dmO;
                        WriteData axK2 = writeShareActivity5.axK();
                        i2 = this.dmR.height;
                        axK2.setShareSummaryImgHeight(i2);
                        this.dmR.dmQ = true;
                        this.dmR.aCf();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dmR.dmQ = false;
        this.dmR.aCf();
        writeShareActivity = this.dmR.dmO;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dmR.dmO;
            writeShareActivity2.lQ(i.h.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.dmR.dmQ = false;
        this.dmR.aCf();
        writeShareActivity = this.dmR.dmO;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dmR.dmO;
            writeShareActivity2.lQ(i.h.share_load_image_fail_tip);
        }
    }
}
