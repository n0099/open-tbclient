package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b ctO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ctO = bVar;
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
        hVar = this.ctO.ctL;
        if (hVar != null) {
            hVar2 = this.ctO.ctL;
            i = this.ctO.mCurrentIndex;
            ImageFileInfo iQ = hVar2.iQ(i);
            nVar = this.ctO.ctF;
            if (nVar != null) {
                albumActivity = this.ctO.ctK;
                if (albumActivity != null) {
                    hVar3 = this.ctO.ctL;
                    i2 = this.ctO.mCurrentIndex;
                    if (hVar3.iR(i2)) {
                        nVar2 = this.ctO.ctF;
                        if (nVar2.isAdded(iQ)) {
                            albumActivity5 = this.ctO.ctK;
                            if (albumActivity5.d(iQ)) {
                                b bVar = this.ctO;
                                imageView3 = this.ctO.ctM;
                                bVar.b(imageView3, false);
                                albumActivity6 = this.ctO.ctK;
                                i4 = this.ctO.mCurrentIndex;
                                albumActivity6.t(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.ctO.ctK;
                        if (albumActivity2.c(iQ)) {
                            b bVar2 = this.ctO;
                            imageView = this.ctO.ctM;
                            bVar2.b(imageView, true);
                            albumActivity3 = this.ctO.ctK;
                            i3 = this.ctO.mCurrentIndex;
                            albumActivity3.t(i3, true);
                            albumActivity4 = this.ctO.ctK;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.p.album_choose_icon);
                            imageView2 = this.ctO.ctM;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
