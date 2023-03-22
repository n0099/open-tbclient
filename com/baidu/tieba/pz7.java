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
public class pz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gz7 gz7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, gz7Var, i) == null) && gz7Var != null && gz7Var.w() != null && !ListUtils.isEmpty(gz7Var.m()) && gz7Var.m().size() >= 2) {
            List<NewFloorInfo> m = gz7Var.m();
            if (m.size() > 2) {
                if (StringHelper.equals(gz7Var.w().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (m.get(1) != null) {
                        if (m.get(1).is_floor.intValue() == 0) {
                            b(gz7Var, 12, i);
                            return;
                        } else if (m.get(1).is_floor.intValue() == 1) {
                            b(gz7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (m.get(1) != null) {
                    if (m.get(1).is_floor.intValue() == 0) {
                        if (gz7Var.t() != null) {
                            if (StringHelper.equals(gz7Var.t().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(gz7Var, 14, i);
                                return;
                            } else {
                                b(gz7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (m.get(1).is_floor.intValue() == 1) {
                        b(gz7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(gz7Var, 11, i);
        }
    }

    public static void b(gz7 gz7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, gz7Var, i, i2) == null) && gz7Var != null && gz7Var.u() != null && gz7Var.o() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", gz7Var.o().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gz7Var.o().e);
            statisticItem.param("fname", gz7Var.o().d);
            statisticItem.param("pid", gz7Var.r());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
