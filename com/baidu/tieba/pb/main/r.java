package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class r implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bs bsVar;
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        bsVar = this.a.D;
        bsVar.n();
        if (i == 0) {
            writeImagesInfo = this.a.l;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.a.l;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.a.l;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.o = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.a;
            str = this.a.o;
            com.baidu.tbadk.core.util.ax.a(pbActivity, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ax.b(this.a);
        }
    }
}
