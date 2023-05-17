package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, rn rnVar) {
        InterceptResult invokeLL;
        ck6 ck6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, rnVar)) == null) {
            if ((rnVar instanceof ck6) && (threadData = (ck6Var = (ck6) rnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(ck6Var.a.getVoiceRoomData().room_name) && ck6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((bk5) ServiceManager.getService(bk5.a.a())).b(tbPageContext, ck6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
