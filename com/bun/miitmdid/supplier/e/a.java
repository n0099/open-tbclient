package com.bun.miitmdid.supplier.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes18.dex */
public class a {
    private static String c = "OpenDeviceId library";
    private static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private Context f3987a;
    private com.zui.deviceidservice.a oYR;
    private ServiceConnection oYS;
    private com.bun.miitmdid.supplier.c.a oYT;

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.f3987a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f3987a = context;
        this.oYT = aVar;
        this.oYS = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.e.a.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.oYR = a.AbstractBinderC1038a.a(iBinder);
                if (a.this.oYT != null) {
                    a.this.oYT.a(true);
                }
                a.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.oYR = null;
                a.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f3987a.bindService(intent, this.oYS, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        if (this.oYT != null) {
            this.oYT.a();
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
        if (this.f3987a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.oYR != null) {
                return this.oYR.a();
            }
        } catch (RemoteException e) {
            b("getOAID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public String b() {
        if (this.f3987a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.oYR != null) {
                return this.oYR.b();
            }
        } catch (RemoteException e) {
            b("getUDID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean c() {
        try {
            if (this.oYR != null) {
                a("Device support opendeviceid");
                return this.oYR.c();
            }
            return false;
        } catch (RemoteException e) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        if (this.f3987a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.f3987a.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.oYR != null) {
                    return this.oYR.a(packageName);
                }
            } catch (RemoteException e) {
                b("getVAID error, RemoteException!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public String e() {
        if (this.f3987a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.f3987a.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
        } else {
            try {
                if (this.oYR != null) {
                    return this.oYR.b(packageName);
                }
            } catch (RemoteException e) {
                b("getAAID error, RemoteException!");
            }
        }
        return null;
    }

    public void f() {
        try {
            this.f3987a.unbindService(this.oYS);
            a("unBind Service successful");
        } catch (IllegalArgumentException e) {
            b("unBind Service exception");
        }
        this.oYR = null;
    }
}
