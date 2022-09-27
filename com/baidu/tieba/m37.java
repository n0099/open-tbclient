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
/* loaded from: classes4.dex */
public class m37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<Cdo> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<Cdo> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            bu4 bu4Var = new bu4();
            bu4Var.t = threadData;
            bu4Var.position = i;
            if (z) {
                bu4Var.a = true;
            } else {
                bu4Var.r = true;
            }
            bu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(bu4Var);
        }
    }

    public static ArrayList<Cdo> c(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        bu4 bu4Var = new bu4();
                        bu4Var.t = threadData;
                        bu4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bu4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            bu4Var.d = true;
                            bu4Var.u = imageWidthAndHeight[0];
                            bu4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bu4Var.e = true;
                        } else {
                            bu4Var.b = true;
                        }
                        bu4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        bu4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bu4Var);
                        if (threadData.getItem() != null) {
                            bu4 bu4Var2 = new bu4();
                            bu4Var2.n = true;
                            bu4Var2.t = threadData;
                            bu4Var2.position = i;
                            bu4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            bu4 bu4Var3 = new bu4();
                            bu4Var3.t = threadData;
                            bu4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                bu4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                bu4Var3.q = true;
                            }
                            bu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var3);
                        }
                        bu4 bu4Var4 = new bu4();
                        bu4Var4.m = true;
                        bu4Var4.t = threadData;
                        bu4Var4.position = i;
                        bu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bu4Var4);
                        bu4 bu4Var5 = new bu4();
                        bu4Var5.g = true;
                        bu4Var5.t = threadData;
                        bu4Var5.position = i;
                        bu4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        bu4 bu4Var6 = new bu4();
                        bu4Var6.t = threadData;
                        bu4Var6.position = i;
                        bu4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        bu4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bu4Var6);
                        if (threadData.getItem() != null) {
                            bu4 bu4Var7 = new bu4();
                            bu4Var7.n = true;
                            bu4Var7.t = threadData;
                            bu4Var7.position = i;
                            bu4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(bu4Var7);
                        }
                        bu4 bu4Var8 = new bu4();
                        bu4Var8.m = true;
                        bu4Var8.t = threadData;
                        bu4Var8.position = i;
                        bu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bu4Var8);
                        bu4 bu4Var9 = new bu4();
                        bu4Var9.g = true;
                        bu4Var9.t = threadData;
                        bu4Var9.position = i;
                        bu4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bu4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (w26.W(threadData)) {
                        w26 w26Var = new w26(threadData);
                        w26Var.g = threadData.getTid();
                        w26Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        w26Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(w26Var);
                    } else {
                        bu4 bu4Var10 = new bu4();
                        bu4Var10.t = threadData;
                        bu4Var10.position = i;
                        bu4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(bu4Var10);
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

    public static String d(g45 g45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, g45Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return g45Var.a();
                }
                return g45Var.b();
            }
            return g45Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(g45 g45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, g45Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return g45Var.d();
                }
                return g45Var.e();
            }
            return g45Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static g45 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (g45 g45Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(g45Var.h()) && g45Var.h().equals(str)) {
                        return g45Var;
                    }
                }
            }
            return null;
        }
        return (g45) invokeL.objValue;
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
                Cdo B = bdTypeRecyclerView.B(i3);
                ThreadData threadData = null;
                if (B instanceof bu4) {
                    threadData = ((bu4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof w26) {
                    threadData = ((w26) B).a;
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

    public static void h(boolean z, ArrayList<Cdo> arrayList, yq4 yq4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, yq4Var}) == null) || yq4Var == null || arrayList == null || (i = yq4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, yq4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
