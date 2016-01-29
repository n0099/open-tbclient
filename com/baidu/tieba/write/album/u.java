package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t enK;
    private final /* synthetic */ ImageFileInfo enL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.enK = tVar;
        this.enL = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.enK.emU;
        albumActivity.b(this.enL);
        albumActivity2 = this.enK.emU;
        albumActivity2.e(this.enL, false);
        albumActivity3 = this.enK.emU;
        albumActivity3.f(this.enL, false);
    }
}
