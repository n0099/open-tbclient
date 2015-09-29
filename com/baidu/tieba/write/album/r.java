package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q dks;
    private final /* synthetic */ ImageFileInfo dkt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, ImageFileInfo imageFileInfo) {
        this.dks = qVar;
        this.dkt = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.dks.djw;
        albumActivity.d(this.dkt);
        albumActivity2 = this.dks.djw;
        albumActivity2.d(this.dkt, false);
        albumActivity3 = this.dks.djw;
        albumActivity3.e(this.dkt, false);
    }
}
