package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, wn wnVar) {
        InterceptResult invokeLL;
        g46 g46Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, wnVar)) == null) {
            if ((wnVar instanceof g46) && (threadData = (g46Var = (g46) wnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(g46Var.a.getVoiceRoomData().room_name) && g46Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((va5) ServiceManager.getService(va5.a.a())).a(tbPageContext, g46Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
