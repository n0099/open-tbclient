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
public class kt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(vs8 vs8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, vs8Var, i) == null) && vs8Var != null && vs8Var.u() != null && !ListUtils.isEmpty(vs8Var.i()) && vs8Var.i().size() >= 2) {
            List<NewFloorInfo> i2 = vs8Var.i();
            if (i2.size() > 2) {
                if (StringHelper.equals(vs8Var.u().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (i2.get(1) != null) {
                        if (i2.get(1).is_floor.intValue() == 0) {
                            b(vs8Var, 12, i);
                            return;
                        } else if (i2.get(1).is_floor.intValue() == 1) {
                            b(vs8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (i2.get(1) != null) {
                    if (i2.get(1).is_floor.intValue() == 0) {
                        if (vs8Var.q() != null) {
                            if (StringHelper.equals(vs8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(vs8Var, 14, i);
                                return;
                            } else {
                                b(vs8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (i2.get(1).is_floor.intValue() == 1) {
                        b(vs8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(vs8Var, 11, i);
        }
    }

    public static void b(vs8 vs8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, vs8Var, i, i2) == null) && vs8Var != null && vs8Var.r() != null && vs8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", vs8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", vs8Var.l().e);
            statisticItem.param("fname", vs8Var.l().d);
            statisticItem.param("pid", vs8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
