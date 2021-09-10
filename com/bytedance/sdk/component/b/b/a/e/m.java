package com.bytedance.sdk.component.b.b.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes9.dex */
public interface m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f64764a = new m() { // from class: com.bytedance.sdk.component.b.b.a.e.m.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        {
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

        @Override // com.bytedance.sdk.component.b.b.a.e.m
        public void a(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) {
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.m
        public boolean a(int i2, com.bytedance.sdk.component.b.a.e eVar, int i3, boolean z) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), eVar, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                eVar.h(i3);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.m
        public boolean a(int i2, List<c> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, list)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.m
        public boolean a(int i2, List<c> list, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)})) == null) {
                return true;
            }
            return invokeCommon.booleanValue;
        }
    };

    void a(int i2, b bVar);

    boolean a(int i2, com.bytedance.sdk.component.b.a.e eVar, int i3, boolean z) throws IOException;

    boolean a(int i2, List<c> list);

    boolean a(int i2, List<c> list, boolean z);
}
