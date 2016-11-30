package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e gjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.gjX = eVar;
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
        ImageFileInfo tG;
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
        jVar = this.gjX.gjV;
        if (jVar != null) {
            oVar = this.gjX.gjE;
            if (oVar != null) {
                albumActivity = this.gjX.gjT;
                if (albumActivity != null) {
                    jVar2 = this.gjX.gjV;
                    i = this.gjX.axF;
                    if (jVar2.tH(i)) {
                        oVar2 = this.gjX.gjE;
                        if ("-1".equals(oVar2.buO())) {
                            jVar4 = this.gjX.gjV;
                            i7 = this.gjX.axF;
                            tG = jVar4.tG(i7 + 1);
                        } else {
                            jVar3 = this.gjX.gjV;
                            i2 = this.gjX.axF;
                            tG = jVar3.tG(i2);
                        }
                        oVar3 = this.gjX.gjE;
                        if (oVar3.isAdded(tG)) {
                            albumActivity6 = this.gjX.gjT;
                            if (albumActivity6.e(tG)) {
                                e eVar = this.gjX;
                                imageView3 = this.gjX.gjW;
                                eVar.b(imageView3, false);
                                oVar5 = this.gjX.gjE;
                                if ("-1".equals(oVar5.buO())) {
                                    albumActivity8 = this.gjX.gjT;
                                    i6 = this.gjX.axF;
                                    albumActivity8.Z(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.gjX.gjT;
                                    i5 = this.gjX.axF;
                                    albumActivity7.Z(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.gjX.gjT;
                            if (albumActivity2.d(tG)) {
                                e eVar2 = this.gjX;
                                imageView = this.gjX.gjW;
                                eVar2.b(imageView, true);
                                oVar4 = this.gjX.gjE;
                                if ("-1".equals(oVar4.buO())) {
                                    albumActivity5 = this.gjX.gjT;
                                    i4 = this.gjX.axF;
                                    albumActivity5.Z(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.gjX.gjT;
                                    i3 = this.gjX.axF;
                                    albumActivity3.Z(i3, true);
                                }
                                albumActivity4 = this.gjX.gjT;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), r.a.album_choose_icon);
                                imageView2 = this.gjX.gjW;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.gjX.buK();
                    }
                }
            }
        }
    }
}
