package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.v;
/* loaded from: classes9.dex */
public final class h extends ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f64883a;

    /* renamed from: b  reason: collision with root package name */
    public final long f64884b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.e f64885c;

    public h(String str, long j2, com.bytedance.sdk.component.b.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64883a = str;
        this.f64884b = j2;
        this.f64885c = eVar;
    }

    @Override // com.bytedance.sdk.component.b.b.ac
    public v a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f64883a;
            if (str != null) {
                return v.a(str);
            }
            return null;
        }
        return (v) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.ac
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64884b : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.component.b.b.ac
    public com.bytedance.sdk.component.b.a.e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64885c : (com.bytedance.sdk.component.b.a.e) invokeV.objValue;
    }
}
