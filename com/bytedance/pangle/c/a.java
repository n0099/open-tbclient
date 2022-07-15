package com.bytedance.pangle.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Class a;
    public static Object b;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                try {
                    synchronized (a.class) {
                        if (b == null) {
                            if (a == null) {
                                a = Class.forName("android.app.ActivityThread");
                            }
                            b = MethodUtils.invokeStaticMethod(a, "currentActivityThread", new Object[0]);
                        }
                        if (b == null && Looper.myLooper() != Looper.getMainLooper()) {
                            Object obj = new Object();
                            new Handler(Looper.getMainLooper()).post(new Runnable(obj) { // from class: com.bytedance.pangle.c.a.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Object a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {obj};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = obj;
                                }

                                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        try {
                                            try {
                                                Object unused = a.b = MethodUtils.invokeStaticMethod(a.a, "currentActivityThread", new Object[0]);
                                                synchronized (this.a) {
                                                    this.a.notify();
                                                }
                                            } catch (Exception e) {
                                                ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                                synchronized (this.a) {
                                                    this.a.notify();
                                                }
                                            }
                                        } catch (Throwable th) {
                                            synchronized (this.a) {
                                                this.a.notify();
                                                throw th;
                                            }
                                        }
                                    }
                                }
                            });
                            if (b == null) {
                                synchronized (obj) {
                                    try {
                                        obj.wait(5000L);
                                    } catch (InterruptedException e) {
                                        ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
                }
            }
            return b;
        }
        return invokeV.objValue;
    }
}
