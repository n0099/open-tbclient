package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.pb.data.PbFirstFloorRecommendData;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AichatBotCard;
import tbclient.NovelRecomCard;
import tbclient.PbPage.SimilarContent;
/* loaded from: classes8.dex */
public final class w3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(mwa postData, vv9 mData) {
        ForumData n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, postData, mData) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(mData, "mData");
            if (postData.getAdvertAppInfo() != null) {
                postData.getAdvertAppInfo().i = new hw4();
                if (mData.B() != null) {
                    postData.getAdvertAppInfo().i.b = mData.B().a();
                }
                postData.getAdvertAppInfo().i.a = postData.J1();
                if (mData.n() != null && (n = mData.n()) != null) {
                    postData.getAdvertAppInfo().i.c = n.getId();
                    postData.getAdvertAppInfo().i.d = n.getFirst_class();
                    postData.getAdvertAppInfo().i.e = n.getSecond_class();
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    postData.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
                }
                postData.getAdvertAppInfo().i.g = postData.getAdvertAppInfo().g;
                postData.getAdvertAppInfo().i.h = false;
            }
        }
    }

    public static final void b(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            int size = list.size();
            if (size > 0) {
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) instanceof nwa) {
                        if (i == 0 && (list.get(i2) instanceof mwa)) {
                            i = i2 + 1;
                        }
                        nwa nwaVar = (nwa) list.get(i2);
                        if (!TextUtils.isEmpty(nwaVar.Z())) {
                            wx4 wx4Var = new wx4();
                            wx4Var.e(nwaVar.Z());
                            list.set(i2, wx4Var);
                        }
                    }
                }
                if (i > 0 && c36.i().q()) {
                    c36.i().n(list, i, 5);
                }
            }
        }
    }

    public static final int c(zv9 zv9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, zv9Var, i)) == null) {
            if (zv9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (zv9Var.Z()) {
                if (i != 2) {
                    if (i == 3) {
                        return 2;
                    }
                } else {
                    return 1;
                }
            }
            return 3;
        }
        return invokeLI.intValue;
    }

    public static final void d(ArrayList<pi> list, boolean z, ArrayList<nwa> mHistoryFunAdList, PbFragment pbFragment, vv9 mData) {
        PbModel pbModel;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{list, Boolean.valueOf(z), mHistoryFunAdList, pbFragment, mData}) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mHistoryFunAdList, "mHistoryFunAdList");
            Intrinsics.checkNotNullParameter(mData, "mData");
            int i = y75.i();
            int j = y75.j() - 1;
            if (z) {
                boolean z3 = false;
                pi piVar = list.get(0);
                Intrinsics.checkNotNullExpressionValue(piVar, "list[0]");
                pi piVar2 = piVar;
                if ((piVar2 instanceof nwa) && ((nwa) piVar2).L() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pi piVar3 = list.get(list.size() - 1);
                Intrinsics.checkNotNullExpressionValue(piVar3, "list[list.size - 1]");
                pi piVar4 = piVar3;
                if ((piVar4 instanceof nwa) && ((nwa) piVar4).L() == 1) {
                    z3 = true;
                }
                if (z2 || z3) {
                    j++;
                }
            }
            int k = y75.k() + 1;
            if (pbFragment != null) {
                pbModel = pbFragment.l0();
            } else {
                pbModel = null;
            }
            if (pbModel != null && pbFragment.l0().D1() == 3) {
                mHistoryFunAdList.clear();
            }
            i(j, i, k, list, mData, mHistoryFunAdList);
        }
    }

    @Nullable
    public static final pi h(ArrayList<pi> list, int i, vv9 vv9Var, ThreadData threadData, PbFragment mPbFragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{list, Integer.valueOf(i), vv9Var, threadData, mPbFragment})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            lwa lwaVar = null;
            if (i1a.z(mPbFragment)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && vv9Var != null && vv9Var.u0()) {
                String d = r88.e().d("pb_banner");
                if (threadData == null && l88.m().v(d)) {
                    threadData = new ThreadData();
                    lwa lwaVar2 = new lwa();
                    threadData.funAdData = lwaVar2;
                    lwaVar2.m(vv9Var.o());
                    threadData.funAdData.r(vv9Var.T());
                }
                if (threadData != null) {
                    lwaVar = threadData.funAdData;
                }
                if (lwaVar != null) {
                    threadData.funAdData.j(1);
                    j26.k().q(true);
                    ListUtils.add(list, i, threadData);
                    if (c36.i().q()) {
                        c36.i().n(list, i + 1, 4);
                    }
                }
            }
            return threadData;
        }
        return (pi) invokeCommon.objValue;
    }

    @Nullable
    public static final pi e(ArrayList<pi> list, int i, vv9 mData, PbFragment mPbFragment) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i, mData, mPbFragment)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mData, "mData");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            mwa K0 = mPbFragment.l0().K0();
            if (K0 == null) {
                K0 = mData.C();
            }
            if (K0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert K1 = K0.K1();
            if (K1 != null) {
                K1.setAdvertAppInfo(K0.getAdvertAppInfo());
            }
            int h = K0.getAdvertAppInfo().h();
            if (h != 0) {
                gja.j(K0, h);
                if (h != 28 && h != 31) {
                    K0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (mData.n() != null) {
                K0.k1 = mData.n().getId();
            }
            if (mData.R() != null) {
                K0.n1 = JavaTypesHelper.toLong(mData.R().getId(), 0L);
            }
            if (mData.B() != null) {
                K0.o1 = mData.B().a();
            }
            a(K0, mData);
            if (i < 0) {
                return null;
            }
            K0.r1 = 1;
            j26.k().q(true);
            zf9.b(list, K0, i);
            mData.O0(K0);
            if (c36.i().q()) {
                c36.i().n(list, i + 1, 4);
            }
            return K0;
        }
        return (pi) invokeLILL.objValue;
    }

    public static final int r(vv9 data, ArrayList<pi> list, int i, PbFragment mPbFragment) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65553, null, data, list, i, mPbFragment)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            SimilarContent Q = data.Q();
            Intrinsics.checkNotNullExpressionValue(Q, "data.similarContent");
            zv9 zv9Var = new zv9(Q);
            String tid = zv9Var.X().getTid();
            int r1 = mPbFragment.l0().r1();
            data.Q0(c(zv9Var, r1));
            aw9 aw9Var = new aw9(zv9Var.V(), zv9Var.W());
            aw9Var.a = zv9Var.X();
            aw9Var.C = r1;
            aw9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(list, i2, aw9Var);
            zv9Var.X().isLinkThread();
            zv9Var.X().isSmartAppThreadType();
            if (!zv9Var.X().isLinkThread() && !zv9Var.X().isSmartAppThreadType()) {
                zv9Var.X().isGodThread();
            }
            zv9Var.a = zv9Var.X();
            zv9Var.C = r1;
            zv9Var.g = tid;
            zv9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(list, i2 + 1, zv9Var);
            return i2;
        }
        return invokeLLIL.intValue;
    }

    public static final boolean f(vv9 data, ArrayList<pi> list, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{data, list, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(data.h()) && data.h().size() > 2) {
                int min = Math.min(data.h().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    uw4 bjhThread = data.h().get(i5);
                    if (!z2 && i5 == 0) {
                        bjhThread.h(true);
                    }
                    if (bjhThread.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            bjhThread.l(true);
                        }
                    } else if (i5 == min - 2) {
                        bjhThread.l(true);
                    } else if (i5 == min - 1) {
                        bjhThread.k(true);
                    }
                    Intrinsics.checkNotNullExpressionValue(bjhThread, "bjhThread");
                    arrayList.add(bjhThread);
                }
            }
            if (arrayList.size() > 0) {
                if (z && i >= 0) {
                    i3 = i + 1;
                } else if (z) {
                    i3 = i2 + 2;
                } else if (i2 >= 0) {
                    i3 = i2 + 1;
                } else if (i3 < 0) {
                    if (i4 >= 0) {
                        i3 = i4;
                    } else {
                        i3 = -1;
                    }
                }
                if (i3 >= 0 && arrayList.size() > 1) {
                    int size = arrayList.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i6 = size - 1;
                            ListUtils.add(list, i3, arrayList.get(size));
                            if (i6 < 0) {
                                break;
                            }
                            size = i6;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public static final pi g(vv9 vv9Var, ArrayList<pi> list, int i) {
        InterceptResult invokeLLI;
        sv9 sv9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, vv9Var, list, i)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            if (i >= 0 && vv9Var != null && vv9Var.k && (sv9Var = vv9Var.l) != null) {
                Intrinsics.checkNotNullExpressionValue(sv9Var, "data.mCardGiftInfoData");
                ListUtils.add(list, i, sv9Var);
                return sv9Var;
            }
            return null;
        }
        return (pi) invokeLLI.objValue;
    }

    public static final void s(nwa data, ArrayList<pi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, null, data, list, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            data.y1(true);
            list.add(i, data);
        }
    }

    public static final void i(int i, int i2, int i3, ArrayList<pi> arrayList, vv9 vv9Var, ArrayList<nwa> arrayList2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList, vv9Var, arrayList2}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<pi> listIterator = arrayList.listIterator();
            Intrinsics.checkNotNullExpressionValue(listIterator, "posts.listIterator()");
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 >= i3) {
                        break;
                    }
                    if (i5 < arrayList2.size()) {
                        listIterator.add(arrayList2.get(i5));
                    } else {
                        nwa nwaVar = new nwa();
                        lwa lwaVar = new lwa();
                        lwaVar.m(vv9Var.o());
                        lwaVar.r(vv9Var.T());
                        lwaVar.n(true);
                        nwaVar.A0 = lwaVar;
                        lwaVar.j(i7);
                        listIterator.add(nwaVar);
                        i7++;
                        arrayList2.add(nwaVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && c36.i().q()) {
                c36.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                nwa nwaVar2 = new nwa();
                lwa lwaVar2 = new lwa();
                lwaVar2.m(vv9Var.o());
                lwaVar2.r(vv9Var.T());
                lwaVar2.n(true);
                nwaVar2.A0 = lwaVar2;
                lwaVar2.j(1);
                listIterator.add(nwaVar2);
                arrayList2.add(nwaVar2);
                if (c36.i().q()) {
                    c36.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public static final pi j(vv9 data, ArrayList<pi> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, data, list, i)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            AichatBotCard e = data.e();
            if (e == null || i < 0) {
                return null;
            }
            jw4 jw4Var = new jw4();
            jw4Var.f(e);
            ListUtils.add(list, i, jw4Var);
            return jw4Var;
        }
        return (pi) invokeLLI.objValue;
    }

    public static final boolean k(vv9 data, nwa nwaVar, List<? extends pi> list, int i, nwa nwaVar2, PbFragment mPbFragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{data, nwaVar, list, Integer.valueOf(i), nwaVar2, mPbFragment})) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            if (!n(data, nwaVar, list, i, nwaVar2) && !m(data, nwaVar, list, i, nwaVar2, mPbFragment) && !l(data, list, i, mPbFragment)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean l(vv9 vv9Var, List<? extends pi> list, int i, PbFragment pbFragment) {
        InterceptResult invokeLLIL;
        xv9 xv9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65547, null, vv9Var, list, i, pbFragment)) == null) {
            if (vv9Var.n() != null && !StringUtils.isNull(vv9Var.n().getName()) && !vv9Var.m && (!TextUtils.equals(vv9Var.n().getName(), pbFragment.l0().R0()) || !pbFragment.l0().X0())) {
                if (!pbFragment.e1() && !ListUtils.isEmpty(vv9Var.r())) {
                    xv9Var = new xv9(vv9Var.r().get(0));
                } else {
                    xv9Var = new xv9(vv9Var.n());
                }
                xv9Var.g = pbFragment.l0().M1();
                ListUtils.add(list, i, xv9Var);
            } else {
                xv9Var = null;
            }
            if (xv9Var == null) {
                return false;
            }
            return true;
        }
        return invokeLLIL.booleanValue;
    }

    public static final boolean m(vv9 vv9Var, nwa nwaVar, List<? extends pi> list, int i, nwa nwaVar2, PbFragment pbFragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{vv9Var, nwaVar, list, Integer.valueOf(i), nwaVar2, pbFragment})) == null) {
            if (vv9Var.n() != null && !StringUtils.isNull(vv9Var.n().getName()) && TextUtils.equals(vv9Var.n().getName(), pbFragment.l0().R0())) {
                pbFragment.l0().X0();
            }
            yv9 yv9Var = null;
            if (nwaVar != null) {
                if (nwaVar.v0 != null) {
                    yv9Var = new yv9(nwaVar.v0);
                }
            } else if (nwaVar2 != null && nwaVar2.v0 != null) {
                yv9Var = new yv9(nwaVar2.v0);
            }
            if (yv9Var != null) {
                yv9Var.b = pbFragment.l0().M1();
                ListUtils.add(list, i + 1, yv9Var);
            }
            if (yv9Var != null) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean n(vv9 vv9Var, nwa nwaVar, List<? extends pi> list, int i, nwa nwaVar2) {
        InterceptResult invokeCommon;
        NovelRecomCard novelRecomCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{vv9Var, nwaVar, list, Integer.valueOf(i), nwaVar2})) == null) {
            PbFirstFloorRecommendData pbFirstFloorRecommendData = null;
            if (nwaVar != null && nwaVar.c0() != null) {
                NovelRecomCard c0 = nwaVar.c0();
                Intrinsics.checkNotNullExpressionValue(c0, "firstFloorData.novelRecomCard");
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(c0);
            } else {
                if (nwaVar2 != null) {
                    novelRecomCard = nwaVar2.c0();
                } else {
                    novelRecomCard = null;
                }
                if (novelRecomCard != null) {
                    NovelRecomCard c02 = nwaVar2.c0();
                    Intrinsics.checkNotNullExpressionValue(c02, "mFirstFloorDataCache.novelRecomCard");
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(c02);
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (!TextUtils.isEmpty(vv9Var.T())) {
                    String T2 = vv9Var.T();
                    Intrinsics.checkNotNullExpressionValue(T2, "data.threadId");
                    pbFirstFloorRecommendData.f(T2);
                }
                ListUtils.add(list, i + 1, pbFirstFloorRecommendData);
            }
            if (pbFirstFloorRecommendData != null) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public static final l0a o(ArrayList<pi> list, pi piVar, int i, int i2, vv9 mData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{list, piVar, Integer.valueOf(i), Integer.valueOf(i2), mData})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mData, "mData");
            l0a E = mData.E();
            if (E != null) {
                if (piVar != null) {
                    if (i2 < 0 && piVar.getType() != AdvertAppInfo.B) {
                        i2 = i + 2;
                    } else if (piVar.getType() != AdvertAppInfo.B) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0) {
                    ListUtils.add(list, i2, E);
                    return E;
                }
                return null;
            }
            return null;
        }
        return (l0a) invokeCommon.objValue;
    }

    public static final void p(vv9 data, ArrayList<pi> list, int i, PbFragment mPbFragment) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65551, null, data, list, i, mPbFragment) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            jw9 jw9Var = new jw9(jw9.g);
            ThreadData R = data.R();
            jw9Var.c = mPbFragment.F7();
            jw9Var.b = data.g;
            jw9Var.d = data.a();
            jw9Var.e = data.f;
            if (R != null && R.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            jw9Var.f = z;
            ListUtils.add(list, i, jw9Var);
            if (data.M() == 4) {
                ListUtils.add(list, i + 1, new iw9());
            }
        }
    }

    @Nullable
    public static final pi q(ArrayList<pi> list, int i, PbFragment mPbFragment, vv9 mData) {
        InterceptResult invokeLILL;
        PbModel l0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65552, null, list, i, mPbFragment, mData)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            Intrinsics.checkNotNullParameter(mData, "mData");
            if (i < 0 || (l0 = mPbFragment.l0()) == null || TextUtils.isEmpty(l0.w1())) {
                return null;
            }
            mwa mwaVar = new mwa();
            a(mwaVar, mData);
            ListUtils.add(list, i + 1, mwaVar);
            return mwaVar;
        }
        return (pi) invokeLILL.objValue;
    }

    public static final void t(vv9 pbData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, pbData, threadData) == null) {
            Intrinsics.checkNotNullParameter(pbData, "pbData");
            Intrinsics.checkNotNullParameter(threadData, "threadData");
            threadData.setRobotEntrance(pbData.N());
        }
    }

    public static final void u(vv9 mData, PbFragment pbFragment, boolean z) {
        FragmentActivity fragmentActivity;
        mwa mwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65556, null, mData, pbFragment, z) == null) {
            Intrinsics.checkNotNullParameter(mData, "mData");
            if (mData.Z || mData.a0 == 2) {
                return;
            }
            ArrayList<nwa> I = mData.I();
            Intrinsics.checkNotNullExpressionValue(I, "mData.post_list");
            ArrayList<mwa> g = mData.g();
            Intrinsics.checkNotNullExpressionValue(g, "mData.apps");
            if (!zf9.e(I) && !zf9.e(g)) {
                StringBuilder sb = new StringBuilder();
                Iterator<mwa> it = g.iterator();
                while (it.hasNext()) {
                    mwa next = it.next();
                    if (next != null && next.I1() != null) {
                        sb.append(next.I1());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<mwa> it2 = g.iterator();
                while (it2.hasNext()) {
                    mwa next2 = it2.next();
                    if (next2 != null) {
                        next2.q1 = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<mwa> it3 = g.iterator();
                while (it3.hasNext()) {
                    mwa next3 = it3.next();
                    Intrinsics.checkNotNull(next3);
                    if (next3.getAdvertAppInfo() != null) {
                        int h = next3.getAdvertAppInfo().h();
                        if (h != 0) {
                            gja.j(next3, h);
                            if (h != 28 && h != 31) {
                                next3.getAdvertAppInfo().c = -1001;
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                g.clear();
                HashMap hashMap = new HashMap();
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    mwa mwaVar2 = (mwa) sparseArray.valueAt(i);
                    if (mwaVar2 != null && (mwaVar = (mwa) hashMap.put(mwaVar2.H1(), mwaVar2)) != null) {
                        gja.j(mwaVar, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    Object value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                    mwa mwaVar3 = (mwa) value;
                    sparseArray.put(mwaVar3.getPosition(), mwaVar3);
                }
                ArrayList arrayList = new ArrayList();
                int size2 = sparseArray.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    zf9.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
                }
                CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
                int i3 = zf9.i(arrayList);
                int i4 = 1;
                for (int i5 = 0; i5 < i3; i5++) {
                    Integer index = (Integer) zf9.d(arrayList, i5);
                    Intrinsics.checkNotNullExpressionValue(index, "index");
                    mwa mwaVar4 = (mwa) sparseArray.get(index.intValue());
                    if (mData.n() != null) {
                        Intrinsics.checkNotNull(mwaVar4);
                        mwaVar4.k1 = mData.n().getId();
                    }
                    if (mData.R() != null) {
                        Intrinsics.checkNotNull(mwaVar4);
                        mwaVar4.n1 = JavaTypesHelper.toLong(mData.R().getId(), 0L);
                    }
                    if (mData.B() != null) {
                        Intrinsics.checkNotNull(mwaVar4);
                        mwaVar4.o1 = mData.B().a();
                    }
                    if (mwaVar4 != null) {
                        a(mwaVar4, mData);
                    }
                    Intrinsics.checkNotNull(mwaVar4);
                    int position = mwaVar4.getPosition() + mData.Y;
                    if (position >= zf9.i(I)) {
                        mwaVar4.q1 = position;
                        gja.k(mwaVar4, 2, position, zf9.i(I));
                        return;
                    }
                    if (!z) {
                        position--;
                        mwaVar4.q1 = position;
                    }
                    if (position < 0) {
                        gja.j(mwaVar4, 23);
                    } else {
                        mwaVar4.r1 = i4;
                        zf9.b(I, mwaVar4, position);
                        i4++;
                        if (pbFragment != null) {
                            fragmentActivity = pbFragment.getActivity();
                        } else {
                            fragmentActivity = null;
                        }
                        if (fragmentActivity != null) {
                            TiebaStatic.eventStat(pbFragment.getActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mwaVar4.getAdvertAppInfo().q);
                        }
                    }
                }
            }
        }
    }
}
