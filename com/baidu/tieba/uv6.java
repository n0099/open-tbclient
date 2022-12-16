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
public class uv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(wp5 wp5Var, ForumData forumData, List<xn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{wp5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        eq5 eq5Var = new eq5(wp5Var, 5);
        eq5Var.G(list);
        if (forumData != null) {
            eq5Var.w(forumData.getId());
            eq5Var.v(forumData.getFirst_class());
            eq5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            eq5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        eq5Var.A(z);
        eq5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, eq5Var));
    }

    public static void b(wp5 wp5Var, FrsViewData frsViewData, List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, wp5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(wp5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(cs8 cs8Var, List<xn> list, List<xn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, cs8Var, list, list2) == null) && cs8Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : cs8.f) {
                xn xnVar = (xn) ListUtils.getItem(list, i);
                if (xnVar != null && (indexOf = list2.indexOf(xnVar)) >= 0) {
                    cs8Var.a(i, indexOf);
                }
            }
        }
    }
}
