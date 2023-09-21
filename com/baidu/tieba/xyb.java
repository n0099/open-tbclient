package com.baidu.tieba;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nyb;
import com.baidu.tieba.ryb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class xyb implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final Object e;
    public transient /* synthetic */ FieldHolder $fh;
    public final yxb a;
    public a b;
    public Handler c;
    public boolean d;

    /* loaded from: classes8.dex */
    public interface a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948318120, "Lcom/baidu/tieba/xyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948318120, "Lcom/baidu/tieba/xyb;");
                return;
            }
        }
        e = new Object();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (e) {
                Handler handler = this.c;
                if (handler != null) {
                    handler.removeMessages(1001);
                    this.c = null;
                }
            }
        }
    }

    public xyb(yxb yxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yxbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = false;
        this.a = yxbVar;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, componentName) == null) {
            Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
            if (this.d) {
                this.d = false;
                return;
            }
            c();
            a();
            a aVar = this.b;
            if (aVar != null) {
                tyb tybVar = (tyb) aVar;
                tybVar.a.a.set(1);
                tybVar.a.a(8002005);
                tybVar.a.b = null;
            }
        }
    }

    public final void b(int i) {
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (aVar = this.b) != null) {
            tyb tybVar = (tyb) aVar;
            AtomicInteger atomicInteger = tybVar.a.a;
            if (i == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            atomicInteger.set(i2);
            tybVar.a.a(i);
            tybVar.a.b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, componentName) == null) {
            Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
            a aVar = this.b;
            if (aVar != null) {
                tyb tybVar = (tyb) aVar;
                tybVar.a.a.set(1);
                tybVar.a.a(8002002);
                tybVar.a.b = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                Log.i("AIDLSrvConnection", "trying to unbind service from " + this);
                cyb.e.a().unbindService(this);
            } catch (Exception e2) {
                String str = "on unBind service exception:" + e2.getMessage();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, componentName, iBinder) == null) {
            Log.i("AIDLSrvConnection", "enter onServiceConnected.");
            a();
            a aVar = this.b;
            if (aVar != null) {
                tyb tybVar = (tyb) aVar;
                tybVar.a.b = IPushInvoke.Stub.asInterface(iBinder);
                if (tybVar.a.b == null) {
                    tybVar.a.d.c();
                    tybVar.a.a.set(1);
                    tybVar.a.a(8002001);
                    return;
                }
                tybVar.a.a.set(3);
                ryb.a aVar2 = tybVar.a.c;
                if (aVar2 != null) {
                    nyb.a aVar3 = (nyb.a) aVar2;
                    if (Looper.myLooper() == aVar3.f.a.getLooper()) {
                        aVar3.d();
                    } else {
                        aVar3.f.a.post(new kyb(aVar3));
                    }
                }
            }
        }
    }
}
