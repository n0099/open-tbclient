package com.bun.miitmdid.supplier.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static String f26888c = "OpenDeviceId library";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f26889d = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f26890a;

    /* renamed from: b  reason: collision with root package name */
    public com.zui.deviceidservice.a f26891b;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f26892e;

    /* renamed from: f  reason: collision with root package name */
    public com.bun.miitmdid.supplier.c.a f26893f;

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.f26890a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f26890a = context;
        this.f26893f = aVar;
        this.f26892e = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.e.a.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.f26891b = a.AbstractBinderC0529a.a(iBinder);
                if (a.this.f26893f != null) {
                    a.this.f26893f.a(true);
                }
                a.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.f26891b = null;
                a.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f26890a.bindService(intent, this.f26892e, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        com.bun.miitmdid.supplier.c.a aVar2 = this.f26893f;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f26889d) {
            Log.i(f26888c, str);
        }
    }

    private void b(String str) {
        if (f26889d) {
            Log.e(f26888c, str);
        }
    }

    public String a() {
        if (this.f26890a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f26891b != null) {
                return this.f26891b.a();
            }
            return null;
        } catch (RemoteException e2) {
            b("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        if (this.f26890a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f26891b != null) {
                return this.f26891b.b();
            }
            return null;
        } catch (RemoteException e2) {
            b("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.f26891b != null) {
                a("Device support opendeviceid");
                return this.f26891b.c();
            }
            return false;
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f26890a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            if (this.f26891b != null) {
                return this.f26891b.a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            b("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f26890a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            if (this.f26891b != null) {
                return this.f26891b.b(packageName);
            }
            return null;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return null;
        }
    }

    public void f() {
        try {
            this.f26890a.unbindService(this.f26892e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f26891b = null;
    }
}
