package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        eVar.dismiss();
        this.bIv.Jt();
        if (i == 0) {
            writeImagesInfo = this.bIv.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bIv.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bIv.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bIv.showToast(String.format(this.bIv.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bIv.aHA = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bIv.getPageContext();
            str = this.bIv.aHA;
            com.baidu.tbadk.core.util.az.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.az.q(this.bIv.getPageContext().getPageActivity());
        }
    }
}
