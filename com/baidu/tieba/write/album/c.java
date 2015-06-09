package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b cye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cye = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        int i;
        p pVar;
        AlbumActivity albumActivity;
        j jVar3;
        int i2;
        p pVar2;
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
        jVar = this.cye.cyb;
        if (jVar != null) {
            jVar2 = this.cye.cyb;
            i = this.cye.mCurrentIndex;
            ImageFileInfo jm = jVar2.jm(i);
            pVar = this.cye.cxV;
            if (pVar != null) {
                albumActivity = this.cye.cya;
                if (albumActivity != null) {
                    jVar3 = this.cye.cyb;
                    i2 = this.cye.mCurrentIndex;
                    if (jVar3.jn(i2)) {
                        pVar2 = this.cye.cxV;
                        if (pVar2.isAdded(jm)) {
                            albumActivity5 = this.cye.cya;
                            if (albumActivity5.d(jm)) {
                                b bVar = this.cye;
                                imageView3 = this.cye.cyc;
                                bVar.b(imageView3, false);
                                albumActivity6 = this.cye.cya;
                                i4 = this.cye.mCurrentIndex;
                                albumActivity6.s(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.cye.cya;
                        if (albumActivity2.c(jm)) {
                            b bVar2 = this.cye;
                            imageView = this.cye.cyc;
                            bVar2.b(imageView, true);
                            albumActivity3 = this.cye.cya;
                            i3 = this.cye.mCurrentIndex;
                            albumActivity3.s(i3, true);
                            albumActivity4 = this.cye.cya;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.k.album_choose_icon);
                            imageView2 = this.cye.cyc;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
