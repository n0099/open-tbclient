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
        bk bkVar;
        com.baidu.tieba.c.bd bdVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bkVar = this.a.o;
                bkVar.a(bitmap);
                bdVar = this.a.k;
                bdVar.a(true);
            }
        }
    }
}
