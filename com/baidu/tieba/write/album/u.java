package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t gdf;
    private final /* synthetic */ ImageFileInfo gdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.gdf = tVar;
        this.gdg = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.gdf.gco;
        albumActivity.e(this.gdg);
        albumActivity2 = this.gdf.gco;
        albumActivity2.e(this.gdg, false);
        albumActivity3 = this.gdf.gco;
        albumActivity3.f(this.gdg, false);
    }
}
