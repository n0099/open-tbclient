package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ju7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, in inVar) {
        InterceptResult invokeLL;
        qi6 qi6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, inVar)) == null) {
            if ((inVar instanceof qi6) && (threadData = (qi6Var = (qi6) inVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(qi6Var.a.getVoiceRoomData().room_name) && qi6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((si5) ServiceManager.getService(si5.a.a())).b(tbPageContext, qi6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
