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
/* loaded from: classes8.dex */
public class us7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(q26 q26Var, ForumData forumData, List<ym> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{q26Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        y26 y26Var = new y26(q26Var, 5);
        y26Var.G(list);
        if (forumData != null) {
            y26Var.w(forumData.getId());
            y26Var.v(forumData.getFirst_class());
            y26Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            y26Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        y26Var.A(z);
        y26Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, y26Var));
    }

    public static void b(q26 q26Var, FrsViewData frsViewData, List<ym> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, q26Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(q26Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(iba ibaVar, List<ym> list, List<ym> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, ibaVar, list, list2) == null) && ibaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : iba.f) {
                ym ymVar = (ym) ListUtils.getItem(list, i);
                if (ymVar != null && (indexOf = list2.indexOf(ymVar)) >= 0) {
                    ibaVar.a(i, indexOf);
                }
            }
        }
    }
}
