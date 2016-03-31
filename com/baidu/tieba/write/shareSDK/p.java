package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o eJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.eJF = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
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
            shareSDKImageView = this.eJF.eJz;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.eJF.eJz;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.eJF;
                    shareSDKImageView3 = this.eJF.eJz;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.eJF;
                    shareSDKImageView4 = this.eJF.eJz;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.eJF.eJC;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.eJF.eJC;
                        WriteData aUF = writeShareActivity4.aUF();
                        i = this.eJF.width;
                        aUF.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.eJF.eJC;
                        WriteData aUF2 = writeShareActivity5.aUF();
                        i2 = this.eJF.height;
                        aUF2.setShareSummaryImgHeight(i2);
                        this.eJF.eJE = true;
                        this.eJF.aZX();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.eJF.eJE = false;
        this.eJF.aZX();
        writeShareActivity = this.eJF.eJC;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.eJF.eJC;
            writeShareActivity2.qw(t.j.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.eJF.eJE = false;
        this.eJF.aZX();
        writeShareActivity = this.eJF.eJC;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.eJF.eJC;
            writeShareActivity2.qw(t.j.share_load_image_fail_tip);
        }
    }
}
