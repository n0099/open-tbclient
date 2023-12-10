package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.PeiwanInfo;
/* loaded from: classes7.dex */
public class ki8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, threadData) == null) && threadData != null && threadData.getPeiwanInfo() != null) {
            PeiwanInfo peiwanInfo = threadData.getPeiwanInfo();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_locate", String.valueOf(threadData.floorPosition));
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, peiwanInfo.room_id.longValue());
            if (threadData.isFromNet) {
                str = "1";
            } else {
                str = "0";
            }
            statisticItem.addParam("obj_param1", str);
            statisticItem.eventStat();
        }
    }

    public static boolean b(TbPageContext<?> tbPageContext, pi piVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbPageContext, piVar)) == null) {
            if (piVar instanceof um6) {
                um6 um6Var = (um6) piVar;
                ThreadData threadData = um6Var.a;
                if (threadData != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(um6Var.a.getVoiceRoomData().room_name) && um6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                    ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(tbPageContext, um6Var.a.getVoiceRoomData().room_id.longValue());
                    return true;
                }
                ThreadData threadData2 = um6Var.a;
                if (threadData2 != null && threadData2.getPeiwanInfo() != null && !StringUtils.isNull(um6Var.a.getPeiwanInfo().scheme)) {
                    UrlManager.getInstance().dealOneLink(um6Var.a.getPeiwanInfo().scheme);
                    a(um6Var.a);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
