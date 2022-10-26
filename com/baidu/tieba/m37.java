package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class m37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext tbPageContext, eo eoVar) {
        InterceptResult invokeLL;
        w26 w26Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, eoVar)) == null) {
            if ((eoVar instanceof w26) && (threadData = (w26Var = (w26) eoVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(w26Var.a.getVoiceRoomData().room_name) && w26Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((aa5) ServiceManager.getService(aa5.a.a())).a(tbPageContext, w26Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
