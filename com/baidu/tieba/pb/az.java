package com.baidu.tieba.pb;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class az extends com.baidu.adp.a.g {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        cu cuVar;
        com.baidu.tieba.model.bk bkVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                cuVar = this.a.C;
                cuVar.a(bitmap);
                bkVar = this.a.y;
                bkVar.a(true);
            }
        }
    }
}
