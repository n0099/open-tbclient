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
        bq bqVar;
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        bqVar = this.a.D;
        bqVar.m();
        if (i == 0) {
            writeImagesInfo = this.a.n;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.a.n;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.a.n;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.o = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.a;
            str = this.a.o;
            com.baidu.tbadk.core.util.bb.a(pbActivity, str);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.bb.b(this.a);
        }
    }
}
