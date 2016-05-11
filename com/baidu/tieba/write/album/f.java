package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e eXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.eXP = eVar;
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
        ImageFileInfo qL;
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
        jVar = this.eXP.eXN;
        if (jVar != null) {
            oVar = this.eXP.eXx;
            if (oVar != null) {
                albumActivity = this.eXP.eXM;
                if (albumActivity != null) {
                    jVar2 = this.eXP.eXN;
                    i = this.eXP.asz;
                    if (jVar2.qM(i)) {
                        oVar2 = this.eXP.eXx;
                        if ("-1".equals(oVar2.bby())) {
                            jVar4 = this.eXP.eXN;
                            i7 = this.eXP.asz;
                            qL = jVar4.qL(i7 + 1);
                        } else {
                            jVar3 = this.eXP.eXN;
                            i2 = this.eXP.asz;
                            qL = jVar3.qL(i2);
                        }
                        oVar3 = this.eXP.eXx;
                        if (oVar3.isAdded(qL)) {
                            albumActivity6 = this.eXP.eXM;
                            if (albumActivity6.d(qL)) {
                                e eVar = this.eXP;
                                imageView3 = this.eXP.eXO;
                                eVar.b(imageView3, false);
                                oVar5 = this.eXP.eXx;
                                if ("-1".equals(oVar5.bby())) {
                                    albumActivity8 = this.eXP.eXM;
                                    i6 = this.eXP.asz;
                                    albumActivity8.C(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.eXP.eXM;
                                    i5 = this.eXP.asz;
                                    albumActivity7.C(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.eXP.eXM;
                            if (albumActivity2.c(qL)) {
                                e eVar2 = this.eXP;
                                imageView = this.eXP.eXO;
                                eVar2.b(imageView, true);
                                oVar4 = this.eXP.eXx;
                                if ("-1".equals(oVar4.bby())) {
                                    albumActivity5 = this.eXP.eXM;
                                    i4 = this.eXP.asz;
                                    albumActivity5.C(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.eXP.eXM;
                                    i3 = this.eXP.asz;
                                    albumActivity3.C(i3, true);
                                }
                                albumActivity4 = this.eXP.eXM;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), t.a.album_choose_icon);
                                imageView2 = this.eXP.eXO;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.eXP.bbu();
                    }
                }
            }
        }
    }
}
