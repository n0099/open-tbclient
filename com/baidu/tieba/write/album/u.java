package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t fzm;
    private final /* synthetic */ ImageFileInfo fzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.fzm = tVar;
        this.fzn = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.fzm.fyo;
        albumActivity.d(this.fzn);
        albumActivity2 = this.fzm.fyo;
        albumActivity2.e(this.fzn, false);
        albumActivity3 = this.fzm.fyo;
        albumActivity3.f(this.fzn, false);
    }
}
