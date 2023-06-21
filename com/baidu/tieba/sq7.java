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
public class sq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(z36 z36Var, ForumData forumData, List<wn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{z36Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        h46 h46Var = new h46(z36Var, 5);
        h46Var.G(list);
        if (forumData != null) {
            h46Var.w(forumData.getId());
            h46Var.v(forumData.getFirst_class());
            h46Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            h46Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        h46Var.A(z);
        h46Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, h46Var));
    }

    public static void b(z36 z36Var, FrsViewData frsViewData, List<wn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, z36Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(z36Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(sz9 sz9Var, List<wn> list, List<wn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, sz9Var, list, list2) == null) && sz9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : sz9.f) {
                wn wnVar = (wn) ListUtils.getItem(list, i);
                if (wnVar != null && (indexOf = list2.indexOf(wnVar)) >= 0) {
                    sz9Var.a(i, indexOf);
                }
            }
        }
    }
}
