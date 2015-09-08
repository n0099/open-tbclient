package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.dbp = oVar;
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
            shareSDKImageView = this.dbp.dbj;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.dbp.dbj;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.dbp;
                    shareSDKImageView3 = this.dbp.dbj;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.dbp;
                    shareSDKImageView4 = this.dbp.dbj;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.dbp.dbm;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.dbp.dbm;
                        WriteData avr = writeShareActivity4.avr();
                        i = this.dbp.width;
                        avr.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.dbp.dbm;
                        WriteData avr2 = writeShareActivity5.avr();
                        i2 = this.dbp.height;
                        avr2.setShareSummaryImgHeight(i2);
                        this.dbp.dbo = true;
                        this.dbp.ayQ();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dbp.dbo = false;
        this.dbp.ayQ();
        writeShareActivity = this.dbp.dbm;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dbp.dbm;
            writeShareActivity2.kZ(i.h.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.dbp.dbo = false;
        this.dbp.ayQ();
        writeShareActivity = this.dbp.dbm;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dbp.dbm;
            writeShareActivity2.kZ(i.h.share_load_image_fail_tip);
        }
    }
}
