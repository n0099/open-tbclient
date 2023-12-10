package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ec7;
import com.baidu.tieba.forum.model.FrsGeneralTabListResMsg;
import com.baidu.tieba.forum.model.FrsPageHttpResponseMessage;
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.tieba.forum.model.FrsThreadListHttpResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public abstract class rl7 extends ec7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId d;
    public final Bundle e;
    public int f;
    public int g;
    public int h;
    public int i;
    public List<Long> j;
    public final Map<String, String> k;
    public final String l;
    public final String m;
    public final int n;
    public final boolean o;
    public final vm7 p;
    public String q;
    public String r;
    public String s;

    public abstract String n();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rl7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bdUniqueId, "bdUniqueId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.d = bdUniqueId;
        this.e = bundle;
        this.f = -1;
        this.h = 1;
        this.j = CollectionsKt__CollectionsKt.emptyList();
        this.k = new LinkedHashMap();
        this.p = new vm7(this.e);
        String string = this.e.getString("frs_fid");
        this.q = string == null ? "" : string;
        String string2 = this.e.getString("frs_first_class");
        this.r = string2 == null ? "" : string2;
        String string3 = this.e.getString("frs_second_class");
        this.s = string3 == null ? "" : string3;
        m();
        String string4 = this.e.getString("forum_common_info");
        this.l = string4 == null ? "" : string4;
        String string5 = this.e.getString("name");
        this.m = string5 != null ? string5 : "";
        this.n = this.e.getInt("forum_tab_id");
        this.o = this.e.getInt("forum_staggered_tab") == 1;
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public final List<Long> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b().c;
        }
        return invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.put("page_from", "frs");
        }
    }

    public final BdUniqueId o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.d;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final Bundle p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.e;
        }
        return (Bundle) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public final vm7 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.p;
        }
        return (vm7) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final Map<String, String> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.k;
        }
        return (Map) invokeV.objValue;
    }

    public final String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final void E(ti7 responseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responseData) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            if (responseData instanceof vi7) {
                this.j = ((vi7) responseData).i();
            }
            H(responseData, true, false);
        }
    }

    public final void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.i = i;
        }
    }

    public final void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = i;
        }
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f = i;
        }
    }

    public final void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.g = i;
        }
    }

    public final void N(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.j = list;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f = i;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h++;
            FrsPageRequestMessage a = zl7.a(this.e);
            a.setTag(this.d);
            a.setPn(this.h);
            a.setRn(90);
            a.setRnNeed(30);
            a.setSortType(this.f);
            a.setLoadType(2);
            String g = c37.g(b().a, false);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, false)");
            a.setAdFloorInfo(g);
            MessageManager.getInstance().sendMessage(a);
        }
    }

    public void H(ti7 responseData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{responseData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            if (z && !z2) {
                b().a.clear();
            }
            try {
                List<sb7<?>> c = responseData.b().c(responseData.a(), b(), this.k, z2);
                k(this.q, this.r, this.s, c);
                b().a.addAll(c);
                int size = b().a.size();
                for (int i = 0; i < size; i++) {
                    sb7<?> sb7Var = b().a.get(i);
                    if (sb7Var instanceof g77) {
                        ((g77) sb7Var).setPosition(i);
                    }
                    if (sb7Var instanceof xb7) {
                        ((xb7) sb7Var).e(this.p);
                    }
                }
                b().c = responseData.b().a(responseData.a());
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    System.exit(0);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (((com.baidu.tieba.fc7) r1).getFeedLoadType() == 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(ResponsedMessage<?> responsedMessage) {
        boolean z;
        ti7 ti7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedMessage) == null) {
            i(false);
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof fc7) {
                    z = true;
                }
            }
            z = false;
            if (responsedMessage.getError() != 0) {
                b().d = responsedMessage.getError();
                b().e = responsedMessage.getErrorString();
            } else {
                b().d = 0;
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                    ti7Var = frsPageHttpResponseMessage.getFrsPageData();
                    this.j = frsPageHttpResponseMessage.getFrsPageData().i();
                } else if (responsedMessage instanceof FrsThreadListHttpResponseMessage) {
                    ti7Var = ((FrsThreadListHttpResponseMessage) responsedMessage).getThreadListData();
                } else if (responsedMessage instanceof FrsGeneralTabListResMsg) {
                    ti7Var = ((FrsGeneralTabListResMsg) responsedMessage).getGeneralTabListData();
                } else {
                    ti7Var = new ti7();
                }
                H(ti7Var, z, false);
            }
            ec7.a d = d();
            if (d != null) {
                d.a(b());
            }
        }
    }

    public final Set<pi> j(List<? extends pi> threadData, int i, String fid, String firstClass, String secondClass) {
        InterceptResult invokeCommon;
        AdvertAppInfo w;
        AdvertAppInfo w2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{threadData, Integer.valueOf(i), fid, firstClass, secondClass})) == null) {
            Intrinsics.checkNotNullParameter(threadData, "threadData");
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(firstClass, "firstClass");
            Intrinsics.checkNotNullParameter(secondClass, "secondClass");
            HashSet hashSet = new HashSet();
            if (eg9.e(threadData)) {
                return hashSet;
            }
            Set<pi> a = jja.a("FRS");
            if (a == null) {
                a = new HashSet();
            }
            for (pi piVar : threadData) {
                if (piVar != null) {
                    for (pi piVar2 : a) {
                        if ((piVar instanceof yx4) && (w2 = ((yx4) piVar).w()) != null && piVar2.hashCode() == w2.hashCode()) {
                            if (piVar2 != null) {
                                w2.i = ((AdvertAppInfo) piVar2).i;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.AdvertAppInfo");
                            }
                        }
                    }
                    if ((piVar instanceof yx4) && (w = ((yx4) piVar).w()) != null && w.i == null) {
                        w.j = n();
                        kw4 kw4Var = new kw4();
                        w.i = kw4Var;
                        kw4Var.a = n();
                        kw4 kw4Var2 = w.i;
                        kw4Var2.b = i;
                        kw4Var2.c = fid;
                        kw4Var2.d = firstClass;
                        kw4Var2.e = secondClass;
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        if (currentAccountObj != null) {
                            w.i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
                        }
                        kw4 kw4Var3 = w.i;
                        kw4Var3.g = w.g;
                        kw4Var3.h = false;
                        hashSet.add(w);
                    }
                }
            }
            a.addAll(hashSet);
            jja.b("FRS", a);
            return hashSet;
        }
        return (Set) invokeCommon.objValue;
    }

    public final void k(String fid, String firstClass, String secondClass, List<? extends sb7<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, fid, firstClass, secondClass, list) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(firstClass, "firstClass");
            Intrinsics.checkNotNullParameter(secondClass, "secondClass");
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (sb7<?> sb7Var : list) {
                if (sb7Var.b() instanceof AdvertAppInfo) {
                    Object b = sb7Var.b();
                    if (b != null) {
                        arrayList.add((pi) b);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            j(arrayList, this.h, fid, firstClass, secondClass);
        }
    }
}
