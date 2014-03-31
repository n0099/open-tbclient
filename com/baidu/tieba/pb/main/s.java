package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
final class s extends com.baidu.adp.a.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        bk bkVar;
        com.baidu.tieba.model.ar arVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bkVar = this.a.D;
                bkVar.a(bitmap);
                arVar = this.a.z;
                arVar.a(true);
            }
        }
    }
}
