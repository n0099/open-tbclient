package com.bytedance.pangle.helper;

import android.os.Handler;
import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
/* loaded from: classes11.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class f62323a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f62324b;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f62324b == null) {
                try {
                    synchronized (a.class) {
                        if (f62324b == null) {
                            if (f62323a == null) {
                                f62323a = Class.forName("android.app.ActivityThread");
                            }
                            f62324b = MethodUtils.invokeStaticMethod(f62323a, "currentActivityThread", new Object[0]);
                        }
                        if (f62324b == null && Looper.myLooper() != Looper.getMainLooper()) {
                            Object obj = new Object();
                            new Handler(Looper.getMainLooper()).post(new Runnable(obj) { // from class: com.bytedance.pangle.helper.a.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ Object f62325a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {obj};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f62325a = obj;
                                }

                                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        try {
                                            try {
                                                Object unused = a.f62324b = MethodUtils.invokeStaticMethod(a.f62323a, "currentActivityThread", new Object[0]);
                                                synchronized (this.f62325a) {
                                                    this.f62325a.notify();
                                                }
                                            } catch (Exception e2) {
                                                ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                                                synchronized (this.f62325a) {
                                                    this.f62325a.notify();
                                                }
                                            }
                                        } catch (Throwable th) {
                                            synchronized (this.f62325a) {
                                                this.f62325a.notify();
                                                throw th;
                                            }
                                        }
                                    }
                                }
                            });
                            if (f62324b == null) {
                                synchronized (obj) {
                                    try {
                                        obj.wait(5000L);
                                    } catch (InterruptedException e2) {
                                        ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e2);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                    ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e3);
                }
            }
            return f62324b;
        }
        return invokeV.objValue;
    }
}
