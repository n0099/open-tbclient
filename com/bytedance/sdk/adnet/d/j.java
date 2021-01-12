package com.bytedance.sdk.adnet.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f6060a;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Message message);
    }

    public j(Looper looper, a aVar) {
        super(looper);
        this.f6060a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f6060a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
