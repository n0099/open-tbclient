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
public class yu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ap5 ap5Var, ForumData forumData, List<xn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{ap5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ip5 ip5Var = new ip5(ap5Var, 5);
        ip5Var.G(list);
        if (forumData != null) {
            ip5Var.w(forumData.getId());
            ip5Var.v(forumData.getFirst_class());
            ip5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ip5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        ip5Var.A(z);
        ip5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ip5Var));
    }

    public static void b(ap5 ap5Var, FrsViewData frsViewData, List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, ap5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(ap5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(cp8 cp8Var, List<xn> list, List<xn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, cp8Var, list, list2) == null) && cp8Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : cp8.f) {
                xn xnVar = (xn) ListUtils.getItem(list, i);
                if (xnVar != null && (indexOf = list2.indexOf(xnVar)) >= 0) {
                    cp8Var.a(i, indexOf);
                }
            }
        }
    }
}
