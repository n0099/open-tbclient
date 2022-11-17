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
import com.baidu.tieba.rp8;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class ov6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(du6 du6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, du6Var, str) == null) && !TextUtils.isEmpty(str) && du6Var != null && !TextUtils.isEmpty(du6Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", du6Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.j0() - j, frsModelController.l0(), frsModelController.k0(), currentTimeMillis - frsModelController.i0());
    }

    public static void b(nj6 nj6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        m15 adAdSense;
        wn6 Y;
        List<xn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{nj6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && nj6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<xn> list2 = null;
            if (nj6Var == null) {
                Y = null;
            } else {
                Y = nj6Var.Y();
            }
            if (Y != null) {
                list2 = Y.f();
            }
            if (threadData != null) {
                list = Collections.singletonList(threadData);
            } else {
                list = list2;
            }
            if (list != null && list2 != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    for (xn xnVar : list2) {
                        for (xn xnVar2 : list) {
                            if (xnVar == xnVar2 && (xnVar2 instanceof ThreadData)) {
                                rp8.c cVar = new rp8.c();
                                ((ThreadData) xnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (xn xnVar3 : list) {
                        if (xnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) xnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                rp8.c cVar2 = new rp8.c();
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

    public static void c(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, vu4Var) != null) || vu4Var == null) {
            return;
        }
        String d = vu4Var.d();
        if (StringUtils.isNull(d)) {
            d = vu4Var.g();
        }
        String str = d;
        String b = vu4Var.b();
        String c = vu4Var.c();
        String i = vu4Var.i();
        rp8.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + vu4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController J0 = frsFragment.J0();
            nj6 j1 = frsFragment.j1();
            if (j1 != null && J0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    du6 du6Var = new du6();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    du6Var.a = z;
                    du6Var.c = frsViewData.getForum().getId();
                    du6Var.d = frsViewData.getForum().getName();
                    du6Var.b = J0.U();
                    du6 du6Var2 = fu6.p0;
                    if (du6Var2 != null) {
                        du6Var.e = du6Var2.e;
                        du6Var.f = du6Var2.f;
                    }
                    eu6.k().h(du6Var, threadData, 1);
                    cu6.e(threadData, 1, frsFragment.getUniqueId(), du6Var, frsFragment.getTbPageTag());
                }
                b(j1, frsViewData, frsFragment.k(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            en4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            cu6.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
