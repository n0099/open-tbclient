package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
@Autowired
/* loaded from: classes5.dex */
public final class l74 {
    public static /* synthetic */ Interceptable $ic;
    public static final l74 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements k74 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.k74
        public void a(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void b(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void c(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void d(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void e(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.tieba.k74
        public void g(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void h(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void i(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        @Override // com.baidu.tieba.k74
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        @Override // com.baidu.tieba.k74
        public void k(JsObject jsObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
                Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            }
        }

        public a() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895776, "Lcom/baidu/tieba/l74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895776, "Lcom/baidu/tieba/l74;");
                return;
            }
        }
        a = new l74();
    }

    public l74() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Inject(force = false)
    public final k74 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (k74) invokeV.objValue;
    }
}
