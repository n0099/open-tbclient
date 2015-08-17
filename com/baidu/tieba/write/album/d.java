package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cPT = cVar;
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
        hVar = this.cPT.cPR;
        if (hVar != null) {
            hVar2 = this.cPT.cPR;
            i = this.cPT.apO;
            ImageFileInfo kg = hVar2.kg(i);
            mVar = this.cPT.cPJ;
            if (mVar != null) {
                albumActivity = this.cPT.cPQ;
                if (albumActivity != null) {
                    hVar3 = this.cPT.cPR;
                    i2 = this.cPT.apO;
                    if (hVar3.kh(i2)) {
                        mVar2 = this.cPT.cPJ;
                        if (mVar2.isAdded(kg)) {
                            albumActivity5 = this.cPT.cPQ;
                            if (albumActivity5.d(kg)) {
                                c cVar = this.cPT;
                                imageView3 = this.cPT.cPS;
                                cVar.b(imageView3, false);
                                albumActivity6 = this.cPT.cPQ;
                                i4 = this.cPT.apO;
                                albumActivity6.q(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.cPT.cPQ;
                        if (albumActivity2.c(kg)) {
                            c cVar2 = this.cPT;
                            imageView = this.cPT.cPS;
                            cVar2.b(imageView, true);
                            albumActivity3 = this.cPT.cPQ;
                            i3 = this.cPT.apO;
                            albumActivity3.q(i3, true);
                            albumActivity4 = this.cPT.cPQ;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), i.a.album_choose_icon);
                            imageView2 = this.cPT.cPS;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
