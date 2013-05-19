package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class as extends com.baidu.adp.a.e {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bl blVar;
        com.baidu.tieba.c.ba baVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                blVar = this.a.o;
                blVar.a(bitmap);
                baVar = this.a.k;
                baVar.a(true);
            }
        }
    }
}
