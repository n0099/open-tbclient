package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, gn gnVar) {
        InterceptResult invokeLL;
        sf6 sf6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, gnVar)) == null) {
            if ((gnVar instanceof sf6) && (threadData = (sf6Var = (sf6) gnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(sf6Var.a.getVoiceRoomData().room_name) && sf6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((ug5) ServiceManager.getService(ug5.a.a())).a(tbPageContext, sf6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
