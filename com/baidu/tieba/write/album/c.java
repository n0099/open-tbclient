package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b cyd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cyd = bVar;
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
        jVar = this.cyd.cya;
        if (jVar != null) {
            jVar2 = this.cyd.cya;
            i = this.cyd.mCurrentIndex;
            ImageFileInfo jm = jVar2.jm(i);
            pVar = this.cyd.cxU;
            if (pVar != null) {
                albumActivity = this.cyd.cxZ;
                if (albumActivity != null) {
                    jVar3 = this.cyd.cya;
                    i2 = this.cyd.mCurrentIndex;
                    if (jVar3.jn(i2)) {
                        pVar2 = this.cyd.cxU;
                        if (pVar2.isAdded(jm)) {
                            albumActivity5 = this.cyd.cxZ;
                            if (albumActivity5.d(jm)) {
                                b bVar = this.cyd;
                                imageView3 = this.cyd.cyb;
                                bVar.b(imageView3, false);
                                albumActivity6 = this.cyd.cxZ;
                                i4 = this.cyd.mCurrentIndex;
                                albumActivity6.s(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.cyd.cxZ;
                        if (albumActivity2.c(jm)) {
                            b bVar2 = this.cyd;
                            imageView = this.cyd.cyb;
                            bVar2.b(imageView, true);
                            albumActivity3 = this.cyd.cxZ;
                            i3 = this.cyd.mCurrentIndex;
                            albumActivity3.s(i3, true);
                            albumActivity4 = this.cyd.cxZ;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.k.album_choose_icon);
                            imageView2 = this.cyd.cyb;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
