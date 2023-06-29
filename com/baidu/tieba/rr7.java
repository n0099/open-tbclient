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
import com.baidu.tieba.t4a;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class rr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(zo7 zo7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, zo7Var, str) == null) && !TextUtils.isEmpty(str) && zo7Var != null && !TextUtils.isEmpty(zo7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", zo7Var.c);
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

    public static void b(yd7 yd7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        mc5 adAdSense;
        ji7 a0;
        List<xn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{yd7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && yd7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<xn> list2 = null;
            if (yd7Var == null) {
                a0 = null;
            } else {
                a0 = yd7Var.a0();
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
                    for (xn xnVar : list2) {
                        for (xn xnVar2 : list) {
                            if (xnVar == xnVar2 && (xnVar2 instanceof ThreadData)) {
                                t4a.c cVar = new t4a.c();
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
                                t4a.c cVar2 = new t4a.c();
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

    public static void c(p45 p45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, p45Var) != null) || p45Var == null) {
            return;
        }
        String e = p45Var.e();
        if (StringUtils.isNull(e)) {
            e = p45Var.h();
        }
        String str = e;
        String c = p45Var.c();
        String d = p45Var.d();
        String k = p45Var.k();
        t4a.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + p45Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController V0 = frsFragment.V0();
            yd7 y1 = frsFragment.y1();
            if (y1 != null && V0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    zo7 zo7Var = new zo7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zo7Var.a = z;
                    zo7Var.c = frsViewData.getForum().getId();
                    zo7Var.d = frsViewData.getForum().getName();
                    zo7Var.b = V0.p0();
                    zo7 zo7Var2 = bp7.q0;
                    if (zo7Var2 != null) {
                        zo7Var.e = zo7Var2.e;
                        zo7Var.f = zo7Var2.f;
                    }
                    ap7.k().h(zo7Var, threadData, 1);
                    yo7.e(threadData, 1, frsFragment.getUniqueId(), zo7Var, frsFragment.getTbPageTag());
                }
                b(y1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            bv4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            yo7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
