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
import com.baidu.tieba.ml8;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class nr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(dq6 dq6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, dq6Var, str) == null) || TextUtils.isEmpty(str) || dq6Var == null || TextUtils.isEmpty(dq6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", dq6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(gf6 gf6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        ox4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gf6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || gf6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        zj6 X = gf6Var == null ? null : gf6Var.X();
        List<pn> f = X != null ? X.f() : null;
        List<pn> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (pn pnVar : f) {
                for (pn pnVar2 : singletonList) {
                    if (pnVar == pnVar2 && (pnVar2 instanceof ThreadData)) {
                        ml8.c cVar = new ml8.c();
                        ((ThreadData) pnVar2).getTid();
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (pn pnVar3 : singletonList) {
                if (pnVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) pnVar3;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        ml8.c cVar2 = new ml8.c();
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

    public static void c(hr4 hr4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, hr4Var) == null) || hr4Var == null) {
            return;
        }
        String d = hr4Var.d();
        if (StringUtils.isNull(d)) {
            d = hr4Var.f();
        }
        String str = d;
        String b = hr4Var.b();
        String c = hr4Var.c();
        String g = hr4Var.g();
        ml8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + hr4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController K0 = frsFragment.K0();
        gf6 k1 = frsFragment.k1();
        if (k1 == null || K0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            dq6 dq6Var = new dq6();
            dq6Var.a = frsViewData.needLog == 1;
            dq6Var.c = frsViewData.getForum().getId();
            dq6Var.d = frsViewData.getForum().getName();
            dq6Var.b = K0.U();
            dq6 dq6Var2 = fq6.p0;
            if (dq6Var2 != null) {
                dq6Var.e = dq6Var2.e;
                dq6Var.f = dq6Var2.f;
            }
            eq6.k().h(dq6Var, threadData, 1);
            cq6.e(threadData, 1, frsFragment.getUniqueId(), dq6Var, frsFragment.getTbPageTag());
        }
        b(k1, frsViewData, frsFragment.d(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            xj4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65541, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.i0() - j, frsModelController.k0(), frsModelController.j0(), currentTimeMillis - frsModelController.h0());
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        cq6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
