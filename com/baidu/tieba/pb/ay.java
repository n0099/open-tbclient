package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        cu cuVar;
        cu cuVar2;
        WriteImagesInfo writeImagesInfo;
        String str;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        NewPbActivity newPbActivity = this.a;
        cuVar = this.a.C;
        newPbActivity.D = cuVar.ad();
        cuVar2 = this.a.C;
        cuVar2.j();
        if (i == 0) {
            writeImagesInfo = this.a.m;
            if (writeImagesInfo.getChosedFiles() != null) {
                writeImagesInfo2 = this.a.m;
                int size = writeImagesInfo2.getChosedFiles().size();
                writeImagesInfo3 = this.a.m;
                if (size >= writeImagesInfo3.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(R.string.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.n = String.valueOf(System.currentTimeMillis());
            NewPbActivity newPbActivity2 = this.a;
            str = this.a.n;
            com.baidu.tieba.write.bz.a(newPbActivity2, str);
        } else if (i == 1) {
            com.baidu.tieba.write.bz.b(this.a);
        }
    }
}
