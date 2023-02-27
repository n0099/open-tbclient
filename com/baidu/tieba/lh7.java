package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, Cdo cdo) {
        InterceptResult invokeLL;
        eg6 eg6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, cdo)) == null) {
            if ((cdo instanceof eg6) && (threadData = (eg6Var = (eg6) cdo).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(eg6Var.a.getVoiceRoomData().room_name) && eg6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((ai5) ServiceManager.getService(ai5.a.a())).a(tbPageContext, eg6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
