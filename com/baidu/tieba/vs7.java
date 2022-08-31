package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.ExcPbPage.DataRes;
import tbclient.ExcPbPage.ExcPbPageResIdl;
/* loaded from: classes6.dex */
public class vs7 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vs7() {
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

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        ExcPbPageResIdl excPbPageResIdl;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            us7 us7Var = null;
            if (customMessage != null && customMessage.getCmd() == 2001314) {
                ur4.f();
                byte[] bArr = ur4.d("tb.pb_normal").get("chosen_pb_page_cache");
                if (bArr != null) {
                    try {
                        excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
                    } catch (Exception unused) {
                        excPbPageResIdl = null;
                    }
                    if (excPbPageResIdl != null && (dataRes = excPbPageResIdl.data) != null) {
                        us7Var = new us7(dataRes.user_info, dataRes.thread_info, dataRes.post_list, dataRes.user_list);
                    }
                }
                return new ReadChosenPbCacheResponse(us7Var);
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
