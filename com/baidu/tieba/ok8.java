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
public class ok8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(zj8 zj8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, zj8Var, i) == null) && zj8Var != null && zj8Var.w() != null && !ListUtils.isEmpty(zj8Var.k()) && zj8Var.k().size() >= 2) {
            List<NewFloorInfo> k = zj8Var.k();
            if (k.size() > 2) {
                if (StringHelper.equals(zj8Var.w().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (k.get(1) != null) {
                        if (k.get(1).is_floor.intValue() == 0) {
                            b(zj8Var, 12, i);
                            return;
                        } else if (k.get(1).is_floor.intValue() == 1) {
                            b(zj8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        if (zj8Var.q() != null) {
                            if (StringHelper.equals(zj8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(zj8Var, 14, i);
                                return;
                            } else {
                                b(zj8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(zj8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(zj8Var, 11, i);
        }
    }

    public static void b(zj8 zj8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, zj8Var, i, i2) == null) && zj8Var != null && zj8Var.s() != null && zj8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", zj8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", zj8Var.l().e);
            statisticItem.param("fname", zj8Var.l().d);
            statisticItem.param("pid", zj8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
