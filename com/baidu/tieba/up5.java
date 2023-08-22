package com.baidu.tieba;

import com.baidu.tbadk.mutiprocess.aiApply.AICapacityMainProcessToastEvent;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class up5 implements lp5<AICapacityMainProcessToastEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public up5() {
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
    @Override // com.baidu.tieba.lp5
    /* renamed from: a */
    public boolean onEvent(AICapacityMainProcessToastEvent aICapacityMainProcessToastEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aICapacityMainProcessToastEvent)) == null) {
            if (aICapacityMainProcessToastEvent == null) {
                return false;
            }
            AICapacityApplyHelper.e.a().j(aICapacityMainProcessToastEvent.getToastString());
            return true;
        }
        return invokeL.booleanValue;
    }
}
