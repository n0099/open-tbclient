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
import com.baidu.tieba.b69;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class m77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(x57 x57Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, x57Var, str) == null) && !TextUtils.isEmpty(str) && x57Var != null && !TextUtils.isEmpty(x57Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", x57Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.x0() - j, frsModelController.z0(), frsModelController.y0(), currentTimeMillis - frsModelController.w0());
    }

    public static void b(fv6 fv6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        w75 adAdSense;
        qz6 a0;
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fv6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && fv6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<Cdo> list2 = null;
            if (fv6Var == null) {
                a0 = null;
            } else {
                a0 = fv6Var.a0();
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
                                b69.c cVar = new b69.c();
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
                                b69.c cVar2 = new b69.c();
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

    public static void c(b15 b15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, b15Var) != null) || b15Var == null) {
            return;
        }
        String d = b15Var.d();
        if (StringUtils.isNull(d)) {
            d = b15Var.g();
        }
        String str = d;
        String b = b15Var.b();
        String c = b15Var.c();
        String i = b15Var.i();
        b69.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + b15Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController P0 = frsFragment.P0();
            fv6 u1 = frsFragment.u1();
            if (u1 != null && P0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    x57 x57Var = new x57();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    x57Var.a = z;
                    x57Var.c = frsViewData.getForum().getId();
                    x57Var.d = frsViewData.getForum().getName();
                    x57Var.b = P0.i0();
                    x57 x57Var2 = z57.q0;
                    if (x57Var2 != null) {
                        x57Var.e = x57Var2.e;
                        x57Var.f = x57Var2.f;
                    }
                    y57.k().h(x57Var, threadData, 1);
                    w57.e(threadData, 1, frsFragment.getUniqueId(), x57Var, frsFragment.getTbPageTag());
                }
                b(u1, frsViewData, frsFragment.l(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            ks4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            w57.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
