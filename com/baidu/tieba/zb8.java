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
/* loaded from: classes7.dex */
public class zb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qb8 qb8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, qb8Var, i) == null) && qb8Var != null && qb8Var.v() != null && !ListUtils.isEmpty(qb8Var.j()) && qb8Var.j().size() >= 2) {
            List<NewFloorInfo> j = qb8Var.j();
            if (j.size() > 2) {
                if (StringHelper.equals(qb8Var.v().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (j.get(1) != null) {
                        if (j.get(1).is_floor.intValue() == 0) {
                            b(qb8Var, 12, i);
                            return;
                        } else if (j.get(1).is_floor.intValue() == 1) {
                            b(qb8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (j.get(1) != null) {
                    if (j.get(1).is_floor.intValue() == 0) {
                        if (qb8Var.p() != null) {
                            if (StringHelper.equals(qb8Var.p().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(qb8Var, 14, i);
                                return;
                            } else {
                                b(qb8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (j.get(1).is_floor.intValue() == 1) {
                        b(qb8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(qb8Var, 11, i);
        }
    }

    public static void b(qb8 qb8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, qb8Var, i, i2) == null) && qb8Var != null && qb8Var.r() != null && qb8Var.k() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", qb8Var.k().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", qb8Var.k().e);
            statisticItem.param("fname", qb8Var.k().d);
            statisticItem.param("pid", qb8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
