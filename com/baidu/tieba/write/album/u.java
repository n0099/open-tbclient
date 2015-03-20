package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t cul;
    private final /* synthetic */ ImageFileInfo cum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.cul = tVar;
        this.cum = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.cul.ctu;
        albumActivity.d(this.cum);
        albumActivity2 = this.cul.ctu;
        albumActivity2.c(this.cum, false);
        albumActivity3 = this.cul.ctu;
        albumActivity3.d(this.cum, false);
    }
}
