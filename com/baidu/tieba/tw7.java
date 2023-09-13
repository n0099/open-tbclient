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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class tw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(vt7 vt7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, vt7Var, str) == null) && !TextUtils.isEmpty(str) && vt7Var != null && !TextUtils.isEmpty(vt7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", vt7Var.c);
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
        TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.w0() - j, frsModelController.y0(), frsModelController.x0(), currentTimeMillis - frsModelController.v0());
    }

    public static void b(li7 li7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        jc5 adAdSense;
        dn7 a0;
        List<cn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{li7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && li7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<cn> list2 = null;
            if (li7Var == null) {
                a0 = null;
            } else {
                a0 = li7Var.a0();
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
                    for (cn cnVar : list2) {
                        for (cn cnVar2 : list) {
                            if (cnVar == cnVar2 && (cnVar2 instanceof ThreadData)) {
                                zha.c cVar = new zha.c();
                                ((ThreadData) cnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (cn cnVar3 : list) {
                        if (cnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) cnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                zha.c cVar2 = new zha.c();
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

    public static void c(f45 f45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, f45Var) != null) || f45Var == null) {
            return;
        }
        String e = f45Var.e();
        if (StringUtils.isNull(e)) {
            e = f45Var.h();
        }
        String str = e;
        String c = f45Var.c();
        String d = f45Var.d();
        String k = f45Var.k();
        zha.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + f45Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController f1 = frsFragment.f1();
            li7 N1 = frsFragment.N1();
            if (N1 != null && f1 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    vt7 vt7Var = new vt7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    vt7Var.a = z;
                    vt7Var.c = frsViewData.getForum().getId();
                    vt7Var.d = frsViewData.getForum().getName();
                    vt7Var.b = f1.h0();
                    vt7 vt7Var2 = xt7.q0;
                    if (vt7Var2 != null) {
                        vt7Var.e = vt7Var2.e;
                        vt7Var.f = vt7Var2.f;
                    }
                    wt7.k().h(vt7Var, threadData, 1);
                    ut7.e(threadData, 1, frsFragment.getUniqueId(), vt7Var, frsFragment.getTbPageTag());
                }
                b(N1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            du4.a(param, str);
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
            ut7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
