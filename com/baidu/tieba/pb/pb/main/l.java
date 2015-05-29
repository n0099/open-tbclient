package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        eVar.dismiss();
        this.bKT.KD();
        if (i == 0) {
            writeImagesInfo = this.bKT.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bKT.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bKT.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bKT.showToast(String.format(this.bKT.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bKT.aJR = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bKT.getPageContext();
            str = this.bKT.aJR;
            com.baidu.tbadk.core.util.ax.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ax.p(this.bKT.getPageContext().getPageActivity());
        }
    }
}
