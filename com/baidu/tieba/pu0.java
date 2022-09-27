package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public interface pu0 {

    @Autowired
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @NonNull
        @Inject(force = false)
        public static pu0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? hv0.a() : (pu0) invokeV.objValue;
        }
    }

    void a(ix0 ix0Var);

    void b(ix0 ix0Var);
}
