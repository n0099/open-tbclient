package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22940a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22941b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f22942c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f22943d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f22943d = aVar;
        this.f22940a = str;
        this.f22941b = str2;
        this.f22942c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f22940a);
            if (a2 == null) {
                this.f22942c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f22938b;
            hashMap.put(this.f22941b, new SoftReference(a2));
            f.a().a(a2, this.f22941b);
            this.f22942c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
