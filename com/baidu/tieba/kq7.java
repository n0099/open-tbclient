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
public class kq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ny5 ny5Var, ForumData forumData, List<yh> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{ny5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        vy5 vy5Var = new vy5(ny5Var, 5);
        vy5Var.G(list);
        if (forumData != null) {
            vy5Var.w(forumData.getId());
            vy5Var.v(forumData.getFirst_class());
            vy5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            vy5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        vy5Var.A(z);
        vy5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, vy5Var));
    }

    public static void b(ny5 ny5Var, FrsViewData frsViewData, List<yh> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, ny5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(ny5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(fea feaVar, List<yh> list, List<yh> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, feaVar, list, list2) == null) && feaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : fea.f) {
                yh yhVar = (yh) ListUtils.getItem(list, i);
                if (yhVar != null && (indexOf = list2.indexOf(yhVar)) >= 0) {
                    feaVar.a(i, indexOf);
                }
            }
        }
    }
}
