package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, bn bnVar) {
        InterceptResult invokeLL;
        ro6 ro6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, bnVar)) == null) {
            if ((bnVar instanceof ro6) && (threadData = (ro6Var = (ro6) bnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(ro6Var.a.getVoiceRoomData().room_name) && ro6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(tbPageContext, ro6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
