package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.a.g {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        cr crVar;
        com.baidu.tieba.model.bs bsVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                crVar = this.a.x;
                crVar.a(bitmap);
                bsVar = this.a.t;
                bsVar.a(true);
            }
        }
    }
}
