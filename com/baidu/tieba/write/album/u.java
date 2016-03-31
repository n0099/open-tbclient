package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t eHH;
    private final /* synthetic */ ImageFileInfo eHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.eHH = tVar;
        this.eHI = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.eHH.eGS;
        albumActivity.d(this.eHI);
        albumActivity2 = this.eHH.eGS;
        albumActivity2.e(this.eHI, false);
        albumActivity3 = this.eHH.eGS;
        albumActivity3.f(this.eHI, false);
    }
}
