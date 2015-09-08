package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r cZu;
    private final /* synthetic */ ImageFileInfo cZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, ImageFileInfo imageFileInfo) {
        this.cZu = rVar;
        this.cZv = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.cZu.cYB;
        albumActivity.d(this.cZv);
        albumActivity2 = this.cZu.cYB;
        albumActivity2.c(this.cZv, false);
        albumActivity3 = this.cZu.cYB;
        albumActivity3.d(this.cZv, false);
    }
}
