package com.baidu.tieba.pb.view;

import android.widget.ImageView;
import com.baidu.tieba.pb.pb.main.view.c;
/* loaded from: classes.dex */
class s implements c.a {
    final /* synthetic */ r eCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.eCz = rVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.c.a
    public void aNu() {
        l lVar;
        ImageView imageView;
        l lVar2;
        ImageView imageView2;
        l lVar3;
        ImageView imageView3;
        l lVar4;
        ImageView imageView4;
        lVar = this.eCz.eCy;
        imageView = lVar.eCs;
        imageView.setVisibility(8);
        lVar2 = this.eCz.eCy;
        imageView2 = lVar2.eCs;
        if (imageView2.getTag() != null) {
            lVar4 = this.eCz.eCy;
            imageView4 = lVar4.eCs;
            ((com.baidu.tieba.pb.pb.main.view.c) imageView4.getTag()).stop();
        }
        lVar3 = this.eCz.eCy;
        imageView3 = lVar3.eCs;
        imageView3.setTag(null);
    }
}
