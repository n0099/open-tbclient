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
public class p57 {
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
            wu4 wu4Var = new wu4();
            wu4Var.t = threadData;
            wu4Var.position = i;
            if (z) {
                wu4Var.a = true;
            } else {
                wu4Var.r = true;
            }
            wu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(wu4Var);
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
                        wu4 wu4Var = new wu4();
                        wu4Var.t = threadData;
                        wu4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wu4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            wu4Var.d = true;
                            wu4Var.u = imageWidthAndHeight[0];
                            wu4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wu4Var.e = true;
                        } else {
                            wu4Var.b = true;
                        }
                        wu4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        wu4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wu4Var);
                        if (threadData.getItem() != null) {
                            wu4 wu4Var2 = new wu4();
                            wu4Var2.n = true;
                            wu4Var2.t = threadData;
                            wu4Var2.position = i;
                            wu4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wu4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            wu4 wu4Var3 = new wu4();
                            wu4Var3.t = threadData;
                            wu4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                wu4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                wu4Var3.q = true;
                            }
                            wu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wu4Var3);
                        }
                        wu4 wu4Var4 = new wu4();
                        wu4Var4.m = true;
                        wu4Var4.t = threadData;
                        wu4Var4.position = i;
                        wu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(wu4Var4);
                        wu4 wu4Var5 = new wu4();
                        wu4Var5.g = true;
                        wu4Var5.t = threadData;
                        wu4Var5.position = i;
                        wu4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        wu4 wu4Var6 = new wu4();
                        wu4Var6.t = threadData;
                        wu4Var6.position = i;
                        wu4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        wu4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wu4Var6);
                        if (threadData.getItem() != null) {
                            wu4 wu4Var7 = new wu4();
                            wu4Var7.n = true;
                            wu4Var7.t = threadData;
                            wu4Var7.position = i;
                            wu4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(wu4Var7);
                        }
                        wu4 wu4Var8 = new wu4();
                        wu4Var8.m = true;
                        wu4Var8.t = threadData;
                        wu4Var8.position = i;
                        wu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(wu4Var8);
                        wu4 wu4Var9 = new wu4();
                        wu4Var9.g = true;
                        wu4Var9.t = threadData;
                        wu4Var9.position = i;
                        wu4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wu4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (z46.W(threadData)) {
                        z46 z46Var = new z46(threadData);
                        z46Var.g = threadData.getTid();
                        z46Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        z46Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(z46Var);
                    } else {
                        wu4 wu4Var10 = new wu4();
                        wu4Var10.t = threadData;
                        wu4Var10.position = i;
                        wu4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(wu4Var10);
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

    public static String d(k55 k55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return k55Var.a();
                }
                return k55Var.b();
            }
            return k55Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(k55 k55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, k55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return k55Var.d();
                }
                return k55Var.e();
            }
            return k55Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static k55 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (k55 k55Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(k55Var.g()) && k55Var.g().equals(str)) {
                        return k55Var;
                    }
                }
            }
            return null;
        }
        return (k55) invokeL.objValue;
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
                if (B instanceof wu4) {
                    threadData = ((wu4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof z46) {
                    threadData = ((z46) B).a;
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

    public static void h(boolean z, ArrayList<xn> arrayList, sr4 sr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, sr4Var}) == null) && sr4Var != null && arrayList != null && (i = sr4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, sr4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
