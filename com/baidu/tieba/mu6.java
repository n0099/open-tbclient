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
/* loaded from: classes5.dex */
public class mu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(oo5 oo5Var, ForumData forumData, List<wn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{oo5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        wo5 wo5Var = new wo5(oo5Var, 5);
        wo5Var.G(list);
        if (forumData != null) {
            wo5Var.w(forumData.getId());
            wo5Var.v(forumData.getFirst_class());
            wo5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            wo5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        wo5Var.A(z);
        wo5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wo5Var));
    }

    public static void b(oo5 oo5Var, FrsViewData frsViewData, List<wn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, oo5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(oo5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(ro8 ro8Var, List<wn> list, List<wn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, ro8Var, list, list2) == null) && ro8Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : ro8.f) {
                wn wnVar = (wn) ListUtils.getItem(list, i);
                if (wnVar != null && (indexOf = list2.indexOf(wnVar)) >= 0) {
                    ro8Var.a(i, indexOf);
                }
            }
        }
    }
}
