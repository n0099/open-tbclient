package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class l implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        this.bzj.FM();
        if (i == 0) {
            writeImagesInfo = this.bzj.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bzj.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bzj.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bzj.showToast(String.format(this.bzj.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bzj.aAI = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bzj.getPageContext();
            str = this.bzj.aAI;
            com.baidu.tbadk.core.util.aw.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.aw.o(this.bzj.getPageContext().getPageActivity());
        }
    }
}
