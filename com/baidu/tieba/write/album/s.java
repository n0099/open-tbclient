package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r dmA;
    private final /* synthetic */ ImageFileInfo dmB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, ImageFileInfo imageFileInfo) {
        this.dmA = rVar;
        this.dmB = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.dmA.dlE;
        albumActivity.d(this.dmB);
        albumActivity2 = this.dmA.dlE;
        albumActivity2.d(this.dmB, false);
        albumActivity3 = this.dmA.dlE;
        albumActivity3.e(this.dmB, false);
    }
}
