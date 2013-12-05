package com.baidu.tieba.square;

import android.widget.ImageView;
/* loaded from: classes.dex */
class bs implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f2515a;
    final /* synthetic */ br b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar, ImageView imageView) {
        this.b = brVar;
        this.f2515a = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f2515a.invalidate();
        }
    }
}
