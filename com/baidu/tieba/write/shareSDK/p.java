package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o dNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.dNF = oVar;
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
            shareSDKImageView = this.dNF.dNz;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.dNF.dNz;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.dNF;
                    shareSDKImageView3 = this.dNF.dNz;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.dNF;
                    shareSDKImageView4 = this.dNF.dNz;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.dNF.dNC;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.dNF.dNC;
                        WriteData aEl = writeShareActivity4.aEl();
                        i = this.dNF.width;
                        aEl.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.dNF.dNC;
                        WriteData aEl2 = writeShareActivity5.aEl();
                        i2 = this.dNF.height;
                        aEl2.setShareSummaryImgHeight(i2);
                        this.dNF.dNE = true;
                        this.dNF.aIs();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dNF.dNE = false;
        this.dNF.aIs();
        writeShareActivity = this.dNF.dNC;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dNF.dNC;
            writeShareActivity2.nq(n.i.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.dNF.dNE = false;
        this.dNF.aIs();
        writeShareActivity = this.dNF.dNC;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.dNF.dNC;
            writeShareActivity2.nq(n.i.share_load_image_fail_tip);
        }
    }
}
