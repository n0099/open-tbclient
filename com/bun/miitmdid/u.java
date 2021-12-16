package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.samsung.android.deviceidservice.IDeviceIdService;
/* loaded from: classes2.dex */
public class u extends l implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public Context f55022j;

    /* renamed from: k  reason: collision with root package name */
    public String f55023k;
    public ServiceConnection l;
    public IDeviceIdService m;

    public u(Context context) {
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
        this.f55022j = context;
        Context a = a(context);
        this.f55022j = a;
        this.f55023k = a != null ? a.getPackageName() : "";
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55022j = a(this.f55022j);
            try {
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                c();
                if (this.f55022j.bindService(intent, this, 1)) {
                    b();
                } else {
                    a();
                    a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
                }
            } catch (Exception unused) {
                a();
                a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
            }
        }
    }

    @Override // com.bun.miitmdid.l, com.bun.miitmdid.interfaces.IIdProvider
    public boolean isSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, componentName, iBinder) == null) || d()) {
            return;
        }
        IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
        this.m = asInterface;
        if (asInterface != null) {
            try {
                this.f54998f = true;
                String oaid = this.m.getOAID();
                String vaid = this.m.getVAID(this.f55023k);
                String aaid = this.m.getAAID(this.f55023k);
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
                this.f54999g = false;
            } catch (Exception unused) {
                a();
            }
        }
        a(this.f54995c, this.f54996d, this.f54997e, this.f54998f, this.f54999g);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, componentName) == null) {
            this.m = null;
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (serviceConnection = this.l) == null || (context = this.f55022j) == null) {
            return;
        }
        context.unbindService(serviceConnection);
        this.m = null;
    }
}
