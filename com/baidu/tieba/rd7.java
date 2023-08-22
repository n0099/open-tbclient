package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.feed.widget.uistate.ForumAttentionUiStateKt;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class rd7 extends hb7 implements ja7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w77 c;
    public final String d;
    public final long e;
    public final Function2<rd7, TbPageContext<?>, Unit> f;

    @JvmOverloads
    public rd7(w77 forumAttentionData, String tid, long j, Function2<? super rd7, ? super TbPageContext<?>, Unit> onAttentionClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumAttentionData, tid, Long.valueOf(j), onAttentionClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(forumAttentionData, "forumAttentionData");
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(onAttentionClick, "onAttentionClick");
        this.c = forumAttentionData;
        this.d = tid;
        this.e = j;
        this.f = onAttentionClick;
    }

    public /* synthetic */ rd7(w77 w77Var, String str, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(w77Var, str, j, (i & 8) != 0 ? ForumAttentionUiStateKt.a : function2);
    }

    @Override // com.baidu.tieba.ja7
    public void d(Object event) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof AttentionBarData) {
                AttentionBarData attentionBarData = (AttentionBarData) event;
                if (attentionBarData.forumId == this.e) {
                    this.c.d(attentionBarData.isLike);
                    b();
                    x77 a = v77.a.a("tb.feed_home_reco_user_state");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (attentionBarData.isLike) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    linkedHashMap.put("is_like", str);
                    if (a != null) {
                        a.a(String.valueOf(this.e), linkedHashMap);
                    }
                }
            }
        }
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public final w77 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (w77) invokeV.objValue;
    }

    public final Function2<rd7, TbPageContext<?>, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }
}
