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
public class s48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, ym ymVar) {
        InterceptResult invokeLL;
        kn6 kn6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, ymVar)) == null) {
            if ((ymVar instanceof kn6) && (threadData = (kn6Var = (kn6) ymVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(kn6Var.a.getVoiceRoomData().room_name) && kn6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(tbPageContext, kn6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
