package com.baidu.tieba.pb.view;

import android.widget.ImageView;
import com.baidu.tieba.pb.pb.main.view.c;
/* loaded from: classes.dex */
class s implements c.a {
    final /* synthetic */ r eLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.eLW = rVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.c.a
    public void aRu() {
        l lVar;
        ImageView imageView;
        l lVar2;
        ImageView imageView2;
        l lVar3;
        ImageView imageView3;
        l lVar4;
        ImageView imageView4;
        lVar = this.eLW.eLV;
        imageView = lVar.eLP;
        imageView.setVisibility(8);
        lVar2 = this.eLW.eLV;
        imageView2 = lVar2.eLP;
        if (imageView2.getTag() != null) {
            lVar4 = this.eLW.eLV;
            imageView4 = lVar4.eLP;
            ((com.baidu.tieba.pb.pb.main.view.c) imageView4.getTag()).stop();
        }
        lVar3 = this.eLW.eLV;
        imageView3 = lVar3.eLP;
        imageView3.setTag(null);
    }
}
