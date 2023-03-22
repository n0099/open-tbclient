package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.tieba.e60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class r60 implements CallFactory.CallFactoryProducer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e60 a;

    /* loaded from: classes6.dex */
    public class a implements CallFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e60 a;
        public final /* synthetic */ r60 b;

        public a(r60 r60Var, e60 e60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r60Var, e60Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r60Var;
            this.a = e60Var;
        }

        @Override // com.baidu.searchbox.network.outback.core.CallFactory
        public Call newCall(Request request, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, request, z)) == null) {
                if (!this.b.isAvailable() && z) {
                    return null;
                }
                return new d60(request, this.a, false);
            }
            return (Call) invokeLZ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<T extends b, R extends r60> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e60.a a;

        public abstract R b(e60 e60Var);

        public b() {
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
            this.a = new e60.a();
        }

        public final R a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b(this.a.b());
            }
            return (R) invokeV.objValue;
        }
    }

    public r60(e60 e60Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e60Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = e60Var;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public CallFactory produceCallFactory(CallFactoryParams callFactoryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callFactoryParams)) == null) {
            e60.a x = this.a.x();
            a(x, callFactoryParams);
            return new a(this, x.b());
        }
        return (CallFactory) invokeL.objValue;
    }

    public final void a(e60.a aVar, CallFactoryParams callFactoryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, callFactoryParams) == null) {
            aVar.c(new y50(this.a.p().c()));
        }
    }
}
