package com.baidu.tieba;

import com.baidu.tbadk.mutiprocess.aiApply.AICapacityStatusUpdateEvent;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class vm5 implements lm5<AICapacityStatusUpdateEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vm5() {
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
    @Override // com.baidu.tieba.lm5
    /* renamed from: a */
    public boolean onEvent(AICapacityStatusUpdateEvent aICapacityStatusUpdateEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aICapacityStatusUpdateEvent)) == null) {
            if (aICapacityStatusUpdateEvent == null) {
                return false;
            }
            AICapacityApplyHelper.e.a().g(aICapacityStatusUpdateEvent.getAiCapacityPermission());
            return true;
        }
        return invokeL.booleanValue;
    }
}
