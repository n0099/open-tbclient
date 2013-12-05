package com.baidu.tieba.topRec;

import android.widget.ImageView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2549a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, ImageView imageView) {
        this.c = eVar;
        this.f2549a = str;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (str.equals(this.f2549a)) {
            this.b.setTag(this.f2549a);
            this.b.invalidate();
        }
    }
}
