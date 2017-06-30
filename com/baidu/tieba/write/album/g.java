package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f geI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.geI = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        p pVar;
        AlbumActivity albumActivity;
        k kVar2;
        int i;
        k kVar3;
        int i2;
        p pVar2;
        AlbumActivity albumActivity2;
        ImageView imageView;
        AlbumActivity albumActivity3;
        int i3;
        AlbumActivity albumActivity4;
        ImageView imageView2;
        AlbumActivity albumActivity5;
        int i4;
        kVar = this.geI.geE;
        if (kVar != null) {
            pVar = this.geI.gei;
            if (pVar != null) {
                albumActivity = this.geI.gex;
                if (albumActivity != null) {
                    kVar2 = this.geI.geE;
                    i = this.geI.aCI;
                    if (kVar2.tE(i)) {
                        kVar3 = this.geI.geE;
                        i2 = this.geI.aCI;
                        ImageFileInfo tD = kVar3.tD(i2);
                        pVar2 = this.geI.gei;
                        if (pVar2.isAdded(tD)) {
                            albumActivity4 = this.geI.gex;
                            if (albumActivity4.d(tD)) {
                                f fVar = this.geI;
                                imageView2 = this.geI.geF;
                                fVar.c(imageView2, false);
                                albumActivity5 = this.geI.gex;
                                i4 = this.geI.aCI;
                                albumActivity5.G(i4, false);
                            }
                        } else {
                            albumActivity2 = this.geI.gex;
                            if (albumActivity2.c(tD)) {
                                f fVar2 = this.geI;
                                imageView = this.geI.geF;
                                fVar2.c(imageView, true);
                                albumActivity3 = this.geI.gex;
                                i3 = this.geI.aCI;
                                albumActivity3.G(i3, true);
                            }
                        }
                        this.geI.bse();
                    }
                }
            }
        }
    }
}
