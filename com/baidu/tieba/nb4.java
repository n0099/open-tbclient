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
/* loaded from: classes5.dex */
public class nb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap a;
    public ConcurrentHashMap b;

    public nb4() {
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

    public mb4 a(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            return (mb4) this.a.get(cls);
        }
        return (mb4) invokeL.objValue;
    }

    public Uri b(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return (Uri) this.b.get(cls);
        }
        return (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new ConcurrentHashMap();
            this.b = new ConcurrentHashMap();
            this.a.put(lc4.class, new qb4());
            this.a.put(mc4.class, new rb4());
            this.a.put(jc4.class, new pb4());
            this.a.put(hc4.class, new ob4());
            this.a.put(PMSAppInfo.class, new lb4());
            this.a.put(nc4.class, new sb4());
            this.a.put(oc4.class, new tb4());
            this.b.put(lc4.class, dc4.f);
            this.b.put(mc4.class, dc4.g);
            this.b.put(jc4.class, dc4.d);
            this.b.put(hc4.class, dc4.h);
            this.b.put(PMSAppInfo.class, dc4.e);
            this.b.put(nc4.class, dc4.i);
            this.b.put(oc4.class, dc4.j);
        }
    }
}
