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
public class ze7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qe7 qe7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, qe7Var, i) == null) && qe7Var != null && qe7Var.C() != null && !ListUtils.isEmpty(qe7Var.n()) && qe7Var.n().size() >= 2) {
            List n = qe7Var.n();
            if (n.size() > 2) {
                if (StringHelper.equals(qe7Var.C().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (n.get(1) != null) {
                        if (((NewFloorInfo) n.get(1)).is_floor.intValue() == 0) {
                            b(qe7Var, 12, i);
                            return;
                        } else if (((NewFloorInfo) n.get(1)).is_floor.intValue() == 1) {
                            b(qe7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (n.get(1) != null) {
                    if (((NewFloorInfo) n.get(1)).is_floor.intValue() == 0) {
                        if (qe7Var.z() != null) {
                            if (StringHelper.equals(qe7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(qe7Var, 14, i);
                                return;
                            } else {
                                b(qe7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (((NewFloorInfo) n.get(1)).is_floor.intValue() == 1) {
                        b(qe7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(qe7Var, 11, i);
        }
    }

    public static void b(qe7 qe7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, qe7Var, i, i2) == null) && qe7Var != null && qe7Var.A() != null && qe7Var.r() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", qe7Var.r().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", qe7Var.r().e);
            statisticItem.param("fname", qe7Var.r().d);
            statisticItem.param("pid", qe7Var.t());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
