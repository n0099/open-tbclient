package com.bun.miitmdid.supplier.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static String f27611c = "OpenDeviceId library";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f27612d = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f27613a;

    /* renamed from: b  reason: collision with root package name */
    public com.zui.deviceidservice.a f27614b;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f27615e;

    /* renamed from: f  reason: collision with root package name */
    public com.bun.miitmdid.supplier.c.a f27616f;

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.f27613a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f27613a = context;
        this.f27616f = aVar;
        this.f27615e = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.e.a.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.f27614b = a.AbstractBinderC0485a.a(iBinder);
                if (a.this.f27616f != null) {
                    a.this.f27616f.a(true);
                }
                a.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.f27614b = null;
                a.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f27613a.bindService(intent, this.f27615e, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        com.bun.miitmdid.supplier.c.a aVar2 = this.f27616f;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f27612d) {
            Log.i(f27611c, str);
        }
    }

    private void b(String str) {
        if (f27612d) {
            Log.e(f27611c, str);
        }
    }

    public String a() {
        if (this.f27613a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f27614b != null) {
                return this.f27614b.a();
            }
            return null;
        } catch (RemoteException e2) {
            b("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        if (this.f27613a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f27614b != null) {
                return this.f27614b.b();
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
            if (this.f27614b != null) {
                a("Device support opendeviceid");
                return this.f27614b.c();
            }
            return false;
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f27613a;
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
            if (this.f27614b != null) {
                return this.f27614b.a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            b("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f27613a;
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
            if (this.f27614b != null) {
                return this.f27614b.b(packageName);
            }
            return null;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return null;
        }
    }

    public void f() {
        try {
            this.f27613a.unbindService(this.f27615e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f27614b = null;
    }
}
