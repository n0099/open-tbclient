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
public class wh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fx5 fx5Var, ForumData forumData, List<in> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{fx5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        nx5 nx5Var = new nx5(fx5Var, 5);
        nx5Var.G(list);
        if (forumData != null) {
            nx5Var.w(forumData.getId());
            nx5Var.v(forumData.getFirst_class());
            nx5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            nx5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        nx5Var.A(z);
        nx5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, nx5Var));
    }

    public static void b(fx5 fx5Var, FrsViewData frsViewData, List<in> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, fx5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(fx5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(rl9 rl9Var, List<in> list, List<in> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, rl9Var, list, list2) == null) && rl9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : rl9.f) {
                in inVar = (in) ListUtils.getItem(list, i);
                if (inVar != null && (indexOf = list2.indexOf(inVar)) >= 0) {
                    rl9Var.a(i, indexOf);
                }
            }
        }
    }
}
