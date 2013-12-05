package com.baidu.tieba.motu_gallery;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumActivity f2121a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(JigsawAlbumActivity jigsawAlbumActivity) {
        this.f2121a = jigsawAlbumActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        ArrayList arrayList;
        c b;
        Map map;
        u uVar;
        Map map2;
        bArr = this.f2121a.s;
        synchronized (bArr) {
            try {
                arrayList = this.f2121a.f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b = this.f2121a.b(((c) it.next()).f2112a);
                    map = this.f2121a.h;
                    if (!map.containsKey(b.b)) {
                        uVar = this.f2121a.k;
                        Bitmap a2 = uVar.a(this.f2121a, b, this.f2121a.a(70.0f));
                        map2 = this.f2121a.h;
                        map2.put(b.b, a2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
