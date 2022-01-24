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
    public Context f52978j;
    public String k;
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
        this.f52978j = context;
        Context a = a(context);
        this.f52978j = a;
        this.k = a != null ? a.getPackageName() : "";
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52978j = a(this.f52978j);
            try {
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                c();
                if (this.f52978j.bindService(intent, this, 1)) {
                    b();
                } else {
                    a();
                    a(this.f52952c, this.f52953d, this.f52954e, this.f52955f, this.f52956g);
                }
            } catch (Exception unused) {
                a();
                a(this.f52952c, this.f52953d, this.f52954e, this.f52955f, this.f52956g);
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
                this.f52955f = true;
                String oaid = this.m.getOAID();
                String vaid = this.m.getVAID(this.k);
                String aaid = this.m.getAAID(this.k);
                if (oaid == null) {
                    oaid = "";
                }
                this.f52952c = oaid;
                if (vaid == null) {
                    vaid = "";
                }
                this.f52953d = vaid;
                if (aaid == null) {
                    aaid = "";
                }
                this.f52954e = aaid;
                this.f52956g = false;
            } catch (Exception unused) {
                a();
            }
        }
        a(this.f52952c, this.f52953d, this.f52954e, this.f52955f, this.f52956g);
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (serviceConnection = this.l) == null || (context = this.f52978j) == null) {
            return;
        }
        context.unbindService(serviceConnection);
        this.m = null;
    }
}
