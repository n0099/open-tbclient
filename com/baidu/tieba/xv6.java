package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xv6 implements Comparator<h0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xv6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(h0 entity1, h0 entity2) {
        InterceptResult invokeLL;
        ov6 a;
        aw6 b;
        ov6 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entity1, entity2)) == null) {
            Intrinsics.checkNotNullParameter(entity1, "entity1");
            Intrinsics.checkNotNullParameter(entity2, "entity2");
            aw6 b2 = yw6.b(entity2);
            if (b2 == null || (a = b2.a()) == null || (b = yw6.b(entity1)) == null || (a2 = b.a()) == null) {
                return 0;
            }
            return a2.compareTo(a);
        }
        return invokeLL.intValue;
    }
}
