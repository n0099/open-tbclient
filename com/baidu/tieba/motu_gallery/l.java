package com.baidu.tieba.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends Thread {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        byte[] bArr;
        ArrayList arrayList;
        Map map;
        Map map2;
        u unused;
        bArr = this.a.s;
        synchronized (bArr) {
            try {
                arrayList = this.a.f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c a = JigsawAlbumActivity.a(this.a, ((c) it.next()).a);
                    map = this.a.h;
                    if (!map.containsKey(a.b)) {
                        unused = this.a.k;
                        Bitmap a2 = u.a(this.a, a, this.a.a(70.0f));
                        map2 = this.a.h;
                        map2.put(a.b, a2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
