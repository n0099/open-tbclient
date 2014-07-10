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
        bt btVar;
        com.baidu.tieba.model.aq aqVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                btVar = this.a.D;
                btVar.a(bitmap);
                aqVar = this.a.z;
                aqVar.a(true);
            }
        }
    }
}
