package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class n implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        this.bAS.Gd();
        if (i == 0) {
            writeImagesInfo = this.bAS.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bAS.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bAS.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bAS.showToast(String.format(this.bAS.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bAS.aBH = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bAS.getPageContext();
            str = this.bAS.aBH;
            com.baidu.tbadk.core.util.bb.a(pageContext, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.bb.p(this.bAS.getPageContext().getPageActivity());
        }
    }
}
