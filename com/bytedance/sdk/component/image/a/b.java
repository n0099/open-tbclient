package com.bytedance.sdk.component.image.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IKeyGenerator;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IKeyGenerator a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new IKeyGenerator() { // from class: com.bytedance.sdk.component.image.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakHashMap<String, String> f28863a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28863a = new WeakHashMap<>();
            }

            private String a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, str)) == null) {
                    String str2 = this.f28863a.get(str);
                    if (str2 == null) {
                        String a2 = com.bytedance.sdk.component.image.c.c.b.a(str);
                        this.f28863a.put(str, a2);
                        return a2;
                    }
                    return str2;
                }
                return (String) invokeL.objValue;
            }

            @Override // com.bytedance.sdk.component.image.IKeyGenerator
            public String generatorKey(com.bytedance.sdk.component.image.c.a aVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    return a(aVar.a() + "#width=" + aVar.h() + "#height=" + aVar.i() + "#scaletype=" + aVar.f());
                }
                return (String) invokeL.objValue;
            }

            @Override // com.bytedance.sdk.component.image.IKeyGenerator
            public String generatorRawKey(com.bytedance.sdk.component.image.c.a aVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? a(aVar.a()) : (String) invokeL.objValue;
            }
        } : (IKeyGenerator) invokeV.objValue;
    }
}
