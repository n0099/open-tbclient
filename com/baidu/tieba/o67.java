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
public class o67 {
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
            yu4 yu4Var = new yu4();
            yu4Var.t = threadData;
            yu4Var.position = i;
            if (z) {
                yu4Var.a = true;
            } else {
                yu4Var.r = true;
            }
            yu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(yu4Var);
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
                        yu4 yu4Var = new yu4();
                        yu4Var.t = threadData;
                        yu4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            yu4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            yu4Var.d = true;
                            yu4Var.u = imageWidthAndHeight[0];
                            yu4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            yu4Var.e = true;
                        } else {
                            yu4Var.b = true;
                        }
                        yu4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        yu4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(yu4Var);
                        if (threadData.getItem() != null) {
                            yu4 yu4Var2 = new yu4();
                            yu4Var2.n = true;
                            yu4Var2.t = threadData;
                            yu4Var2.position = i;
                            yu4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            yu4 yu4Var3 = new yu4();
                            yu4Var3.t = threadData;
                            yu4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                yu4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                yu4Var3.q = true;
                            }
                            yu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var3);
                        }
                        yu4 yu4Var4 = new yu4();
                        yu4Var4.m = true;
                        yu4Var4.t = threadData;
                        yu4Var4.position = i;
                        yu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(yu4Var4);
                        yu4 yu4Var5 = new yu4();
                        yu4Var5.g = true;
                        yu4Var5.t = threadData;
                        yu4Var5.position = i;
                        yu4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(yu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        yu4 yu4Var6 = new yu4();
                        yu4Var6.t = threadData;
                        yu4Var6.position = i;
                        yu4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        yu4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(yu4Var6);
                        if (threadData.getItem() != null) {
                            yu4 yu4Var7 = new yu4();
                            yu4Var7.n = true;
                            yu4Var7.t = threadData;
                            yu4Var7.position = i;
                            yu4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(yu4Var7);
                        }
                        yu4 yu4Var8 = new yu4();
                        yu4Var8.m = true;
                        yu4Var8.t = threadData;
                        yu4Var8.position = i;
                        yu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(yu4Var8);
                        yu4 yu4Var9 = new yu4();
                        yu4Var9.g = true;
                        yu4Var9.t = threadData;
                        yu4Var9.position = i;
                        yu4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(yu4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (v56.W(threadData)) {
                        v56 v56Var = new v56(threadData);
                        v56Var.g = threadData.getTid();
                        v56Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        v56Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(v56Var);
                    } else {
                        yu4 yu4Var10 = new yu4();
                        yu4Var10.t = threadData;
                        yu4Var10.position = i;
                        yu4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(yu4Var10);
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

    public static String d(m55 m55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, m55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return m55Var.a();
                }
                return m55Var.b();
            }
            return m55Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(m55 m55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return m55Var.d();
                }
                return m55Var.e();
            }
            return m55Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static m55 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (m55 m55Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(m55Var.g()) && m55Var.g().equals(str)) {
                        return m55Var;
                    }
                }
            }
            return null;
        }
        return (m55) invokeL.objValue;
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
                xn E = bdTypeRecyclerView.E(i3);
                ThreadData threadData = null;
                if (E instanceof yu4) {
                    threadData = ((yu4) E).getThreadData();
                } else if (E instanceof ThreadData) {
                    threadData = (ThreadData) E;
                } else if (E instanceof v56) {
                    threadData = ((v56) E).a;
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

    public static void h(boolean z, ArrayList<xn> arrayList, vr4 vr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, vr4Var}) == null) && vr4Var != null && arrayList != null && (i = vr4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, vr4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
