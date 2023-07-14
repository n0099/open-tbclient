package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tbclient.ClickBackCard;
import tbclient.ClickBackCardItem;
/* loaded from: classes6.dex */
public final class l18 extends kq6 {
    public static /* synthetic */ Interceptable $ic;
    public static final a U0;
    public transient /* synthetic */ FieldHolder $fh;
    public String S0;
    public List<b> T0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890134, "Lcom/baidu/tieba/l18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890134, "Lcom/baidu/tieba/l18;");
                return;
            }
        }
        U0 = new a(null);
    }

    @JvmStatic
    public static final boolean d0(l18 l18Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, l18Var)) == null) ? U0.b(l18Var) : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean f0(l18 l18Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l18Var)) == null) ? U0.c(l18Var) : invokeL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int q = da5.p().q("key_recom_topic_card_show_times", 0);
                int q2 = da5.p().q("key_recom_topic_card_curr_show_times", 0);
                long currentTimeMillis = System.currentTimeMillis();
                long r = da5.p().r("key_recom_topic_card_last_show_time", 0L);
                String tidString = da5.p().w("key_recom_topic_card_curr_tid_builder", "");
                StringBuilder sb = new StringBuilder(tidString);
                if (StringHelper.isTaday(r) && q2 < q) {
                    Intrinsics.checkNotNullExpressionValue(tidString, "tidString");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) tidString, (CharSequence) str, false, 2, (Object) null)) {
                        da5.p().F("key_recom_topic_card_curr_show_times", q2 + 1);
                        da5.p().H("key_recom_topic_card_last_show_time", currentTimeMillis);
                        da5 p = da5.p();
                        sb.append(str);
                        p.J("key_recom_topic_card_curr_tid_builder", sb.toString());
                        return true;
                    }
                }
                if (StringHelper.isTaday(r) || q <= 0) {
                    return false;
                }
                da5.p().F("key_recom_topic_card_curr_show_times", 1);
                da5.p().H("key_recom_topic_card_last_show_time", currentTimeMillis);
                da5.p().J("key_recom_topic_card_curr_tid_builder", str);
                return true;
            }
            return invokeL.booleanValue;
        }

        @JvmStatic
        public final boolean b(l18 l18Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l18Var)) == null) {
                if (l18Var != null && !StringUtils.isNull(l18Var.c0()) && l18Var.b0() != null && !l18Var.b0().isEmpty()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @JvmStatic
        public final boolean c(l18 l18Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l18Var)) == null) {
                if (TbadkCoreApplication.isLogin() && l18Var != null && ListUtils.isNotEmpty(l18Var.b0())) {
                    String str = l18Var.g;
                    Intrinsics.checkNotNullExpressionValue(str, "data.tid");
                    if (a(str)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;
        public String d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return invokeV.longValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.yn
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                BdUniqueId TYPE_RECOMMEND_TOPIC_CARD = kq6.C0;
                Intrinsics.checkNotNullExpressionValue(TYPE_RECOMMEND_TOPIC_CARD, "TYPE_RECOMMEND_TOPIC_CARD");
                return TYPE_RECOMMEND_TOPIC_CARD;
            }
            return (BdUniqueId) invokeV.objValue;
        }

        public final void e(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.c = j;
            }
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.d = str;
            }
        }

        public final void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.b = str;
            }
        }

        public final void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.a = str;
            }
        }
    }

    public l18() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.T0 = new ArrayList();
    }

    public final List<b> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.T0;
        }
        return (List) invokeV.objValue;
    }

    public final String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.S0;
        }
        return (String) invokeV.objValue;
    }

    public final String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kq6, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdUniqueId TYPE_RECOMMEND_TOPIC_CARD = kq6.C0;
            Intrinsics.checkNotNullExpressionValue(TYPE_RECOMMEND_TOPIC_CARD, "TYPE_RECOMMEND_TOPIC_CARD");
            return TYPE_RECOMMEND_TOPIC_CARD;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void e0(ClickBackCard clickBackCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clickBackCard) != null) || clickBackCard == null) {
            return;
        }
        this.S0 = clickBackCard.card_name;
        this.T0.clear();
        List<ClickBackCardItem> list = clickBackCard.card_list;
        if (ListUtils.isNotEmpty(list)) {
            for (ClickBackCardItem clickBackCardItem : list) {
                b bVar = new b();
                bVar.h(clickBackCardItem.text);
                bVar.g(clickBackCardItem.jump_url);
                Long l = clickBackCardItem.business_id;
                Intrinsics.checkNotNullExpressionValue(l, "item.business_id");
                bVar.e(l.longValue());
                bVar.f(clickBackCardItem.business_type);
                this.T0.add(bVar);
            }
        }
    }

    public final void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.g = str;
        }
    }
}
