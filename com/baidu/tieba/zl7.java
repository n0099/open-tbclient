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
import com.baidu.tieba.yr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class zl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(hj7 hj7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, hj7Var, str) == null) && !TextUtils.isEmpty(str) && hj7Var != null && !TextUtils.isEmpty(hj7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", hj7Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.E0() - j, frsModelController.G0(), frsModelController.F0(), currentTimeMillis - frsModelController.D0());
    }

    public static void b(j87 j87Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        k95 adAdSense;
        uc7 a0;
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{j87Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && j87Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<rn> list2 = null;
            if (j87Var == null) {
                a0 = null;
            } else {
                a0 = j87Var.a0();
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
                    for (rn rnVar : list2) {
                        for (rn rnVar2 : list) {
                            if (rnVar == rnVar2 && (rnVar2 instanceof ThreadData)) {
                                yr9.c cVar = new yr9.c();
                                ((ThreadData) rnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (rn rnVar3 : list) {
                        if (rnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) rnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                yr9.c cVar2 = new yr9.c();
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

    public static void c(m15 m15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, m15Var) != null) || m15Var == null) {
            return;
        }
        String e = m15Var.e();
        if (StringUtils.isNull(e)) {
            e = m15Var.h();
        }
        String str = e;
        String c = m15Var.c();
        String d = m15Var.d();
        String k = m15Var.k();
        yr9.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + m15Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController U0 = frsFragment.U0();
            j87 x1 = frsFragment.x1();
            if (x1 != null && U0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    hj7 hj7Var = new hj7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    hj7Var.a = z;
                    hj7Var.c = frsViewData.getForum().getId();
                    hj7Var.d = frsViewData.getForum().getName();
                    hj7Var.b = U0.p0();
                    hj7 hj7Var2 = jj7.q0;
                    if (hj7Var2 != null) {
                        hj7Var.e = hj7Var2.e;
                        hj7Var.f = hj7Var2.f;
                    }
                    ij7.k().h(hj7Var, threadData, 1);
                    gj7.e(threadData, 1, frsFragment.getUniqueId(), hj7Var, frsFragment.getTbPageTag());
                }
                b(x1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            fs4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            gj7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
