package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class uc8 extends kc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nc8 b;

    @Override // com.baidu.tieba.kc8
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kc8
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "un_support" : (String) invokeV.objValue;
    }

    public uc8(nc8 wrapper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrapper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        this.b = wrapper;
    }

    @Override // com.baidu.tieba.kc8
    public void c(AbilityItem abilityItem, TbBaseMsg tbBaseMsg, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, tbBaseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            nc8 nc8Var = this.b;
            String string = UtilHelper.getString(R.string.obfuscated_res_0x7f0f092d);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.group_ability_un_support)");
            nc8Var.y(string, false);
        }
    }
}
