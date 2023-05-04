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
public class su7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<in> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<in> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            f05 f05Var = new f05();
            f05Var.t = threadData;
            f05Var.position = i;
            if (z) {
                f05Var.a = true;
            } else {
                f05Var.r = true;
            }
            f05Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(f05Var);
        }
    }

    public static ArrayList<in> c(ArrayList<in> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<in> arrayList2 = new ArrayList<>();
            Iterator<in> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                in next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        f05 f05Var = new f05();
                        f05Var.t = threadData;
                        f05Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            f05Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            f05Var.d = true;
                            f05Var.u = imageWidthAndHeight[0];
                            f05Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            f05Var.e = true;
                        } else {
                            f05Var.b = true;
                        }
                        f05Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        f05Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(f05Var);
                        if (threadData.getItem() != null) {
                            f05 f05Var2 = new f05();
                            f05Var2.n = true;
                            f05Var2.t = threadData;
                            f05Var2.position = i;
                            f05Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            f05 f05Var3 = new f05();
                            f05Var3.t = threadData;
                            f05Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                f05Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                f05Var3.q = true;
                            }
                            f05Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var3);
                        }
                        f05 f05Var4 = new f05();
                        f05Var4.m = true;
                        f05Var4.t = threadData;
                        f05Var4.position = i;
                        f05Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(f05Var4);
                        f05 f05Var5 = new f05();
                        f05Var5.g = true;
                        f05Var5.t = threadData;
                        f05Var5.position = i;
                        f05Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(f05Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        f05 f05Var6 = new f05();
                        f05Var6.t = threadData;
                        f05Var6.position = i;
                        f05Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        f05Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(f05Var6);
                        if (threadData.getItem() != null) {
                            f05 f05Var7 = new f05();
                            f05Var7.n = true;
                            f05Var7.t = threadData;
                            f05Var7.position = i;
                            f05Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(f05Var7);
                        }
                        f05 f05Var8 = new f05();
                        f05Var8.m = true;
                        f05Var8.t = threadData;
                        f05Var8.position = i;
                        f05Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(f05Var8);
                        f05 f05Var9 = new f05();
                        f05Var9.g = true;
                        f05Var9.t = threadData;
                        f05Var9.position = i;
                        f05Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(f05Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (xi6.W(threadData)) {
                        xi6 xi6Var = new xi6(threadData);
                        xi6Var.g = threadData.getTid();
                        xi6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        xi6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(xi6Var);
                    } else {
                        f05 f05Var10 = new f05();
                        f05Var10.t = threadData;
                        f05Var10.position = i;
                        f05Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(f05Var10);
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
                in item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof f05) {
                    threadData = ((f05) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof xi6) {
                    threadData = ((xi6) item).a;
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

    public static void e(boolean z, ArrayList<in> arrayList, ax4 ax4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, ax4Var}) == null) && ax4Var != null && arrayList != null && (i = ax4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, ax4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
