package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t fMj;
    private final /* synthetic */ ImageFileInfo fMk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.fMj = tVar;
        this.fMk = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.fMj.fLm;
        albumActivity.d(this.fMk);
        albumActivity2 = this.fMj.fLm;
        albumActivity2.e(this.fMk, false);
        albumActivity3 = this.fMj.fLm;
        albumActivity3.f(this.fMk, false);
    }
}
