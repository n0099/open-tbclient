package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e dSm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dSm = eVar;
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
        ImageFileInfo oa;
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
        jVar = this.dSm.dSk;
        if (jVar != null) {
            oVar = this.dSm.dRW;
            if (oVar != null) {
                albumActivity = this.dSm.dSj;
                if (albumActivity != null) {
                    jVar2 = this.dSm.dSk;
                    i = this.dSm.auZ;
                    if (jVar2.ob(i)) {
                        oVar2 = this.dSm.dRW;
                        if ("-1".equals(oVar2.aJX())) {
                            jVar4 = this.dSm.dSk;
                            i7 = this.dSm.auZ;
                            oa = jVar4.oa(i7 + 1);
                        } else {
                            jVar3 = this.dSm.dSk;
                            i2 = this.dSm.auZ;
                            oa = jVar3.oa(i2);
                        }
                        oVar3 = this.dSm.dRW;
                        if (oVar3.isAdded(oa)) {
                            albumActivity6 = this.dSm.dSj;
                            if (albumActivity6.b(oa)) {
                                e eVar = this.dSm;
                                imageView3 = this.dSm.dSl;
                                eVar.b(imageView3, false);
                                oVar5 = this.dSm.dRW;
                                if ("-1".equals(oVar5.aJX())) {
                                    albumActivity8 = this.dSm.dSj;
                                    i6 = this.dSm.auZ;
                                    albumActivity8.w(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.dSm.dSj;
                                    i5 = this.dSm.auZ;
                                    albumActivity7.w(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.dSm.dSj;
                            if (albumActivity2.a(oa)) {
                                e eVar2 = this.dSm;
                                imageView = this.dSm.dSl;
                                eVar2.b(imageView, true);
                                oVar4 = this.dSm.dRW;
                                if ("-1".equals(oVar4.aJX())) {
                                    albumActivity5 = this.dSm.dSj;
                                    i4 = this.dSm.auZ;
                                    albumActivity5.w(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.dSm.dSj;
                                    i3 = this.dSm.auZ;
                                    albumActivity3.w(i3, true);
                                }
                                albumActivity4 = this.dSm.dSj;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), n.a.album_choose_icon);
                                imageView2 = this.dSm.dSl;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.dSm.aJQ();
                    }
                }
            }
        }
    }
}
