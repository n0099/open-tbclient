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
public class t67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(sw5 sw5Var, ForumData forumData, List<Cdo> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{sw5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ax5 ax5Var = new ax5(sw5Var, 5);
        ax5Var.G(list);
        if (forumData != null) {
            ax5Var.w(forumData.getId());
            ax5Var.v(forumData.getFirst_class());
            ax5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ax5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        ax5Var.A(z);
        ax5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ax5Var));
    }

    public static void b(sw5 sw5Var, FrsViewData frsViewData, List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, sw5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(sw5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(n59 n59Var, List<Cdo> list, List<Cdo> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, n59Var, list, list2) == null) && n59Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : n59.f) {
                Cdo cdo = (Cdo) ListUtils.getItem(list, i);
                if (cdo != null && (indexOf = list2.indexOf(cdo)) >= 0) {
                    n59Var.a(i, indexOf);
                }
            }
        }
    }
}
