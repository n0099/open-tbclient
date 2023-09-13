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
/* loaded from: classes8.dex */
public class yv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d46 d46Var, ForumData forumData, List<cn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{d46Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        l46 l46Var = new l46(d46Var, 5);
        l46Var.G(list);
        if (forumData != null) {
            l46Var.w(forumData.getId());
            l46Var.v(forumData.getFirst_class());
            l46Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            l46Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        l46Var.A(z);
        l46Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var));
    }

    public static void b(d46 d46Var, FrsViewData frsViewData, List<cn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, d46Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(d46Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(jha jhaVar, List<cn> list, List<cn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, jhaVar, list, list2) == null) && jhaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : jha.f) {
                cn cnVar = (cn) ListUtils.getItem(list, i);
                if (cnVar != null && (indexOf = list2.indexOf(cnVar)) >= 0) {
                    jhaVar.a(i, indexOf);
                }
            }
        }
    }
}
