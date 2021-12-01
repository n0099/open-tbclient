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
/* loaded from: classes12.dex */
public class u extends l implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public Context f54442j;

    /* renamed from: k  reason: collision with root package name */
    public String f54443k;
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
        this.f54442j = context;
        Context a = a(context);
        this.f54442j = a;
        this.f54443k = a != null ? a.getPackageName() : "";
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54442j = a(this.f54442j);
            try {
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                c();
                if (this.f54442j.bindService(intent, this, 1)) {
                    b();
                } else {
                    a();
                    a(this.f54415c, this.f54416d, this.f54417e, this.f54418f, this.f54419g);
                }
            } catch (Exception unused) {
                a();
                a(this.f54415c, this.f54416d, this.f54417e, this.f54418f, this.f54419g);
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
                this.f54418f = true;
                String oaid = this.m.getOAID();
                String vaid = this.m.getVAID(this.f54443k);
                String aaid = this.m.getAAID(this.f54443k);
                if (oaid == null) {
                    oaid = "";
                }
                this.f54415c = oaid;
                if (vaid == null) {
                    vaid = "";
                }
                this.f54416d = vaid;
                if (aaid == null) {
                    aaid = "";
                }
                this.f54417e = aaid;
                this.f54419g = false;
            } catch (Exception unused) {
                a();
            }
        }
        a(this.f54415c, this.f54416d, this.f54417e, this.f54418f, this.f54419g);
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (serviceConnection = this.l) == null || (context = this.f54442j) == null) {
            return;
        }
        context.unbindService(serviceConnection);
        this.m = null;
    }
}
