package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes6.dex */
public class lp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(wo8 wo8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, wo8Var, i) == null) && wo8Var != null && wo8Var.u() != null && !ListUtils.isEmpty(wo8Var.i()) && wo8Var.i().size() >= 2) {
            List<NewFloorInfo> i2 = wo8Var.i();
            if (i2.size() > 2) {
                if (StringHelper.equals(wo8Var.u().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (i2.get(1) != null) {
                        if (i2.get(1).is_floor.intValue() == 0) {
                            b(wo8Var, 12, i);
                            return;
                        } else if (i2.get(1).is_floor.intValue() == 1) {
                            b(wo8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (i2.get(1) != null) {
                    if (i2.get(1).is_floor.intValue() == 0) {
                        if (wo8Var.q() != null) {
                            if (StringHelper.equals(wo8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(wo8Var, 14, i);
                                return;
                            } else {
                                b(wo8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (i2.get(1).is_floor.intValue() == 1) {
                        b(wo8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(wo8Var, 11, i);
        }
    }

    public static void b(wo8 wo8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, wo8Var, i, i2) == null) && wo8Var != null && wo8Var.r() != null && wo8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", wo8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", wo8Var.l().e);
            statisticItem.param("fname", wo8Var.l().d);
            statisticItem.param("pid", wo8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
