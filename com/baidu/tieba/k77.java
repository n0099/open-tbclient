package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k77 implements pc7<k77> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThreadRecommendInfoData a;

    @Override // com.baidu.tieba.pc7
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "recommend_info" : (String) invokeV.objValue;
    }

    public k77 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (k77) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k77) && Intrinsics.areEqual(this.a, ((k77) obj).a);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "CardRecommendInfoUiState(recommendInfoData=" + this.a + ')';
        }
        return (String) invokeV.objValue;
    }

    public k77(ThreadRecommendInfoData recommendInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recommendInfoData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(recommendInfoData, "recommendInfoData");
        this.a = recommendInfoData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.pc7
    public /* bridge */ /* synthetic */ k77 b() {
        c();
        return this;
    }

    public final ThreadRecommendInfoData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ThreadRecommendInfoData) invokeV.objValue;
    }
}
