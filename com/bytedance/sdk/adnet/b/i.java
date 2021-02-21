package com.bytedance.sdk.adnet.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.p;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class i<T> implements p.a<T>, Future<p<T>> {

    /* renamed from: b  reason: collision with root package name */
    private boolean f6005b = false;
    private Request<?> pvl;
    private p<T> pvo;

    public static <E> i<E> eqP() {
        return new i<>();
    }

    private i() {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.pvl != null && !isDone()) {
                this.pvl.cancel();
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: eqO */
    public p<T> get() throws InterruptedException {
        try {
            return i(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: g */
    public p<T> get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return i(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized p<T> i(Long l) throws InterruptedException, TimeoutException {
        p<T> pVar;
        if (this.f6005b) {
            pVar = this.pvo;
        } else {
            if (l == null) {
                while (!isDone()) {
                    wait(0L);
                }
            } else if (l.longValue() > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                long longValue = l.longValue() + uptimeMillis;
                while (!isDone() && uptimeMillis < longValue) {
                    wait(longValue - uptimeMillis);
                    uptimeMillis = SystemClock.uptimeMillis();
                }
            }
            if (!this.f6005b) {
                throw new TimeoutException();
            }
            pVar = this.pvo;
        }
        return pVar;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.pvl == null) {
            return false;
        }
        return this.pvl.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f6005b) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public synchronized void a(p<T> pVar) {
        this.f6005b = true;
        this.pvo = pVar;
        notifyAll();
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public synchronized void b(p<T> pVar) {
        this.f6005b = true;
        this.pvo = pVar;
        notifyAll();
    }
}
