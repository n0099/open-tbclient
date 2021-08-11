package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.samsung.android.deviceidservice.a;
@Keep
/* loaded from: classes9.dex */
public class SumsungCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DBG = false;
    public static String SAMSUNGTAG = "Samsung_DeviceIdService";
    public static String TAG = "SumsungCore library";
    public transient /* synthetic */ FieldHolder $fh;
    public com.bun.miitmdid.supplier.c.a mCallerCallBack;
    public ServiceConnection mConnection;
    public Context mContext;
    public com.samsung.android.deviceidservice.a mDeviceidInterface;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-767200358, "Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-767200358, "Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;");
        }
    }

    public SumsungCore(Context context, com.bun.miitmdid.supplier.c.a aVar) {
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
        this.mContext = null;
        this.mCallerCallBack = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new ServiceConnection(this) { // from class: com.bun.miitmdid.supplier.sumsung.SumsungCore.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SumsungCore f63653a;

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
                this.f63653a = this;
            }

            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    synchronized (this) {
                        this.f63653a.mDeviceidInterface = a.AbstractBinderC2042a.a(iBinder);
                        if (this.f63653a.mCallerCallBack != null) {
                            this.f63653a.mCallerCallBack.a(true);
                        }
                        com.bun.miitmdid.utils.a.a(SumsungCore.TAG, "Service onServiceConnected");
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    this.f63653a.mDeviceidInterface = null;
                    com.bun.miitmdid.utils.a.a(SumsungCore.TAG, "Service onServiceDisconnected");
                }
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
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = this.mContext;
            if (context == null) {
                com.bun.miitmdid.utils.a.a(TAG, "Context is null.");
                throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
            }
            String packageName = context.getPackageName();
            com.bun.miitmdid.utils.a.a(TAG, "liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                str = TAG;
                str2 = "input package is null!";
            } else {
                try {
                    if (this.mDeviceidInterface != null) {
                        String str3 = "getAAID Package: " + packageName;
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
        return (String) invokeV.objValue;
    }

    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mContext == null) {
                com.bun.miitmdid.utils.a.b(TAG, "Context is null.");
                throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
            }
            try {
                if (this.mDeviceidInterface != null) {
                    return this.mDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e2) {
                com.bun.miitmdid.utils.a.b(TAG, "getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.mContext;
            if (context == null) {
                com.bun.miitmdid.utils.a.a(TAG, "Context is null.");
                throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
            }
            String packageName = context.getPackageName();
            com.bun.miitmdid.utils.a.a(TAG, "liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                com.bun.miitmdid.utils.a.a(TAG, "input package is null!");
                return null;
            }
            try {
                if (this.mDeviceidInterface != null) {
                    String str = "getVAID Package: " + packageName;
                    return this.mDeviceidInterface.a(packageName);
                }
                return null;
            } catch (RemoteException e2) {
                com.bun.miitmdid.utils.a.a(TAG, "getVAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.mContext.unbindService(this.mConnection);
                com.bun.miitmdid.utils.a.a(TAG, "unBind Service successful");
            } catch (IllegalArgumentException unused) {
                com.bun.miitmdid.utils.a.a(TAG, "unBind Service exception");
            }
            this.mDeviceidInterface = null;
        }
    }
}
