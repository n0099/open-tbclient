package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.CustomMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pm8 extends nm8<CustomMsg, qk8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nm8
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return Integer.MAX_VALUE;
        }
        return invokeV.intValue;
    }

    public pm8() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nm8
    /* renamed from: h */
    public CustomMsg e(qk8 qk8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qk8Var)) == null) {
            CustomMsg customMsg = new CustomMsg();
            customMsg.setMsgId(Long.MAX_VALUE);
            customMsg.setMsgKey(String.valueOf(System.currentTimeMillis()));
            return customMsg;
        }
        return (CustomMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nm8
    /* renamed from: i */
    public qk8 g(CustomMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            return new qk8();
        }
        return (qk8) invokeL.objValue;
    }
}
