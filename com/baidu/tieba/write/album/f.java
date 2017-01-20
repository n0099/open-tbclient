package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fGW = eVar;
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
        ImageFileInfo sQ;
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
        jVar = this.fGW.fGU;
        if (jVar != null) {
            oVar = this.fGW.fGE;
            if (oVar != null) {
                albumActivity = this.fGW.fGS;
                if (albumActivity != null) {
                    jVar2 = this.fGW.fGU;
                    i = this.fGW.awg;
                    if (jVar2.sR(i)) {
                        oVar2 = this.fGW.fGE;
                        if ("-1".equals(oVar2.bng())) {
                            jVar4 = this.fGW.fGU;
                            i7 = this.fGW.awg;
                            sQ = jVar4.sQ(i7 + 1);
                        } else {
                            jVar3 = this.fGW.fGU;
                            i2 = this.fGW.awg;
                            sQ = jVar3.sQ(i2);
                        }
                        oVar3 = this.fGW.fGE;
                        if (oVar3.isAdded(sQ)) {
                            albumActivity6 = this.fGW.fGS;
                            if (albumActivity6.d(sQ)) {
                                e eVar = this.fGW;
                                imageView3 = this.fGW.fGV;
                                eVar.b(imageView3, false);
                                oVar5 = this.fGW.fGE;
                                if ("-1".equals(oVar5.bng())) {
                                    albumActivity8 = this.fGW.fGS;
                                    i6 = this.fGW.awg;
                                    albumActivity8.J(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fGW.fGS;
                                    i5 = this.fGW.awg;
                                    albumActivity7.J(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fGW.fGS;
                            if (albumActivity2.c(sQ)) {
                                e eVar2 = this.fGW;
                                imageView = this.fGW.fGV;
                                eVar2.b(imageView, true);
                                oVar4 = this.fGW.fGE;
                                if ("-1".equals(oVar4.bng())) {
                                    albumActivity5 = this.fGW.fGS;
                                    i4 = this.fGW.awg;
                                    albumActivity5.J(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fGW.fGS;
                                    i3 = this.fGW.awg;
                                    albumActivity3.J(i3, true);
                                }
                                albumActivity4 = this.fGW.fGS;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), r.a.album_choose_icon);
                                imageView2 = this.fGW.fGV;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fGW.bmZ();
                    }
                }
            }
        }
    }
}
