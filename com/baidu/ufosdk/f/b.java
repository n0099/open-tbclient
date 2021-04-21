package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22634a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22635b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f22636c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f22637d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f22637d = aVar;
        this.f22634a = str;
        this.f22635b = str2;
        this.f22636c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f22634a);
            if (a2 == null) {
                this.f22636c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f22632b;
            hashMap.put(this.f22635b, new SoftReference(a2));
            f.a().a(a2, this.f22635b);
            this.f22636c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
