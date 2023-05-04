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
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vp9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class lk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(th7 th7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, th7Var, str) == null) && !TextUtils.isEmpty(str) && th7Var != null && !TextUtils.isEmpty(th7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", th7Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.F0() - j, frsModelController.H0(), frsModelController.G0(), currentTimeMillis - frsModelController.E0());
    }

    public static void b(v67 v67Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        b85 adAdSense;
        gb7 a0;
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{v67Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && v67Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<in> list2 = null;
            if (v67Var == null) {
                a0 = null;
            } else {
                a0 = v67Var.a0();
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
                    for (in inVar : list2) {
                        for (in inVar2 : list) {
                            if (inVar == inVar2 && (inVar2 instanceof ThreadData)) {
                                vp9.c cVar = new vp9.c();
                                ((ThreadData) inVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (in inVar3 : list) {
                        if (inVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) inVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                vp9.c cVar2 = new vp9.c();
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

    public static void c(d05 d05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, d05Var) != null) || d05Var == null) {
            return;
        }
        String e = d05Var.e();
        if (StringUtils.isNull(e)) {
            e = d05Var.h();
        }
        String str = e;
        String c = d05Var.c();
        String d = d05Var.d();
        String k = d05Var.k();
        vp9.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + d05Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController T0 = frsFragment.T0();
            v67 w1 = frsFragment.w1();
            if (w1 != null && T0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    th7 th7Var = new th7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    th7Var.a = z;
                    th7Var.c = frsViewData.getForum().getId();
                    th7Var.d = frsViewData.getForum().getName();
                    th7Var.b = T0.q0();
                    th7 th7Var2 = vh7.q0;
                    if (th7Var2 != null) {
                        th7Var.e = th7Var2.e;
                        th7Var.f = th7Var2.f;
                    }
                    uh7.k().h(th7Var, threadData, 1);
                    sh7.e(threadData, 1, frsFragment.getUniqueId(), th7Var, frsFragment.getTbPageTag());
                }
                b(w1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            wq4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            sh7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
