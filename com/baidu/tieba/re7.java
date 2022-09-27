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
/* loaded from: classes5.dex */
public class re7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ie7 ie7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, ie7Var, i) == null) || ie7Var == null || ie7Var.C() == null || ListUtils.isEmpty(ie7Var.n()) || ie7Var.n().size() < 2) {
            return;
        }
        List<NewFloorInfo> n = ie7Var.n();
        if (n.size() > 2) {
            if (StringHelper.equals(ie7Var.C().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        b(ie7Var, 12, i);
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(ie7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (n.get(1) != null) {
                if (n.get(1).is_floor.intValue() == 0) {
                    if (ie7Var.z() != null) {
                        if (StringHelper.equals(ie7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(ie7Var, 14, i);
                            return;
                        } else {
                            b(ie7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (n.get(1).is_floor.intValue() == 1) {
                    b(ie7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(ie7Var, 11, i);
    }

    public static void b(ie7 ie7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, ie7Var, i, i2) == null) || ie7Var == null || ie7Var.A() == null || ie7Var.r() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", ie7Var.r().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", ie7Var.r().e);
        statisticItem.param("fname", ie7Var.r().d);
        statisticItem.param("pid", ie7Var.t());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
