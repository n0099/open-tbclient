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
/* loaded from: classes9.dex */
public class y58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(p06 p06Var, ForumData forumData, List<pi> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{p06Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        x06 x06Var = new x06(p06Var, 5);
        x06Var.G(list);
        if (forumData != null) {
            x06Var.w(forumData.getId());
            x06Var.v(forumData.getFirst_class());
            x06Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            x06Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        x06Var.A(z);
        x06Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x06Var));
    }

    public static void b(p06 p06Var, FrsViewData frsViewData, List<pi> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, p06Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(p06Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(ewa ewaVar, List<pi> list, List<pi> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, ewaVar, list, list2) == null) && ewaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : ewa.f) {
                pi piVar = (pi) ListUtils.getItem(list, i);
                if (piVar != null && (indexOf = list2.indexOf(piVar)) >= 0) {
                    ewaVar.a(i, indexOf);
                }
            }
        }
    }
}
