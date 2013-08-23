package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class as extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewPbActivity newPbActivity) {
        this.f1495a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bo boVar;
        com.baidu.tieba.model.bh bhVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                boVar = this.f1495a.q;
                boVar.a(bitmap);
                bhVar = this.f1495a.m;
                bhVar.a(true);
            }
        }
    }
}
