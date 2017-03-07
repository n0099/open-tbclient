package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fLq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fLq = eVar;
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
        ImageFileInfo sP;
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
        jVar = this.fLq.fLo;
        if (jVar != null) {
            oVar = this.fLq.fKY;
            if (oVar != null) {
                albumActivity = this.fLq.fLm;
                if (albumActivity != null) {
                    jVar2 = this.fLq.fLo;
                    i = this.fLq.aBB;
                    if (jVar2.sQ(i)) {
                        oVar2 = this.fLq.fKY;
                        if ("-1".equals(oVar2.bmT())) {
                            jVar4 = this.fLq.fLo;
                            i7 = this.fLq.aBB;
                            sP = jVar4.sP(i7 + 1);
                        } else {
                            jVar3 = this.fLq.fLo;
                            i2 = this.fLq.aBB;
                            sP = jVar3.sP(i2);
                        }
                        oVar3 = this.fLq.fKY;
                        if (oVar3.isAdded(sP)) {
                            albumActivity6 = this.fLq.fLm;
                            if (albumActivity6.d(sP)) {
                                e eVar = this.fLq;
                                imageView3 = this.fLq.fLp;
                                eVar.b(imageView3, false);
                                oVar5 = this.fLq.fKY;
                                if ("-1".equals(oVar5.bmT())) {
                                    albumActivity8 = this.fLq.fLm;
                                    i6 = this.fLq.aBB;
                                    albumActivity8.K(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fLq.fLm;
                                    i5 = this.fLq.aBB;
                                    albumActivity7.K(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fLq.fLm;
                            if (albumActivity2.c(sP)) {
                                e eVar2 = this.fLq;
                                imageView = this.fLq.fLp;
                                eVar2.b(imageView, true);
                                oVar4 = this.fLq.fKY;
                                if ("-1".equals(oVar4.bmT())) {
                                    albumActivity5 = this.fLq.fLm;
                                    i4 = this.fLq.aBB;
                                    albumActivity5.K(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fLq.fLm;
                                    i3 = this.fLq.aBB;
                                    albumActivity3.K(i3, true);
                                }
                                albumActivity4 = this.fLq.fLm;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), w.a.album_choose_icon);
                                imageView2 = this.fLq.fLp;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fLq.bmM();
                    }
                }
            }
        }
    }
}
