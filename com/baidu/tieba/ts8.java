package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ts8 {
    public static /* synthetic */ Interceptable $ic;
    public static final ts8 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-393355725, "Lcom/baidu/tieba/ts8$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-393355725, "Lcom/baidu/tieba/ts8$a;");
                    return;
                }
            }
            int[] iArr = new int[NotifyType.values().length];
            iArr[NotifyType.AT_ME.ordinal()] = 1;
            iArr[NotifyType.AGREE_ME.ordinal()] = 2;
            iArr[NotifyType.REPLY_ME.ordinal()] = 3;
            iArr[NotifyType.FANS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948191888, "Lcom/baidu/tieba/ts8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948191888, "Lcom/baidu/tieba/ts8;");
                return;
            }
        }
        a = new ts8();
    }

    public ts8() {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
        }
    }

    public final void a(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            StatisticItem param = new StatisticItem("c12926").param("uid", TbadkCoreApplication.getCurrentAccount());
            if (i > 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(param.param("obj_type", i2).param("obj_param1", i));
        }
    }

    public final void b(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TiebaStatic.log("c12925");
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (i > 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(param.param("obj_type", i2).param("obj_param1", i));
        }
    }

    public final void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int y = be5.p0().y();
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_FANS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (y > 0) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(param.param("obj_type", i).param("obj_param1", y));
        }
    }

    public final void e() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int B = be5.p0().B();
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (B > 0) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(param.param("obj_type", i).param("obj_param1", B));
        }
    }

    public final void d(np8 np8Var) {
        NotifyType notifyType;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, np8Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (np8Var != null) {
                notifyType = np8Var.getType();
            } else {
                notifyType = null;
            }
            if (notifyType == null) {
                i = -1;
            } else {
                i = a.$EnumSwitchMapping$0[notifyType.ordinal()];
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            statisticItem.param("obj_type", 4);
                        }
                    } else {
                        statisticItem.param("obj_type", 3);
                    }
                } else {
                    statisticItem.param("obj_type", 2);
                }
            } else {
                statisticItem.param("obj_type", 1);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null) {
            TiebaStatic.eventStat(context, "msg_atme_tab_click", "click", 1, new Object[0]);
        }
    }

    public final void h(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            StatisticItem statisticItem = new StatisticItem("c13616");
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
