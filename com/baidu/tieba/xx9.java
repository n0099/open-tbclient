package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.bu9;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ay9 a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, iBaseDialogData)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null || iBaseDialogData.getType() != 1) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(bu9.a.a);
            int i = 0;
            int from = iBaseDialogData.getFrom();
            if (from != 0) {
                if (from != 1) {
                    if (from == 2) {
                        i = 4;
                    }
                } else {
                    i = 3;
                }
            } else {
                i = 2;
            }
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
            return new yx9(tbPageContext, (CustomDialogData) iBaseDialogData);
        }
        return (ay9) invokeLL.objValue;
    }
}
