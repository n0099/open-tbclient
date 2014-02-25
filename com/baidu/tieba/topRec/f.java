package com.baidu.tieba.topRec;

import android.widget.ImageView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ e a;
    private final /* synthetic */ String b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, ImageView imageView) {
        this.a = eVar;
        this.b = str;
        this.c = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (str.equals(this.b)) {
            this.c.setTag(this.b);
            this.c.invalidate();
        }
    }
}
