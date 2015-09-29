package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b djz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.djz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        int i;
        l lVar;
        AlbumActivity albumActivity;
        g gVar3;
        int i2;
        l lVar2;
        AlbumActivity albumActivity2;
        ImageView imageView;
        AlbumActivity albumActivity3;
        int i3;
        AlbumActivity albumActivity4;
        ImageView imageView2;
        AlbumActivity albumActivity5;
        ImageView imageView3;
        AlbumActivity albumActivity6;
        int i4;
        gVar = this.djz.djx;
        if (gVar != null) {
            gVar2 = this.djz.djx;
            i = this.djz.apY;
            ImageFileInfo lG = gVar2.lG(i);
            lVar = this.djz.djp;
            if (lVar != null) {
                albumActivity = this.djz.djw;
                if (albumActivity != null) {
                    gVar3 = this.djz.djx;
                    i2 = this.djz.apY;
                    if (gVar3.lH(i2)) {
                        lVar2 = this.djz.djp;
                        if (lVar2.isAdded(lG)) {
                            albumActivity5 = this.djz.djw;
                            if (albumActivity5.d(lG)) {
                                b bVar = this.djz;
                                imageView3 = this.djz.djy;
                                bVar.b(imageView3, false);
                                albumActivity6 = this.djz.djw;
                                i4 = this.djz.apY;
                                albumActivity6.u(i4, false);
                            }
                        } else {
                            albumActivity2 = this.djz.djw;
                            if (albumActivity2.c(lG)) {
                                b bVar2 = this.djz;
                                imageView = this.djz.djy;
                                bVar2.b(imageView, true);
                                albumActivity3 = this.djz.djw;
                                i3 = this.djz.apY;
                                albumActivity3.u(i3, true);
                                albumActivity4 = this.djz.djw;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), i.a.album_choose_icon);
                                imageView2 = this.djz.djy;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.djz.aBc();
                    }
                }
            }
        }
    }
}
