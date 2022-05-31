package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wo4;
/* loaded from: classes3.dex */
public class ResponseLocalPersonListMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wo4 data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseLocalPersonListMessage() {
        super(2001188);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    public void setData(wo4 wo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wo4Var) == null) {
            this.data = wo4Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.repackage.wo4' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (wo4) invokeV.objValue;
    }
}
