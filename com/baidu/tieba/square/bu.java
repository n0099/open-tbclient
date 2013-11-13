package com.baidu.tieba.square;

import android.widget.ImageView;
/* loaded from: classes.dex */
class bu implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f2415a;
    final /* synthetic */ bt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar, ImageView imageView) {
        this.b = btVar;
        this.f2415a = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f2415a.invalidate();
        }
    }
}
