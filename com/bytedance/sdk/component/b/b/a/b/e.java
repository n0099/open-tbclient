package com.bytedance.sdk.component.b.b.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class e extends RuntimeException {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Method f28089a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public IOException f28090b;

    static {
        Method method;
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952359152, "Lcom/bytedance/sdk/component/b/b/a/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952359152, "Lcom/bytedance/sdk/component/b/b/a/b/e;");
                return;
            }
        }
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f28089a = method;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(IOException iOException) {
        super(iOException);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iOException};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28090b = iOException;
    }

    public IOException a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28090b : (IOException) invokeV.objValue;
    }

    public void a(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
            a(iOException, this.f28090b);
            this.f28090b = iOException;
        }
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, iOException, iOException2) == null) || (method = f28089a) == null) {
            return;
        }
        try {
            method.invoke(iOException, iOException2);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
