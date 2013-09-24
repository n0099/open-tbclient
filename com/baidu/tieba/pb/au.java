package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class au extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.f1540a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        br brVar;
        com.baidu.tieba.model.bj bjVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                brVar = this.f1540a.t;
                brVar.a(bitmap);
                bjVar = this.f1540a.p;
                bjVar.a(true);
            }
        }
    }
}
