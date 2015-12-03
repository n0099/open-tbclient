package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e dKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dKN = eVar;
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
        ImageFileInfo ni;
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
        jVar = this.dKN.dKL;
        if (jVar != null) {
            oVar = this.dKN.dKx;
            if (oVar != null) {
                albumActivity = this.dKN.dKK;
                if (albumActivity != null) {
                    jVar2 = this.dKN.dKL;
                    i = this.dKN.atv;
                    if (jVar2.nj(i)) {
                        oVar2 = this.dKN.dKx;
                        if ("-1".equals(oVar2.aHC())) {
                            jVar4 = this.dKN.dKL;
                            i7 = this.dKN.atv;
                            ni = jVar4.ni(i7 + 1);
                        } else {
                            jVar3 = this.dKN.dKL;
                            i2 = this.dKN.atv;
                            ni = jVar3.ni(i2);
                        }
                        oVar3 = this.dKN.dKx;
                        if (oVar3.isAdded(ni)) {
                            albumActivity6 = this.dKN.dKK;
                            if (albumActivity6.b(ni)) {
                                e eVar = this.dKN;
                                imageView3 = this.dKN.dKM;
                                eVar.b(imageView3, false);
                                oVar5 = this.dKN.dKx;
                                if ("-1".equals(oVar5.aHC())) {
                                    albumActivity8 = this.dKN.dKK;
                                    i6 = this.dKN.atv;
                                    albumActivity8.v(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.dKN.dKK;
                                    i5 = this.dKN.atv;
                                    albumActivity7.v(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.dKN.dKK;
                            if (albumActivity2.a(ni)) {
                                e eVar2 = this.dKN;
                                imageView = this.dKN.dKM;
                                eVar2.b(imageView, true);
                                oVar4 = this.dKN.dKx;
                                if ("-1".equals(oVar4.aHC())) {
                                    albumActivity5 = this.dKN.dKK;
                                    i4 = this.dKN.atv;
                                    albumActivity5.v(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.dKN.dKK;
                                    i3 = this.dKN.atv;
                                    albumActivity3.v(i3, true);
                                }
                                albumActivity4 = this.dKN.dKK;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), n.a.album_choose_icon);
                                imageView2 = this.dKN.dKM;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.dKN.aHv();
                    }
                }
            }
        }
    }
}
