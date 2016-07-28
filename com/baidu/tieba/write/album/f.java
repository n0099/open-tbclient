package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fQe = eVar;
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
        ImageFileInfo sv;
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
        jVar = this.fQe.fQc;
        if (jVar != null) {
            oVar = this.fQe.fPM;
            if (oVar != null) {
                albumActivity = this.fQe.fQb;
                if (albumActivity != null) {
                    jVar2 = this.fQe.fQc;
                    i = this.fQe.aue;
                    if (jVar2.sw(i)) {
                        oVar2 = this.fQe.fPM;
                        if ("-1".equals(oVar2.bnx())) {
                            jVar4 = this.fQe.fQc;
                            i7 = this.fQe.aue;
                            sv = jVar4.sv(i7 + 1);
                        } else {
                            jVar3 = this.fQe.fQc;
                            i2 = this.fQe.aue;
                            sv = jVar3.sv(i2);
                        }
                        oVar3 = this.fQe.fPM;
                        if (oVar3.isAdded(sv)) {
                            albumActivity6 = this.fQe.fQb;
                            if (albumActivity6.e(sv)) {
                                e eVar = this.fQe;
                                imageView3 = this.fQe.fQd;
                                eVar.b(imageView3, false);
                                oVar5 = this.fQe.fPM;
                                if ("-1".equals(oVar5.bnx())) {
                                    albumActivity8 = this.fQe.fQb;
                                    i6 = this.fQe.aue;
                                    albumActivity8.U(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fQe.fQb;
                                    i5 = this.fQe.aue;
                                    albumActivity7.U(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fQe.fQb;
                            if (albumActivity2.d(sv)) {
                                e eVar2 = this.fQe;
                                imageView = this.fQe.fQd;
                                eVar2.b(imageView, true);
                                oVar4 = this.fQe.fPM;
                                if ("-1".equals(oVar4.bnx())) {
                                    albumActivity5 = this.fQe.fQb;
                                    i4 = this.fQe.aue;
                                    albumActivity5.U(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fQe.fQb;
                                    i3 = this.fQe.aue;
                                    albumActivity3.U(i3, true);
                                }
                                albumActivity4 = this.fQe.fQb;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), u.a.album_choose_icon);
                                imageView2 = this.fQe.fQd;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fQe.bnt();
                    }
                }
            }
        }
    }
}
