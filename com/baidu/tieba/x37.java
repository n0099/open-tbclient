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
public class x37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(bv5 bv5Var, ForumData forumData, List<Cdo> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{bv5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        jv5 jv5Var = new jv5(bv5Var, 5);
        jv5Var.G(list);
        if (forumData != null) {
            jv5Var.w(forumData.getId());
            jv5Var.v(forumData.getFirst_class());
            jv5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            jv5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        jv5Var.A(z);
        jv5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, jv5Var));
    }

    public static void b(bv5 bv5Var, FrsViewData frsViewData, List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, bv5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(bv5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(x09 x09Var, List<Cdo> list, List<Cdo> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, x09Var, list, list2) == null) && x09Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : x09.f) {
                Cdo cdo = (Cdo) ListUtils.getItem(list, i);
                if (cdo != null && (indexOf = list2.indexOf(cdo)) >= 0) {
                    x09Var.a(i, indexOf);
                }
            }
        }
    }
}
