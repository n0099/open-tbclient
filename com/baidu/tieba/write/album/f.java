package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e gcs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.gcs = eVar;
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
        ImageFileInfo tk;
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
        jVar = this.gcs.gcq;
        if (jVar != null) {
            oVar = this.gcs.gbZ;
            if (oVar != null) {
                albumActivity = this.gcs.gco;
                if (albumActivity != null) {
                    jVar2 = this.gcs.gcq;
                    i = this.gcs.awO;
                    if (jVar2.tl(i)) {
                        oVar2 = this.gcs.gbZ;
                        if ("-1".equals(oVar2.bst())) {
                            jVar4 = this.gcs.gcq;
                            i7 = this.gcs.awO;
                            tk = jVar4.tk(i7 + 1);
                        } else {
                            jVar3 = this.gcs.gcq;
                            i2 = this.gcs.awO;
                            tk = jVar3.tk(i2);
                        }
                        oVar3 = this.gcs.gbZ;
                        if (oVar3.isAdded(tk)) {
                            albumActivity6 = this.gcs.gco;
                            if (albumActivity6.e(tk)) {
                                e eVar = this.gcs;
                                imageView3 = this.gcs.gcr;
                                eVar.b(imageView3, false);
                                oVar5 = this.gcs.gbZ;
                                if ("-1".equals(oVar5.bst())) {
                                    albumActivity8 = this.gcs.gco;
                                    i6 = this.gcs.awO;
                                    albumActivity8.W(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.gcs.gco;
                                    i5 = this.gcs.awO;
                                    albumActivity7.W(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.gcs.gco;
                            if (albumActivity2.d(tk)) {
                                e eVar2 = this.gcs;
                                imageView = this.gcs.gcr;
                                eVar2.b(imageView, true);
                                oVar4 = this.gcs.gbZ;
                                if ("-1".equals(oVar4.bst())) {
                                    albumActivity5 = this.gcs.gco;
                                    i4 = this.gcs.awO;
                                    albumActivity5.W(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.gcs.gco;
                                    i3 = this.gcs.awO;
                                    albumActivity3.W(i3, true);
                                }
                                albumActivity4 = this.gcs.gco;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), r.a.album_choose_icon);
                                imageView2 = this.gcs.gcr;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.gcs.bsp();
                    }
                }
            }
        }
    }
}
