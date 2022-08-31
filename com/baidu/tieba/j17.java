package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, pn pnVar) {
        InterceptResult invokeLL;
        l06 l06Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, pnVar)) == null) {
            if (!(pnVar instanceof l06) || (threadData = (l06Var = (l06) pnVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(l06Var.a.getVoiceRoomData().room_name) || l06Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((b75) ServiceManager.getService(b75.a.a())).a(tbPageContext, l06Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
