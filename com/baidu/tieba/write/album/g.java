package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f fTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.fTY = fVar;
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
        kVar = this.fTY.fTU;
        if (kVar != null) {
            pVar = this.fTY.fTx;
            if (pVar != null) {
                albumActivity = this.fTY.fTN;
                if (albumActivity != null) {
                    kVar2 = this.fTY.fTU;
                    i = this.fTY.aBF;
                    if (kVar2.tj(i)) {
                        kVar3 = this.fTY.fTU;
                        i2 = this.fTY.aBF;
                        ImageFileInfo ti = kVar3.ti(i2);
                        pVar2 = this.fTY.fTx;
                        if (pVar2.isAdded(ti)) {
                            albumActivity4 = this.fTY.fTN;
                            if (albumActivity4.d(ti)) {
                                f fVar = this.fTY;
                                imageView2 = this.fTY.fTV;
                                fVar.c(imageView2, false);
                                albumActivity5 = this.fTY.fTN;
                                i4 = this.fTY.aBF;
                                albumActivity5.G(i4, false);
                            }
                        } else {
                            albumActivity2 = this.fTY.fTN;
                            if (albumActivity2.c(ti)) {
                                f fVar2 = this.fTY;
                                imageView = this.fTY.fTV;
                                fVar2.c(imageView, true);
                                albumActivity3 = this.fTY.fTN;
                                i3 = this.fTY.aBF;
                                albumActivity3.G(i3, true);
                            }
                        }
                        this.fTY.bnH();
                    }
                }
            }
        }
    }
}
