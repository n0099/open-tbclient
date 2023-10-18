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
public class oq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(vp8 vp8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, vp8Var, i) == null) && vp8Var != null && vp8Var.u() != null && !ListUtils.isEmpty(vp8Var.i()) && vp8Var.i().size() >= 2) {
            List<NewFloorInfo> i2 = vp8Var.i();
            if (i2.size() > 2) {
                if (StringHelper.equals(vp8Var.u().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (i2.get(1) != null) {
                        if (i2.get(1).is_floor.intValue() == 0) {
                            b(vp8Var, 12, i);
                            return;
                        } else if (i2.get(1).is_floor.intValue() == 1) {
                            b(vp8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (i2.get(1) != null) {
                    if (i2.get(1).is_floor.intValue() == 0) {
                        if (vp8Var.q() != null) {
                            if (StringHelper.equals(vp8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(vp8Var, 14, i);
                                return;
                            } else {
                                b(vp8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (i2.get(1).is_floor.intValue() == 1) {
                        b(vp8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(vp8Var, 11, i);
        }
    }

    public static void b(vp8 vp8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, vp8Var, i, i2) == null) && vp8Var != null && vp8Var.r() != null && vp8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", vp8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", vp8Var.l().e);
            statisticItem.param("fname", vp8Var.l().d);
            statisticItem.param("pid", vp8Var.o());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
