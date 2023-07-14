package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.SocialUiStateKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class x77 extends m77 implements mb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s97 d;
    public final List<u97> e;
    public final Function1<s97, Unit> f;
    public final Function3<Context, s97, List<u97>, Unit> g;
    public final Function1<s97, Unit> h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948253361, "Lcom/baidu/tieba/x77;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948253361, "Lcom/baidu/tieba/x77;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public x77(s97 data, List<u97> statDataList, Function1<? super s97, Unit> onShareClick, Function3<? super Context, ? super s97, ? super List<u97>, Unit> onCommentClick, Function1<? super s97, Unit> onPraiseClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, statDataList, onShareClick, onCommentClick, onPraiseClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Function2) objArr2[0], (Function1) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(statDataList, "statDataList");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Intrinsics.checkNotNullParameter(onCommentClick, "onCommentClick");
        Intrinsics.checkNotNullParameter(onPraiseClick, "onPraiseClick");
        this.d = data;
        this.e = statDataList;
        this.f = onShareClick;
        this.g = onCommentClick;
        this.h = onPraiseClick;
    }

    public /* synthetic */ x77(s97 s97Var, List list, Function1 function1, Function3 function3, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(s97Var, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? SocialUiStateKt.a : function1, (i & 8) != 0 ? SocialUiStateKt.b : function3, (i & 16) != 0 ? SocialUiStateKt.c : function12);
    }

    @Override // com.baidu.tieba.mb7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.d.d(event);
        }
    }

    public final s97 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (s97) invokeV.objValue;
    }

    public final Function3<Context, s97, List<u97>, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (Function3) invokeV.objValue;
    }

    public final Function1<s97, Unit> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (Function1) invokeV.objValue;
    }

    public final Function1<s97, Unit> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Function1) invokeV.objValue;
    }

    public final List<u97> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }
}
