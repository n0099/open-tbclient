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
/* loaded from: classes7.dex */
public class pu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(h36 h36Var, ForumData forumData, List<bn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{h36Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        p36 p36Var = new p36(h36Var, 5);
        p36Var.G(list);
        if (forumData != null) {
            p36Var.w(forumData.getId());
            p36Var.v(forumData.getFirst_class());
            p36Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            p36Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        p36Var.A(z);
        p36Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p36Var));
    }

    public static void b(h36 h36Var, FrsViewData frsViewData, List<bn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, h36Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(h36Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(qfa qfaVar, List<bn> list, List<bn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, qfaVar, list, list2) == null) && qfaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : qfa.f) {
                bn bnVar = (bn) ListUtils.getItem(list, i);
                if (bnVar != null && (indexOf = list2.indexOf(bnVar)) >= 0) {
                    qfaVar.a(i, indexOf);
                }
            }
        }
    }
}
