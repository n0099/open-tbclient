package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t fQo;
    private final /* synthetic */ ImageFileInfo fQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.fQo = tVar;
        this.fQp = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.fQo.fPr;
        albumActivity.d(this.fQp);
        albumActivity2 = this.fQo.fPr;
        albumActivity2.e(this.fQp, false);
        albumActivity3 = this.fQo.fPr;
        albumActivity3.f(this.fQp, false);
    }
}
