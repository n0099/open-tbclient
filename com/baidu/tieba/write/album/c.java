package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b djZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.djZ = bVar;
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
        gVar = this.djZ.djX;
        if (gVar != null) {
            gVar2 = this.djZ.djX;
            i = this.djZ.apZ;
            ImageFileInfo lI = gVar2.lI(i);
            lVar = this.djZ.djP;
            if (lVar != null) {
                albumActivity = this.djZ.djW;
                if (albumActivity != null) {
                    gVar3 = this.djZ.djX;
                    i2 = this.djZ.apZ;
                    if (gVar3.lJ(i2)) {
                        lVar2 = this.djZ.djP;
                        if (lVar2.isAdded(lI)) {
                            albumActivity5 = this.djZ.djW;
                            if (albumActivity5.d(lI)) {
                                b bVar = this.djZ;
                                imageView3 = this.djZ.djY;
                                bVar.b(imageView3, false);
                                albumActivity6 = this.djZ.djW;
                                i4 = this.djZ.apZ;
                                albumActivity6.u(i4, false);
                            }
                        } else {
                            albumActivity2 = this.djZ.djW;
                            if (albumActivity2.c(lI)) {
                                b bVar2 = this.djZ;
                                imageView = this.djZ.djY;
                                bVar2.b(imageView, true);
                                albumActivity3 = this.djZ.djW;
                                i3 = this.djZ.apZ;
                                albumActivity3.u(i3, true);
                                albumActivity4 = this.djZ.djW;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), i.a.album_choose_icon);
                                imageView2 = this.djZ.djY;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.djZ.aBm();
                    }
                }
            }
        }
    }
}
