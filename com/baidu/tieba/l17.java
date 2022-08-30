package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, pn pnVar) {
        InterceptResult invokeLL;
        n06 n06Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, pnVar)) == null) {
            if (!(pnVar instanceof n06) || (threadData = (n06Var = (n06) pnVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(n06Var.a.getVoiceRoomData().room_name) || n06Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((d75) ServiceManager.getService(d75.a.a())).a(tbPageContext, n06Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
