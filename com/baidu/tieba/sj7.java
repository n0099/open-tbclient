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
public class sj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(jj7 jj7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, jj7Var, i) == null) && jj7Var != null && jj7Var.y() != null && !ListUtils.isEmpty(jj7Var.m()) && jj7Var.m().size() >= 2) {
            List<NewFloorInfo> m = jj7Var.m();
            if (m.size() > 2) {
                if (StringHelper.equals(jj7Var.y().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (m.get(1) != null) {
                        if (m.get(1).is_floor.intValue() == 0) {
                            b(jj7Var, 12, i);
                            return;
                        } else if (m.get(1).is_floor.intValue() == 1) {
                            b(jj7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (m.get(1) != null) {
                    if (m.get(1).is_floor.intValue() == 0) {
                        if (jj7Var.s() != null) {
                            if (StringHelper.equals(jj7Var.s().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(jj7Var, 14, i);
                                return;
                            } else {
                                b(jj7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (m.get(1).is_floor.intValue() == 1) {
                        b(jj7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(jj7Var, 11, i);
        }
    }

    public static void b(jj7 jj7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, jj7Var, i, i2) == null) && jj7Var != null && jj7Var.v() != null && jj7Var.o() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", jj7Var.o().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", jj7Var.o().e);
            statisticItem.param("fname", jj7Var.o().d);
            statisticItem.param("pid", jj7Var.q());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
