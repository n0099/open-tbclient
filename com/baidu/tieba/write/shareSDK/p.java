package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.doz = oVar;
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
            shareSDKImageView = this.doz.dot;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.doz.dot;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.doz;
                    shareSDKImageView3 = this.doz.dot;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.doz;
                    shareSDKImageView4 = this.doz.dot;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.doz.dow;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.doz.dow;
                        WriteData ayT = writeShareActivity4.ayT();
                        i = this.doz.width;
                        ayT.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.doz.dow;
                        WriteData ayT2 = writeShareActivity5.ayT();
                        i2 = this.doz.height;
                        ayT2.setShareSummaryImgHeight(i2);
                        this.doz.doy = true;
                        this.doz.aCV();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.doz.doy = false;
        this.doz.aCV();
        writeShareActivity = this.doz.dow;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.doz.dow;
            writeShareActivity2.me(i.h.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.doz.doy = false;
        this.doz.aCV();
        writeShareActivity = this.doz.dow;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.doz.dow;
            writeShareActivity2.me(i.h.share_load_image_fail_tip);
        }
    }
}
