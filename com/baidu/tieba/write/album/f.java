package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e eGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.eGV = eVar;
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
        ImageFileInfo qo;
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
        jVar = this.eGV.eGT;
        if (jVar != null) {
            oVar = this.eGV.eGD;
            if (oVar != null) {
                albumActivity = this.eGV.eGS;
                if (albumActivity != null) {
                    jVar2 = this.eGV.eGT;
                    i = this.eGV.awy;
                    if (jVar2.qp(i)) {
                        oVar2 = this.eGV.eGD;
                        if ("-1".equals(oVar2.aZj())) {
                            jVar4 = this.eGV.eGT;
                            i7 = this.eGV.awy;
                            qo = jVar4.qo(i7 + 1);
                        } else {
                            jVar3 = this.eGV.eGT;
                            i2 = this.eGV.awy;
                            qo = jVar3.qo(i2);
                        }
                        oVar3 = this.eGV.eGD;
                        if (oVar3.isAdded(qo)) {
                            albumActivity6 = this.eGV.eGS;
                            if (albumActivity6.d(qo)) {
                                e eVar = this.eGV;
                                imageView3 = this.eGV.eGU;
                                eVar.b(imageView3, false);
                                oVar5 = this.eGV.eGD;
                                if ("-1".equals(oVar5.aZj())) {
                                    albumActivity8 = this.eGV.eGS;
                                    i6 = this.eGV.awy;
                                    albumActivity8.y(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.eGV.eGS;
                                    i5 = this.eGV.awy;
                                    albumActivity7.y(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.eGV.eGS;
                            if (albumActivity2.c(qo)) {
                                e eVar2 = this.eGV;
                                imageView = this.eGV.eGU;
                                eVar2.b(imageView, true);
                                oVar4 = this.eGV.eGD;
                                if ("-1".equals(oVar4.aZj())) {
                                    albumActivity5 = this.eGV.eGS;
                                    i4 = this.eGV.awy;
                                    albumActivity5.y(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.eGV.eGS;
                                    i3 = this.eGV.awy;
                                    albumActivity3.y(i3, true);
                                }
                                albumActivity4 = this.eGV.eGS;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), t.a.album_choose_icon);
                                imageView2 = this.eGV.eGU;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.eGV.aZe();
                    }
                }
            }
        }
    }
}
