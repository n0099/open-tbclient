package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        eVar.dismiss();
        this.bKU.KE();
        if (i == 0) {
            writeImagesInfo = this.bKU.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bKU.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bKU.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bKU.showToast(String.format(this.bKU.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bKU.aJS = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bKU.getPageContext();
            str = this.bKU.aJS;
            com.baidu.tbadk.core.util.ax.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ax.p(this.bKU.getPageContext().getPageActivity());
        }
    }
}
