package com.bytedance.sdk.component.d.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.m;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class l<T> extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public T f28698a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.component.d.b.d f28699b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28700c;

    public l(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28698a = t;
    }

    private Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            com.bytedance.sdk.component.d.b.d dVar = this.f28699b;
            if (dVar != null) {
                return dVar.d();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.d.d.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "success" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.d.d.h
    public void a(com.bytedance.sdk.component.d.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            String e2 = aVar.e();
            Map<String, List<com.bytedance.sdk.component.d.c.a>> h2 = com.bytedance.sdk.component.d.c.b.a().h();
            List<com.bytedance.sdk.component.d.c.a> list = h2.get(e2);
            if (list == null) {
                b(aVar);
                return;
            }
            for (com.bytedance.sdk.component.d.c.a aVar2 : list) {
                b(aVar2);
            }
            list.clear();
            h2.remove(e2);
        }
    }

    public l(T t, com.bytedance.sdk.component.d.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28698a = t;
        this.f28699b = dVar;
    }

    private void b(com.bytedance.sdk.component.d.c.a aVar) {
        com.bytedance.sdk.component.d.g c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || (c2 = aVar.c()) == null) {
            return;
        }
        c2.a(new m().a(aVar, this.f28698a, b(), this.f28700c));
    }

    public l(T t, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f28698a = t;
        this.f28700c = z;
    }

    public l(T t, com.bytedance.sdk.component.d.b.d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, dVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28698a = t;
        this.f28699b = dVar;
        this.f28700c = z;
    }
}
