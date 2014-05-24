package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class s extends com.baidu.adp.base.e {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        bq bqVar;
        com.baidu.tieba.model.ar arVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bqVar = this.a.D;
                bqVar.a(bitmap);
                arVar = this.a.z;
                arVar.a(true);
            }
        }
    }
}
