package com.bun.miitmdid.supplier.h.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5756a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5757b = false;
    private static b pbK = null;
    private static a pbL = null;
    private static c pbM = null;
    private static c pbN = null;
    private static c pbO = null;
    private static Object h = new Object();
    private static HandlerThread i = null;
    private static Handler j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;

    private b() {
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
        }
        return str2;
    }

    private static void a(Context context, int i2, String str) {
        switch (i2) {
            case 0:
                pbM = new c(pbK, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, pbM);
                return;
            case 1:
                pbN = new c(pbK, 1, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, pbN);
                return;
            case 2:
                pbO = new c(pbK, 2, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, pbO);
                return;
            default:
                return;
        }
    }

    private void b(int i2, String str) {
        Message obtainMessage = j.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        j.sendMessage(obtainMessage);
    }

    public static void c() {
        f5757b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private static void f() {
        i = new HandlerThread("SqlWorkThread");
        i.start();
        j = new Handler(i.getLooper()) { // from class: com.bun.miitmdid.supplier.h.a.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Client", "message type valid");
                    return;
                }
                try {
                    String unused = b.k = b.pbL.a(message.getData().getInt("type"), message.getData().getString("appid"));
                } catch (Exception e) {
                    String unused2 = b.k = "";
                    com.bun.miitmdid.utils.a.a("VMS_IDLG_SDK_Client", "exception", e);
                }
                synchronized (b.h) {
                    b.h.notify();
                }
            }
        };
    }

    public static b hK(Context context) {
        if (pbK == null) {
            pbK = new b();
            f5756a = context;
            f();
            pbL = new a(f5756a);
            c();
        }
        return pbK;
    }

    public String a(String str) {
        if (a()) {
            if (m != null) {
                return m;
            }
            a(1, str);
            if (pbN == null && m != null) {
                a(f5756a, 1, str);
            }
            return m;
        }
        return null;
    }

    public void a(int i2, String str) {
        synchronized (h) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                h.wait(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                switch (i2) {
                    case 0:
                        l = k;
                        k = null;
                        break;
                    case 1:
                        if (k == null) {
                            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Client", "get vaid failed");
                            break;
                        } else {
                            m = k;
                            k = null;
                            break;
                        }
                    case 2:
                        if (k == null) {
                            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Client", "get aaid failed");
                            break;
                        } else {
                            n = k;
                            k = null;
                            break;
                        }
                }
            } else {
                com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Client", "query timeout");
            }
        }
    }

    public boolean a() {
        return f5757b;
    }

    public String b() {
        if (a()) {
            if (l != null) {
                return l;
            }
            a(0, (String) null);
            if (pbM == null) {
                a(f5756a, 0, null);
            }
            return l;
        }
        return null;
    }

    public String b(String str) {
        if (a()) {
            if (n != null) {
                return n;
            }
            a(2, str);
            if (pbO == null && n != null) {
                a(f5756a, 2, str);
            }
            return n;
        }
        return null;
    }
}
