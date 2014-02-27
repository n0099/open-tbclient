package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.album.AlbumActivity;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class bf implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        String str;
        if (i == 0) {
            writeImagesInfo2 = this.a.D;
            int size = writeImagesInfo2.size();
            writeImagesInfo3 = this.a.D;
            if (size < writeImagesInfo3.getMaxImagesAllowed()) {
                this.a.E = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity = this.a;
                str = this.a.E;
                by.a(writeActivity, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(R.string.editor_mutiiamge_max), 10));
        } else if (i == 1) {
            WriteActivity writeActivity2 = this.a;
            writeImagesInfo = this.a.D;
            AlbumActivity.a(writeActivity2, writeImagesInfo, 12002);
        }
    }
}
