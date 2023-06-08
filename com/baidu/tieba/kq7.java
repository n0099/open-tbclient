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
public class kq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(u36 u36Var, ForumData forumData, List<vn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{u36Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        c46 c46Var = new c46(u36Var, 5);
        c46Var.G(list);
        if (forumData != null) {
            c46Var.w(forumData.getId());
            c46Var.v(forumData.getFirst_class());
            c46Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            c46Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        c46Var.A(z);
        c46Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, c46Var));
    }

    public static void b(u36 u36Var, FrsViewData frsViewData, List<vn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, u36Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(u36Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(ay9 ay9Var, List<vn> list, List<vn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, ay9Var, list, list2) == null) && ay9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : ay9.f) {
                vn vnVar = (vn) ListUtils.getItem(list, i);
                if (vnVar != null && (indexOf = list2.indexOf(vnVar)) >= 0) {
                    ay9Var.a(i, indexOf);
                }
            }
        }
    }
}
