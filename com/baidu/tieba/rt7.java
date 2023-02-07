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
public class rt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(it7 it7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, it7Var, i) == null) && it7Var != null && it7Var.y() != null && !ListUtils.isEmpty(it7Var.m()) && it7Var.m().size() >= 2) {
            List<NewFloorInfo> m = it7Var.m();
            if (m.size() > 2) {
                if (StringHelper.equals(it7Var.y().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (m.get(1) != null) {
                        if (m.get(1).is_floor.intValue() == 0) {
                            b(it7Var, 12, i);
                            return;
                        } else if (m.get(1).is_floor.intValue() == 1) {
                            b(it7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (m.get(1) != null) {
                    if (m.get(1).is_floor.intValue() == 0) {
                        if (it7Var.s() != null) {
                            if (StringHelper.equals(it7Var.s().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(it7Var, 14, i);
                                return;
                            } else {
                                b(it7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (m.get(1).is_floor.intValue() == 1) {
                        b(it7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(it7Var, 11, i);
        }
    }

    public static void b(it7 it7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, it7Var, i, i2) == null) && it7Var != null && it7Var.u() != null && it7Var.o() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", it7Var.o().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", it7Var.o().e);
            statisticItem.param("fname", it7Var.o().d);
            statisticItem.param("pid", it7Var.q());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
