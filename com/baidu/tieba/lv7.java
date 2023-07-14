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
public class lv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(i56 i56Var, ForumData forumData, List<yn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{i56Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        q56 q56Var = new q56(i56Var, 5);
        q56Var.G(list);
        if (forumData != null) {
            q56Var.w(forumData.getId());
            q56Var.v(forumData.getFirst_class());
            q56Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            q56Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        q56Var.A(z);
        q56Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q56Var));
    }

    public static void b(i56 i56Var, FrsViewData frsViewData, List<yn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, i56Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(i56Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(pca pcaVar, List<yn> list, List<yn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, pcaVar, list, list2) == null) && pcaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : pca.f) {
                yn ynVar = (yn) ListUtils.getItem(list, i);
                if (ynVar != null && (indexOf = list2.indexOf(ynVar)) >= 0) {
                    pcaVar.a(i, indexOf);
                }
            }
        }
    }
}
