package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.TopNotifyData;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.toptip.TopNotifyEvent;
import com.baidu.tieba.yf5;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final mg5 a;
    public static final String b;
    public static final String c;
    public static final AtomicInteger d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947971726, "Lcom/baidu/tieba/mg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947971726, "Lcom/baidu/tieba/mg5;");
                return;
            }
        }
        a = new mg5();
        b = "key_top_notify_show_time" + TbadkCoreApplication.getCurrentAccount();
        c = "key_top_notify_limit_count" + TbadkCoreApplication.getCurrentAccount();
        d = new AtomicInteger(0);
    }

    public mg5() {
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

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return d.get();
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.set(0);
            SharedPrefHelper.getInstance().putInt(c, 0);
        }
    }

    public static final void j(TopNotifyData topNotifyData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, topNotifyData) == null) {
            Intrinsics.checkNotNullParameter(topNotifyData, "$topNotifyData");
            a.a(topNotifyData.getJumpUrl());
            a.f(topNotifyData);
        }
    }

    public static final void k(TopNotifyData topNotifyData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, topNotifyData) == null) {
            Intrinsics.checkNotNullParameter(topNotifyData, "$topNotifyData");
            a.a(topNotifyData.getJumpUrl());
            a.f(topNotifyData);
        }
    }

    public static final void l(yt6.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar) == null) {
            e = false;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{str});
        }
    }

    public final boolean b(TopNotifyData topNotifyData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topNotifyData)) == null) {
            if (Intrinsics.areEqual(BdUtilHelper.getTopActivityName(), "com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity") && topNotifyData.getChatroomId() == rp5.a().c()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void m(TopNotifyData topNotifyData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, topNotifyData) == null) && topNotifyData.getWindowType() == 1) {
            d.incrementAndGet();
            SharedPrefHelper.getInstance().putInt(c, c());
        }
    }

    public final void n(TopNotifyData topNotifyData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, topNotifyData) == null) && topNotifyData.getWindowType() == 1) {
            SharedPrefHelper.getInstance().putLong(b, System.currentTimeMillis());
        }
    }

    public final boolean d(TopNotifyData topNotifyData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, topNotifyData)) == null) {
            Intrinsics.checkNotNullParameter(topNotifyData, "topNotifyData");
            if (!e(topNotifyData) || topNotifyData.getWindowType() != 1) {
                return false;
            }
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (TbadkCoreApplication.getInst().isMainProcess(true) && currentActivity == null) {
                TopNotifyEvent topNotifyEvent = new TopNotifyEvent();
                topNotifyEvent.topNotifyData = topNotifyData;
                topNotifyData.setSkinType(TbadkCoreApplication.getInst().getSkinType());
                MutiProcessManager.publishEvent(topNotifyEvent);
                return false;
            }
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().setSkinType(topNotifyData.getSkinType());
            }
            if (!b(topNotifyData) || e || topNotifyData.getWindowType() != 1) {
                return false;
            }
            long j = SharedPrefHelper.getInstance().getLong(c, 0L);
            if (System.currentTimeMillis() - SharedPrefHelper.getInstance().getLong(b, 0L) <= topNotifyData.getToastMinuteGap() * 60000) {
                if (j >= topNotifyData.getToastShowNumber()) {
                    return false;
                }
            } else {
                o();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(TopNotifyData topNotifyData) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, topNotifyData)) == null) {
            if (topNotifyData.getAvatar().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (topNotifyData.getTitle().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (topNotifyData.getContent().length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (topNotifyData.getCueWord().length() > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            if (topNotifyData.getJumpUrl().length() > 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5 && topNotifyData.getToastShowNumber() > 0 && topNotifyData.getToastMinuteGap() > 0) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f(TopNotifyData topNotifyData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, topNotifyData) == null) {
            new StatisticItem(CommonStatisticKey.KEY_TOP_NOTIFY_CLICK).param("fid", topNotifyData.getForumId()).param("room_id", topNotifyData.getChatroomId()).param("obj_type", cf5.a.h()).eventStat();
        }
    }

    public final void g(TopNotifyData topNotifyData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, topNotifyData) == null) {
            new StatisticItem(CommonStatisticKey.KEY_TOP_NOTIFY_SHOW).param("fid", topNotifyData.getForumId()).param("room_id", topNotifyData.getChatroomId()).param("obj_type", cf5.a.h()).eventStat();
        }
    }

    public final yf5 i(final TopNotifyData topNotifyData, final yt6.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, topNotifyData, eVar)) == null) {
            Intrinsics.checkNotNullParameter(topNotifyData, "topNotifyData");
            if (!d(topNotifyData)) {
                if (eVar != null) {
                    eVar.onDismiss();
                }
                return null;
            }
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                if (eVar != null) {
                    eVar.onDismiss();
                }
                return null;
            }
            yf5.g gVar = new yf5.g(currentActivity);
            gVar.w(zf5.a("SCENE_TOP_NOTIFY"));
            gVar.s(topNotifyData.getAvatar());
            gVar.y(topNotifyData.getTitle());
            gVar.q(topNotifyData.getContent());
            gVar.o(topNotifyData.getCueWord());
            gVar.x(topNotifyData.getForumName());
            gVar.r(topNotifyData.getToastShowTime() * 1000);
            gVar.u(new yf5.i() { // from class: com.baidu.tieba.ag5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yf5.i
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mg5.j(TopNotifyData.this);
                    }
                }
            });
            gVar.t(new yf5.h() { // from class: com.baidu.tieba.cg5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yf5.h
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mg5.k(TopNotifyData.this);
                    }
                }
            });
            gVar.v(new yf5.j() { // from class: com.baidu.tieba.bg5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yf5.j
                public final void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mg5.l(yt6.e.this);
                    }
                }
            });
            yf5 n = gVar.n();
            n.s();
            new WeakReference(n);
            n(topNotifyData);
            m(topNotifyData);
            e = true;
            g(topNotifyData);
            return n;
        }
        return (yf5) invokeLL.objValue;
    }
}
