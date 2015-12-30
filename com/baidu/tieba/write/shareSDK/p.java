package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o dVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.dVe = oVar;
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
            shareSDKImageView = this.dVe.dUY;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.dVe.dUY;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.dVe;
                    shareSDKImageView3 = this.dVe.dUY;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.dVe;
                    shareSDKImageView4 = this.dVe.dUY;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.dVe.dVb;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.dVe.dVb;
                        WriteData aGz = writeShareActivity4.aGz();
                        i = this.dVe.width;
                        aGz.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.dVe.dVb;
                        WriteData aGz2 = writeShareActivity5.aGz();
                        i2 = this.dVe.height;
                        aGz2.setShareSummaryImgHeight(i2);
                        this.dVe.dVd = true;
                        this.dVe.aKN();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dVe.dVd = false;
        this.dVe.aKN();
        writeShareActivity = this.dVe.dVb;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dVe.dVb;
            writeShareActivity2.oi(n.j.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.dVe.dVd = false;
        this.dVe.aKN();
        writeShareActivity = this.dVe.dVb;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dVe.dVb;
            writeShareActivity2.oi(n.j.share_load_image_fail_tip);
        }
    }
}
