package com.bytedance.pangle.log;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f51719b;

    /* renamed from: c  reason: collision with root package name */
    public String f51720c;

    /* renamed from: d  reason: collision with root package name */
    public long f51721d;

    /* renamed from: e  reason: collision with root package name */
    public long f51722e;

    public c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f51719b = str2;
        this.f51720c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f51722e = currentTimeMillis;
        this.f51721d = currentTimeMillis;
        String str4 = this.a;
        ZeusLogger.i(str4, this.f51719b + String.format(" watcher[%s]-start", str3));
    }

    public static c a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) ? new c(str, str2, str3) : (c) invokeLLL.objValue;
    }

    public final long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f51722e;
            long currentTimeMillis2 = System.currentTimeMillis() - this.f51721d;
            String str2 = this.a;
            ZeusLogger.i(str2, this.f51719b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f51720c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
            return currentTimeMillis2;
        }
        return invokeL.longValue;
    }

    public final long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f51722e;
            String str2 = this.a;
            ZeusLogger.i(str2, this.f51719b + String.format(" watcher[%s]-%s cost=%s", this.f51720c, str, Long.valueOf(currentTimeMillis)));
            this.f51722e = System.currentTimeMillis();
            return currentTimeMillis;
        }
        return invokeL.longValue;
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f51721d : invokeV.longValue;
    }
}
