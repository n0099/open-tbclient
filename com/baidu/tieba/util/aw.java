package com.baidu.tieba.util;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f2433a;
    final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar, ba baVar) {
        this.b = auVar;
        this.f2433a = baVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        Bitmap f;
        com.baidu.adp.widget.ImageView.e d = com.baidu.tbadk.imageManager.d.a().d(str);
        if (d != null && (f = d.f()) != null && this.f2433a != null) {
            this.f2433a.a(f);
        }
    }
}
