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
public class mu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(xt8 xt8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, xt8Var, i) == null) && xt8Var != null && xt8Var.u() != null && !ListUtils.isEmpty(xt8Var.i()) && xt8Var.i().size() >= 2) {
            List<NewFloorInfo> i2 = xt8Var.i();
            if (i2.size() > 2) {
                if (StringHelper.equals(xt8Var.u().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (i2.get(1) != null) {
                        if (i2.get(1).is_floor.intValue() == 0) {
                            b(xt8Var, 12, i);
                            return;
                        } else if (i2.get(1).is_floor.intValue() == 1) {
                            b(xt8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (i2.get(1) != null) {
                    if (i2.get(1).is_floor.intValue() == 0) {
                        if (xt8Var.q() != null) {
                            if (StringHelper.equals(xt8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(xt8Var, 14, i);
                                return;
                            } else {
                                b(xt8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (i2.get(1).is_floor.intValue() == 1) {
                        b(xt8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(xt8Var, 11, i);
        }
    }

    public static void b(xt8 xt8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, xt8Var, i, i2) == null) && xt8Var != null && xt8Var.s() != null && xt8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", xt8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", xt8Var.l().e);
            statisticItem.param("fname", xt8Var.l().d);
            statisticItem.param("pid", xt8Var.o());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
