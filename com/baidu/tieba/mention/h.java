package com.baidu.tieba.mention;

import android.widget.ImageView;
/* loaded from: classes.dex */
final class h implements com.baidu.tbadk.imageManager.d {
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
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.setTag(null);
            bVar.a(this.b);
            return;
        }
        this.b.setTag(this.c);
        this.b.setImageResource(com.baidu.tieba.a.g.photo);
    }
}
