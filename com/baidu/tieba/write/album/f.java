package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fys = eVar;
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
        ImageFileInfo sf;
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
        jVar = this.fys.fyq;
        if (jVar != null) {
            oVar = this.fys.fxZ;
            if (oVar != null) {
                albumActivity = this.fys.fyo;
                if (albumActivity != null) {
                    jVar2 = this.fys.fyq;
                    i = this.fys.axc;
                    if (jVar2.sg(i)) {
                        oVar2 = this.fys.fxZ;
                        if ("-1".equals(oVar2.blI())) {
                            jVar4 = this.fys.fyq;
                            i7 = this.fys.axc;
                            sf = jVar4.sf(i7 + 1);
                        } else {
                            jVar3 = this.fys.fyq;
                            i2 = this.fys.axc;
                            sf = jVar3.sf(i2);
                        }
                        oVar3 = this.fys.fxZ;
                        if (oVar3.isAdded(sf)) {
                            albumActivity6 = this.fys.fyo;
                            if (albumActivity6.d(sf)) {
                                e eVar = this.fys;
                                imageView3 = this.fys.fyr;
                                eVar.b(imageView3, false);
                                oVar5 = this.fys.fxZ;
                                if ("-1".equals(oVar5.blI())) {
                                    albumActivity8 = this.fys.fyo;
                                    i6 = this.fys.axc;
                                    albumActivity8.J(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fys.fyo;
                                    i5 = this.fys.axc;
                                    albumActivity7.J(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fys.fyo;
                            if (albumActivity2.c(sf)) {
                                e eVar2 = this.fys;
                                imageView = this.fys.fyr;
                                eVar2.b(imageView, true);
                                oVar4 = this.fys.fxZ;
                                if ("-1".equals(oVar4.blI())) {
                                    albumActivity5 = this.fys.fyo;
                                    i4 = this.fys.axc;
                                    albumActivity5.J(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fys.fyo;
                                    i3 = this.fys.axc;
                                    albumActivity3.J(i3, true);
                                }
                                albumActivity4 = this.fys.fyo;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), r.a.album_choose_icon);
                                imageView2 = this.fys.fyr;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fys.blB();
                    }
                }
            }
        }
    }
}
