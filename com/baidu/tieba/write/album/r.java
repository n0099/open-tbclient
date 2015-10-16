package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q dkS;
    private final /* synthetic */ ImageFileInfo dkT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, ImageFileInfo imageFileInfo) {
        this.dkS = qVar;
        this.dkT = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.dkS.djW;
        albumActivity.d(this.dkT);
        albumActivity2 = this.dkS.djW;
        albumActivity2.d(this.dkT, false);
        albumActivity3 = this.dkS.djW;
        albumActivity3.e(this.dkT, false);
    }
}
