package com.baidu.tieba.square;

import android.widget.ImageView;
/* loaded from: classes.dex */
class av implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f2354a;
    final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, ImageView imageView) {
        this.b = auVar;
        this.f2354a = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f2354a.invalidate();
        }
    }
}
