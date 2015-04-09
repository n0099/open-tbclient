package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t cuB;
    private final /* synthetic */ ImageFileInfo cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.cuB = tVar;
        this.cuC = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.cuB.ctK;
        albumActivity.d(this.cuC);
        albumActivity2 = this.cuB.ctK;
        albumActivity2.c(this.cuC, false);
        albumActivity3 = this.cuB.ctK;
        albumActivity3.d(this.cuC, false);
    }
}
