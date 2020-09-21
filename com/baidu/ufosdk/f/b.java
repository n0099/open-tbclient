package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2, n nVar) {
        this.d = aVar;
        this.a = str;
        this.b = str2;
        this.c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a = a.a(this.a);
            if (a != null) {
                hashMap = a.b;
                hashMap.put(this.b, new SoftReference(a));
                f.a().a(a, this.b);
                this.c.obtainMessage(0, a).sendToTarget();
            } else {
                this.c.obtainMessage(0, null).sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            c.d(e2.toString());
            System.gc();
        }
    }
}
