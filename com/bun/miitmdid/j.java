package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coolpad.deviceidsupport.IDeviceIdManager;
/* loaded from: classes11.dex */
public class j extends l implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static IDeviceIdManager l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context j;
    public String k;

    public j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = context;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context a2 = a(this.j);
            this.j = a2;
            this.k = a2.getPackageName();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            try {
                c();
                if (this.j.bindService(intent, this, 1)) {
                    b();
                } else {
                    e0.a("CoolpadProvider", "DeviceIDManager service bind failed");
                    a();
                    a(this.f62089c, this.f62090d, this.f62091e, this.f62092f, this.f62093g);
                }
            } catch (SecurityException unused) {
                e0.a("CoolpadProvider", "DeviceIDManager service bind failed");
                a();
                a(this.f62089c, this.f62090d, this.f62091e, this.f62092f, this.f62093g);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) || d()) {
            return;
        }
        IDeviceIdManager a2 = IDeviceIdManager.a.a(iBinder);
        l = a2;
        try {
            if (a2 != null) {
                this.f62092f = a2.isCoolOs();
                this.f62093g = false;
                String oaid = l.getOAID(this.k);
                String vaid = l.getVAID(this.k);
                String aaid = l.getAAID(this.k);
                if (oaid == null) {
                    oaid = "";
                }
                this.f62089c = oaid;
                if (vaid == null) {
                    vaid = "";
                }
                this.f62090d = vaid;
                if (aaid == null) {
                    aaid = "";
                }
                this.f62091e = aaid;
            } else {
                e0.a("CoolpadProvider", "DeviceIdManager Null");
                a();
            }
            a(this.f62089c, this.f62090d, this.f62091e, this.f62092f, this.f62093g);
        } catch (RemoteException unused) {
            e0.a("CoolpadProvider", "DeviceIdManager RemoteException");
            a();
            a(this.f62089c, this.f62090d, this.f62091e, this.f62092f, this.f62093g);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
            e0.a("CoolpadProvider", "onServiceDisconnected");
            l = null;
            a();
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (context = this.j) == null) {
            return;
        }
        context.unbindService(this);
        l = null;
    }
}
