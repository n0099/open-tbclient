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
public class qo6 implements mo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mo6 a;
    public final Map<Integer, mo6> b;

    public qo6(mo6 defaultLayouter, Pair<Integer, ? extends mo6>... layouter) {
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

    @Override // com.baidu.tieba.mo6
    public void a(ym6 item, long j, yo6 displayer, sm6 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            f(item).a(item, j, displayer, config);
        }
    }

    @Override // com.baidu.tieba.mo6
    public boolean d(ym6 item, long j, yo6 displayer, sm6 config) {
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

    @Override // com.baidu.tieba.mo6
    public void b(ym6 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            f(item).b(item);
        }
    }

    public int e(ym6 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().j();
        }
        return invokeL.intValue;
    }

    public final mo6 f(ym6 ym6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ym6Var)) == null) {
            mo6 mo6Var = this.b.get(Integer.valueOf(e(ym6Var)));
            if (mo6Var == null) {
                return this.a;
            }
            return mo6Var;
        }
        return (mo6) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mo6
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c(i, i2);
            for (mo6 mo6Var : this.b.values()) {
                mo6Var.c(i, i2);
            }
        }
    }

    @Override // com.baidu.tieba.mo6
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
            for (mo6 mo6Var : this.b.values()) {
                mo6Var.clear();
            }
        }
    }
}
