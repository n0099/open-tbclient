package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.album.AlbumActivity;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class bn implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        String str;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        if (i == 0) {
            writeImagesInfo2 = this.a.m;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.a.m;
                int size = writeImagesInfo3.getChosedFiles().size();
                writeImagesInfo4 = this.a.m;
                if (size >= writeImagesInfo4.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(R.string.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.n = String.valueOf(System.currentTimeMillis());
            NewPbActivity newPbActivity = this.a;
            str = this.a.n;
            com.baidu.tieba.write.by.a(newPbActivity, str);
        } else if (i == 1) {
            NewPbActivity newPbActivity2 = this.a;
            writeImagesInfo = this.a.m;
            AlbumActivity.a(newPbActivity2, writeImagesInfo, 12002);
        }
    }
}
