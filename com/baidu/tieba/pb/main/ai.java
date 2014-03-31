package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
final class ai implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        if (i == 0) {
            writeImagesInfo4 = this.a.n;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.n;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.n;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.o = String.valueOf(System.currentTimeMillis());
            PbActivity pbActivity = this.a;
            str = this.a.o;
            com.baidu.tbadk.core.util.az.a(pbActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.n;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.n;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    PbActivity pbActivity2 = this.a;
                    writeImagesInfo3 = this.a.n;
                    com.baidu.tbadk.core.b.a aVar = new com.baidu.tbadk.core.b.a(pbActivity2, writeImagesInfo3.toJsonString());
                    aVar.a(12002);
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, aVar));
                }
            }
        }
    }
}
