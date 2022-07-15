package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Long> a;
    public final Handler b;
    public final Map<String, Runnable> c;
    public final Map<String, Runnable> d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (c.class) {
                    if (e == null) {
                        e = new c();
                    }
                }
            }
            return e;
        }
        return (c) invokeV.objValue;
    }
}
