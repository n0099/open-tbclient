package com.baidu.turbonet.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes19.dex */
class SystemMessageHandler extends Handler {
    private long mGB;
    private long mGC = 0;

    private native void nativeDoRunLoopOnce(long j, long j2);

    private SystemMessageHandler(long j) {
        this.mGB = 0L;
        this.mGB = j;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 2) {
            this.mGC = 0L;
        }
        nativeDoRunLoopOnce(this.mGB, this.mGC);
    }

    @CalledByNative
    private void scheduleWork() {
        sendMessage(HB(1));
    }

    @CalledByNative
    private void scheduleDelayedWork(long j, long j2) {
        if (this.mGC != 0) {
            removeMessages(2);
        }
        this.mGC = j;
        sendMessageDelayed(HB(2), j2);
    }

    @CalledByNative
    private void removeAllPendingMessages() {
        removeMessages(1);
        removeMessages(2);
    }

    private Message HB(int i) {
        Message obtain = Message.obtain();
        obtain.what = i;
        a.a(obtain, true);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class a {
        static final c mGD;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes19.dex */
        public interface c {
            void a(Message message, boolean z);
        }

        public static void a(Message message, boolean z) {
            mGD.a(message, z);
        }

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                mGD = new b();
            } else {
                mGD = new C0793a();
            }
        }

        /* loaded from: classes19.dex */
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
        /* loaded from: classes19.dex */
        static class C0793a implements c {
            private Method mGE;

            C0793a() {
                try {
                    this.mGE = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
                } catch (ClassNotFoundException e) {
                    com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Failed to find android.os.Message class", e);
                } catch (NoSuchMethodException e2) {
                    com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Failed to load Message.setAsynchronous method", e2);
                } catch (RuntimeException e3) {
                    com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Exception while loading Message.setAsynchronous method", e3);
                }
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            public void a(Message message, boolean z) {
                if (this.mGE != null) {
                    try {
                        this.mGE.invoke(message, Boolean.valueOf(z));
                    } catch (IllegalAccessException e) {
                        com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                        this.mGE = null;
                    } catch (IllegalArgumentException e2) {
                        com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                        this.mGE = null;
                    } catch (RuntimeException e3) {
                        com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                        this.mGE = null;
                    } catch (InvocationTargetException e4) {
                        com.baidu.turbonet.base.a.h("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                        this.mGE = null;
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
