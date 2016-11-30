package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t gkK;
    private final /* synthetic */ ImageFileInfo gkL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.gkK = tVar;
        this.gkL = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.gkK.gjT;
        albumActivity.e(this.gkL);
        albumActivity2 = this.gkK.gjT;
        albumActivity2.e(this.gkL, false);
        albumActivity3 = this.gkK.gjT;
        albumActivity3.f(this.gkL, false);
    }
}
