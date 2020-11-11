package com.bun.miitmdid.supplier.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes11.dex */
public class a {
    private static String c = "OpenDeviceId library";
    private static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private Context f3984a;
    private com.zui.deviceidservice.a oIf;
    private ServiceConnection oIg;
    private com.bun.miitmdid.supplier.c.a oIh;

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.f3984a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f3984a = context;
        this.oIh = aVar;
        this.oIg = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.e.a.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.oIf = a.AbstractBinderC1058a.a(iBinder);
                if (a.this.oIh != null) {
                    a.this.oIh.a(true);
                }
                a.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.oIf = null;
                a.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f3984a.bindService(intent, this.oIg, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        if (this.oIh != null) {
            this.oIh.a();
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
        if (this.f3984a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.oIf != null) {
                return this.oIf.a();
            }
        } catch (RemoteException e) {
            b("getOAID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public String b() {
        if (this.f3984a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.oIf != null) {
                return this.oIf.b();
            }
        } catch (RemoteException e) {
            b("getUDID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean c() {
        try {
            if (this.oIf != null) {
                a("Device support opendeviceid");
                return this.oIf.c();
            }
            return false;
        } catch (RemoteException e) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        if (this.f3984a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.f3984a.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.oIf != null) {
                    return this.oIf.a(packageName);
                }
            } catch (RemoteException e) {
                b("getVAID error, RemoteException!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public String e() {
        if (this.f3984a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.f3984a.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.oIf != null) {
                    return this.oIf.b(packageName);
                }
            } catch (RemoteException e) {
                b("getAAID error, RemoteException!");
            }
        }
        return null;
    }

    public void f() {
        try {
            this.f3984a.unbindService(this.oIg);
            a("unBind Service successful");
        } catch (IllegalArgumentException e) {
            b("unBind Service exception");
        }
        this.oIf = null;
    }
}
