package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zh5 implements ph5<AgreeEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zh5() {
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
    @Override // com.baidu.tieba.ph5
    /* renamed from: a */
    public boolean onEvent(AgreeEvent agreeEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, agreeEvent)) == null) {
            if (agreeEvent != null && agreeEvent.agreeData != null) {
                rb9 rb9Var = new rb9();
                rb9Var.b = agreeEvent.agreeData;
                String str = agreeEvent.agreeExtra;
                if (AgreeEvent.IS_THREAD.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, rb9Var));
                    return true;
                } else if (AgreeEvent.IS_POST.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, rb9Var));
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
