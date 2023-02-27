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
public class sw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(jw7 jw7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, jw7Var, i) == null) && jw7Var != null && jw7Var.v() != null && !ListUtils.isEmpty(jw7Var.l()) && jw7Var.l().size() >= 2) {
            List<NewFloorInfo> l = jw7Var.l();
            if (l.size() > 2) {
                if (StringHelper.equals(jw7Var.v().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (l.get(1) != null) {
                        if (l.get(1).is_floor.intValue() == 0) {
                            b(jw7Var, 12, i);
                            return;
                        } else if (l.get(1).is_floor.intValue() == 1) {
                            b(jw7Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (l.get(1) != null) {
                    if (l.get(1).is_floor.intValue() == 0) {
                        if (jw7Var.s() != null) {
                            if (StringHelper.equals(jw7Var.s().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(jw7Var, 14, i);
                                return;
                            } else {
                                b(jw7Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (l.get(1).is_floor.intValue() == 1) {
                        b(jw7Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(jw7Var, 11, i);
        }
    }

    public static void b(jw7 jw7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, jw7Var, i, i2) == null) && jw7Var != null && jw7Var.t() != null && jw7Var.n() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", jw7Var.n().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", jw7Var.n().e);
            statisticItem.param("fname", jw7Var.n().d);
            statisticItem.param("pid", jw7Var.q());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
