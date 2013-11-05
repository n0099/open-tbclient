package com.baidu.tieba.square;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f2378a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, ImageView imageView) {
        this.b = tVar;
        this.f2378a = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.b.a(this.f2378a, eVar.f());
        }
    }
}
