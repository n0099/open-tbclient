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
/* loaded from: classes4.dex */
public class jg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ag7 ag7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, ag7Var, i) == null) && ag7Var != null && ag7Var.C() != null && !ListUtils.isEmpty(ag7Var.n()) && ag7Var.n().size() >= 2) {
            List<NewFloorInfo> n = ag7Var.n();
            if (n.size() > 2) {
                if (StringHelper.equals(ag7Var.C().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (n.get(1) != null) {
                        if (n.get(1).is_floor.intValue() == 0) {
                            b(ag7Var, 12, i);
                            return;
                        } else if (n.get(1).is_floor.intValue() == 1) {
                            b(ag7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        if (ag7Var.z() != null) {
                            if (StringHelper.equals(ag7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(ag7Var, 14, i);
                                return;
                            } else {
                                b(ag7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(ag7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(ag7Var, 11, i);
        }
    }

    public static void b(ag7 ag7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, ag7Var, i, i2) == null) && ag7Var != null && ag7Var.A() != null && ag7Var.r() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", ag7Var.r().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", ag7Var.r().e);
            statisticItem.param("fname", ag7Var.r().d);
            statisticItem.param("pid", ag7Var.t());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
