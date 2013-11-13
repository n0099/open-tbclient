package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewPbActivity newPbActivity) {
        this.f2088a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        cp cpVar;
        com.baidu.tieba.model.bs bsVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                cpVar = this.f2088a.y;
                cpVar.a(bitmap);
                bsVar = this.f2088a.u;
                bsVar.a(true);
            }
        }
    }
}
