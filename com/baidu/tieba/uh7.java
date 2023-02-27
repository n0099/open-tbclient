package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
public class uh7 {
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
            d15 d15Var = new d15();
            d15Var.t = threadData;
            d15Var.position = i;
            if (z) {
                d15Var.a = true;
            } else {
                d15Var.r = true;
            }
            d15Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(d15Var);
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
                        d15 d15Var = new d15();
                        d15Var.t = threadData;
                        d15Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            d15Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            d15Var.d = true;
                            d15Var.u = imageWidthAndHeight[0];
                            d15Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            d15Var.e = true;
                        } else {
                            d15Var.b = true;
                        }
                        d15Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        d15Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d15Var);
                        if (threadData.getItem() != null) {
                            d15 d15Var2 = new d15();
                            d15Var2.n = true;
                            d15Var2.t = threadData;
                            d15Var2.position = i;
                            d15Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            d15 d15Var3 = new d15();
                            d15Var3.t = threadData;
                            d15Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                d15Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                d15Var3.q = true;
                            }
                            d15Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var3);
                        }
                        d15 d15Var4 = new d15();
                        d15Var4.m = true;
                        d15Var4.t = threadData;
                        d15Var4.position = i;
                        d15Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(d15Var4);
                        d15 d15Var5 = new d15();
                        d15Var5.g = true;
                        d15Var5.t = threadData;
                        d15Var5.position = i;
                        d15Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d15Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        d15 d15Var6 = new d15();
                        d15Var6.t = threadData;
                        d15Var6.position = i;
                        d15Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        d15Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d15Var6);
                        if (threadData.getItem() != null) {
                            d15 d15Var7 = new d15();
                            d15Var7.n = true;
                            d15Var7.t = threadData;
                            d15Var7.position = i;
                            d15Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(d15Var7);
                        }
                        d15 d15Var8 = new d15();
                        d15Var8.m = true;
                        d15Var8.t = threadData;
                        d15Var8.position = i;
                        d15Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(d15Var8);
                        d15 d15Var9 = new d15();
                        d15Var9.g = true;
                        d15Var9.t = threadData;
                        d15Var9.position = i;
                        d15Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d15Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (lg6.W(threadData)) {
                        lg6 lg6Var = new lg6(threadData);
                        lg6Var.g = threadData.getTid();
                        lg6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        lg6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(lg6Var);
                    } else {
                        d15 d15Var10 = new d15();
                        d15Var10.t = threadData;
                        d15Var10.position = i;
                        d15Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(d15Var10);
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

    public static List<Integer> d(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                Cdo E = bdTypeRecyclerView.E(i3);
                ThreadData threadData = null;
                if (E instanceof d15) {
                    threadData = ((d15) E).getThreadData();
                } else if (E instanceof ThreadData) {
                    threadData = (ThreadData) E;
                } else if (E instanceof lg6) {
                    threadData = ((lg6) E).a;
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

    public static void e(boolean z, ArrayList<Cdo> arrayList, zx4 zx4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, zx4Var}) == null) && zx4Var != null && arrayList != null && (i = zx4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, zx4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
