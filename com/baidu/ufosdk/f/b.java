package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22582a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f22584c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f22585d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f22585d = aVar;
        this.f22582a = str;
        this.f22583b = str2;
        this.f22584c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f22582a);
            if (a2 == null) {
                this.f22584c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f22580b;
            hashMap.put(this.f22583b, new SoftReference(a2));
            f.a().a(a2, this.f22583b);
            this.f22584c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
