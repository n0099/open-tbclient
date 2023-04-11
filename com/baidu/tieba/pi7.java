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
import com.baidu.tieba.yl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class pi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(xf7 xf7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, xf7Var, str) == null) && !TextUtils.isEmpty(str) && xf7Var != null && !TextUtils.isEmpty(xf7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", xf7Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.A0() - j, frsModelController.C0(), frsModelController.B0(), currentTimeMillis - frsModelController.z0());
    }

    public static void b(e57 e57Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        k75 adAdSense;
        p97 a0;
        List<hn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{e57Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && e57Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<hn> list2 = null;
            if (e57Var == null) {
                a0 = null;
            } else {
                a0 = e57Var.a0();
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
                    for (hn hnVar : list2) {
                        for (hn hnVar2 : list) {
                            if (hnVar == hnVar2 && (hnVar2 instanceof ThreadData)) {
                                yl9.c cVar = new yl9.c();
                                ((ThreadData) hnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (hn hnVar3 : list) {
                        if (hnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) hnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                yl9.c cVar2 = new yl9.c();
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

    public static void c(mz4 mz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, mz4Var) != null) || mz4Var == null) {
            return;
        }
        String d = mz4Var.d();
        if (StringUtils.isNull(d)) {
            d = mz4Var.g();
        }
        String str = d;
        String b = mz4Var.b();
        String c = mz4Var.c();
        String i = mz4Var.i();
        yl9.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + mz4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController S0 = frsFragment.S0();
            e57 v1 = frsFragment.v1();
            if (v1 != null && S0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    xf7 xf7Var = new xf7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    xf7Var.a = z;
                    xf7Var.c = frsViewData.getForum().getId();
                    xf7Var.d = frsViewData.getForum().getName();
                    xf7Var.b = S0.l0();
                    xf7 xf7Var2 = zf7.q0;
                    if (xf7Var2 != null) {
                        xf7Var.e = xf7Var2.e;
                        xf7Var.f = xf7Var2.f;
                    }
                    yf7.k().h(xf7Var, threadData, 1);
                    wf7.e(threadData, 1, frsFragment.getUniqueId(), xf7Var, frsFragment.getTbPageTag());
                }
                b(v1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            tq4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            wf7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
