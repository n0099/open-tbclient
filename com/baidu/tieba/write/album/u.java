package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t dTf;
    private final /* synthetic */ ImageFileInfo dTg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.dTf = tVar;
        this.dTg = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.dTf.dSj;
        albumActivity.b(this.dTg);
        albumActivity2 = this.dTf.dSj;
        albumActivity2.e(this.dTg, false);
        albumActivity3 = this.dTf.dSj;
        albumActivity3.f(this.dTg, false);
    }
}
