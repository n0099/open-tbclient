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
public class y27 {
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
            ot4 ot4Var = new ot4();
            ot4Var.t = threadData;
            ot4Var.position = i;
            if (z) {
                ot4Var.a = true;
            } else {
                ot4Var.r = true;
            }
            ot4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(ot4Var);
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
                        ot4 ot4Var = new ot4();
                        ot4Var.t = threadData;
                        ot4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ot4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            ot4Var.d = true;
                            ot4Var.u = imageWidthAndHeight[0];
                            ot4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ot4Var.e = true;
                        } else {
                            ot4Var.b = true;
                        }
                        ot4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        ot4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ot4Var);
                        if (threadData.getItem() != null) {
                            ot4 ot4Var2 = new ot4();
                            ot4Var2.n = true;
                            ot4Var2.t = threadData;
                            ot4Var2.position = i;
                            ot4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            ot4 ot4Var3 = new ot4();
                            ot4Var3.t = threadData;
                            ot4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                ot4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                ot4Var3.q = true;
                            }
                            ot4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var3);
                        }
                        ot4 ot4Var4 = new ot4();
                        ot4Var4.m = true;
                        ot4Var4.t = threadData;
                        ot4Var4.position = i;
                        ot4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(ot4Var4);
                        ot4 ot4Var5 = new ot4();
                        ot4Var5.g = true;
                        ot4Var5.t = threadData;
                        ot4Var5.position = i;
                        ot4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ot4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        ot4 ot4Var6 = new ot4();
                        ot4Var6.t = threadData;
                        ot4Var6.position = i;
                        ot4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        ot4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ot4Var6);
                        if (threadData.getItem() != null) {
                            ot4 ot4Var7 = new ot4();
                            ot4Var7.n = true;
                            ot4Var7.t = threadData;
                            ot4Var7.position = i;
                            ot4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(ot4Var7);
                        }
                        ot4 ot4Var8 = new ot4();
                        ot4Var8.m = true;
                        ot4Var8.t = threadData;
                        ot4Var8.position = i;
                        ot4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(ot4Var8);
                        ot4 ot4Var9 = new ot4();
                        ot4Var9.g = true;
                        ot4Var9.t = threadData;
                        ot4Var9.position = i;
                        ot4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ot4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (j26.W(threadData)) {
                        j26 j26Var = new j26(threadData);
                        j26Var.g = threadData.getTid();
                        j26Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        j26Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(j26Var);
                    } else {
                        ot4 ot4Var10 = new ot4();
                        ot4Var10.t = threadData;
                        ot4Var10.position = i;
                        ot4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(ot4Var10);
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

    public static String d(t35 t35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t35Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return t35Var.a();
                }
                return t35Var.b();
            }
            return t35Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(t35 t35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t35Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return t35Var.d();
                }
                return t35Var.e();
            }
            return t35Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static t35 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (t35 t35Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(t35Var.h()) && t35Var.h().equals(str)) {
                        return t35Var;
                    }
                }
            }
            return null;
        }
        return (t35) invokeL.objValue;
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
                if (B instanceof ot4) {
                    threadData = ((ot4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof j26) {
                    threadData = ((j26) B).a;
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

    public static void h(boolean z, ArrayList<Cdo> arrayList, lq4 lq4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, lq4Var}) == null) || lq4Var == null || arrayList == null || (i = lq4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, lq4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
