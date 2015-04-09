package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        eVar.dismiss();
        this.bIJ.Jz();
        if (i == 0) {
            writeImagesInfo = this.bIJ.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bIJ.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bIJ.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bIJ.showToast(String.format(this.bIJ.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bIJ.aHI = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bIJ.getPageContext();
            str = this.bIJ.aHI;
            com.baidu.tbadk.core.util.az.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.az.q(this.bIJ.getPageContext().getPageActivity());
        }
    }
}
