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
/* loaded from: classes4.dex */
public class SumsungCore {
    private com.bun.miitmdid.supplier.c.a mCallerCallBack;
    private ServiceConnection mConnection;
    private Context mContext;
    private com.samsung.android.deviceidservice.a mDeviceidInterface;
    private static String TAG = "SumsungCore library";
    private static String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static boolean DBG = false;

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
                SumsungCore.this.mDeviceidInterface = a.AbstractBinderC1207a.a(iBinder);
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
        if (this.mCallerCallBack != null) {
            this.mCallerCallBack.a();
        }
    }

    public String getAAID() {
        if (this.mContext == null) {
            com.bun.miitmdid.utils.a.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = this.mContext.getPackageName();
        com.bun.miitmdid.utils.a.a(TAG, "liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            com.bun.miitmdid.utils.a.a(TAG, "input package is null!");
        } else {
            try {
                if (this.mDeviceidInterface != null) {
                    Log.d(SAMSUNGTAG, "getAAID Package: " + packageName);
                    return this.mDeviceidInterface.b(packageName);
                }
            } catch (RemoteException e) {
                com.bun.miitmdid.utils.a.a(TAG, "getAAID error, RemoteException!");
            }
        }
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
        } catch (RemoteException e) {
            com.bun.miitmdid.utils.a.b(TAG, "getOAID error, RemoteException!");
            e.printStackTrace();
        }
        return null;
    }

    public String getUDID() {
        return "";
    }

    public String getVAID() {
        if (this.mContext == null) {
            com.bun.miitmdid.utils.a.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = this.mContext.getPackageName();
        com.bun.miitmdid.utils.a.a(TAG, "liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            com.bun.miitmdid.utils.a.a(TAG, "input package is null!");
        } else {
            try {
                if (this.mDeviceidInterface != null) {
                    Log.d(SAMSUNGTAG, "getVAID Package: " + packageName);
                    return this.mDeviceidInterface.a(packageName);
                }
            } catch (RemoteException e) {
                com.bun.miitmdid.utils.a.a(TAG, "getVAID error, RemoteException!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface != null) {
                com.bun.miitmdid.utils.a.a(TAG, "Device support opendeviceid");
                return true;
            }
            return false;
        } catch (Exception e) {
            com.bun.miitmdid.utils.a.a(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            com.bun.miitmdid.utils.a.a(TAG, "unBind Service successful");
        } catch (IllegalArgumentException e) {
            com.bun.miitmdid.utils.a.a(TAG, "unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
