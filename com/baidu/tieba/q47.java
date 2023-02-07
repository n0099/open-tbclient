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
import com.baidu.tieba.l19;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class q47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b37 b37Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, b37Var, str) == null) && !TextUtils.isEmpty(str) && b37Var != null && !TextUtils.isEmpty(b37Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", b37Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.q0() - j, frsModelController.s0(), frsModelController.r0(), currentTimeMillis - frsModelController.p0());
    }

    public static void b(gs6 gs6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        k65 adAdSense;
        rw6 a0;
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gs6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && gs6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<Cdo> list2 = null;
            if (gs6Var == null) {
                a0 = null;
            } else {
                a0 = gs6Var.a0();
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
                    for (Cdo cdo : list2) {
                        for (Cdo cdo2 : list) {
                            if (cdo == cdo2 && (cdo2 instanceof ThreadData)) {
                                l19.c cVar = new l19.c();
                                ((ThreadData) cdo2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (Cdo cdo3 : list) {
                        if (cdo3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) cdo3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                l19.c cVar2 = new l19.c();
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

    public static void c(uz4 uz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, uz4Var) != null) || uz4Var == null) {
            return;
        }
        String d = uz4Var.d();
        if (StringUtils.isNull(d)) {
            d = uz4Var.g();
        }
        String str = d;
        String b = uz4Var.b();
        String c = uz4Var.c();
        String i = uz4Var.i();
        l19.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + uz4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController Q0 = frsFragment.Q0();
            gs6 u1 = frsFragment.u1();
            if (u1 != null && Q0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    b37 b37Var = new b37();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b37Var.a = z;
                    b37Var.c = frsViewData.getForum().getId();
                    b37Var.d = frsViewData.getForum().getName();
                    b37Var.b = Q0.b0();
                    b37 b37Var2 = d37.q0;
                    if (b37Var2 != null) {
                        b37Var.e = b37Var2.e;
                        b37Var.f = b37Var2.f;
                    }
                    c37.k().h(b37Var, threadData, 1);
                    a37.e(threadData, 1, frsFragment.getUniqueId(), b37Var, frsFragment.getTbPageTag());
                }
                b(u1, frsViewData, frsFragment.l(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            ur4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            a37.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
