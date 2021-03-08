package com.bytedance.sdk.adnet.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f4057a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public h(Looper looper, a aVar) {
        super(looper);
        this.f4057a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f4057a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
