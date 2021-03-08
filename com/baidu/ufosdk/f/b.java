package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3618a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2, n nVar) {
        this.d = aVar;
        this.f3618a = str;
        this.b = str2;
        this.c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f3618a);
            if (a2 != null) {
                hashMap = a.b;
                hashMap.put(this.b, new SoftReference(a2));
                f.a().a(a2, this.b);
                this.c.obtainMessage(0, a2).sendToTarget();
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
