package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes8.dex */
public final class uu8 {
    public static /* synthetic */ Interceptable $ic;
    public static final uu8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223601, "Lcom/baidu/tieba/uu8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223601, "Lcom/baidu/tieba/uu8;");
                return;
            }
        }
        a = new uu8();
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final String i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i > 0 ? "1" : "2" : (String) invokeI.objValue;
    }

    public uu8() {
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

    public final void h(List<tr8> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                int c = ForumChannelDataObs.c.a().c();
                for (tr8 tr8Var : data) {
                    if (tr8Var.getType() == 3) {
                        a.c(tr8Var.c(), c);
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
            a("msgCenterChatTabMC:" + chatCount);
            TiebaStatic.log(new StatisticItem("c15331").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i(chatCount)));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            a("msgCenterChatTabPV:" + m);
            TiebaStatic.log(new StatisticItem("c15332").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i(m.getChatCount())));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            int notificationCount = m.getNotificationCount() + m.getMsgCount();
            a("msgCenterNotifyTabMC:" + notificationCount);
            TiebaStatic.log(new StatisticItem("c15329").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i(notificationCount)));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            a("msgCenterNotifyTabPV:" + m);
            TiebaStatic.log(new StatisticItem("c15330").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i(m.getNotificationCount() + m.getMsgCount())));
        }
    }
}
