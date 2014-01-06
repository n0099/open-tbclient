package com.baidu.tieba.topRec;

import android.widget.ImageView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ String a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, ImageView imageView) {
        this.c = eVar;
        this.a = str;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (str.equals(this.a)) {
            this.b.setTag(this.a);
            this.b.invalidate();
        }
    }
}
