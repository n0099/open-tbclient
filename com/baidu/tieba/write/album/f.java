package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fPv = eVar;
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
        ImageFileInfo sT;
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
        jVar = this.fPv.fPt;
        if (jVar != null) {
            oVar = this.fPv.fPd;
            if (oVar != null) {
                albumActivity = this.fPv.fPr;
                if (albumActivity != null) {
                    jVar2 = this.fPv.fPt;
                    i = this.fPv.aBT;
                    if (jVar2.sU(i)) {
                        oVar2 = this.fPv.fPd;
                        if ("-1".equals(oVar2.boE())) {
                            jVar4 = this.fPv.fPt;
                            i7 = this.fPv.aBT;
                            sT = jVar4.sT(i7 + 1);
                        } else {
                            jVar3 = this.fPv.fPt;
                            i2 = this.fPv.aBT;
                            sT = jVar3.sT(i2);
                        }
                        oVar3 = this.fPv.fPd;
                        if (oVar3.isAdded(sT)) {
                            albumActivity6 = this.fPv.fPr;
                            if (albumActivity6.d(sT)) {
                                e eVar = this.fPv;
                                imageView3 = this.fPv.fPu;
                                eVar.c(imageView3, false);
                                oVar5 = this.fPv.fPd;
                                if ("-1".equals(oVar5.boE())) {
                                    albumActivity8 = this.fPv.fPr;
                                    i6 = this.fPv.aBT;
                                    albumActivity8.K(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fPv.fPr;
                                    i5 = this.fPv.aBT;
                                    albumActivity7.K(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fPv.fPr;
                            if (albumActivity2.c(sT)) {
                                e eVar2 = this.fPv;
                                imageView = this.fPv.fPu;
                                eVar2.c(imageView, true);
                                oVar4 = this.fPv.fPd;
                                if ("-1".equals(oVar4.boE())) {
                                    albumActivity5 = this.fPv.fPr;
                                    i4 = this.fPv.aBT;
                                    albumActivity5.K(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fPv.fPr;
                                    i3 = this.fPv.aBT;
                                    albumActivity3.K(i3, true);
                                }
                                albumActivity4 = this.fPv.fPr;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), w.a.album_choose_icon);
                                imageView2 = this.fPv.fPu;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fPv.box();
                    }
                }
            }
        }
    }
}
