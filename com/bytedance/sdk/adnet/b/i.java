package com.bytedance.sdk.adnet.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class i<T> implements o.a<T>, Future<o<T>> {
    private boolean b = false;
    private Request<?> pxq;
    private o<T> pxt;

    public static <E> i<E> eqX() {
        return new i<>();
    }

    private i() {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.pxq != null && !isDone()) {
                this.pxq.cancel();
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: eqW */
    public o<T> get() throws InterruptedException {
        try {
            return i(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: f */
    public o<T> get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return i(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized o<T> i(Long l) throws InterruptedException, TimeoutException {
        o<T> oVar;
        if (this.b) {
            oVar = this.pxt;
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
            if (!this.b) {
                throw new TimeoutException();
            }
            oVar = this.pxt;
        }
        return oVar;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.pxq == null) {
            return false;
        }
        return this.pxq.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.b) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.bytedance.sdk.adnet.core.o.a
    public synchronized void a(o<T> oVar) {
        this.b = true;
        this.pxt = oVar;
        notifyAll();
    }

    @Override // com.bytedance.sdk.adnet.core.o.a
    public synchronized void b(o<T> oVar) {
        this.b = true;
        this.pxt = oVar;
        notifyAll();
    }
}
