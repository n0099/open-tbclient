package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        this.bvu.FI();
        if (i == 0) {
            writeImagesInfo = this.bvu.writeImagesInfo;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.bvu.writeImagesInfo;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.bvu.writeImagesInfo;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.bvu.showToast(String.format(this.bvu.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bvu.ayG = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.bvu;
            str = this.bvu.ayG;
            com.baidu.tbadk.core.util.av.a(pbActivity, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.av.i(this.bvu);
        }
    }
}
