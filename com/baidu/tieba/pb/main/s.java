package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class s extends com.baidu.adp.base.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bs bsVar;
        com.baidu.tieba.model.ar arVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bsVar = this.a.E;
                bsVar.a(bitmap);
                arVar = this.a.A;
                arVar.a(true);
            }
        }
    }
}
