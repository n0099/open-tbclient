package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5379a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5380b;
    final /* synthetic */ n c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2, n nVar) {
        this.d = aVar;
        this.f5379a = str;
        this.f5380b = str2;
        this.c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f5379a);
            if (a2 != null) {
                hashMap = a.f5378b;
                hashMap.put(this.f5380b, new SoftReference(a2));
                f.a().a(a2, this.f5380b);
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
