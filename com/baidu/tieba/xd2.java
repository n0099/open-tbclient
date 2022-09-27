package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.tieba.af2;
import com.baidu.tieba.xe2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class xd2<P extends xe2, R extends af2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public P a;
    @NonNull
    public R b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948296451, "Lcom/baidu/tieba/xd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948296451, "Lcom/baidu/tieba/xd2;");
                return;
            }
        }
        c = vj1.a;
    }

    public xd2(@NonNull P p, @NonNull R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p, r};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = p;
        this.b = r;
    }

    public <T extends re2> Exception a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
            }
            return this.b.e(t);
        }
        return (Exception) invokeL.objValue;
    }

    public abstract String b(int i);

    @Nullable
    public abstract ExtensionCore c();

    @NonNull
    public ExtensionCore d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int c2 = this.a.a.c();
            if (cf2.f(c2)) {
                ExtensionCore extensionCore = new ExtensionCore();
                extensionCore.extensionCoreVersionCode = 0L;
                extensionCore.extensionCoreVersionName = "0";
                extensionCore.extensionCorePath = b(c2);
                extensionCore.extensionCoreType = 2;
                if (c) {
                    Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
                }
                return extensionCore;
            }
            ExtensionCore h = this.a.h();
            ExtensionCore f = this.b.f();
            if (h.extensionCoreVersionCode < f.extensionCoreVersionCode && f.isAvailable()) {
                if (c) {
                    Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + f.toString());
                }
                return f;
            }
            if (c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + h.toString());
            }
            return h;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @NonNull
    public P e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (P) invokeV.objValue;
    }

    @NonNull
    public R f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (R) invokeV.objValue;
    }

    public void g(@Nullable ei3<Exception> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ei3Var) == null) {
            this.a.p(ei3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.q();
        }
    }
}
