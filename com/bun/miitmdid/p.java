package com.bun.miitmdid;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.zui.opendeviceidlibrary.OpenDeviceId;
/* loaded from: classes6.dex */
public class p extends l implements OpenDeviceId.CallBack<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context j;
    public OpenDeviceId k;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.zui.opendeviceidlibrary.OpenDeviceId.CallBack
    /* renamed from: a */
    public void serviceConnected(String str, OpenDeviceId openDeviceId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, openDeviceId) == null) {
            e0.c("LenovoProvider", "serviceConnected, info: " + str);
            if (d()) {
                return;
            }
            if (str.equals("Deviceid Service Connected")) {
                this.f37986f = true;
                try {
                    this.f37983c = openDeviceId.getOAID();
                    this.f37985e = openDeviceId.getAAID();
                    this.f37984d = openDeviceId.getVAID();
                } catch (Exception e2) {
                    e0.b("LenovoProvider", "serviceConnected: Exception: " + e2.getMessage());
                }
                this.f37987g = false;
                a(this.f37983c, this.f37984d, this.f37985e, this.f37986f, this.f37987g);
            }
            e0.d("LenovoProvider", "serviceConnected error: " + str);
            a();
            this.f37987g = false;
            a(this.f37983c, this.f37984d, this.f37985e, this.f37986f, this.f37987g);
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (isSync()) {
                e0.c("LenovoProvider", "doStart: sync, unsupported");
                this.f37983c = "";
                this.f37984d = "";
                this.f37985e = "";
                this.f37986f = false;
                this.f37987g = false;
                a("", "", "", false, false);
                return;
            }
            e0.c("LenovoProvider", "doStart: async");
            this.k = new OpenDeviceId();
            this.j = a(this.j);
            try {
                c();
                this.k.init(this.j, this);
                b();
            } catch (Exception e2) {
                e0.b("LenovoProvider", "doStart: Exception: " + e2.getMessage());
                a();
                a(this.f37983c, this.f37984d, this.f37985e, this.f37986f, this.f37987g);
            }
        }
    }

    @Override // com.bun.miitmdid.l, com.bun.miitmdid.interfaces.IIdProvider
    public boolean isSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Build.VERSION.SDK_INT < 26 : invokeV.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        OpenDeviceId openDeviceId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isSync() || (openDeviceId = this.k) == null) {
            return;
        }
        openDeviceId.shutdown();
    }
}
