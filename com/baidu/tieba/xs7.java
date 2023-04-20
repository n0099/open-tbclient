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
/* loaded from: classes7.dex */
public class xs7 {
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
            pz4 pz4Var = new pz4();
            pz4Var.t = threadData;
            pz4Var.position = i;
            if (z) {
                pz4Var.a = true;
            } else {
                pz4Var.r = true;
            }
            pz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(pz4Var);
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
                        pz4 pz4Var = new pz4();
                        pz4Var.t = threadData;
                        pz4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            pz4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            pz4Var.d = true;
                            pz4Var.u = imageWidthAndHeight[0];
                            pz4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            pz4Var.e = true;
                        } else {
                            pz4Var.b = true;
                        }
                        pz4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        pz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(pz4Var);
                        if (threadData.getItem() != null) {
                            pz4 pz4Var2 = new pz4();
                            pz4Var2.n = true;
                            pz4Var2.t = threadData;
                            pz4Var2.position = i;
                            pz4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(pz4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            pz4 pz4Var3 = new pz4();
                            pz4Var3.t = threadData;
                            pz4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                pz4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                pz4Var3.q = true;
                            }
                            pz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(pz4Var3);
                        }
                        pz4 pz4Var4 = new pz4();
                        pz4Var4.m = true;
                        pz4Var4.t = threadData;
                        pz4Var4.position = i;
                        pz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(pz4Var4);
                        pz4 pz4Var5 = new pz4();
                        pz4Var5.g = true;
                        pz4Var5.t = threadData;
                        pz4Var5.position = i;
                        pz4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(pz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        pz4 pz4Var6 = new pz4();
                        pz4Var6.t = threadData;
                        pz4Var6.position = i;
                        pz4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        pz4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(pz4Var6);
                        if (threadData.getItem() != null) {
                            pz4 pz4Var7 = new pz4();
                            pz4Var7.n = true;
                            pz4Var7.t = threadData;
                            pz4Var7.position = i;
                            pz4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(pz4Var7);
                        }
                        pz4 pz4Var8 = new pz4();
                        pz4Var8.m = true;
                        pz4Var8.t = threadData;
                        pz4Var8.position = i;
                        pz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(pz4Var8);
                        pz4 pz4Var9 = new pz4();
                        pz4Var9.g = true;
                        pz4Var9.t = threadData;
                        pz4Var9.position = i;
                        pz4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(pz4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (mh6.W(threadData)) {
                        mh6 mh6Var = new mh6(threadData);
                        mh6Var.g = threadData.getTid();
                        mh6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        mh6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(mh6Var);
                    } else {
                        pz4 pz4Var10 = new pz4();
                        pz4Var10.t = threadData;
                        pz4Var10.position = i;
                        pz4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(pz4Var10);
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
                if (item instanceof pz4) {
                    threadData = ((pz4) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof mh6) {
                    threadData = ((mh6) item).a;
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

    public static void e(boolean z, ArrayList<in> arrayList, kw4 kw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, kw4Var}) == null) && kw4Var != null && arrayList != null && (i = kw4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, kw4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
