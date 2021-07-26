package com.bytedance.sdk.component.image.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "check_duplicate" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.image.d.h
    public void a(com.bytedance.sdk.component.image.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            String e2 = aVar.e();
            Map<String, List<com.bytedance.sdk.component.image.c.a>> h2 = com.bytedance.sdk.component.image.c.b.a().h();
            synchronized (h2) {
                List<com.bytedance.sdk.component.image.c.a> list = h2.get(e2);
                if (list == null) {
                    list = new LinkedList<>();
                    h2.put(e2, list);
                }
                list.add(aVar);
                if (list.size() <= 1) {
                    aVar.a(new c());
                }
            }
        }
    }
}
