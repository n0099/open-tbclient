package com.bun.miitmdid.supplier.h.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f26991a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f26992b = false;

    /* renamed from: c  reason: collision with root package name */
    public static b f26993c;

    /* renamed from: d  reason: collision with root package name */
    public static a f26994d;

    /* renamed from: e  reason: collision with root package name */
    public static c f26995e;

    /* renamed from: f  reason: collision with root package name */
    public static c f26996f;

    /* renamed from: g  reason: collision with root package name */
    public static c f26997g;

    /* renamed from: h  reason: collision with root package name */
    public static Object f26998h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static HandlerThread f26999i;
    public static Handler j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;

    public static b a(Context context) {
        if (f26993c == null) {
            f26993c = new b();
            f26991a = context;
            f();
            f26994d = new a(f26991a);
            c();
        }
        return f26993c;
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, int i2, String str) {
        ContentResolver contentResolver;
        Uri parse;
        c cVar;
        if (i2 == 0) {
            f26995e = new c(f26993c, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f26995e);
            return;
        }
        if (i2 == 1) {
            f26996f = new c(f26993c, 1, str);
            contentResolver = context.getContentResolver();
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
            cVar = f26996f;
        } else if (i2 != 2) {
            return;
        } else {
            f26997g = new c(f26993c, 2, str);
            contentResolver = context.getContentResolver();
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
            cVar = f26997g;
        }
        contentResolver.registerContentObserver(parse, false, cVar);
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
        f26992b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    public static void f() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f26999i = handlerThread;
        handlerThread.start();
        j = new Handler(f26999i.getLooper()) { // from class: com.bun.miitmdid.supplier.h.a.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Client", "message type valid");
                    return;
                }
                try {
                    String unused = b.k = b.f26994d.a(message.getData().getInt("type"), message.getData().getString("appid"));
                } catch (Exception e2) {
                    String unused2 = b.k = "";
                    com.bun.miitmdid.utils.a.a("VMS_IDLG_SDK_Client", "exception", e2);
                }
                synchronized (b.f26998h) {
                    b.f26998h.notify();
                }
            }
        };
    }

    public String a(String str) {
        if (a()) {
            String str2 = m;
            if (str2 != null) {
                return str2;
            }
            a(1, str);
            if (f26996f == null && m != null) {
                a(f26991a, 1, str);
            }
            return m;
        }
        return null;
    }

    public void a(int i2, String str) {
        String str2;
        String str3;
        synchronized (f26998h) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f26998h.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 == 0) {
                    l = k;
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        if (k != null) {
                            n = k;
                        } else {
                            str2 = "VMS_IDLG_SDK_Client";
                            str3 = "get aaid failed";
                        }
                    }
                } else if (k != null) {
                    m = k;
                } else {
                    str2 = "VMS_IDLG_SDK_Client";
                    str3 = "get vaid failed";
                }
                k = null;
            } else {
                str2 = "VMS_IDLG_SDK_Client";
                str3 = "query timeout";
            }
            com.bun.miitmdid.utils.a.b(str2, str3);
        }
    }

    public boolean a() {
        return f26992b;
    }

    public String b() {
        if (a()) {
            String str = l;
            if (str != null) {
                return str;
            }
            a(0, (String) null);
            if (f26995e == null) {
                a(f26991a, 0, null);
            }
            return l;
        }
        return null;
    }

    public String b(String str) {
        if (a()) {
            String str2 = n;
            if (str2 != null) {
                return str2;
            }
            a(2, str);
            if (f26997g == null && n != null) {
                a(f26991a, 2, str);
            }
            return n;
        }
        return null;
    }
}
