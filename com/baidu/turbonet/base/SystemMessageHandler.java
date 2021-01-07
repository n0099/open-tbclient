package com.baidu.turbonet.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
class SystemMessageHandler extends Handler {
    private long oJd;
    private long oJe = 0;

    private native void nativeDoRunLoopOnce(long j, long j2);

    private SystemMessageHandler(long j) {
        this.oJd = 0L;
        this.oJd = j;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 2) {
            this.oJe = 0L;
        }
        nativeDoRunLoopOnce(this.oJd, this.oJe);
    }

    @CalledByNative
    private void scheduleWork() {
        sendMessage(NV(1));
    }

    @CalledByNative
    private void scheduleDelayedWork(long j, long j2) {
        if (this.oJe != 0) {
            removeMessages(2);
        }
        this.oJe = j;
        sendMessageDelayed(NV(2), j2);
    }

    @CalledByNative
    private void removeAllPendingMessages() {
        removeMessages(1);
        removeMessages(2);
    }

    private Message NV(int i) {
        Message obtain = Message.obtain();
        obtain.what = i;
        a.a(obtain, true);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        static final c oJf;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public interface c {
            void a(Message message, boolean z);
        }

        public static void a(Message message, boolean z) {
            oJf.a(message, z);
        }

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                oJf = new b();
            } else {
                oJf = new C0961a();
            }
        }

        /* loaded from: classes5.dex */
        static class b implements c {
            b() {
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            @SuppressLint({"NewApi"})
            public void a(Message message, boolean z) {
                message.setAsynchronous(z);
            }
        }

        /* renamed from: com.baidu.turbonet.base.SystemMessageHandler$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        static class C0961a implements c {
            private Method oJg;

            C0961a() {
                try {
                    this.oJg = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
                } catch (ClassNotFoundException e) {
                    com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Failed to find android.os.Message class", e);
                } catch (NoSuchMethodException e2) {
                    com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Failed to load Message.setAsynchronous method", e2);
                } catch (RuntimeException e3) {
                    com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Exception while loading Message.setAsynchronous method", e3);
                }
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            public void a(Message message, boolean z) {
                if (this.oJg != null) {
                    try {
                        this.oJg.invoke(message, Boolean.valueOf(z));
                    } catch (IllegalAccessException e) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                        this.oJg = null;
                    } catch (IllegalArgumentException e2) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                        this.oJg = null;
                    } catch (RuntimeException e3) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                        this.oJg = null;
                    } catch (InvocationTargetException e4) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                        this.oJg = null;
                    }
                }
            }
        }
    }

    @CalledByNative
    private static SystemMessageHandler create(long j) {
        return new SystemMessageHandler(j);
    }
}
