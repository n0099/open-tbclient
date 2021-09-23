package com.bun.miitmdid.supplier.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.zui.deviceidservice.a;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f64304c = "OpenDeviceId library";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64305d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64306a;

    /* renamed from: b  reason: collision with root package name */
    public com.zui.deviceidservice.a f64307b;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f64308e;

    /* renamed from: f  reason: collision with root package name */
    public com.bun.miitmdid.supplier.c.a f64309f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-536295265, "Lcom/bun/miitmdid/supplier/e/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-536295265, "Lcom/bun/miitmdid/supplier/e/a;");
        }
    }

    public a(Context context, com.bun.miitmdid.supplier.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64306a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f64306a = context;
        this.f64309f = aVar;
        this.f64308e = new ServiceConnection(this) { // from class: com.bun.miitmdid.supplier.e.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f64310a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f64310a = this;
            }

            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    synchronized (this) {
                        this.f64310a.f64307b = a.AbstractBinderC2107a.a(iBinder);
                        if (this.f64310a.f64309f != null) {
                            this.f64310a.f64309f.a(true);
                        }
                        this.f64310a.a("Service onServiceConnected");
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    this.f64310a.f64307b = null;
                    this.f64310a.a("Service onServiceDisconnected");
                }
            }
        };
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f64306a.bindService(intent, this.f64308e, 1)) {
            a("bindService Successful!");
            return;
        }
        a("bindService Failed!");
        com.bun.miitmdid.supplier.c.a aVar2 = this.f64309f;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            boolean z = f64305d;
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            boolean z = f64305d;
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f64306a == null) {
                b("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            try {
                if (this.f64307b != null) {
                    return this.f64307b.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f64306a == null) {
                b("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            try {
                if (this.f64307b != null) {
                    return this.f64307b.b();
                }
                return null;
            } catch (RemoteException e2) {
                b("getUDID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.f64307b != null) {
                    a("Device support opendeviceid");
                    return this.f64307b.c();
                }
                return false;
            } catch (RemoteException unused) {
                b("isSupport error, RemoteException!");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.f64306a;
            if (context == null) {
                a("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            String packageName = context.getPackageName();
            a("liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                a("input package is null!");
                return null;
            }
            try {
                if (this.f64307b != null) {
                    return this.f64307b.a(packageName);
                }
                return null;
            } catch (RemoteException e2) {
                b("getVAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.f64306a;
            if (context == null) {
                a("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            String packageName = context.getPackageName();
            a("liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                a("input package is null!");
                return null;
            }
            try {
                if (this.f64307b != null) {
                    return this.f64307b.b(packageName);
                }
                return null;
            } catch (RemoteException unused) {
                b("getAAID error, RemoteException!");
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.f64306a.unbindService(this.f64308e);
                a("unBind Service successful");
            } catch (IllegalArgumentException unused) {
                b("unBind Service exception");
            }
            this.f64307b = null;
        }
    }
}
