package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes6.dex */
public class uq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gl9 a;
    public final xl9 b;
    public final HashMap c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Object obj);

        void b(Object obj);
    }

    public uq9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new xl9();
        this.c = new HashMap();
    }

    public final void a(Set set, Set set2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, set, set2, aVar) == null) {
            for (Object obj : set2) {
                if (set == null || !set.contains(obj)) {
                    aVar.b(obj);
                } else {
                    aVar.a(obj);
                }
            }
        }
    }
}
