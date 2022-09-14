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
/* loaded from: classes4.dex */
public class js6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(vm5 vm5Var, ForumData forumData, List<Cdo> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{vm5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        dn5 dn5Var = new dn5(vm5Var, 5);
        dn5Var.G(list);
        if (forumData != null) {
            dn5Var.w(forumData.getId());
            dn5Var.v(forumData.getFirst_class());
            dn5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            dn5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        dn5Var.A(z);
        dn5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, dn5Var));
    }

    public static void b(vm5 vm5Var, FrsViewData frsViewData, List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, vm5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(vm5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(mm8 mm8Var, List<Cdo> list, List<Cdo> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, mm8Var, list, list2) == null) || mm8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : mm8.f) {
            Cdo cdo = (Cdo) ListUtils.getItem(list, i);
            if (cdo != null && (indexOf = list2.indexOf(cdo)) >= 0) {
                mm8Var.a(i, indexOf);
            }
        }
    }
}
