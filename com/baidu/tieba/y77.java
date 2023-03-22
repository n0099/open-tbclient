package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class y77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(yv5 yv5Var, ForumData forumData, List<gn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{yv5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        gw5 gw5Var = new gw5(yv5Var, 5);
        gw5Var.G(list);
        if (forumData != null) {
            gw5Var.w(forumData.getId());
            gw5Var.v(forumData.getFirst_class());
            gw5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            gw5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        gw5Var.A(z);
        gw5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, gw5Var));
    }

    public static void b(yv5 yv5Var, FrsViewData frsViewData, List<gn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, yv5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(yv5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(sb9 sb9Var, List<gn> list, List<gn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, sb9Var, list, list2) == null) && sb9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : sb9.f) {
                gn gnVar = (gn) ListUtils.getItem(list, i);
                if (gnVar != null && (indexOf = list2.indexOf(gnVar)) >= 0) {
                    sb9Var.a(i, indexOf);
                }
            }
        }
    }
}
