package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t fNS;
    private final /* synthetic */ ImageFileInfo fNT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.fNS = tVar;
        this.fNT = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.fNS.fMV;
        albumActivity.d(this.fNT);
        albumActivity2 = this.fNS.fMV;
        albumActivity2.e(this.fNT, false);
        albumActivity3 = this.fNS.fMV;
        albumActivity3.f(this.fNT, false);
    }
}
