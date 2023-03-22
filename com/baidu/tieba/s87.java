package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.hc9;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class s87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c77 c77Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, c77Var, str) == null) && !TextUtils.isEmpty(str) && c77Var != null && !TextUtils.isEmpty(c77Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", c77Var.c);
            statisticItem.param("obj_name", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65541, null, frsModelController, j) != null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.B0() - j, frsModelController.D0(), frsModelController.C0(), currentTimeMillis - frsModelController.A0());
    }

    public static void b(kw6 kw6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        h65 adAdSense;
        v07 a0;
        List<gn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{kw6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && kw6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<gn> list2 = null;
            if (kw6Var == null) {
                a0 = null;
            } else {
                a0 = kw6Var.a0();
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
                    for (gn gnVar : list2) {
                        for (gn gnVar2 : list) {
                            if (gnVar == gnVar2 && (gnVar2 instanceof ThreadData)) {
                                hc9.c cVar = new hc9.c();
                                ((ThreadData) gnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (gn gnVar3 : list) {
                        if (gnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) gnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                hc9.c cVar2 = new hc9.c();
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
        String d = kz4Var.d();
        if (StringUtils.isNull(d)) {
            d = kz4Var.g();
        }
        String str = d;
        String b = kz4Var.b();
        String c = kz4Var.c();
        String i = kz4Var.i();
        hc9.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + kz4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController Q0 = frsFragment.Q0();
            kw6 v1 = frsFragment.v1();
            if (v1 != null && Q0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    c77 c77Var = new c77();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c77Var.a = z;
                    c77Var.c = frsViewData.getForum().getId();
                    c77Var.d = frsViewData.getForum().getName();
                    c77Var.b = Q0.m0();
                    c77 c77Var2 = e77.q0;
                    if (c77Var2 != null) {
                        c77Var.e = c77Var2.e;
                        c77Var.f = c77Var2.f;
                    }
                    d77.k().h(c77Var, threadData, 1);
                    b77.e(threadData, 1, frsFragment.getUniqueId(), c77Var, frsFragment.getTbPageTag());
                }
                b(v1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            rq4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            b77.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
