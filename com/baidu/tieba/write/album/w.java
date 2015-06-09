package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v cyU;
    private final /* synthetic */ ImageFileInfo cyV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, ImageFileInfo imageFileInfo) {
        this.cyU = vVar;
        this.cyV = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.cyU.cya;
        albumActivity.d(this.cyV);
        albumActivity2 = this.cyU.cya;
        albumActivity2.c(this.cyV, false);
        albumActivity3 = this.cyU.cya;
        albumActivity3.d(this.cyV, false);
    }
}
