package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.mh9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ReadChosenPbCacheResponse extends CustomResponsedMessage<mh9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mh9 chosenData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadChosenPbCacheResponse(mh9 mh9Var) {
        super(2001314);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mh9Var};
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
        this.chosenData = mh9Var;
    }

    public mh9 getChosenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chosenData;
        }
        return (mh9) invokeV.objValue;
    }
}
