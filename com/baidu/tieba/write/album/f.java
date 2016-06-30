package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e fCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.fCS = eVar;
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
        ImageFileInfo sb;
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
        jVar = this.fCS.fCQ;
        if (jVar != null) {
            oVar = this.fCS.fCA;
            if (oVar != null) {
                albumActivity = this.fCS.fCP;
                if (albumActivity != null) {
                    jVar2 = this.fCS.fCQ;
                    i = this.fCS.atp;
                    if (jVar2.sc(i)) {
                        oVar2 = this.fCS.fCA;
                        if ("-1".equals(oVar2.bkb())) {
                            jVar4 = this.fCS.fCQ;
                            i7 = this.fCS.atp;
                            sb = jVar4.sb(i7 + 1);
                        } else {
                            jVar3 = this.fCS.fCQ;
                            i2 = this.fCS.atp;
                            sb = jVar3.sb(i2);
                        }
                        oVar3 = this.fCS.fCA;
                        if (oVar3.isAdded(sb)) {
                            albumActivity6 = this.fCS.fCP;
                            if (albumActivity6.e(sb)) {
                                e eVar = this.fCS;
                                imageView3 = this.fCS.fCR;
                                eVar.b(imageView3, false);
                                oVar5 = this.fCS.fCA;
                                if ("-1".equals(oVar5.bkb())) {
                                    albumActivity8 = this.fCS.fCP;
                                    i6 = this.fCS.atp;
                                    albumActivity8.Q(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.fCS.fCP;
                                    i5 = this.fCS.atp;
                                    albumActivity7.Q(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.fCS.fCP;
                            if (albumActivity2.d(sb)) {
                                e eVar2 = this.fCS;
                                imageView = this.fCS.fCR;
                                eVar2.b(imageView, true);
                                oVar4 = this.fCS.fCA;
                                if ("-1".equals(oVar4.bkb())) {
                                    albumActivity5 = this.fCS.fCP;
                                    i4 = this.fCS.atp;
                                    albumActivity5.Q(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.fCS.fCP;
                                    i3 = this.fCS.atp;
                                    albumActivity3.Q(i3, true);
                                }
                                albumActivity4 = this.fCS.fCP;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), u.a.album_choose_icon);
                                imageView2 = this.fCS.fCR;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.fCS.bjX();
                    }
                }
            }
        }
    }
}
