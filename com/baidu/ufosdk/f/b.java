package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23337a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23338b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f23339c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f23340d;

    public b(a aVar, String str, String str2, n nVar) {
        this.f23340d = aVar;
        this.f23337a = str;
        this.f23338b = str2;
        this.f23339c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        try {
            Bitmap a2 = a.a(this.f23337a);
            if (a2 == null) {
                this.f23339c.obtainMessage(0, null).sendToTarget();
                return;
            }
            hashMap = a.f23335b;
            hashMap.put(this.f23338b, new SoftReference(a2));
            f.a().a(a2, this.f23338b);
            this.f23339c.obtainMessage(0, a2).sendToTarget();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            c.d(e3.toString());
            System.gc();
        }
    }
}
