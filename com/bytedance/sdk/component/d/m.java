package com.bytedance.sdk.component.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class m<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28702a;

    /* renamed from: b  reason: collision with root package name */
    public String f28703b;

    /* renamed from: c  reason: collision with root package name */
    public T f28704c;

    /* renamed from: d  reason: collision with root package name */
    public int f28705d;

    /* renamed from: e  reason: collision with root package name */
    public int f28706e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f28707f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28708g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28709h;

    public m() {
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

    public m a(com.bytedance.sdk.component.d.c.a aVar, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, t)) == null) {
            this.f28704c = t;
            this.f28702a = aVar.e();
            this.f28703b = aVar.a();
            this.f28705d = aVar.h();
            this.f28706e = aVar.i();
            this.f28709h = aVar.l();
            return this;
        }
        return (m) invokeLL.objValue;
    }

    public m a(com.bytedance.sdk.component.d.c.a aVar, T t, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, t, map, Boolean.valueOf(z)})) == null) {
            this.f28707f = map;
            this.f28708g = z;
            return a(aVar, t);
        }
        return (m) invokeCommon.objValue;
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28704c : (T) invokeV.objValue;
    }
}
