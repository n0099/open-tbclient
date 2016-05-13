package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t eYA;
    private final /* synthetic */ ImageFileInfo eYB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.eYA = tVar;
        this.eYB = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.eYA.eXL;
        albumActivity.d(this.eYB);
        albumActivity2 = this.eYA.eXL;
        albumActivity2.e(this.eYB, false);
        albumActivity3 = this.eYA.eXL;
        albumActivity3.f(this.eYB, false);
    }
}
