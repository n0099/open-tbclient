package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.swa;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class z68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(u38 u38Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, u38Var, str) == null) && !TextUtils.isEmpty(str) && u38Var != null && !TextUtils.isEmpty(u38Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", u38Var.c);
            statisticItem.param("obj_name", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void g(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65542, null, frsModelController, j) != null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.y0() - j, frsModelController.A0(), frsModelController.z0(), currentTimeMillis - frsModelController.x0());
    }

    public static void b(ms7 ms7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        a85 adAdSense;
        gx7 a0;
        List<pi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ms7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && ms7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<pi> list2 = null;
            if (ms7Var == null) {
                a0 = null;
            } else {
                a0 = ms7Var.a0();
            }
            if (a0 != null) {
                list2 = a0.f();
            }
            if (threadData != null) {
                list = Collections.singletonList(threadData);
            } else {
                list = list2;
            }
            if (list != null && list2 != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    for (pi piVar : list2) {
                        for (pi piVar2 : list) {
                            if (piVar == piVar2 && (piVar2 instanceof ThreadData)) {
                                swa.c cVar = new swa.c();
                                ((ThreadData) piVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (pi piVar3 : list) {
                        if (piVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) piVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                swa.c cVar2 = new swa.c();
                                threadData2.getTid();
                                arrayList.add(cVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    frsViewData.getForum().getFirst_class();
                    frsViewData.getForum().getSecond_class();
                }
            }
        }
    }

    public static void c(kz4 kz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, kz4Var) != null) || kz4Var == null) {
            return;
        }
        String e = kz4Var.e();
        if (StringUtils.isNull(e)) {
            e = kz4Var.h();
        }
        String str = e;
        String c = kz4Var.c();
        String d = kz4Var.d();
        String k = kz4Var.k();
        swa.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + kz4Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController J1 = frsFragment.J1();
            ms7 u2 = frsFragment.u2();
            if (u2 != null && J1 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    u38 u38Var = new u38();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    u38Var.a = z;
                    u38Var.c = frsViewData.getForum().getId();
                    u38Var.d = frsViewData.getForum().getName();
                    u38Var.b = J1.j0();
                    u38 u38Var2 = w38.q0;
                    if (u38Var2 != null) {
                        u38Var.e = u38Var2.e;
                        u38Var.f = u38Var2.f;
                    }
                    v38.k().h(u38Var, threadData, 1);
                    t38.e(threadData, 1, frsFragment.getUniqueId(), u38Var, frsFragment.getTbPageTag());
                }
                b(u2, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            fp4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(String str, int i, int i2, @NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), exc}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "recycleviewNotify").param("obj_source", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("obj_param1", i).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("extra", exc.toString()));
            throw new RuntimeException(exc);
        }
    }

    public static void h(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65543, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            t38.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
