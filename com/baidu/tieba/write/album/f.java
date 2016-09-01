package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e gaj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.gaj = eVar;
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
        ImageFileInfo sW;
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
        jVar = this.gaj.gah;
        if (jVar != null) {
            oVar = this.gaj.fZQ;
            if (oVar != null) {
                albumActivity = this.gaj.gaf;
                if (albumActivity != null) {
                    jVar2 = this.gaj.gah;
                    i = this.gaj.axl;
                    if (jVar2.sX(i)) {
                        oVar2 = this.gaj.fZQ;
                        if ("-1".equals(oVar2.brN())) {
                            jVar4 = this.gaj.gah;
                            i7 = this.gaj.axl;
                            sW = jVar4.sW(i7 + 1);
                        } else {
                            jVar3 = this.gaj.gah;
                            i2 = this.gaj.axl;
                            sW = jVar3.sW(i2);
                        }
                        oVar3 = this.gaj.fZQ;
                        if (oVar3.isAdded(sW)) {
                            albumActivity6 = this.gaj.gaf;
                            if (albumActivity6.e(sW)) {
                                e eVar = this.gaj;
                                imageView3 = this.gaj.gai;
                                eVar.b(imageView3, false);
                                oVar5 = this.gaj.fZQ;
                                if ("-1".equals(oVar5.brN())) {
                                    albumActivity8 = this.gaj.gaf;
                                    i6 = this.gaj.axl;
                                    albumActivity8.W(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.gaj.gaf;
                                    i5 = this.gaj.axl;
                                    albumActivity7.W(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.gaj.gaf;
                            if (albumActivity2.d(sW)) {
                                e eVar2 = this.gaj;
                                imageView = this.gaj.gai;
                                eVar2.b(imageView, true);
                                oVar4 = this.gaj.fZQ;
                                if ("-1".equals(oVar4.brN())) {
                                    albumActivity5 = this.gaj.gaf;
                                    i4 = this.gaj.axl;
                                    albumActivity5.W(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.gaj.gaf;
                                    i3 = this.gaj.axl;
                                    albumActivity3.W(i3, true);
                                }
                                albumActivity4 = this.gaj.gaf;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), t.a.album_choose_icon);
                                imageView2 = this.gaj.gai;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.gaj.brJ();
                    }
                }
            }
        }
    }
}
