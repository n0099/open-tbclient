package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class z88 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948313935, "Lcom/baidu/tieba/z88;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948313935, "Lcom/baidu/tieba/z88;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<Cdo> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                ThreadData threadData = (ThreadData) ListUtils.getItem(list, i);
                if (threadData != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    c26 d = d(threadData);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<Cdo> b(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                i88 i88Var = new i88();
                i88Var.d = c;
                i88Var.c = b;
                i88Var.b = a;
                i88Var.a = R.string.obfuscated_res_0x7f0f0e4b;
                arrayList.add(i88Var);
                for (int i = 0; i < list.size(); i++) {
                    ThreadData threadData = list.get(i);
                    if (threadData != null) {
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        c26 d = d(threadData);
                        if (d != null) {
                            arrayList.add(d);
                        }
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<Cdo> c(List<Cdo> list) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                Cdo cdo = (Cdo) ListUtils.getItem(list, i);
                if ((cdo instanceof CardPersonDynamicThreadData) && (threadData = ((CardPersonDynamicThreadData) cdo).p) != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    c26 d = d(threadData);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static c26 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
            c26 c26Var = null;
            if (threadData == null) {
                return null;
            }
            threadData.isFromPersonPolymeric = true;
            threadData.insertItemToTitleOrAbstractText();
            if (threadData.isShareThread) {
                c26Var = new k26();
                c26Var.a = threadData;
            } else if (f26.W(threadData)) {
                c26Var = new f26(threadData);
            } else if (g26.Z(threadData)) {
                c26Var = new g26(threadData);
            } else if (!k26.W(threadData) && !k26.X(threadData)) {
                if (l26.R(threadData)) {
                    c26Var = new l26(threadData);
                }
            } else {
                c26Var = new k26();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                c26Var.a = threadData;
            }
            if (c26Var != null) {
                AbsGroupUbsABTest.setCardInfoUbsABTest(c26Var);
            }
            return c26Var;
        }
        return (c26) invokeL.objValue;
    }

    public static ThreadData e(Cdo cdo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cdo)) == null) {
            if (cdo != null && (cdo instanceof lq4)) {
                ThreadData threadData = ((lq4) cdo).getThreadData();
                threadData.isFromPersonPolymeric = true;
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                return threadData;
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }
}
