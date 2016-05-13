package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e eXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.eXO = eVar;
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
        ImageFileInfo qK;
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
        jVar = this.eXO.eXM;
        if (jVar != null) {
            oVar = this.eXO.eXw;
            if (oVar != null) {
                albumActivity = this.eXO.eXL;
                if (albumActivity != null) {
                    jVar2 = this.eXO.eXM;
                    i = this.eXO.asz;
                    if (jVar2.qL(i)) {
                        oVar2 = this.eXO.eXw;
                        if ("-1".equals(oVar2.bbF())) {
                            jVar4 = this.eXO.eXM;
                            i7 = this.eXO.asz;
                            qK = jVar4.qK(i7 + 1);
                        } else {
                            jVar3 = this.eXO.eXM;
                            i2 = this.eXO.asz;
                            qK = jVar3.qK(i2);
                        }
                        oVar3 = this.eXO.eXw;
                        if (oVar3.isAdded(qK)) {
                            albumActivity6 = this.eXO.eXL;
                            if (albumActivity6.d(qK)) {
                                e eVar = this.eXO;
                                imageView3 = this.eXO.eXN;
                                eVar.b(imageView3, false);
                                oVar5 = this.eXO.eXw;
                                if ("-1".equals(oVar5.bbF())) {
                                    albumActivity8 = this.eXO.eXL;
                                    i6 = this.eXO.asz;
                                    albumActivity8.C(i6 + 1, false);
                                } else {
                                    albumActivity7 = this.eXO.eXL;
                                    i5 = this.eXO.asz;
                                    albumActivity7.C(i5, false);
                                }
                            }
                        } else {
                            albumActivity2 = this.eXO.eXL;
                            if (albumActivity2.c(qK)) {
                                e eVar2 = this.eXO;
                                imageView = this.eXO.eXN;
                                eVar2.b(imageView, true);
                                oVar4 = this.eXO.eXw;
                                if ("-1".equals(oVar4.bbF())) {
                                    albumActivity5 = this.eXO.eXL;
                                    i4 = this.eXO.asz;
                                    albumActivity5.C(i4 + 1, true);
                                } else {
                                    albumActivity3 = this.eXO.eXL;
                                    i3 = this.eXO.asz;
                                    albumActivity3.C(i3, true);
                                }
                                albumActivity4 = this.eXO.eXL;
                                Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), t.a.album_choose_icon);
                                imageView2 = this.eXO.eXN;
                                imageView2.startAnimation(loadAnimation);
                            }
                        }
                        this.eXO.bbB();
                    }
                }
            }
        }
    }
}
