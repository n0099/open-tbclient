package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
final class bp<SERVICE, RESULT> {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f5809a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private final Intent f5810b;
    private final Context d;
    private final b<SERVICE, RESULT> pmY;

    /* loaded from: classes6.dex */
    interface b<T, RESULT> {
        RESULT a(T t);

        T e(IBinder iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.d = context;
        this.f5810b = intent;
        this.pmY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RESULT a() {
        bp<SERVICE, RESULT>.a aVar;
        RESULT result = null;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            try {
                aVar = new a(this.f5809a, this.pmY);
                this.d.bindService(this.f5810b, aVar, 1);
                this.f5809a.await();
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                result = this.pmY.a(aVar.f5811a);
                a(aVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    a(aVar);
                    return result;
                } catch (Throwable th3) {
                    a(aVar);
                    throw th3;
                }
            }
        }
        return result;
    }

    private void a(bp<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements ServiceConnection {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        SERVICE f5811a;
        private final CountDownLatch c;
        private final b<SERVICE, RESULT> pmZ;

        a(CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.c = countDownLatch;
            this.pmZ = bVar;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bb.b(bh.f5801a, "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f5811a = this.pmZ.e(iBinder);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    bb.b(bh.f5801a, "ServiceBlockBinder#onServiceConnected", th);
                    try {
                        this.c.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    try {
                        this.c.countDown();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            bb.b(bh.f5801a, "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.c.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
