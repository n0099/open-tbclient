package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Keep;
import com.samsung.android.deviceidservice.a;
@Keep
/* loaded from: classes5.dex */
public class SumsungCore {
    public static boolean DBG = false;
    public static String SAMSUNGTAG = "Samsung_DeviceIdService";
    public static String TAG = "SumsungCore library";
    public com.bun.miitmdid.supplier.c.a mCallerCallBack;
    public ServiceConnection mConnection;
    public Context mContext;
    public com.samsung.android.deviceidservice.a mDeviceidInterface;

    public SumsungCore(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        this.mContext = null;
        this.mCallerCallBack = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new ServiceConnection() { // from class: com.bun.miitmdid.supplier.sumsung.SumsungCore.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                SumsungCore.this.mDeviceidInterface = a.AbstractBinderC0487a.a(iBinder);
                if (SumsungCore.this.mCallerCallBack != null) {
                    SumsungCore.this.mCallerCallBack.a(true);
                }
                com.bun.miitmdid.utils.a.a(SumsungCore.TAG, "Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                SumsungCore.this.mDeviceidInterface = null;
                com.bun.miitmdid.utils.a.a(SumsungCore.TAG, "Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            com.bun.miitmdid.utils.a.a(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        com.bun.miitmdid.utils.a.a(TAG, "bindService Failed!");
        com.bun.miitmdid.supplier.c.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public String getAAID() {
        String str;
        String str2;
        Context context = this.mContext;
        if (context == null) {
            com.bun.miitmdid.utils.a.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = context.getPackageName();
        String str3 = TAG;
        com.bun.miitmdid.utils.a.a(str3, "liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            str = TAG;
            str2 = "input package is null!";
        } else {
            try {
                if (this.mDeviceidInterface != null) {
                    String str4 = SAMSUNGTAG;
                    Log.d(str4, "getAAID Package: " + packageName);
                    return this.mDeviceidInterface.b(packageName);
                }
                return null;
            } catch (RemoteException unused) {
                str = TAG;
                str2 = "getAAID error, RemoteException!";
            }
        }
        com.bun.miitmdid.utils.a.a(str, str2);
        return null;
    }

    public String getOAID() {
        if (this.mContext == null) {
            com.bun.miitmdid.utils.a.b(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        try {
            if (this.mDeviceidInterface != null) {
                Log.d(SAMSUNGTAG, "getOAID call");
                return this.mDeviceidInterface.a();
            }
            return null;
        } catch (RemoteException e2) {
            com.bun.miitmdid.utils.a.b(TAG, "getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String getUDID() {
        return "";
    }

    public String getVAID() {
        Context context = this.mContext;
        if (context == null) {
            com.bun.miitmdid.utils.a.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = context.getPackageName();
        String str = TAG;
        com.bun.miitmdid.utils.a.a(str, "liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            com.bun.miitmdid.utils.a.a(TAG, "input package is null!");
            return null;
        }
        try {
            if (this.mDeviceidInterface != null) {
                String str2 = SAMSUNGTAG;
                Log.d(str2, "getVAID Package: " + packageName);
                return this.mDeviceidInterface.a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            com.bun.miitmdid.utils.a.a(TAG, "getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface != null) {
                com.bun.miitmdid.utils.a.a(TAG, "Device support opendeviceid");
                return true;
            }
            return false;
        } catch (Exception unused) {
            com.bun.miitmdid.utils.a.a(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            com.bun.miitmdid.utils.a.a(TAG, "unBind Service successful");
        } catch (IllegalArgumentException unused) {
            com.bun.miitmdid.utils.a.a(TAG, "unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
