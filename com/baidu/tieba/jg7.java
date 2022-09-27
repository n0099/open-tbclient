package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class jg7 implements tn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jg7() {
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

    @Override // com.baidu.tieba.tn4
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbConfig.FOLLOW_ADDRESS : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tn4
    public void b(HashMap<String, String> hashMap, un4 un4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap, un4Var) == null) || un4Var == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.a = un4Var.a;
        aVar.b = un4Var.c;
        aVar.d = true;
        aVar.c = hashMap.get("touid") == null ? "" : hashMap.get("touid");
        MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
    }
}
