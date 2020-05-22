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
    private Context a;
    private ServiceConnection mjA;
    private com.bun.miitmdid.supplier.c.a mjB;
    private com.zui.deviceidservice.a mjz;

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.mjB = aVar;
        this.mjA = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.e.a.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.mjz = a.AbstractBinderC0863a.a(iBinder);
                if (a.this.mjB != null) {
                    a.this.mjB.a(true);
                }
                a.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.mjz = null;
                a.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.mjA, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        if (this.mjB != null) {
            this.mjB.a();
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
        if (this.a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.mjz != null) {
                return this.mjz.a();
            }
        } catch (RemoteException e) {
            b("getOAID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public String b() {
        if (this.a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.mjz != null) {
                return this.mjz.b();
            }
        } catch (RemoteException e) {
            b("getUDID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean c() {
        try {
            if (this.mjz != null) {
                a("Device support opendeviceid");
                return this.mjz.c();
            }
            return false;
        } catch (RemoteException e) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        if (this.a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.a.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.mjz != null) {
                    return this.mjz.a(packageName);
                }
            } catch (RemoteException e) {
                b("getVAID error, RemoteException!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public String e() {
        if (this.a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.a.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.mjz != null) {
                    return this.mjz.b(packageName);
                }
            } catch (RemoteException e) {
                b("getAAID error, RemoteException!");
            }
        }
        return null;
    }

    public void f() {
        try {
            this.a.unbindService(this.mjA);
            a("unBind Service successful");
        } catch (IllegalArgumentException e) {
            b("unBind Service exception");
        }
        this.mjz = null;
    }
}
