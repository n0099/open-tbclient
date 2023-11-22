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
import com.baidu.tieba.mb7;
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
/* loaded from: classes8.dex */
public final class wj7 implements yj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uj7 a;
    public final dk7 b;
    public final bk7 c;
    public OperateType d;
    public boolean e;

    /* loaded from: classes8.dex */
    public static final class a implements mb7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj7 a;

        public a(wj7 wj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj7Var;
        }

        @Override // com.baidu.tieba.mb7.a
        public void a(z57 data) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                dk7 o = this.a.o();
                OperateType operateType = this.a.d;
                if (data.d == 0) {
                    z = true;
                } else {
                    z = false;
                }
                o.w0(operateType, z, data.d, data.e, data.b);
            }
        }
    }

    public wj7(uj7 feedModel, dk7 callback) {
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
        this.c = new bk7(feedModel.c(), null, null, 6, null);
        this.d = OperateType.NONE;
    }

    @Override // com.baidu.tieba.yj7
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.F(i);
            this.d = OperateType.CHANGETAB;
            this.a.f();
            ni7.a();
            ni7.b(this.a.n());
        }
    }

    @Override // com.baidu.tieba.yj7
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
            this.a.f();
            ni7.a();
            ni7.b(this.a.n());
        }
    }

    @Override // com.baidu.tieba.yj7
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.a.j(i);
            this.d = OperateType.CHANGESORT;
            this.a.f();
            ni7.a();
            ni7.b(this.a.n());
        }
    }

    @Override // com.baidu.tieba.yj7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = OperateType.LOADMORE;
            this.a.g();
            ni7.a();
        }
    }

    @Override // com.baidu.tieba.yj7
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yj7
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.x();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yj7
    public bk7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (bk7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yj7
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yj7
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return !this.c.a().isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final dk7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (dk7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yj7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.yj7
    public void c(ak7 initData) {
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
            HashMap<String, j87> a2 = s67.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("fake_wall", new ul7());
        }
    }

    @Override // com.baidu.tieba.yj7
    public boolean d(String adId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adId)) == null) {
            Intrinsics.checkNotNullParameter(adId, "adId");
            Iterator<ab7<?>> it = i().a().iterator();
            boolean z = false;
            while (it.hasNext()) {
                ab7<?> next = it.next();
                if (next instanceof ab7) {
                    ab7<?> ab7Var = next;
                    if (ab7Var.b() instanceof AdvertAppInfo) {
                        Object b = ab7Var.b();
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

    @Override // com.baidu.tieba.yj7
    public boolean l(String tid) {
        InterceptResult invokeL;
        f57<?> f57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, tid)) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            Iterator<ab7<?>> it = i().a().iterator();
            boolean z = false;
            while (it.hasNext()) {
                ab7<?> next = it.next();
                if ((next instanceof w47) && (f57Var = ((w47) next).c) != null && Intrinsics.areEqual(tid, f57Var.m())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yj7
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

    @Override // com.baidu.tieba.yj7
    public void j(ThreadData data) {
        ab7<?> ab7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                j87 j87Var = s67.a().get("fake_wall");
                if (j87Var != null) {
                    ab7Var = j87Var.b(data);
                } else {
                    ab7Var = null;
                }
                if (ab7Var != null) {
                    int i = 0;
                    int i2 = 0;
                    for (Object obj : this.c.a()) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        ab7 ab7Var2 = (ab7) obj;
                        if (!"feed_top_card".equals(ab7Var2.a())) {
                            Object b = ab7Var2.b();
                            Intrinsics.checkNotNullExpressionValue(b, "templateData.bindData");
                            if (!vl7.b(b)) {
                                Object b2 = ab7Var2.b();
                                Intrinsics.checkNotNullExpressionValue(b2, "templateData.bindData");
                                if (!vl7.c(b2)) {
                                    i = i3;
                                }
                            }
                        }
                        i2++;
                        i = i3;
                    }
                    this.c.a().add(i2, ab7Var);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (!GlobalBuildConfig.isDebug()) {
                    return;
                }
                throw e;
            }
        }
    }
}
