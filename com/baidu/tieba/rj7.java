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
public class rj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fy5 fy5Var, ForumData forumData, List<in> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{fy5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ny5 ny5Var = new ny5(fy5Var, 5);
        ny5Var.G(list);
        if (forumData != null) {
            ny5Var.w(forumData.getId());
            ny5Var.v(forumData.getFirst_class());
            ny5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ny5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        ny5Var.A(z);
        ny5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ny5Var));
    }

    public static void b(fy5 fy5Var, FrsViewData frsViewData, List<in> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, fy5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(fy5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(gp9 gp9Var, List<in> list, List<in> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, gp9Var, list, list2) == null) && gp9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : gp9.f) {
                in inVar = (in) ListUtils.getItem(list, i);
                if (inVar != null && (indexOf = list2.indexOf(inVar)) >= 0) {
                    gp9Var.a(i, indexOf);
                }
            }
        }
    }
}
