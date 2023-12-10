package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ri7<T> implements yi7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yi7
    public boolean a(Object originData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yi7
    public T b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            return null;
        }
        return (T) invokeL.objValue;
    }

    public ri7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.yi7
    public List<sb7<?>> c(Object originData, q67 feedData, Map<String, String> schemaLocalInfo, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{originData, feedData, schemaLocalInfo, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            Intrinsics.checkNotNullParameter(schemaLocalInfo, "schemaLocalInfo");
            return new ArrayList();
        }
        return (List) invokeCommon.objValue;
    }
}
