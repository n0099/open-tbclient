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
public class rw8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948136150, "Lcom/baidu/tieba/rw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948136150, "Lcom/baidu/tieba/rw8;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<gn> a(List<ThreadData> list) {
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
                    sf6 d = d(threadData);
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

    public static List<gn> b(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                aw8 aw8Var = new aw8();
                aw8Var.d = c;
                aw8Var.c = b;
                aw8Var.b = a;
                aw8Var.a = R.string.obfuscated_res_0x7f0f0f1a;
                arrayList.add(aw8Var);
                for (int i = 0; i < list.size(); i++) {
                    ThreadData threadData = list.get(i);
                    if (threadData != null) {
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        sf6 d = d(threadData);
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

    public static List<gn> c(List<gn> list) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                gn gnVar = (gn) ListUtils.getItem(list, i);
                if ((gnVar instanceof CardPersonDynamicThreadData) && (threadData = ((CardPersonDynamicThreadData) gnVar).p) != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    sf6 d = d(threadData);
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

    public static sf6 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
            sf6 sf6Var = null;
            if (threadData == null) {
                return null;
            }
            threadData.isFromPersonPolymeric = true;
            threadData.insertItemToTitleOrAbstractText();
            if (threadData.isShareThread) {
                sf6Var = new ag6();
                sf6Var.a = threadData;
            } else if (vf6.W(threadData)) {
                sf6Var = new vf6(threadData);
            } else if (wf6.Z(threadData)) {
                sf6Var = new wf6(threadData);
            } else if (!ag6.W(threadData) && !ag6.X(threadData)) {
                if (bg6.R(threadData)) {
                    sf6Var = new bg6(threadData);
                }
            } else {
                sf6Var = new ag6();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                sf6Var.a = threadData;
            }
            if (sf6Var != null) {
                AbsGroupUbsABTest.setCardInfoUbsABTest(sf6Var);
            }
            return sf6Var;
        }
        return (sf6) invokeL.objValue;
    }

    public static ThreadData e(gn gnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, gnVar)) == null) {
            if (gnVar == null || !(gnVar instanceof hw4)) {
                return null;
            }
            ThreadData threadData = ((hw4) gnVar).getThreadData();
            threadData.isFromPersonPolymeric = true;
            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
            return threadData;
        }
        return (ThreadData) invokeL.objValue;
    }
}
