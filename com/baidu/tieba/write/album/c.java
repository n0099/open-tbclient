package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b cty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cty = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        int i;
        n nVar;
        AlbumActivity albumActivity;
        h hVar3;
        int i2;
        n nVar2;
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
        hVar = this.cty.ctv;
        if (hVar != null) {
            hVar2 = this.cty.ctv;
            i = this.cty.mCurrentIndex;
            ImageFileInfo iN = hVar2.iN(i);
            nVar = this.cty.ctp;
            if (nVar != null) {
                albumActivity = this.cty.ctu;
                if (albumActivity != null) {
                    hVar3 = this.cty.ctv;
                    i2 = this.cty.mCurrentIndex;
                    if (hVar3.iO(i2)) {
                        nVar2 = this.cty.ctp;
                        if (nVar2.isAdded(iN)) {
                            albumActivity5 = this.cty.ctu;
                            if (albumActivity5.d(iN)) {
                                b bVar = this.cty;
                                imageView3 = this.cty.ctw;
                                bVar.b(imageView3, false);
                                albumActivity6 = this.cty.ctu;
                                i4 = this.cty.mCurrentIndex;
                                albumActivity6.t(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.cty.ctu;
                        if (albumActivity2.c(iN)) {
                            b bVar2 = this.cty;
                            imageView = this.cty.ctw;
                            bVar2.b(imageView, true);
                            albumActivity3 = this.cty.ctu;
                            i3 = this.cty.mCurrentIndex;
                            albumActivity3.t(i3, true);
                            albumActivity4 = this.cty.ctu;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.p.album_choose_icon);
                            imageView2 = this.cty.ctw;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
