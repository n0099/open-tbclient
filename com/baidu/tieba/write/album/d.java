package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cYE = cVar;
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
        hVar = this.cYE.cYC;
        if (hVar != null) {
            hVar2 = this.cYE.cYC;
            i = this.cYE.ary;
            ImageFileInfo kR = hVar2.kR(i);
            mVar = this.cYE.cYt;
            if (mVar != null) {
                albumActivity = this.cYE.cYB;
                if (albumActivity != null) {
                    hVar3 = this.cYE.cYC;
                    i2 = this.cYE.ary;
                    if (hVar3.kS(i2)) {
                        mVar2 = this.cYE.cYt;
                        if (mVar2.isAdded(kR)) {
                            albumActivity5 = this.cYE.cYB;
                            if (albumActivity5.d(kR)) {
                                c cVar = this.cYE;
                                imageView3 = this.cYE.cYD;
                                cVar.b(imageView3, false);
                                albumActivity6 = this.cYE.cYB;
                                i4 = this.cYE.ary;
                                albumActivity6.r(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.cYE.cYB;
                        if (albumActivity2.c(kR)) {
                            c cVar2 = this.cYE;
                            imageView = this.cYE.cYD;
                            cVar2.b(imageView, true);
                            albumActivity3 = this.cYE.cYB;
                            i3 = this.cYE.ary;
                            albumActivity3.r(i3, true);
                            albumActivity4 = this.cYE.cYB;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), i.a.album_choose_icon);
                            imageView2 = this.cYE.cYD;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
