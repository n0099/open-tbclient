package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, yn ynVar) {
        InterceptResult invokeLL;
        cq6 cq6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, ynVar)) == null) {
            if ((ynVar instanceof cq6) && (threadData = (cq6Var = (cq6) ynVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(cq6Var.a.getVoiceRoomData().room_name) && cq6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((qp5) ServiceManager.getService(qp5.a.a())).b(tbPageContext, cq6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
