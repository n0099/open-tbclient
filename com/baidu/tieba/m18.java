package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, vn vnVar) {
        InterceptResult invokeLL;
        oo6 oo6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, vnVar)) == null) {
            if ((vnVar instanceof oo6) && (threadData = (oo6Var = (oo6) vnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(oo6Var.a.getVoiceRoomData().room_name) && oo6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((fo5) ServiceManager.getService(fo5.a.a())).b(tbPageContext, oo6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
