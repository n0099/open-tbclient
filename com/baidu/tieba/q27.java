package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, Cdo cdo) {
        InterceptResult invokeLL;
        c26 c26Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, cdo)) == null) {
            if (!(cdo instanceof c26) || (threadData = (c26Var = (c26) cdo).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(c26Var.a.getVoiceRoomData().room_name) || c26Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((j95) ServiceManager.getService(j95.a.a())).a(tbPageContext, c26Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
