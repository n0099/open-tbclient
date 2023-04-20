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
import com.baidu.tieba.gm9;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class qi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(yf7 yf7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, yf7Var, str) == null) && !TextUtils.isEmpty(str) && yf7Var != null && !TextUtils.isEmpty(yf7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", yf7Var.c);
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

    public static void b(f57 f57Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        l75 adAdSense;
        q97 a0;
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{f57Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && f57Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<in> list2 = null;
            if (f57Var == null) {
                a0 = null;
            } else {
                a0 = f57Var.a0();
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
                                gm9.c cVar = new gm9.c();
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
                                gm9.c cVar2 = new gm9.c();
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

    public static void c(nz4 nz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, nz4Var) != null) || nz4Var == null) {
            return;
        }
        String d = nz4Var.d();
        if (StringUtils.isNull(d)) {
            d = nz4Var.g();
        }
        String str = d;
        String b = nz4Var.b();
        String c = nz4Var.c();
        String i = nz4Var.i();
        gm9.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + nz4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController S0 = frsFragment.S0();
            f57 v1 = frsFragment.v1();
            if (v1 != null && S0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    yf7 yf7Var = new yf7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    yf7Var.a = z;
                    yf7Var.c = frsViewData.getForum().getId();
                    yf7Var.d = frsViewData.getForum().getName();
                    yf7Var.b = S0.l0();
                    yf7 yf7Var2 = ag7.q0;
                    if (yf7Var2 != null) {
                        yf7Var.e = yf7Var2.e;
                        yf7Var.f = yf7Var2.f;
                    }
                    zf7.k().h(yf7Var, threadData, 1);
                    xf7.e(threadData, 1, frsFragment.getUniqueId(), yf7Var, frsFragment.getTbPageTag());
                }
                b(v1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            uq4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            xf7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
