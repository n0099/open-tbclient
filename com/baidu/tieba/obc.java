package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class obc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes7.dex */
    public static class a<R> implements nbc<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mbc a;

        public a(mbc mbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mbcVar;
        }

        @Override // com.baidu.tieba.nbc
        public R call(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (objArr.length == 2) {
                    return (R) this.a.call(objArr[0], objArr[1]);
                }
                throw new IllegalArgumentException("Func2 expecting 2 arguments.");
            }
            return (R) invokeL.objValue;
        }
    }

    public static <T0, T1, R> nbc<R> a(mbc<? super T0, ? super T1, ? extends R> mbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mbcVar)) == null) {
            return new a(mbcVar);
        }
        return (nbc) invokeL.objValue;
    }
}
