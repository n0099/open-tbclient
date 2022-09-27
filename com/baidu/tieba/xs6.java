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
public class xs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(in5 in5Var, ForumData forumData, List<Cdo> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{in5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        qn5 qn5Var = new qn5(in5Var, 5);
        qn5Var.G(list);
        if (forumData != null) {
            qn5Var.w(forumData.getId());
            qn5Var.v(forumData.getFirst_class());
            qn5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            qn5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        qn5Var.A(z);
        qn5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, qn5Var));
    }

    public static void b(in5 in5Var, FrsViewData frsViewData, List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, in5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(in5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(bn8 bn8Var, List<Cdo> list, List<Cdo> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, bn8Var, list, list2) == null) || bn8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : bn8.f) {
            Cdo cdo = (Cdo) ListUtils.getItem(list, i);
            if (cdo != null && (indexOf = list2.indexOf(cdo)) >= 0) {
                bn8Var.a(i, indexOf);
            }
        }
    }
}
