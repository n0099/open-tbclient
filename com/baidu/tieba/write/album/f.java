package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fMZ = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        o oVar;
        AlbumActivity albumActivity;
        j jVar2;
        int i;
        o oVar2;
        j jVar3;
        int i2;
        ImageFileInfo sN;
        o oVar3;
        AlbumActivity albumActivity2;
        ImageView imageView;
        o oVar4;
        AlbumActivity albumActivity3;
        int i3;
        AlbumActivity albumActivity4;
        ImageView imageView2;
        AlbumActivity albumActivity5;
        int i4;
        AlbumActivity albumActivity6;
        ImageView imageView3;
        o oVar5;
        AlbumActivity albumActivity7;
        int i5;
        AlbumActivity albumActivity8;
        int i6;
        j jVar4;
        int i7;
        jVar = this.fMZ.fMX;
        if (jVar != null) {
            oVar = this.fMZ.fMH;
            if (oVar != null) {
                albumActivity = this.fMZ.fMV;
                if (albumActivity != null) {
                    jVar2 = this.fMZ.fMX;
                    i = this.fMZ.aBR;
                    if (jVar2.sO(i)) {
                        oVar2 = this.fMZ.fMH;
                        if ("-1".equals(oVar2.bnD())) {
                            jVar4 = this.fMZ.fMX;
                            i7 = this.fMZ.aBR;
                            sN = jVar4.sN(i7 + 1);
                        } else {
                            jVar3 = this.fMZ.fMX;
                            i2 = this.fMZ.aBR;
                            sN = jVar3.sN(i2);
                        }
                        oVar3 = this.fMZ.fMH;
                        if (oVar3.isAdded(sN)) {
                            albumActivity6 = this.fMZ.fMV;
                            if (albumActivity6.d(sN)) {
                                e eVar = this.fMZ;
                                imageView3 = this.fMZ.fMY;
                                eVar.c(imageView3, false);
                                oVar5 = this.fMZ.fMH;
                                if ("-1".equals(oVar5.bnD())) {
                                    albumActivity8 = this.fMZ.fMV;
                                    i6 = this.fMZ.aBR;
                                    albumActivity8.K(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fMZ.fMV;
                                    i5 = this.fMZ.aBR;
                                    albumActivity7.K(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fMZ.fMV;
                            if (albumActivity2.c(sN)) {
                                e eVar2 = this.fMZ;
                                imageView = this.fMZ.fMY;
                                eVar2.c(imageView, true);
                                oVar4 = this.fMZ.fMH;
                                if ("-1".equals(oVar4.bnD())) {
                                    albumActivity5 = this.fMZ.fMV;
                                    i4 = this.fMZ.aBR;
                                    albumActivity5.K(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fMZ.fMV;
                                    i3 = this.fMZ.aBR;
                                    albumActivity3.K(i3, true);
                                }
                                albumActivity4 = this.fMZ.fMV;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), w.a.album_choose_icon);
                                imageView2 = this.fMZ.fMY;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fMZ.bnw();
                    }
                }
            }
        }
    }
}
