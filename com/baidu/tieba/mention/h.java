package com.baidu.tieba.mention;

import android.widget.ImageView;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ g a;
    private final /* synthetic */ ImageView b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, ImageView imageView, String str) {
        this.a = gVar;
        this.b = imageView;
        this.c = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            this.b.setTag(null);
            aVar.a(this.b);
            return;
        }
        this.b.setTag(this.c);
        this.b.setImageResource(com.baidu.tieba.q.photo);
    }
}
