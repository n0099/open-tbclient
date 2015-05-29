package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v cyT;
    private final /* synthetic */ ImageFileInfo cyU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, ImageFileInfo imageFileInfo) {
        this.cyT = vVar;
        this.cyU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.cyT.cxZ;
        albumActivity.d(this.cyU);
        albumActivity2 = this.cyT.cxZ;
        albumActivity2.c(this.cyU, false);
        albumActivity3 = this.cyT.cxZ;
        albumActivity3.d(this.cyU, false);
    }
}
