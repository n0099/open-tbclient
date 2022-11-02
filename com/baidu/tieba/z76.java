package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public class z76 implements v76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final v76 a;
    public final Map<Integer, v76> b;

    public z76(v76 defaultLayouter, Pair<Integer, ? extends v76>... layouter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultLayouter, layouter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultLayouter, "defaultLayouter");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        this.a = defaultLayouter;
        this.b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(layouter, layouter.length));
    }

    @Override // com.baidu.tieba.v76
    public void a(h66 item, long j, h86 displayer, b66 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            f(item).a(item, j, displayer, config);
        }
    }

    @Override // com.baidu.tieba.v76
    public boolean d(h66 item, long j, h86 displayer, b66 config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{item, Long.valueOf(j), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            return f(item).d(item, j, displayer, config);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.v76
    public void b(h66 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            f(item).b(item);
        }
    }

    public int e(h66 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().j();
        }
        return invokeL.intValue;
    }

    public final v76 f(h66 h66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h66Var)) == null) {
            v76 v76Var = this.b.get(Integer.valueOf(e(h66Var)));
            if (v76Var == null) {
                return this.a;
            }
            return v76Var;
        }
        return (v76) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v76
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c(i, i2);
            for (v76 v76Var : this.b.values()) {
                v76Var.c(i, i2);
            }
        }
    }

    @Override // com.baidu.tieba.v76
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
            for (v76 v76Var : this.b.values()) {
                v76Var.clear();
            }
        }
    }
}
