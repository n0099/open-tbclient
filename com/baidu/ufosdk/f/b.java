package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f22698c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f22699d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f22699d = aVar;
        this.f22696a = str;
        this.f22697b = str2;
        this.f22698c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f22696a);
            if (a2 == null) {
                this.f22698c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f22694b;
            hashMap.put(this.f22697b, new SoftReference(a2));
            f.a().a(a2, this.f22697b);
            this.f22698c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
