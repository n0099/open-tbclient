package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o dmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.dmr = oVar;
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
            shareSDKImageView = this.dmr.dml;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.dmr.dml;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.dmr;
                    shareSDKImageView3 = this.dmr.dml;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.dmr;
                    shareSDKImageView4 = this.dmr.dml;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.dmr.dmo;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.dmr.dmo;
                        WriteData axE = writeShareActivity4.axE();
                        i = this.dmr.width;
                        axE.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.dmr.dmo;
                        WriteData axE2 = writeShareActivity5.axE();
                        i2 = this.dmr.height;
                        axE2.setShareSummaryImgHeight(i2);
                        this.dmr.dmq = true;
                        this.dmr.aBZ();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dmr.dmq = false;
        this.dmr.aBZ();
        writeShareActivity = this.dmr.dmo;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dmr.dmo;
            writeShareActivity2.lO(i.h.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.dmr.dmq = false;
        this.dmr.aBZ();
        writeShareActivity = this.dmr.dmo;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dmr.dmo;
            writeShareActivity2.lO(i.h.share_load_image_fail_tip);
        }
    }
}
