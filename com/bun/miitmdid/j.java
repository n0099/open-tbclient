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
/* loaded from: classes2.dex */
public class j extends l implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static IDeviceIdManager l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public Context f52905j;
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
        this.f52905j = context;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context a = a(this.f52905j);
            this.f52905j = a;
            this.k = a.getPackageName();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            try {
                c();
                if (this.f52905j.bindService(intent, this, 1)) {
                    b();
                } else {
                    e0.a("CoolpadProvider", "DeviceIDManager service bind failed");
                    a();
                    a(this.f52907c, this.f52908d, this.f52909e, this.f52910f, this.f52911g);
                }
            } catch (SecurityException unused) {
                e0.a("CoolpadProvider", "DeviceIDManager service bind failed");
                a();
                a(this.f52907c, this.f52908d, this.f52909e, this.f52910f, this.f52911g);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) || d()) {
            return;
        }
        IDeviceIdManager a = IDeviceIdManager.a.a(iBinder);
        l = a;
        try {
            if (a != null) {
                this.f52910f = a.isCoolOs();
                this.f52911g = false;
                String oaid = l.getOAID(this.k);
                String vaid = l.getVAID(this.k);
                String aaid = l.getAAID(this.k);
                if (oaid == null) {
                    oaid = "";
                }
                this.f52907c = oaid;
                if (vaid == null) {
                    vaid = "";
                }
                this.f52908d = vaid;
                if (aaid == null) {
                    aaid = "";
                }
                this.f52909e = aaid;
            } else {
                e0.a("CoolpadProvider", "DeviceIdManager Null");
                a();
            }
            a(this.f52907c, this.f52908d, this.f52909e, this.f52910f, this.f52911g);
        } catch (RemoteException unused) {
            e0.a("CoolpadProvider", "DeviceIdManager RemoteException");
            a();
            a(this.f52907c, this.f52908d, this.f52909e, this.f52910f, this.f52911g);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (context = this.f52905j) == null) {
            return;
        }
        context.unbindService(this);
        l = null;
    }
}
