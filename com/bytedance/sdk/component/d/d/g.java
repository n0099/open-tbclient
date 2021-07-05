package com.bytedance.sdk.component.d.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Throwable f28690a;

    /* renamed from: b  reason: collision with root package name */
    public int f28691b;

    /* renamed from: c  reason: collision with root package name */
    public String f28692c;

    public g(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28691b = i2;
        this.f28692c = str;
        this.f28690a = th;
    }

    private void b(com.bytedance.sdk.component.d.c.a aVar) {
        com.bytedance.sdk.component.d.g c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, aVar) == null) || (c2 = aVar.c()) == null) {
            return;
        }
        c2.a(this.f28691b, this.f28692c, this.f28690a);
    }

    @Override // com.bytedance.sdk.component.d.d.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.alipay.sdk.util.e.f1966a : (String) invokeV.objValue;
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
}
