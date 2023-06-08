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
public class rj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ij8 ij8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, ij8Var, i) == null) && ij8Var != null && ij8Var.w() != null && !ListUtils.isEmpty(ij8Var.k()) && ij8Var.k().size() >= 2) {
            List<NewFloorInfo> k = ij8Var.k();
            if (k.size() > 2) {
                if (StringHelper.equals(ij8Var.w().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (k.get(1) != null) {
                        if (k.get(1).is_floor.intValue() == 0) {
                            b(ij8Var, 12, i);
                            return;
                        } else if (k.get(1).is_floor.intValue() == 1) {
                            b(ij8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        if (ij8Var.q() != null) {
                            if (StringHelper.equals(ij8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(ij8Var, 14, i);
                                return;
                            } else {
                                b(ij8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(ij8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(ij8Var, 11, i);
        }
    }

    public static void b(ij8 ij8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, ij8Var, i, i2) == null) && ij8Var != null && ij8Var.s() != null && ij8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", ij8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", ij8Var.l().e);
            statisticItem.param("fname", ij8Var.l().d);
            statisticItem.param("pid", ij8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
