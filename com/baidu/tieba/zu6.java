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
/* loaded from: classes6.dex */
public class zu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(bp5 bp5Var, ForumData forumData, List<xn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{bp5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        jp5 jp5Var = new jp5(bp5Var, 5);
        jp5Var.G(list);
        if (forumData != null) {
            jp5Var.w(forumData.getId());
            jp5Var.v(forumData.getFirst_class());
            jp5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            jp5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        jp5Var.A(z);
        jp5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, jp5Var));
    }

    public static void b(bp5 bp5Var, FrsViewData frsViewData, List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, bp5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(bp5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(dp8 dp8Var, List<xn> list, List<xn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, dp8Var, list, list2) == null) && dp8Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : dp8.f) {
                xn xnVar = (xn) ListUtils.getItem(list, i);
                if (xnVar != null && (indexOf = list2.indexOf(xnVar)) >= 0) {
                    dp8Var.a(i, indexOf);
                }
            }
        }
    }
}
