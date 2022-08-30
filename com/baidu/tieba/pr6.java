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
import com.baidu.tieba.ol8;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class pr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fq6 fq6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, fq6Var, str) == null) || TextUtils.isEmpty(str) || fq6Var == null || TextUtils.isEmpty(fq6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", fq6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(if6 if6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        qx4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{if6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || if6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        bk6 X = if6Var == null ? null : if6Var.X();
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
                        ol8.c cVar = new ol8.c();
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
                        ol8.c cVar2 = new ol8.c();
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

    public static void c(ir4 ir4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, ir4Var) == null) || ir4Var == null) {
            return;
        }
        String d = ir4Var.d();
        if (StringUtils.isNull(d)) {
            d = ir4Var.f();
        }
        String str = d;
        String b = ir4Var.b();
        String c = ir4Var.c();
        String g = ir4Var.g();
        ol8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + ir4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController K0 = frsFragment.K0();
        if6 k1 = frsFragment.k1();
        if (k1 == null || K0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            fq6 fq6Var = new fq6();
            fq6Var.a = frsViewData.needLog == 1;
            fq6Var.c = frsViewData.getForum().getId();
            fq6Var.d = frsViewData.getForum().getName();
            fq6Var.b = K0.U();
            fq6 fq6Var2 = hq6.p0;
            if (fq6Var2 != null) {
                fq6Var.e = fq6Var2.e;
                fq6Var.f = fq6Var2.f;
            }
            gq6.k().h(fq6Var, threadData, 1);
            eq6.e(threadData, 1, frsFragment.getUniqueId(), fq6Var, frsFragment.getTbPageTag());
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
        eq6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
