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
public class vh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ex5 ex5Var, ForumData forumData, List<hn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{ex5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        mx5 mx5Var = new mx5(ex5Var, 5);
        mx5Var.G(list);
        if (forumData != null) {
            mx5Var.w(forumData.getId());
            mx5Var.v(forumData.getFirst_class());
            mx5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            mx5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        mx5Var.A(z);
        mx5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, mx5Var));
    }

    public static void b(ex5 ex5Var, FrsViewData frsViewData, List<hn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, ex5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(ex5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(jl9 jl9Var, List<hn> list, List<hn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, jl9Var, list, list2) == null) && jl9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : jl9.f) {
                hn hnVar = (hn) ListUtils.getItem(list, i);
                if (hnVar != null && (indexOf = list2.indexOf(hnVar)) >= 0) {
                    jl9Var.a(i, indexOf);
                }
            }
        }
    }
}
