package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.write.view.ShareSDKImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ o epJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.epJ = oVar;
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
            shareSDKImageView = this.epJ.epD;
            if (shareSDKImageView.getLoadedWidth() != 0) {
                shareSDKImageView2 = this.epJ.epD;
                if (shareSDKImageView2.getLoadedHeight() != 0) {
                    o oVar = this.epJ;
                    shareSDKImageView3 = this.epJ.epD;
                    oVar.width = shareSDKImageView3.getLoadedWidth();
                    o oVar2 = this.epJ;
                    shareSDKImageView4 = this.epJ.epD;
                    oVar2.height = shareSDKImageView4.getLoadedHeight();
                    writeShareActivity3 = this.epJ.epG;
                    if (writeShareActivity3 != null) {
                        writeShareActivity4 = this.epJ.epG;
                        WriteData aND = writeShareActivity4.aND();
                        i = this.epJ.width;
                        aND.setShareSummaryImgWidth(i);
                        writeShareActivity5 = this.epJ.epG;
                        WriteData aND2 = writeShareActivity5.aND();
                        i2 = this.epJ.height;
                        aND2.setShareSummaryImgHeight(i2);
                        this.epJ.epI = true;
                        this.epJ.aTx();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.epJ.epI = false;
        this.epJ.aTx();
        writeShareActivity = this.epJ.epG;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.epJ.epG;
            writeShareActivity2.pD(t.j.share_load_image_fail_tip);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        WriteShareActivity writeShareActivity;
        WriteShareActivity writeShareActivity2;
        this.epJ.epI = false;
        this.epJ.aTx();
        writeShareActivity = this.epJ.epG;
        if (writeShareActivity != null) {
            writeShareActivity2 = this.epJ.epG;
            writeShareActivity2.pD(t.j.share_load_image_fail_tip);
        }
    }
}
