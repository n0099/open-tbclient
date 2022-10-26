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
/* loaded from: classes6.dex */
public class u37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            du4 du4Var = new du4();
            du4Var.t = threadData;
            du4Var.position = i;
            if (z) {
                du4Var.a = true;
            } else {
                du4Var.r = true;
            }
            du4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(du4Var);
        }
    }

    public static ArrayList c(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) eoVar;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        du4 du4Var = new du4();
                        du4Var.t = threadData;
                        du4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            du4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            du4Var.d = true;
                            du4Var.u = imageWidthAndHeight[0];
                            du4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            du4Var.e = true;
                        } else {
                            du4Var.b = true;
                        }
                        du4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        du4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(du4Var);
                        if (threadData.getItem() != null) {
                            du4 du4Var2 = new du4();
                            du4Var2.n = true;
                            du4Var2.t = threadData;
                            du4Var2.position = i;
                            du4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(du4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            du4 du4Var3 = new du4();
                            du4Var3.t = threadData;
                            du4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                du4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                du4Var3.q = true;
                            }
                            du4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(du4Var3);
                        }
                        du4 du4Var4 = new du4();
                        du4Var4.m = true;
                        du4Var4.t = threadData;
                        du4Var4.position = i;
                        du4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(du4Var4);
                        du4 du4Var5 = new du4();
                        du4Var5.g = true;
                        du4Var5.t = threadData;
                        du4Var5.position = i;
                        du4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(du4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        du4 du4Var6 = new du4();
                        du4Var6.t = threadData;
                        du4Var6.position = i;
                        du4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        du4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(du4Var6);
                        if (threadData.getItem() != null) {
                            du4 du4Var7 = new du4();
                            du4Var7.n = true;
                            du4Var7.t = threadData;
                            du4Var7.position = i;
                            du4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(du4Var7);
                        }
                        du4 du4Var8 = new du4();
                        du4Var8.m = true;
                        du4Var8.t = threadData;
                        du4Var8.position = i;
                        du4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(du4Var8);
                        du4 du4Var9 = new du4();
                        du4Var9.g = true;
                        du4Var9.t = threadData;
                        du4Var9.position = i;
                        du4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(du4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (d36.W(threadData)) {
                        d36 d36Var = new d36(threadData);
                        d36Var.g = threadData.getTid();
                        d36Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        d36Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(d36Var);
                    } else {
                        du4 du4Var10 = new du4();
                        du4Var10.t = threadData;
                        du4Var10.position = i;
                        du4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(du4Var10);
                    }
                } else if (eoVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) eoVar).position = i;
                    arrayList2.add(eoVar);
                } else {
                    arrayList2.add(eoVar);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String d(m45 m45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, m45Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return m45Var.a();
                }
                return m45Var.b();
            }
            return m45Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(m45 m45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m45Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return m45Var.d();
                }
                return m45Var.e();
            }
            return m45Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static m45 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (m45 m45Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(m45Var.g()) && m45Var.g().equals(str)) {
                        return m45Var;
                    }
                }
            }
            return null;
        }
        return (m45) invokeL.objValue;
    }

    public static List g(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                eo B = bdTypeRecyclerView.B(i3);
                ThreadData threadData = null;
                if (B instanceof du4) {
                    threadData = ((du4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof d36) {
                    threadData = ((d36) B).a;
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

    public static void h(boolean z, ArrayList arrayList, ar4 ar4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, ar4Var}) == null) && ar4Var != null && arrayList != null && (i = ar4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (((eo) arrayList.get(i3)) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, ar4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
