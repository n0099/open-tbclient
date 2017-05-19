package com.baidu.tieba.write.album;

import android.app.AlertDialog;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AlbumActivity fMa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AlbumActivity albumActivity) {
        this.fMa = albumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertDialog alertDialog;
        alertDialog = this.fMa.fLX;
        alertDialog.dismiss();
    }
}
