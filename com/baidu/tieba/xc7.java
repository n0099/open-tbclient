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
public class xc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(oc7 oc7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, oc7Var, i) == null) || oc7Var == null || oc7Var.D() == null || ListUtils.isEmpty(oc7Var.n()) || oc7Var.n().size() < 2) {
            return;
        }
        List<NewFloorInfo> n = oc7Var.n();
        if (n.size() > 2) {
            if (StringHelper.equals(oc7Var.D().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        b(oc7Var, 12, i);
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(oc7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (n.get(1) != null) {
                if (n.get(1).is_floor.intValue() == 0) {
                    if (oc7Var.z() != null) {
                        if (StringHelper.equals(oc7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(oc7Var, 14, i);
                            return;
                        } else {
                            b(oc7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (n.get(1).is_floor.intValue() == 1) {
                    b(oc7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(oc7Var, 11, i);
    }

    public static void b(oc7 oc7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, oc7Var, i, i2) == null) || oc7Var == null || oc7Var.A() == null || oc7Var.r() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", oc7Var.r().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", oc7Var.r().e);
        statisticItem.param("fname", oc7Var.r().d);
        statisticItem.param("pid", oc7Var.t());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
