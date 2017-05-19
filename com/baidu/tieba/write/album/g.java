package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f fMr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.fMr = fVar;
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
        kVar = this.fMr.fMn;
        if (kVar != null) {
            pVar = this.fMr.fLQ;
            if (pVar != null) {
                albumActivity = this.fMr.fMg;
                if (albumActivity != null) {
                    kVar2 = this.fMr.fMn;
                    i = this.fMr.aBS;
                    if (kVar2.sO(i)) {
                        kVar3 = this.fMr.fMn;
                        i2 = this.fMr.aBS;
                        ImageFileInfo sN = kVar3.sN(i2);
                        pVar2 = this.fMr.fLQ;
                        if (pVar2.isAdded(sN)) {
                            albumActivity4 = this.fMr.fMg;
                            if (albumActivity4.d(sN)) {
                                f fVar = this.fMr;
                                imageView2 = this.fMr.fMo;
                                fVar.c(imageView2, false);
                                albumActivity5 = this.fMr.fMg;
                                i4 = this.fMr.aBS;
                                albumActivity5.I(i4, false);
                            }
                        } else {
                            albumActivity2 = this.fMr.fMg;
                            if (albumActivity2.c(sN)) {
                                f fVar2 = this.fMr;
                                imageView = this.fMr.fMo;
                                fVar2.c(imageView, true);
                                albumActivity3 = this.fMr.fMg;
                                i3 = this.fMr.aBS;
                                albumActivity3.I(i3, true);
                            }
                        }
                        this.fMr.bmk();
                    }
                }
            }
        }
    }
}
