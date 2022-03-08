package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes7.dex */
public class z {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f51569d = "MsaClient";
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceConnection a;

    /* renamed from: b  reason: collision with root package name */
    public Context f51570b;

    /* renamed from: c  reason: collision with root package name */
    public MsaIdInterface f51571c;

    /* loaded from: classes7.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f51572b;

        public a(z zVar, a0 a0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, a0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51572b = zVar;
            this.a = a0Var;
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this) {
                    this.f51572b.f51571c = MsaIdInterface.Stub.asInterface(iBinder);
                    new y(this.f51572b.f51571c, this.a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    String str = z.f51569d;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f51572b.f51571c = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2134062679, "Lcom/bun/miitmdid/z;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2134062679, "Lcom/bun/miitmdid/z;");
        }
    }

    public z(Context context, a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, a0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f51570b = context;
        this.a = new a(this, a0Var);
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.setAction("com.bun.msa.action.start.service");
            intent.putExtra("com.bun.msa.param.pkgname", str);
            if ((Build.VERSION.SDK_INT < 26 ? context.startService(intent) : context.startForegroundService(intent)) == null) {
                throw new NullPointerException("StartMsaKlService failed.");
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MsaIdInterface msaIdInterface = this.f51571c;
                return msaIdInterface != null ? msaIdInterface.getAAID() : "";
            } catch (RemoteException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", str);
            if (!this.f51570b.bindService(intent, this.a, 1)) {
                throw new NullPointerException("BindService failed.");
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                MsaIdInterface msaIdInterface = this.f51571c;
                return msaIdInterface != null ? msaIdInterface.getOAID() : "";
            } catch (RemoteException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                MsaIdInterface msaIdInterface = this.f51571c;
                return msaIdInterface != null ? msaIdInterface.getVAID() : "";
            } catch (RemoteException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                MsaIdInterface msaIdInterface = this.f51571c;
                if (msaIdInterface != null) {
                    return msaIdInterface.isSupported();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MsaIdInterface msaIdInterface = this.f51571c;
            if (msaIdInterface != null) {
                try {
                    msaIdInterface.shutDown();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                this.f51570b.unbindService(this.a);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
