package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, wn wnVar) {
        InterceptResult invokeLL;
        to6 to6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, wnVar)) == null) {
            if ((wnVar instanceof to6) && (threadData = (to6Var = (to6) wnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(to6Var.a.getVoiceRoomData().room_name) && to6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((jo5) ServiceManager.getService(jo5.a.a())).b(tbPageContext, to6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
