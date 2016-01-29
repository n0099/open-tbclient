package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e emX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.emX = eVar;
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
        ImageFileInfo pv;
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
        jVar = this.emX.emV;
        if (jVar != null) {
            oVar = this.emX.emG;
            if (oVar != null) {
                albumActivity = this.emX.emU;
                if (albumActivity != null) {
                    jVar2 = this.emX.emV;
                    i = this.emX.avR;
                    if (jVar2.pw(i)) {
                        oVar2 = this.emX.emG;
                        if ("-1".equals(oVar2.aSJ())) {
                            jVar4 = this.emX.emV;
                            i7 = this.emX.avR;
                            pv = jVar4.pv(i7 + 1);
                        } else {
                            jVar3 = this.emX.emV;
                            i2 = this.emX.avR;
                            pv = jVar3.pv(i2);
                        }
                        oVar3 = this.emX.emG;
                        if (oVar3.isAdded(pv)) {
                            albumActivity6 = this.emX.emU;
                            if (albumActivity6.b(pv)) {
                                e eVar = this.emX;
                                imageView3 = this.emX.emW;
                                eVar.b(imageView3, false);
                                oVar5 = this.emX.emG;
                                if ("-1".equals(oVar5.aSJ())) {
                                    albumActivity8 = this.emX.emU;
                                    i6 = this.emX.avR;
                                    albumActivity8.y(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.emX.emU;
                                    i5 = this.emX.avR;
                                    albumActivity7.y(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.emX.emU;
                            if (albumActivity2.a(pv)) {
                                e eVar2 = this.emX;
                                imageView = this.emX.emW;
                                eVar2.b(imageView, true);
                                oVar4 = this.emX.emG;
                                if ("-1".equals(oVar4.aSJ())) {
                                    albumActivity5 = this.emX.emU;
                                    i4 = this.emX.avR;
                                    albumActivity5.y(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.emX.emU;
                                    i3 = this.emX.avR;
                                    albumActivity3.y(i3, true);
                                }
                                albumActivity4 = this.emX.emU;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), t.a.album_choose_icon);
                                imageView2 = this.emX.emW;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.emX.aSE();
                    }
                }
            }
        }
    }
}
