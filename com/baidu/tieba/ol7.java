package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forum.model.OperateType;
import com.baidu.tieba.zb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ol7 implements ql7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ml7 a;
    public final vl7 b;
    public final tl7 c;
    public OperateType d;
    public boolean e;
    public boolean f;

    /* loaded from: classes7.dex */
    public static final class a implements zb7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol7 a;

        public a(ol7 ol7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol7Var;
        }

        @Override // com.baidu.tieba.zb7.a
        public void a(m67 data) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                vl7 q = this.a.q();
                OperateType operateType = this.a.d;
                if (data.d == 0) {
                    z = true;
                } else {
                    z = false;
                }
                q.A0(operateType, z, data.d, data.e, data.b);
            }
        }
    }

    public ol7(ml7 feedModel, vl7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedModel, callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(feedModel, "feedModel");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.a = feedModel;
        this.b = callback;
        this.c = new tl7(feedModel.c(), null, null, 6, null);
        this.d = OperateType.NONE;
    }

    @Override // com.baidu.tieba.ql7
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.G(i);
            this.d = OperateType.CHANGETAB;
            this.a.f();
            ek7.a();
            ek7.b(this.a.n());
        }
    }

    @Override // com.baidu.tieba.ql7
    public void f(boolean z) {
        OperateType operateType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                operateType = OperateType.PULLREFRESH;
            } else {
                operateType = OperateType.FULLREFRESH;
            }
            this.d = operateType;
            this.f = true;
            this.a.f();
            ek7.a();
            ek7.b(this.a.n());
        }
    }

    @Override // com.baidu.tieba.ql7
    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a.j(i);
            this.d = OperateType.CHANGESORT;
            this.a.f();
            ek7.a();
            ek7.b(this.a.n());
        }
    }

    @Override // com.baidu.tieba.ql7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = OperateType.LOADMORE;
            this.a.g();
            ek7.a();
        }
    }

    @Override // com.baidu.tieba.ql7
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ql7
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.x();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ql7
    public tl7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (tl7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ql7
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ql7
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if ((!this.c.a().isEmpty()) || this.f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ql7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.ql7
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a.v();
        }
        return invokeV.intValue;
    }

    public final vl7 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (vl7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ql7
    public void c(sl7 initData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, initData) == null) {
            Intrinsics.checkNotNullParameter(initData, "initData");
            this.c.e(initData.b().b());
            this.c.d(initData.b().a());
            this.a.h(new a(this));
            if (initData.a() != null) {
                this.e = true;
                this.a.y(initData.a());
            }
            r();
        }
    }

    @Override // com.baidu.tieba.ql7
    public boolean d(String adId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adId)) == null) {
            Intrinsics.checkNotNullParameter(adId, "adId");
            Iterator<nb7<?>> it = i().a().iterator();
            boolean z = false;
            while (it.hasNext()) {
                nb7<?> next = it.next();
                if (next instanceof nb7) {
                    nb7<?> nb7Var = next;
                    if (nb7Var.b() instanceof AdvertAppInfo) {
                        Object b = nb7Var.b();
                        if (b != null) {
                            if (Intrinsics.areEqual(adId, ((AdvertAppInfo) b).a)) {
                                it.remove();
                                z = true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.AdvertAppInfo");
                        }
                    } else {
                        continue;
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ql7
    public boolean m(String tid) {
        InterceptResult invokeL;
        s57<?> s57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tid)) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            Iterator<nb7<?>> it = i().a().iterator();
            boolean z = false;
            while (it.hasNext()) {
                nb7<?> next = it.next();
                if ((next instanceof j57) && (s57Var = ((j57) next).c) != null && Intrinsics.areEqual(tid, s57Var.m())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ql7
    public void h(JSONObject jSONObject, BdUniqueId pageUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, pageUniqueId) == null) {
            Intrinsics.checkNotNullParameter(pageUniqueId, "pageUniqueId");
            if (jSONObject == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            httpMessage.addParam("dislike", jSONArray.toString());
            httpMessage.addParam("dislike_from", "frs");
            httpMessage.setTag(pageUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tieba.ql7
    public int j(nb7<?> data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            int i = 0;
            int i2 = 0;
            for (Object obj : this.c.a()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                nb7 nb7Var = (nb7) obj;
                if (!Intrinsics.areEqual("feed_top_card", nb7Var.a())) {
                    Object b = nb7Var.b();
                    Intrinsics.checkNotNullExpressionValue(b, "templateData.bindData");
                    if (!co7.b(b)) {
                        Object b2 = nb7Var.b();
                        Intrinsics.checkNotNullExpressionValue(b2, "templateData.bindData");
                        if (!co7.c(b2)) {
                            i2 = i3;
                        }
                    }
                }
                i++;
                i2 = i3;
            }
            this.c.a().add(i, data);
            return i;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.ql7
    public int k(ThreadData data) {
        InterceptResult invokeL;
        nb7<?> nb7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                w87 w87Var = f77.a().get("fake_wall");
                if (w87Var != null) {
                    nb7Var = w87Var.b(data);
                } else {
                    nb7Var = null;
                }
                if (nb7Var != null) {
                    int i = 0;
                    int i2 = 0;
                    for (Object obj : this.c.a()) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        nb7 nb7Var2 = (nb7) obj;
                        if (!"feed_top_card".equals(nb7Var2.a())) {
                            Object b = nb7Var2.b();
                            Intrinsics.checkNotNullExpressionValue(b, "templateData.bindData");
                            if (!co7.b(b)) {
                                Object b2 = nb7Var2.b();
                                Intrinsics.checkNotNullExpressionValue(b2, "templateData.bindData");
                                if (!co7.c(b2)) {
                                    i = i3;
                                }
                            }
                        }
                        i2++;
                        i = i3;
                    }
                    this.c.a().add(i2, nb7Var);
                    return i2;
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                if (!GlobalBuildConfig.isDebug()) {
                    return -1;
                }
                throw e;
            }
        }
        return invokeL.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HashMap<String, w87> a2 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("fake_wall", new zn7());
            HashMap<String, w87> a3 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("double_row_video", new ao7());
        }
    }
}
