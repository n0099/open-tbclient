package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class q57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, threadData, i, arrayList) == null) {
            if (threadData.getTabShowMode() == 1) {
                b(threadData, i, arrayList, true);
            } else if (threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                b(threadData, i, arrayList, false);
            } else {
                b(threadData, i, arrayList, true);
            }
        }
    }

    public static void b(ThreadData threadData, int i, ArrayList<xn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            xu4 xu4Var = new xu4();
            xu4Var.t = threadData;
            xu4Var.position = i;
            if (z) {
                xu4Var.a = true;
            } else {
                xu4Var.r = true;
            }
            xu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(xu4Var);
        }
    }

    public static ArrayList<xn> c(ArrayList<xn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        xu4 xu4Var = new xu4();
                        xu4Var.t = threadData;
                        xu4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            xu4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            xu4Var.d = true;
                            xu4Var.u = imageWidthAndHeight[0];
                            xu4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            xu4Var.e = true;
                        } else {
                            xu4Var.b = true;
                        }
                        xu4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        xu4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(xu4Var);
                        if (threadData.getItem() != null) {
                            xu4 xu4Var2 = new xu4();
                            xu4Var2.n = true;
                            xu4Var2.t = threadData;
                            xu4Var2.position = i;
                            xu4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            xu4 xu4Var3 = new xu4();
                            xu4Var3.t = threadData;
                            xu4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                xu4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                xu4Var3.q = true;
                            }
                            xu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var3);
                        }
                        xu4 xu4Var4 = new xu4();
                        xu4Var4.m = true;
                        xu4Var4.t = threadData;
                        xu4Var4.position = i;
                        xu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(xu4Var4);
                        xu4 xu4Var5 = new xu4();
                        xu4Var5.g = true;
                        xu4Var5.t = threadData;
                        xu4Var5.position = i;
                        xu4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(xu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        xu4 xu4Var6 = new xu4();
                        xu4Var6.t = threadData;
                        xu4Var6.position = i;
                        xu4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        xu4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(xu4Var6);
                        if (threadData.getItem() != null) {
                            xu4 xu4Var7 = new xu4();
                            xu4Var7.n = true;
                            xu4Var7.t = threadData;
                            xu4Var7.position = i;
                            xu4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(xu4Var7);
                        }
                        xu4 xu4Var8 = new xu4();
                        xu4Var8.m = true;
                        xu4Var8.t = threadData;
                        xu4Var8.position = i;
                        xu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(xu4Var8);
                        xu4 xu4Var9 = new xu4();
                        xu4Var9.g = true;
                        xu4Var9.t = threadData;
                        xu4Var9.position = i;
                        xu4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(xu4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (a56.W(threadData)) {
                        a56 a56Var = new a56(threadData);
                        a56Var.g = threadData.getTid();
                        a56Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        a56Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(a56Var);
                    } else {
                        xu4 xu4Var10 = new xu4();
                        xu4Var10.t = threadData;
                        xu4Var10.position = i;
                        xu4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(xu4Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String d(l55 l55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return l55Var.a();
                }
                return l55Var.b();
            }
            return l55Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(l55 l55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return l55Var.d();
                }
                return l55Var.e();
            }
            return l55Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static l55 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (l55 l55Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(l55Var.g()) && l55Var.g().equals(str)) {
                        return l55Var;
                    }
                }
            }
            return null;
        }
        return (l55) invokeL.objValue;
    }

    public static List<Integer> g(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                xn B = bdTypeRecyclerView.B(i3);
                ThreadData threadData = null;
                if (B instanceof xu4) {
                    threadData = ((xu4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof a56) {
                    threadData = ((a56) B).a;
                }
                if (threadData != null && threadData.getTid().equals(str)) {
                    if (!z) {
                        i = i3;
                    }
                    z = true;
                    i2 = i3;
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void h(boolean z, ArrayList<xn> arrayList, tr4 tr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, tr4Var}) == null) && tr4Var != null && arrayList != null && (i = tr4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, tr4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
