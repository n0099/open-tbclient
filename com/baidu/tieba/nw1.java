package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nw1 extends mw1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lm4 f;
    public static long g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948016769, "Lcom/baidu/tieba/nw1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948016769, "Lcom/baidu/tieba/nw1;");
        }
    }

    @Override // com.baidu.tieba.mw1
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mw1, com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "SwanGlobalStorageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            long unused = nw1.g = nw1.f.getContentSize();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (nw1.class) {
            if (f == null) {
                b0();
            }
        }
    }

    @Override // com.baidu.tieba.mw1
    public ly1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#getStorage", false);
            return super.E(str);
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public lm4 G(@NonNull k63 k63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k63Var)) == null) {
            return f;
        }
        return (lm4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#getStorageSync", false);
            return super.L(str);
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            r("#removeStorage", false);
            return super.S(str);
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            r("#removeStorageSync", false);
            return super.U(str);
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            r("#setStorage", false);
            return super.V(str);
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            r("#setStorageSync", false);
            return super.X(str);
        }
        return (ly1) invokeL.objValue;
    }

    public static void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && f != null) {
            ej3.f().execute(new a());
        }
    }

    @Override // com.baidu.tieba.mw1
    public ly1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r("#clearStorage", false);
            return super.B();
        }
        return (ly1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#clearStorageSync", false);
            return super.D();
        }
        return (ly1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public ly1 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r("#getStorageInfoSync", false);
            return H();
        }
        return (ly1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c0();
        }
    }

    public static synchronized void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (nw1.class) {
                if (f == null) {
                    try {
                        f = new bf3("swan_js_global_storage", 2, gp2.g().getAbsolutePath());
                    } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                        f = new tm4("swan_js_global_storage");
                        cf3.i(1, "swan_js_global_storage");
                    }
                    c0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.mw1
    public ly1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            r("#getStorageInfo", false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) f.a()));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, g / 1024);
                jSONObject.put("limitSize", 10240);
                return new ly1(0, jSONObject);
            } catch (JSONException unused) {
                return new ly1(202, "JSONException");
            }
        }
        return (ly1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw1
    public boolean O(@Nullable k63 k63Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k63Var, str, str2)) == null) {
            if ((g - f.getString(str, "").length()) + str2.length() > Config.FULL_TRACE_LOG_LIMIT) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
