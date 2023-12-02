package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.mv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ReadChosenPbCacheResponse extends CustomResponsedMessage<mv9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mv9 chosenData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadChosenPbCacheResponse(mv9 mv9Var) {
        super(2001314);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.chosenData = mv9Var;
    }

    public mv9 getChosenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chosenData;
        }
        return (mv9) invokeV.objValue;
    }
}
