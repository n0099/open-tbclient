package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r cQJ;
    private final /* synthetic */ ImageFileInfo cQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, ImageFileInfo imageFileInfo) {
        this.cQJ = rVar;
        this.cQK = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.cQJ.cPQ;
        albumActivity.d(this.cQK);
        albumActivity2 = this.cQJ.cPQ;
        albumActivity2.c(this.cQK, false);
        albumActivity3 = this.cQJ.cPQ;
        albumActivity3.d(this.cQK, false);
    }
}
