package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t fDE;
    private final /* synthetic */ ImageFileInfo fDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.fDE = tVar;
        this.fDF = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.fDE.fCP;
        albumActivity.e(this.fDF);
        albumActivity2 = this.fDE.fCP;
        albumActivity2.e(this.fDF, false);
        albumActivity3 = this.fDE.fCP;
        albumActivity3.f(this.fDF, false);
    }
}
