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
public class vg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(mg7 mg7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, mg7Var, i) == null) && mg7Var != null && mg7Var.C() != null && !ListUtils.isEmpty(mg7Var.n()) && mg7Var.n().size() >= 2) {
            List<NewFloorInfo> n = mg7Var.n();
            if (n.size() > 2) {
                if (StringHelper.equals(mg7Var.C().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (n.get(1) != null) {
                        if (n.get(1).is_floor.intValue() == 0) {
                            b(mg7Var, 12, i);
                            return;
                        } else if (n.get(1).is_floor.intValue() == 1) {
                            b(mg7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        if (mg7Var.z() != null) {
                            if (StringHelper.equals(mg7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(mg7Var, 14, i);
                                return;
                            } else {
                                b(mg7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(mg7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(mg7Var, 11, i);
        }
    }

    public static void b(mg7 mg7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, mg7Var, i, i2) == null) && mg7Var != null && mg7Var.A() != null && mg7Var.r() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", mg7Var.r().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", mg7Var.r().e);
            statisticItem.param("fname", mg7Var.r().d);
            statisticItem.param("pid", mg7Var.t());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
