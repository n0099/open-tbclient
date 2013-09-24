package com.baidu.tieba.util;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1903a;
    private final /* synthetic */ ar b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, ar arVar) {
        this.f1903a = alVar;
        this.b = arVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        Bitmap f;
        com.baidu.adp.widget.a.c d = com.baidu.tbadk.a.e.a().d(str);
        if (d != null && (f = d.f()) != null && this.b != null) {
            this.b.a(f);
        }
    }
}
