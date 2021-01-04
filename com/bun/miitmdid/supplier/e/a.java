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
    private static String c = "OpenDeviceId library";
    private static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private Context f6045a;
    private com.zui.deviceidservice.a pge;
    private ServiceConnection pgf;
    private com.bun.miitmdid.supplier.c.a pgg;

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.f6045a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f6045a = context;
        this.pgg = aVar;
        this.pgf = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.e.a.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.pge = a.AbstractBinderC1256a.a(iBinder);
                if (a.this.pgg != null) {
                    a.this.pgg.a(true);
                }
                a.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.pge = null;
                a.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f6045a.bindService(intent, this.pgf, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        if (this.pgg != null) {
            this.pgg.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (d) {
            Log.i(c, str);
        }
    }

    private void b(String str) {
        if (d) {
            Log.e(c, str);
        }
    }

    public String a() {
        if (this.f6045a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.pge != null) {
                return this.pge.a();
            }
        } catch (RemoteException e) {
            b("getOAID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public String b() {
        if (this.f6045a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.pge != null) {
                return this.pge.b();
            }
        } catch (RemoteException e) {
            b("getUDID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean c() {
        try {
            if (this.pge != null) {
                a("Device support opendeviceid");
                return this.pge.c();
            }
            return false;
        } catch (RemoteException e) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        if (this.f6045a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.f6045a.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.pge != null) {
                    return this.pge.a(packageName);
                }
            } catch (RemoteException e) {
                b("getVAID error, RemoteException!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public String e() {
        if (this.f6045a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.f6045a.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.pge != null) {
                    return this.pge.b(packageName);
                }
            } catch (RemoteException e) {
                b("getAAID error, RemoteException!");
            }
        }
        return null;
    }

    public void f() {
        try {
            this.f6045a.unbindService(this.pgf);
            a("unBind Service successful");
        } catch (IllegalArgumentException e) {
            b("unBind Service exception");
        }
        this.pge = null;
    }
}
