package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c dlH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dlH = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        int i;
        m mVar;
        AlbumActivity albumActivity;
        h hVar3;
        int i2;
        m mVar2;
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
        hVar = this.dlH.dlF;
        if (hVar != null) {
            hVar2 = this.dlH.dlF;
            i = this.dlH.aru;
            ImageFileInfo lW = hVar2.lW(i);
            mVar = this.dlH.dlv;
            if (mVar != null) {
                albumActivity = this.dlH.dlE;
                if (albumActivity != null) {
                    hVar3 = this.dlH.dlF;
                    i2 = this.dlH.aru;
                    if (hVar3.lX(i2)) {
                        mVar2 = this.dlH.dlv;
                        if (mVar2.isAdded(lW)) {
                            albumActivity5 = this.dlH.dlE;
                            if (albumActivity5.d(lW)) {
                                c cVar = this.dlH;
                                imageView3 = this.dlH.dlG;
                                cVar.b(imageView3, false);
                                albumActivity6 = this.dlH.dlE;
                                i4 = this.dlH.aru;
                                albumActivity6.u(i4, false);
                            }
                        } else {
                            albumActivity2 = this.dlH.dlE;
                            if (albumActivity2.c(lW)) {
                                c cVar2 = this.dlH;
                                imageView = this.dlH.dlG;
                                cVar2.b(imageView, true);
                                albumActivity3 = this.dlH.dlE;
                                i3 = this.dlH.aru;
                                albumActivity3.u(i3, true);
                                albumActivity4 = this.dlH.dlE;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), i.a.album_choose_icon);
                                imageView2 = this.dlH.dlG;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.dlH.aBY();
                    }
                }
            }
        }
    }
}
