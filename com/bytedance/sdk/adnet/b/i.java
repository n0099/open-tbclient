package com.bytedance.sdk.adnet.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.p;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes4.dex */
public class i<T> implements p.a<T>, Future<p<T>> {

    /* renamed from: b  reason: collision with root package name */
    private boolean f6003b = false;
    private Request<?> pkv;
    private p<T> pky;

    public static <E> i<E> eop() {
        return new i<>();
    }

    private i() {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.pkv != null && !isDone()) {
                this.pkv.cancel();
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: eoo */
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
        if (this.f6003b) {
            pVar = this.pky;
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
            if (!this.f6003b) {
                throw new TimeoutException();
            }
            pVar = this.pky;
        }
        return pVar;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.pkv == null) {
            return false;
        }
        return this.pkv.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f6003b) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public synchronized void a(p<T> pVar) {
        this.f6003b = true;
        this.pky = pVar;
        notifyAll();
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public synchronized void b(p<T> pVar) {
        this.f6003b = true;
        this.pky = pVar;
        notifyAll();
    }
}
