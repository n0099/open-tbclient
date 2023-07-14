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
/* loaded from: classes7.dex */
public class qr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(br8 br8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, br8Var, i) == null) && br8Var != null && br8Var.v() != null && !ListUtils.isEmpty(br8Var.i()) && br8Var.i().size() >= 2) {
            List<NewFloorInfo> i2 = br8Var.i();
            if (i2.size() > 2) {
                if (StringHelper.equals(br8Var.v().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (i2.get(1) != null) {
                        if (i2.get(1).is_floor.intValue() == 0) {
                            b(br8Var, 12, i);
                            return;
                        } else if (i2.get(1).is_floor.intValue() == 1) {
                            b(br8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (i2.get(1) != null) {
                    if (i2.get(1).is_floor.intValue() == 0) {
                        if (br8Var.p() != null) {
                            if (StringHelper.equals(br8Var.p().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(br8Var, 14, i);
                                return;
                            } else {
                                b(br8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (i2.get(1).is_floor.intValue() == 1) {
                        b(br8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(br8Var, 11, i);
        }
    }

    public static void b(br8 br8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, br8Var, i, i2) == null) && br8Var != null && br8Var.r() != null && br8Var.k() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", br8Var.k().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", br8Var.k().e);
            statisticItem.param("fname", br8Var.k().d);
            statisticItem.param("pid", br8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
