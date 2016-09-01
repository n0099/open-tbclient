package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t gaW;
    private final /* synthetic */ ImageFileInfo gaX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.gaW = tVar;
        this.gaX = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.gaW.gaf;
        albumActivity.e(this.gaX);
        albumActivity2 = this.gaW.gaf;
        albumActivity2.e(this.gaX, false);
        albumActivity3 = this.gaW.gaf;
        albumActivity3.f(this.gaX, false);
    }
}
