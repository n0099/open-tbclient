package com.bytedance.sdk.component.image.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IRawCache;
import com.bytedance.sdk.component.image.ResultType;
/* loaded from: classes5.dex */
public class k extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
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

    @Override // com.bytedance.sdk.component.image.d.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "raw_cache" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.image.d.h
    public void a(com.bytedance.sdk.component.image.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            ResultType j = aVar.j();
            byte[] a2 = com.bytedance.sdk.component.image.c.b.a().c().a((IRawCache) aVar.d());
            if (a2 == null) {
                aVar.a(new e());
            } else if (j.a(a2)) {
                aVar.a(new l(a2, true));
            } else if (j == ResultType.BITMAP) {
                aVar.a(new d(a2, true));
            } else {
                aVar.a(new l(a2));
            }
        }
    }
}
