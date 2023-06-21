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
import com.baidu.tieba.h0a;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class mr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(uo7 uo7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, uo7Var, str) == null) && !TextUtils.isEmpty(str) && uo7Var != null && !TextUtils.isEmpty(uo7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", uo7Var.c);
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

    public static void b(td7 td7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        jc5 adAdSense;
        ei7 a0;
        List<wn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{td7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && td7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<wn> list2 = null;
            if (td7Var == null) {
                a0 = null;
            } else {
                a0 = td7Var.a0();
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
                    for (wn wnVar : list2) {
                        for (wn wnVar2 : list) {
                            if (wnVar == wnVar2 && (wnVar2 instanceof ThreadData)) {
                                h0a.c cVar = new h0a.c();
                                ((ThreadData) wnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (wn wnVar3 : list) {
                        if (wnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) wnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                h0a.c cVar2 = new h0a.c();
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

    public static void c(m45 m45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, m45Var) != null) || m45Var == null) {
            return;
        }
        String e = m45Var.e();
        if (StringUtils.isNull(e)) {
            e = m45Var.h();
        }
        String str = e;
        String c = m45Var.c();
        String d = m45Var.d();
        String k = m45Var.k();
        h0a.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + m45Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController V0 = frsFragment.V0();
            td7 y1 = frsFragment.y1();
            if (y1 != null && V0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    uo7 uo7Var = new uo7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    uo7Var.a = z;
                    uo7Var.c = frsViewData.getForum().getId();
                    uo7Var.d = frsViewData.getForum().getName();
                    uo7Var.b = V0.p0();
                    uo7 uo7Var2 = wo7.q0;
                    if (uo7Var2 != null) {
                        uo7Var.e = uo7Var2.e;
                        uo7Var.f = uo7Var2.f;
                    }
                    vo7.k().h(uo7Var, threadData, 1);
                    to7.e(threadData, 1, frsFragment.getUniqueId(), uo7Var, frsFragment.getTbPageTag());
                }
                b(y1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            yu4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            to7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
