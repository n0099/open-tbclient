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
public class t17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<pn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<pn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            kr4 kr4Var = new kr4();
            kr4Var.t = threadData;
            kr4Var.position = i;
            if (z) {
                kr4Var.a = true;
            } else {
                kr4Var.r = true;
            }
            kr4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(kr4Var);
        }
    }

    public static ArrayList<pn> c(ArrayList<pn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<pn> arrayList2 = new ArrayList<>();
            Iterator<pn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        kr4 kr4Var = new kr4();
                        kr4Var.t = threadData;
                        kr4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            kr4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            kr4Var.d = true;
                            kr4Var.u = imageWidthAndHeight[0];
                            kr4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            kr4Var.e = true;
                        } else {
                            kr4Var.b = true;
                        }
                        kr4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        kr4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(kr4Var);
                        if (threadData.getItem() != null) {
                            kr4 kr4Var2 = new kr4();
                            kr4Var2.n = true;
                            kr4Var2.t = threadData;
                            kr4Var2.position = i;
                            kr4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(kr4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            kr4 kr4Var3 = new kr4();
                            kr4Var3.t = threadData;
                            kr4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                kr4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                kr4Var3.q = true;
                            }
                            kr4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(kr4Var3);
                        }
                        kr4 kr4Var4 = new kr4();
                        kr4Var4.m = true;
                        kr4Var4.t = threadData;
                        kr4Var4.position = i;
                        kr4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(kr4Var4);
                        kr4 kr4Var5 = new kr4();
                        kr4Var5.g = true;
                        kr4Var5.t = threadData;
                        kr4Var5.position = i;
                        kr4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(kr4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        kr4 kr4Var6 = new kr4();
                        kr4Var6.t = threadData;
                        kr4Var6.position = i;
                        kr4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        kr4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(kr4Var6);
                        if (threadData.getItem() != null) {
                            kr4 kr4Var7 = new kr4();
                            kr4Var7.n = true;
                            kr4Var7.t = threadData;
                            kr4Var7.position = i;
                            kr4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(kr4Var7);
                        }
                        kr4 kr4Var8 = new kr4();
                        kr4Var8.m = true;
                        kr4Var8.t = threadData;
                        kr4Var8.position = i;
                        kr4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(kr4Var8);
                        kr4 kr4Var9 = new kr4();
                        kr4Var9.g = true;
                        kr4Var9.t = threadData;
                        kr4Var9.position = i;
                        kr4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(kr4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (u06.W(threadData)) {
                        u06 u06Var = new u06(threadData);
                        u06Var.g = threadData.getTid();
                        u06Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        u06Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(u06Var);
                    } else {
                        kr4 kr4Var10 = new kr4();
                        kr4Var10.t = threadData;
                        kr4Var10.position = i;
                        kr4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(kr4Var10);
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

    public static String d(m15 m15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, m15Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return m15Var.a();
                }
                return m15Var.b();
            }
            return m15Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(m15 m15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m15Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return m15Var.d();
                }
                return m15Var.e();
            }
            return m15Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static m15 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (m15 m15Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(m15Var.h()) && m15Var.h().equals(str)) {
                        return m15Var;
                    }
                }
            }
            return null;
        }
        return (m15) invokeL.objValue;
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
                pn B = bdTypeRecyclerView.B(i3);
                ThreadData threadData = null;
                if (B instanceof kr4) {
                    threadData = ((kr4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof u06) {
                    threadData = ((u06) B).a;
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

    public static void h(boolean z, ArrayList<pn> arrayList, ho4 ho4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, ho4Var}) == null) || ho4Var == null || arrayList == null || (i = ho4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, ho4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
