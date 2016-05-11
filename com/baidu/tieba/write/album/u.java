package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t eYB;
    private final /* synthetic */ ImageFileInfo eYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.eYB = tVar;
        this.eYC = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.eYB.eXM;
        albumActivity.d(this.eYC);
        albumActivity2 = this.eYB.eXM;
        albumActivity2.e(this.eYC, false);
        albumActivity3 = this.eYB.eXM;
        albumActivity3.f(this.eYC, false);
    }
}
