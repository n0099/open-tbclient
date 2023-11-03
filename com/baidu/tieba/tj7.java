package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.forum.model.FrsGeneralTabListResMsg;
import com.baidu.tieba.forum.model.FrsPageHttpResponseMessage;
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.tieba.forum.model.FrsThreadListHttpResponseMessage;
import com.baidu.tieba.lb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public abstract class tj7 extends lb7 {
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
    public final ok7 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tj7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
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
        this.o = new ok7(this.e);
        k();
        String string = this.e.getString("forum_common_info");
        this.l = string == null ? "" : string;
        String string2 = this.e.getString("name");
        this.m = string2 != null ? string2 : "";
        this.n = this.e.getInt("forum_tab_id");
    }

    public void A(hh7 responseData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{responseData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            if (z && !z2) {
                b().a.clear();
            }
            try {
                b().a.addAll(responseData.b().c(responseData.a(), b(), this.k, z2));
                int size = b().a.size();
                for (int i = 0; i < size; i++) {
                    za7<?> za7Var = b().a.get(i);
                    if (za7Var instanceof o67) {
                        ((o67) za7Var).setPosition(i);
                    }
                    if (za7Var instanceof eb7) {
                        ((eb7) za7Var).e(this.o);
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
        if (((com.baidu.tieba.mb7) r1).getFeedLoadType() == 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(ResponsedMessage<?> responsedMessage) {
        boolean z;
        hh7 hh7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage) == null) {
            i(false);
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof mb7) {
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
                    hh7Var = frsPageHttpResponseMessage.getFrsPageData();
                    this.j = frsPageHttpResponseMessage.getFrsPageData().i();
                } else if (responsedMessage instanceof FrsThreadListHttpResponseMessage) {
                    hh7Var = ((FrsThreadListHttpResponseMessage) responsedMessage).getThreadListData();
                } else if (responsedMessage instanceof FrsGeneralTabListResMsg) {
                    hh7Var = ((FrsGeneralTabListResMsg) responsedMessage).getGeneralTabListData();
                } else {
                    hh7Var = new hh7();
                }
                A(hh7Var, z, false);
            }
            lb7.a d = d();
            if (d != null) {
                d.a(b());
            }
        }
    }

    public final void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.i = i;
        }
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.h = i;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public final void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.g = i;
        }
    }

    public final void G(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.j = list;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f = i;
        }
    }

    public final void y(hh7 responseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, responseData) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            if (responseData instanceof jh7) {
                this.j = ((jh7) responseData).i();
            }
            A(responseData, true, false);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.put("page_from", "frs");
        }
    }

    public final BdUniqueId l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final Bundle m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (Bundle) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final ok7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.o;
        }
        return (ok7) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final Map<String, String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return (Map) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public final List<Long> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return b().c;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h++;
            FrsPageRequestMessage a = bk7.a(this.e);
            a.setTag(this.d);
            a.setPn(this.h);
            a.setRn(90);
            a.setRnNeed(30);
            a.setSortType(this.f);
            a.setLoadType(2);
            String g = m27.g(b().a, false);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, false)");
            a.setAdFloorInfo(g);
            MessageManager.getInstance().sendMessage(a);
        }
    }
}
