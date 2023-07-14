package com.baidu.tieba;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class wj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, vj4> a;
    public ConcurrentHashMap<Class<?>, Uri> b;

    public wj4() {
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
        c();
    }

    public <T> vj4<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            return this.a.get(cls);
        }
        return (vj4) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return this.b.get(cls);
        }
        return (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new ConcurrentHashMap<>();
            this.b = new ConcurrentHashMap<>();
            this.a.put(uk4.class, new zj4());
            this.a.put(vk4.class, new ak4());
            this.a.put(sk4.class, new yj4());
            this.a.put(qk4.class, new xj4());
            this.a.put(PMSAppInfo.class, new uj4());
            this.a.put(wk4.class, new bk4());
            this.a.put(xk4.class, new ck4());
            this.b.put(uk4.class, mk4.f);
            this.b.put(vk4.class, mk4.g);
            this.b.put(sk4.class, mk4.d);
            this.b.put(qk4.class, mk4.h);
            this.b.put(PMSAppInfo.class, mk4.e);
            this.b.put(wk4.class, mk4.i);
            this.b.put(xk4.class, mk4.j);
        }
    }
}
