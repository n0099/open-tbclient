package com.baidu.tieba.square;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1856a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, ImageView imageView) {
        this.f1856a = tVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        if (cVar == null) {
            return;
        }
        this.f1856a.a(this.b, cVar.f());
    }
}
