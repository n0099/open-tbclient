package com.baidu.turbonet.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class SystemMessageHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public long f22319a;

    /* renamed from: b  reason: collision with root package name */
    public long f22320b = 0;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f22321a;

        /* renamed from: com.baidu.turbonet.base.SystemMessageHandler$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0222a implements c {

            /* renamed from: a  reason: collision with root package name */
            public Method f22322a;

            public C0222a() {
                try {
                    this.f22322a = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
                } catch (ClassNotFoundException e2) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Failed to find android.os.Message class", e2);
                } catch (NoSuchMethodException e3) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Failed to load Message.setAsynchronous method", e3);
                } catch (RuntimeException e4) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Exception while loading Message.setAsynchronous method", e4);
                }
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            public void a(Message message, boolean z) {
                Method method = this.f22322a;
                if (method == null) {
                    return;
                }
                try {
                    method.invoke(message, Boolean.valueOf(z));
                } catch (IllegalAccessException unused) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                    this.f22322a = null;
                } catch (IllegalArgumentException unused2) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                    this.f22322a = null;
                } catch (RuntimeException unused3) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                    this.f22322a = null;
                } catch (InvocationTargetException unused4) {
                    d.a.o0.a.a.c("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                    this.f22322a = null;
                }
            }
        }

        /* loaded from: classes5.dex */
        public static class b implements c {
            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            @SuppressLint({"NewApi"})
            public void a(Message message, boolean z) {
                message.setAsynchronous(z);
            }
        }

        /* loaded from: classes5.dex */
        public interface c {
            void a(Message message, boolean z);
        }

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                f22321a = new b();
            } else {
                f22321a = new C0222a();
            }
        }

        public static void a(Message message, boolean z) {
            f22321a.a(message, z);
        }
    }

    public SystemMessageHandler(long j) {
        this.f22319a = 0L;
        this.f22319a = j;
    }

    @CalledByNative
    public static SystemMessageHandler create(long j) {
        return new SystemMessageHandler(j);
    }

    private native void nativeDoRunLoopOnce(long j, long j2);

    @CalledByNative
    private void removeAllPendingMessages() {
        removeMessages(1);
        removeMessages(2);
    }

    @CalledByNative
    private void scheduleDelayedWork(long j, long j2) {
        if (this.f22320b != 0) {
            removeMessages(2);
        }
        this.f22320b = j;
        sendMessageDelayed(a(2), j2);
    }

    @CalledByNative
    private void scheduleWork() {
        sendMessage(a(1));
    }

    public final Message a(int i2) {
        Message obtain = Message.obtain();
        obtain.what = i2;
        a.a(obtain, true);
        return obtain;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 2) {
            this.f22320b = 0L;
        }
        nativeDoRunLoopOnce(this.f22319a, this.f22320b);
    }
}
