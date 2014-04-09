package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
final class r implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        bm bmVar;
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        bmVar = this.a.D;
        bmVar.m();
        if (i == 0) {
            writeImagesInfo = this.a.n;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.a.n;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.a.n;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.o = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.a;
            str = this.a.o;
            com.baidu.tbadk.core.util.az.a(pbActivity, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.az.b(this.a);
        }
    }
}
