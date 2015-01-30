package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class n implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        this.bAT.Gj();
        if (i == 0) {
            writeImagesInfo = this.bAT.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bAT.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bAT.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bAT.showToast(String.format(this.bAT.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bAT.aBK = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bAT.getPageContext();
            str = this.bAT.aBK;
            com.baidu.tbadk.core.util.bb.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.bb.p(this.bAT.getPageContext().getPageActivity());
        }
    }
}
