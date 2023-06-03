package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, vn vnVar) {
        InterceptResult invokeLL;
        mo6 mo6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, vnVar)) == null) {
            if ((vnVar instanceof mo6) && (threadData = (mo6Var = (mo6) vnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(mo6Var.a.getVoiceRoomData().room_name) && mo6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((do5) ServiceManager.getService(do5.a.a())).b(tbPageContext, mo6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
