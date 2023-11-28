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
/* loaded from: classes8.dex */
public class vi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<pi> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<pi> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            jz4 jz4Var = new jz4();
            jz4Var.t = threadData;
            jz4Var.position = i;
            if (z) {
                jz4Var.a = true;
            } else {
                jz4Var.r = true;
            }
            jz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(jz4Var);
        }
    }

    public static ArrayList<pi> c(ArrayList<pi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<pi> arrayList2 = new ArrayList<>();
            Iterator<pi> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        jz4 jz4Var = new jz4();
                        jz4Var.t = threadData;
                        jz4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jz4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            jz4Var.d = true;
                            jz4Var.u = imageWidthAndHeight[0];
                            jz4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jz4Var.e = true;
                        } else {
                            jz4Var.b = true;
                        }
                        jz4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        jz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jz4Var);
                        if (threadData.getItem() != null) {
                            jz4 jz4Var2 = new jz4();
                            jz4Var2.n = true;
                            jz4Var2.t = threadData;
                            jz4Var2.position = i;
                            jz4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            jz4 jz4Var3 = new jz4();
                            jz4Var3.t = threadData;
                            jz4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                jz4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                jz4Var3.q = true;
                            }
                            jz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var3);
                        }
                        jz4 jz4Var4 = new jz4();
                        jz4Var4.m = true;
                        jz4Var4.t = threadData;
                        jz4Var4.position = i;
                        jz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(jz4Var4);
                        jz4 jz4Var5 = new jz4();
                        jz4Var5.g = true;
                        jz4Var5.t = threadData;
                        jz4Var5.position = i;
                        jz4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        jz4 jz4Var6 = new jz4();
                        jz4Var6.t = threadData;
                        jz4Var6.position = i;
                        jz4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        jz4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jz4Var6);
                        if (threadData.getItem() != null) {
                            jz4 jz4Var7 = new jz4();
                            jz4Var7.n = true;
                            jz4Var7.t = threadData;
                            jz4Var7.position = i;
                            jz4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(jz4Var7);
                        }
                        jz4 jz4Var8 = new jz4();
                        jz4Var8.m = true;
                        jz4Var8.t = threadData;
                        jz4Var8.position = i;
                        jz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(jz4Var8);
                        jz4 jz4Var9 = new jz4();
                        jz4Var9.g = true;
                        jz4Var9.t = threadData;
                        jz4Var9.position = i;
                        jz4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jz4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (ym6.R(threadData)) {
                        ym6 ym6Var = new ym6(threadData);
                        ym6Var.g = threadData.getTid();
                        ym6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        ym6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(ym6Var);
                    } else {
                        jz4 jz4Var10 = new jz4();
                        jz4Var10.t = threadData;
                        jz4Var10.position = i;
                        jz4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jz4Var10);
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
                pi item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof jz4) {
                    threadData = ((jz4) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof ym6) {
                    threadData = ((ym6) item).a;
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

    public static void e(boolean z, ArrayList<pi> arrayList, cw4 cw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, cw4Var}) == null) && cw4Var != null && arrayList != null && (i = cw4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, cw4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
