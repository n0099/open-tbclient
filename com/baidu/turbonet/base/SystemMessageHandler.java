package com.baidu.turbonet.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
class SystemMessageHandler extends Handler {
    private long oEA = 0;
    private long oEz;

    private native void nativeDoRunLoopOnce(long j, long j2);

    private SystemMessageHandler(long j) {
        this.oEz = 0L;
        this.oEz = j;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 2) {
            this.oEA = 0L;
        }
        nativeDoRunLoopOnce(this.oEz, this.oEA);
    }

    @CalledByNative
    private void scheduleWork() {
        sendMessage(Mo(1));
    }

    @CalledByNative
    private void scheduleDelayedWork(long j, long j2) {
        if (this.oEA != 0) {
            removeMessages(2);
        }
        this.oEA = j;
        sendMessageDelayed(Mo(2), j2);
    }

    @CalledByNative
    private void removeAllPendingMessages() {
        removeMessages(1);
        removeMessages(2);
    }

    private Message Mo(int i) {
        Message obtain = Message.obtain();
        obtain.what = i;
        a.a(obtain, true);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        static final c oEB;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public interface c {
            void a(Message message, boolean z);
        }

        public static void a(Message message, boolean z) {
            oEB.a(message, z);
        }

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                oEB = new b();
            } else {
                oEB = new C0944a();
            }
        }

        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        static class C0944a implements c {
            private Method oEC;

            C0944a() {
                try {
                    this.oEC = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
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
                if (this.oEC != null) {
                    try {
                        this.oEC.invoke(message, Boolean.valueOf(z));
                    } catch (IllegalAccessException e) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                        this.oEC = null;
                    } catch (IllegalArgumentException e2) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                        this.oEC = null;
                    } catch (RuntimeException e3) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                        this.oEC = null;
                    } catch (InvocationTargetException e4) {
                        com.baidu.turbonet.base.a.e("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                        this.oEC = null;
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
