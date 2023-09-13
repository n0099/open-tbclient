package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes8.dex */
public class ut0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URL a;
    public String b;
    public Headers.a c;
    @Nullable
    public tt0 d;
    public Object e;
    @NonNull
    public final zs0 f;
    public boolean g;
    public boolean h;

    public ut0() {
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
        this.g = true;
        this.h = false;
        this.b = "GET";
        this.c = new Headers.a();
        new Headers.a();
        this.f = new zs0();
    }

    public ut0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.c.a(str, str2);
            return this;
        }
        return (ut0) invokeLL.objValue;
    }

    public ut0 d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            this.c.e(str, str2);
            return this;
        }
        return (ut0) invokeLL.objValue;
    }

    public ut0 e(String str, @Nullable tt0 tt0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, tt0Var)) == null) {
            this.b = str;
            this.d = tt0Var;
            return this;
        }
        return (ut0) invokeLL.objValue;
    }

    public RequestError b() {
        InterceptResult invokeV;
        RequestError requestError;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == null) {
                requestError = new RequestError("url is null");
            } else {
                requestError = null;
            }
            if (this.d != null && !qt0.a(this.b)) {
                requestError = new RequestError("method " + this.b + " must not have a request body.");
            }
            if (this.d == null && qt0.b(this.b)) {
                return new RequestError("method " + this.b + " must have a request body.");
            }
            return requestError;
        }
        return (RequestError) invokeV.objValue;
    }

    public ut0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e("GET", null);
            return this;
        }
        return (ut0) invokeV.objValue;
    }

    public ut0 delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return delete(tt0.h);
        }
        return (ut0) invokeV.objValue;
    }

    public ut0 delete(@Nullable tt0 tt0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tt0Var)) == null) {
            e(HttpDelete.METHOD_NAME, tt0Var);
            return this;
        }
        return (ut0) invokeL.objValue;
    }

    public ut0 f(tt0 tt0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tt0Var)) == null) {
            e("POST", tt0Var);
            return this;
        }
        return (ut0) invokeL.objValue;
    }

    public ut0 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.f.a(i);
            return this;
        }
        return (ut0) invokeI.objValue;
    }

    public ut0 h(pt0 pt0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, pt0Var)) == null) {
            this.f.b(pt0Var);
            return this;
        }
        return (ut0) invokeL.objValue;
    }

    public ut0 i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.g = z;
            return this;
        }
        return (ut0) invokeZ.objValue;
    }

    public ut0 j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.f.c(i);
            return this;
        }
        return (ut0) invokeI.objValue;
    }

    public ut0 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.f.d(i);
            return this;
        }
        return (ut0) invokeI.objValue;
    }

    public ut0 m(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, url)) == null) {
            this.a = url;
            return this;
        }
        return (ut0) invokeL.objValue;
    }

    public ut0 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.a = null;
                return this;
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            try {
                m(new URL(str));
                return this;
            } catch (MalformedURLException | Exception unused) {
                m(null);
                return this;
            }
        }
        return (ut0) invokeL.objValue;
    }
}
