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
public class zq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(mk5 mk5Var, ForumData forumData, List<pn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{mk5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        uk5 uk5Var = new uk5(mk5Var, 5);
        uk5Var.G(list);
        if (forumData != null) {
            uk5Var.w(forumData.getId());
            uk5Var.v(forumData.getFirst_class());
            uk5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            uk5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        uk5Var.A(z);
        uk5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, uk5Var));
    }

    public static void b(mk5 mk5Var, FrsViewData frsViewData, List<pn> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, mk5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(mk5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(yk8 yk8Var, List<pn> list, List<pn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, yk8Var, list, list2) == null) || yk8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : yk8.f) {
            pn pnVar = (pn) ListUtils.getItem(list, i);
            if (pnVar != null && (indexOf = list2.indexOf(pnVar)) >= 0) {
                yk8Var.a(i, indexOf);
            }
        }
    }
}
