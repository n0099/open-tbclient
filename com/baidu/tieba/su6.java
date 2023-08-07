package com.baidu.tieba;

import android.graphics.Canvas;
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
/* loaded from: classes8.dex */
public class su6 implements qu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qu6 a;
    public final Map<Integer, qu6> b;

    public su6(qu6 defaultRenderer, Pair<Integer, ? extends qu6>... renderers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultRenderer, renderers};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultRenderer, "defaultRenderer");
        Intrinsics.checkNotNullParameter(renderers, "renderers");
        this.a = defaultRenderer;
        this.b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(renderers, renderers.length));
    }

    @Override // com.baidu.tieba.qu6
    public cv6 a(us6 item, uu6 displayer, os6 config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            qu6 qu6Var = this.b.get(Integer.valueOf(c(item)));
            if (qu6Var == null) {
                qu6Var = this.a;
            }
            return qu6Var.a(item, displayer, config);
        }
        return (cv6) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qu6
    public void b(us6 item, Canvas canvas, uu6 displayer, os6 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            qu6 qu6Var = this.b.get(Integer.valueOf(c(item)));
            if (qu6Var == null) {
                qu6Var = this.a;
            }
            qu6Var.b(item, canvas, displayer, config);
        }
    }

    public int c(us6 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().g();
        }
        return invokeL.intValue;
    }
}
