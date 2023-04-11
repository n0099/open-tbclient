package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ns7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, hn hnVar) {
        InterceptResult invokeLL;
        eh6 eh6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, hnVar)) == null) {
            if ((hnVar instanceof eh6) && (threadData = (eh6Var = (eh6) hnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(eh6Var.a.getVoiceRoomData().room_name) && eh6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((yh5) ServiceManager.getService(yh5.a.a())).b(tbPageContext, eh6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
