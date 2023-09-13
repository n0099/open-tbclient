package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes9.dex */
public class z19 extends bl1<ju6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements ju6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BdEventBus b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-282503414, "Lcom/baidu/tieba/z19$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-282503414, "Lcom/baidu/tieba/z19$a;");
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = BdEventBus.Companion.getDefault();
        }

        @Override // com.baidu.tieba.ju6
        public <T extends iu6> void a(@NonNull Object obj, @NonNull final ku6<T> ku6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, ku6Var) == null) {
                if (obj instanceof gu6) {
                    y19.a((gu6) obj);
                    this.b.unregister(obj);
                }
                BdEventBus bdEventBus = this.b;
                Class<T> a = ku6Var.a();
                Objects.requireNonNull(ku6Var);
                bdEventBus.register(obj, a, new Action() { // from class: com.baidu.tieba.x19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.searchbox.bdeventbus.Action
                    public final void call(Object obj2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj2) == null) {
                            ku6.this.onEvent((iu6) obj2);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.ju6
        public <T extends iu6> void b(@Nullable T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) && t != null) {
                this.b.post(t);
            }
        }

        @Override // com.baidu.tieba.ju6
        public void unregister(@NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                if (obj instanceof gu6) {
                    y19.d((gu6) obj);
                }
                this.b.unregister(obj);
            }
        }
    }

    public z19() {
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
    @Override // com.baidu.tieba.bl1
    /* renamed from: a */
    public ju6 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (ju6) invokeV.objValue;
    }
}
