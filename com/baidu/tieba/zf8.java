package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Cloneable;
/* loaded from: classes9.dex */
public interface zf8<T> extends Cloneable {

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static <T> Object a(zf8<T> zf8Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zf8Var)) == null) {
                return Cloneable.DefaultImpls.clone(zf8Var);
            }
            return invokeL.objValue;
        }
    }
}
