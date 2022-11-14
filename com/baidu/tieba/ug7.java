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
public class ug7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(lg7 lg7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, lg7Var, i) == null) && lg7Var != null && lg7Var.C() != null && !ListUtils.isEmpty(lg7Var.n()) && lg7Var.n().size() >= 2) {
            List<NewFloorInfo> n = lg7Var.n();
            if (n.size() > 2) {
                if (StringHelper.equals(lg7Var.C().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (n.get(1) != null) {
                        if (n.get(1).is_floor.intValue() == 0) {
                            b(lg7Var, 12, i);
                            return;
                        } else if (n.get(1).is_floor.intValue() == 1) {
                            b(lg7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        if (lg7Var.z() != null) {
                            if (StringHelper.equals(lg7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(lg7Var, 14, i);
                                return;
                            } else {
                                b(lg7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(lg7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(lg7Var, 11, i);
        }
    }

    public static void b(lg7 lg7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, lg7Var, i, i2) == null) && lg7Var != null && lg7Var.A() != null && lg7Var.r() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", lg7Var.r().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", lg7Var.r().e);
            statisticItem.param("fname", lg7Var.r().d);
            statisticItem.param("pid", lg7Var.t());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
