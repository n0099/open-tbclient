package com.baidu.tieba.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c b;
        Map map;
        u uVar;
        Map map2;
        bArr = this.a.s;
        synchronized (bArr) {
            try {
                arrayList = this.a.f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b = this.a.b(((c) it.next()).a);
                    map = this.a.h;
                    if (!map.containsKey(b.b)) {
                        uVar = this.a.k;
                        Bitmap a = uVar.a(this.a, b, this.a.a(70.0f));
                        map2 = this.a.h;
                        map2.put(b.b, a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
