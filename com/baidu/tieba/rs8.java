package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.obs.NewsRemindMsgMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class rs8 {
    public static /* synthetic */ Interceptable $ic;
    public static final rs8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132306, "Lcom/baidu/tieba/rs8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132306, "Lcom/baidu/tieba/rs8;");
                return;
            }
        }
        a = new rs8();
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i > 0 ? "1" : "2" : (String) invokeI.objValue;
    }

    public final String k(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? i > 0 ? "1" : z ? "3" : "2" : (String) invokeCommon.objValue;
    }

    public rs8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
            a("msgCenterChannelTabMC:" + l);
            if (l != null) {
                TiebaStatic.log(new StatisticItem("c15334").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", l.longValue()));
            }
        }
    }

    public final void i(List<op8> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                int c = ForumChannelDataObs.c.a().c();
                for (op8 op8Var : data) {
                    if (op8Var.getType() == 3) {
                        a.c(op8Var.c(), c);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void c(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            a("msgCenterChannelTabMV:forumId=" + j + "+,frsCount=" + i);
            TiebaStatic.log(new StatisticItem("c15333").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", j).param("obj_source", i));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int chatCount = NewsRemindMsgMonitor.f.a().m().getChatCount();
            boolean hasChatRemind = NewsRemindMsgMonitor.f.a().m().hasChatRemind();
            a("msgCenterChatTabMC:" + chatCount);
            StatisticItem statisticItem = new StatisticItem("c15331");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_type", k(chatCount, hasChatRemind));
            TiebaStatic.log(statisticItem);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            boolean hasChatRemind = NewsRemindMsgMonitor.f.a().m().hasChatRemind();
            a("msgCenterChatTabPV:" + m);
            StatisticItem statisticItem = new StatisticItem("c15332");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_type", k(m.getChatCount(), hasChatRemind));
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            int notificationCount = m.getNotificationCount() + m.getMsgCount();
            a("msgCenterNotifyTabMC:" + notificationCount);
            TiebaStatic.log(new StatisticItem("c15329").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", j(notificationCount)));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            a("msgCenterNotifyTabPV:" + m);
            TiebaStatic.log(new StatisticItem("c15330").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", j(m.getNotificationCount() + m.getMsgCount())));
        }
    }

    public final void h(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            if (!m.hasChatRemind() && !m.hasMsgRemind() && !m.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NEW_MSG_TAB_EXPLORE);
            statisticItem.addParam("obj_type", k(m.getChatCount() + m.getMsgCount() + m.getNotificationCount(), z));
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
