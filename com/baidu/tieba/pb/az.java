package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class az extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f2062a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bt btVar;
        com.baidu.tieba.model.br brVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                btVar = this.f2062a.u;
                btVar.a(bitmap);
                brVar = this.f2062a.q;
                brVar.a(true);
            }
        }
    }
}
