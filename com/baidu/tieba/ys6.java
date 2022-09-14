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
import com.baidu.tieba.an8;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class ys6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(nr6 nr6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, nr6Var, str) == null) || TextUtils.isEmpty(str) || nr6Var == null || TextUtils.isEmpty(nr6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", nr6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(wg6 wg6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        yz4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{wg6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || wg6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        el6 X = wg6Var == null ? null : wg6Var.X();
        List<Cdo> f = X != null ? X.f() : null;
        List<Cdo> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (Cdo cdo : f) {
                for (Cdo cdo2 : singletonList) {
                    if (cdo == cdo2 && (cdo2 instanceof ThreadData)) {
                        an8.c cVar = new an8.c();
                        ((ThreadData) cdo2).getTid();
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (Cdo cdo3 : singletonList) {
                if (cdo3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) cdo3;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        an8.c cVar2 = new an8.c();
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

    public static void c(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, mt4Var) == null) || mt4Var == null) {
            return;
        }
        String d = mt4Var.d();
        if (StringUtils.isNull(d)) {
            d = mt4Var.f();
        }
        String str = d;
        String b = mt4Var.b();
        String c = mt4Var.c();
        String g = mt4Var.g();
        an8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + mt4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController J0 = frsFragment.J0();
        wg6 j1 = frsFragment.j1();
        if (j1 == null || J0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            nr6 nr6Var = new nr6();
            nr6Var.a = frsViewData.needLog == 1;
            nr6Var.c = frsViewData.getForum().getId();
            nr6Var.d = frsViewData.getForum().getName();
            nr6Var.b = J0.U();
            nr6 nr6Var2 = pr6.p0;
            if (nr6Var2 != null) {
                nr6Var.e = nr6Var2.e;
                nr6Var.f = nr6Var2.f;
            }
            or6.k().h(nr6Var, threadData, 1);
            mr6.e(threadData, 1, frsFragment.getUniqueId(), nr6Var, frsFragment.getTbPageTag());
        }
        b(j1, frsViewData, frsFragment.d(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            xl4.a(param, str);
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
        mr6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
