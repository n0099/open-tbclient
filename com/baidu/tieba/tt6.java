package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.wn8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class tt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(hs6 hs6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, hs6Var, str) == null) && !TextUtils.isEmpty(str) && hs6Var != null && !TextUtils.isEmpty(hs6Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", hs6Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.i0() - j, frsModelController.k0(), frsModelController.j0(), currentTimeMillis - frsModelController.h0());
    }

    public static void b(qh6 qh6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        q05 adAdSense;
        yl6 Y;
        List<eo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qh6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && qh6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<eo> list2 = null;
            if (qh6Var == null) {
                Y = null;
            } else {
                Y = qh6Var.Y();
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
                    for (eo eoVar : list2) {
                        for (eo eoVar2 : list) {
                            if (eoVar == eoVar2 && (eoVar2 instanceof ThreadData)) {
                                wn8.c cVar = new wn8.c();
                                ((ThreadData) eoVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (eo eoVar3 : list) {
                        if (eoVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) eoVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                wn8.c cVar2 = new wn8.c();
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

    public static void c(bu4 bu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, bu4Var) != null) || bu4Var == null) {
            return;
        }
        String d = bu4Var.d();
        if (StringUtils.isNull(d)) {
            d = bu4Var.f();
        }
        String str = d;
        String b = bu4Var.b();
        String c = bu4Var.c();
        String g = bu4Var.g();
        wn8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + bu4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController J0 = frsFragment.J0();
            qh6 j1 = frsFragment.j1();
            if (j1 != null && J0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    hs6 hs6Var = new hs6();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    hs6Var.a = z;
                    hs6Var.c = frsViewData.getForum().getId();
                    hs6Var.d = frsViewData.getForum().getName();
                    hs6Var.b = J0.U();
                    hs6 hs6Var2 = js6.p0;
                    if (hs6Var2 != null) {
                        hs6Var.e = hs6Var2.e;
                        hs6Var.f = hs6Var2.f;
                    }
                    is6.k().h(hs6Var, threadData, 1);
                    gs6.e(threadData, 1, frsFragment.getUniqueId(), hs6Var, frsFragment.getTbPageTag());
                }
                b(j1, frsViewData, frsFragment.k(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            lm4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(ThreadData threadData, FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            gs6.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
