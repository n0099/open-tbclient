package com.baidu.tieba.util;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1748a;
    private final /* synthetic */ ag b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, ag agVar) {
        this.f1748a = aaVar;
        this.b = agVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        Bitmap f;
        com.baidu.adp.widget.a.b d = com.baidu.tbadk.a.e.a().d(str);
        if (d != null && (f = d.f()) != null && this.b != null) {
            this.b.a(f);
        }
    }
}
