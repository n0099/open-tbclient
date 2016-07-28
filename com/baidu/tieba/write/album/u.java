package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t fQR;
    private final /* synthetic */ ImageFileInfo fQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.fQR = tVar;
        this.fQS = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.fQR.fQb;
        albumActivity.e(this.fQS);
        albumActivity2 = this.fQR.fQb;
        albumActivity2.e(this.fQS, false);
        albumActivity3 = this.fQR.fQb;
        albumActivity3.f(this.fQS, false);
    }
}
