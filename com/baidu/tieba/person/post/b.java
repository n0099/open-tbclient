package com.baidu.tieba.person.post;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        com.baidu.adp.widget.ImageView.d dVar2;
        if (dVar != null) {
            com.baidu.adp.widget.ImageView.d unused = a.j = dVar;
            String unused2 = a.k = this.a;
            HeadImageView headImageView = this.b.b;
            dVar2 = a.j;
            headImageView.setImageBitmap(dVar2.h());
        }
    }
}
