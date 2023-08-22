package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.fga;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class jv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ms7 ms7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, ms7Var, str) == null) && !TextUtils.isEmpty(str) && ms7Var != null && !TextUtils.isEmpty(ms7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", ms7Var.c);
            statisticItem.param("obj_name", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void g(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65542, null, frsModelController, j) != null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.x0() - j, frsModelController.z0(), frsModelController.y0(), currentTimeMillis - frsModelController.w0());
    }

    public static void b(eh7 eh7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        zb5 adAdSense;
        ul7 a0;
        List<bn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{eh7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && eh7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<bn> list2 = null;
            if (eh7Var == null) {
                a0 = null;
            } else {
                a0 = eh7Var.a0();
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
                    for (bn bnVar : list2) {
                        for (bn bnVar2 : list) {
                            if (bnVar == bnVar2 && (bnVar2 instanceof ThreadData)) {
                                fga.c cVar = new fga.c();
                                ((ThreadData) bnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (bn bnVar3 : list) {
                        if (bnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) bnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                fga.c cVar2 = new fga.c();
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

    public static void c(a45 a45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, a45Var) != null) || a45Var == null) {
            return;
        }
        String e = a45Var.e();
        if (StringUtils.isNull(e)) {
            e = a45Var.h();
        }
        String str = e;
        String c = a45Var.c();
        String d = a45Var.d();
        String k = a45Var.k();
        fga.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + a45Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController e1 = frsFragment.e1();
            eh7 L1 = frsFragment.L1();
            if (L1 != null && e1 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    ms7 ms7Var = new ms7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ms7Var.a = z;
                    ms7Var.c = frsViewData.getForum().getId();
                    ms7Var.d = frsViewData.getForum().getName();
                    ms7Var.b = e1.i0();
                    ms7 ms7Var2 = os7.q0;
                    if (ms7Var2 != null) {
                        ms7Var.e = ms7Var2.e;
                        ms7Var.f = ms7Var2.f;
                    }
                    ns7.k().h(ms7Var, threadData, 1);
                    ls7.e(threadData, 1, frsFragment.getUniqueId(), ms7Var, frsFragment.getTbPageTag());
                }
                b(L1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            zt4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(String str, int i, int i2, @NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), exc}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "recycleviewNotify").param("obj_source", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("obj_param1", i).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("extra", exc.toString()));
            throw new RuntimeException(exc);
        }
    }

    public static void h(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65543, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            ls7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
