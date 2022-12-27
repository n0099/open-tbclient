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
public class tj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(kj7 kj7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, kj7Var, i) == null) && kj7Var != null && kj7Var.y() != null && !ListUtils.isEmpty(kj7Var.m()) && kj7Var.m().size() >= 2) {
            List<NewFloorInfo> m = kj7Var.m();
            if (m.size() > 2) {
                if (StringHelper.equals(kj7Var.y().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (m.get(1) != null) {
                        if (m.get(1).is_floor.intValue() == 0) {
                            b(kj7Var, 12, i);
                            return;
                        } else if (m.get(1).is_floor.intValue() == 1) {
                            b(kj7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (m.get(1) != null) {
                    if (m.get(1).is_floor.intValue() == 0) {
                        if (kj7Var.s() != null) {
                            if (StringHelper.equals(kj7Var.s().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(kj7Var, 14, i);
                                return;
                            } else {
                                b(kj7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (m.get(1).is_floor.intValue() == 1) {
                        b(kj7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(kj7Var, 11, i);
        }
    }

    public static void b(kj7 kj7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, kj7Var, i, i2) == null) && kj7Var != null && kj7Var.v() != null && kj7Var.o() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", kj7Var.o().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", kj7Var.o().e);
            statisticItem.param("fname", kj7Var.o().d);
            statisticItem.param("pid", kj7Var.q());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
