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
public class r17 {
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
            jr4 jr4Var = new jr4();
            jr4Var.t = threadData;
            jr4Var.position = i;
            if (z) {
                jr4Var.a = true;
            } else {
                jr4Var.r = true;
            }
            jr4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(jr4Var);
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
                        jr4 jr4Var = new jr4();
                        jr4Var.t = threadData;
                        jr4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jr4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            jr4Var.d = true;
                            jr4Var.u = imageWidthAndHeight[0];
                            jr4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jr4Var.e = true;
                        } else {
                            jr4Var.b = true;
                        }
                        jr4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        jr4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jr4Var);
                        if (threadData.getItem() != null) {
                            jr4 jr4Var2 = new jr4();
                            jr4Var2.n = true;
                            jr4Var2.t = threadData;
                            jr4Var2.position = i;
                            jr4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            jr4 jr4Var3 = new jr4();
                            jr4Var3.t = threadData;
                            jr4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                jr4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                jr4Var3.q = true;
                            }
                            jr4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var3);
                        }
                        jr4 jr4Var4 = new jr4();
                        jr4Var4.m = true;
                        jr4Var4.t = threadData;
                        jr4Var4.position = i;
                        jr4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(jr4Var4);
                        jr4 jr4Var5 = new jr4();
                        jr4Var5.g = true;
                        jr4Var5.t = threadData;
                        jr4Var5.position = i;
                        jr4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jr4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        jr4 jr4Var6 = new jr4();
                        jr4Var6.t = threadData;
                        jr4Var6.position = i;
                        jr4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        jr4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jr4Var6);
                        if (threadData.getItem() != null) {
                            jr4 jr4Var7 = new jr4();
                            jr4Var7.n = true;
                            jr4Var7.t = threadData;
                            jr4Var7.position = i;
                            jr4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(jr4Var7);
                        }
                        jr4 jr4Var8 = new jr4();
                        jr4Var8.m = true;
                        jr4Var8.t = threadData;
                        jr4Var8.position = i;
                        jr4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(jr4Var8);
                        jr4 jr4Var9 = new jr4();
                        jr4Var9.g = true;
                        jr4Var9.t = threadData;
                        jr4Var9.position = i;
                        jr4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jr4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (s06.W(threadData)) {
                        s06 s06Var = new s06(threadData);
                        s06Var.g = threadData.getTid();
                        s06Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        s06Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(s06Var);
                    } else {
                        jr4 jr4Var10 = new jr4();
                        jr4Var10.t = threadData;
                        jr4Var10.position = i;
                        jr4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jr4Var10);
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

    public static String d(k15 k15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k15Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return k15Var.a();
                }
                return k15Var.b();
            }
            return k15Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(k15 k15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, k15Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return k15Var.d();
                }
                return k15Var.e();
            }
            return k15Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static k15 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (k15 k15Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(k15Var.h()) && k15Var.h().equals(str)) {
                        return k15Var;
                    }
                }
            }
            return null;
        }
        return (k15) invokeL.objValue;
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
                if (B instanceof jr4) {
                    threadData = ((jr4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof s06) {
                    threadData = ((s06) B).a;
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

    public static void h(boolean z, ArrayList<pn> arrayList, go4 go4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, go4Var}) == null) || go4Var == null || arrayList == null || (i = go4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, go4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
