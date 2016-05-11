package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.faw = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
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
            shareSDKImageView = this.faw.faq;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.faw.faq;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.faw;
                    shareSDKImageView3 = this.faw.faq;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.faw;
                    shareSDKImageView4 = this.faw.faq;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.faw.fat;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.faw.fat;
                        WriteData aVa = writeShareActivity4.aVa();
                        i = this.faw.width;
                        aVa.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.faw.fat;
                        WriteData aVa2 = writeShareActivity5.aVa();
                        i2 = this.faw.height;
                        aVa2.setShareSummaryImgHeight(i2);
                        this.faw.fav = true;
                        this.faw.bcj();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.faw.fav = false;
        this.faw.bcj();
        writeShareActivity = this.faw.fat;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.faw.fat;
            writeShareActivity2.qS(t.j.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.faw.fav = false;
        this.faw.bcj();
        writeShareActivity = this.faw.fat;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.faw.fat;
            writeShareActivity2.qS(t.j.share_load_image_fail_tip);
        }
    }
}
