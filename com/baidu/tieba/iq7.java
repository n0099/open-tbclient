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
public class iq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(s36 s36Var, ForumData forumData, List<vn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{s36Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        a46 a46Var = new a46(s36Var, 5);
        a46Var.G(list);
        if (forumData != null) {
            a46Var.w(forumData.getId());
            a46Var.v(forumData.getFirst_class());
            a46Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            a46Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        a46Var.A(z);
        a46Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, a46Var));
    }

    public static void b(s36 s36Var, FrsViewData frsViewData, List<vn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, s36Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(s36Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(vx9 vx9Var, List<vn> list, List<vn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, vx9Var, list, list2) == null) && vx9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : vx9.f) {
                vn vnVar = (vn) ListUtils.getItem(list, i);
                if (vnVar != null && (indexOf = list2.indexOf(vnVar)) >= 0) {
                    vx9Var.a(i, indexOf);
                }
            }
        }
    }
}
