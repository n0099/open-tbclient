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
    public Context f54991j;

    /* renamed from: k  reason: collision with root package name */
    public String f54992k;

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
        this.f54991j = context;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context a = a(this.f54991j);
            this.f54991j = a;
            this.f54992k = a.getPackageName();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            try {
                c();
                if (this.f54991j.bindService(intent, this, 1)) {
                    b();
                } else {
                    e0.a("CoolpadProvider", "DeviceIDManager service bind failed");
                    a();
                    a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
                }
            } catch (SecurityException unused) {
                e0.a("CoolpadProvider", "DeviceIDManager service bind failed");
                a();
                a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
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
                this.f54998f = a.isCoolOs();
                this.f54999g = false;
                String oaid = l.getOAID(this.f54992k);
                String vaid = l.getVAID(this.f54992k);
                String aaid = l.getAAID(this.f54992k);
                if (oaid == null) {
                    oaid = "";
                }
                this.f54995c = oaid;
                if (vaid == null) {
                    vaid = "";
                }
                this.f54996d = vaid;
                if (aaid == null) {
                    aaid = "";
                }
                this.f54997e = aaid;
            } else {
                e0.a("CoolpadProvider", "DeviceIdManager Null");
                a();
            }
            a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
        } catch (RemoteException unused) {
            e0.a("CoolpadProvider", "DeviceIdManager RemoteException");
            a();
            a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (context = this.f54991j) == null) {
            return;
        }
        context.unbindService(this);
        l = null;
    }
}
