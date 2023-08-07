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
public class ts7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(p26 p26Var, ForumData forumData, List<ym> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{p26Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        x26 x26Var = new x26(p26Var, 5);
        x26Var.G(list);
        if (forumData != null) {
            x26Var.w(forumData.getId());
            x26Var.v(forumData.getFirst_class());
            x26Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            x26Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        x26Var.A(z);
        x26Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x26Var));
    }

    public static void b(p26 p26Var, FrsViewData frsViewData, List<ym> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, p26Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(p26Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(hba hbaVar, List<ym> list, List<ym> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, hbaVar, list, list2) == null) && hbaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : hba.f) {
                ym ymVar = (ym) ListUtils.getItem(list, i);
                if (ymVar != null && (indexOf = list2.indexOf(ymVar)) >= 0) {
                    hbaVar.a(i, indexOf);
                }
            }
        }
    }
}
