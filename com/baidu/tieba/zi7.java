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
public class zi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<gn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<gn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            mz4 mz4Var = new mz4();
            mz4Var.t = threadData;
            mz4Var.position = i;
            if (z) {
                mz4Var.a = true;
            } else {
                mz4Var.r = true;
            }
            mz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(mz4Var);
        }
    }

    public static ArrayList<gn> c(ArrayList<gn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<gn> arrayList2 = new ArrayList<>();
            Iterator<gn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                gn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        mz4 mz4Var = new mz4();
                        mz4Var.t = threadData;
                        mz4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            mz4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            mz4Var.d = true;
                            mz4Var.u = imageWidthAndHeight[0];
                            mz4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            mz4Var.e = true;
                        } else {
                            mz4Var.b = true;
                        }
                        mz4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        mz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var);
                        if (threadData.getItem() != null) {
                            mz4 mz4Var2 = new mz4();
                            mz4Var2.n = true;
                            mz4Var2.t = threadData;
                            mz4Var2.position = i;
                            mz4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            mz4 mz4Var3 = new mz4();
                            mz4Var3.t = threadData;
                            mz4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                mz4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                mz4Var3.q = true;
                            }
                            mz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var3);
                        }
                        mz4 mz4Var4 = new mz4();
                        mz4Var4.m = true;
                        mz4Var4.t = threadData;
                        mz4Var4.position = i;
                        mz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(mz4Var4);
                        mz4 mz4Var5 = new mz4();
                        mz4Var5.g = true;
                        mz4Var5.t = threadData;
                        mz4Var5.position = i;
                        mz4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(mz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        mz4 mz4Var6 = new mz4();
                        mz4Var6.t = threadData;
                        mz4Var6.position = i;
                        mz4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        mz4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var6);
                        if (threadData.getItem() != null) {
                            mz4 mz4Var7 = new mz4();
                            mz4Var7.n = true;
                            mz4Var7.t = threadData;
                            mz4Var7.position = i;
                            mz4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(mz4Var7);
                        }
                        mz4 mz4Var8 = new mz4();
                        mz4Var8.m = true;
                        mz4Var8.t = threadData;
                        mz4Var8.position = i;
                        mz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(mz4Var8);
                        mz4 mz4Var9 = new mz4();
                        mz4Var9.g = true;
                        mz4Var9.t = threadData;
                        mz4Var9.position = i;
                        mz4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(mz4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (zf6.W(threadData)) {
                        zf6 zf6Var = new zf6(threadData);
                        zf6Var.g = threadData.getTid();
                        zf6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        zf6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(zf6Var);
                    } else {
                        mz4 mz4Var10 = new mz4();
                        mz4Var10.t = threadData;
                        mz4Var10.position = i;
                        mz4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(mz4Var10);
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
                gn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof mz4) {
                    threadData = ((mz4) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof zf6) {
                    threadData = ((zf6) item).a;
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

    public static void e(boolean z, ArrayList<gn> arrayList, hw4 hw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, hw4Var}) == null) && hw4Var != null && arrayList != null && (i = hw4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, hw4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
