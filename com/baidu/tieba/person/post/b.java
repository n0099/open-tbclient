package com.baidu.tieba.person.post;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        com.baidu.adp.widget.ImageView.b bVar2;
        if (bVar != null) {
            a.j = bVar;
            a.k = this.b;
            HeadImageView headImageView = this.a.b;
            bVar2 = a.j;
            headImageView.setImageBitmap(bVar2.h());
        }
    }
}
