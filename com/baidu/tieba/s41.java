package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s41 extends q41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    public s41() {
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
        this.b = null;
    }

    @Override // com.baidu.tieba.t41
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                return f();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(str);
            sb.append('=');
            sb.append(str2);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            zk0 d = rk0.d();
            StringBuilder sb = new StringBuilder();
            e(sb, "productId", d.s());
            e(sb, HttpRequest.CLIENT_TYPE, "2");
            e(sb, "_os_type", "2");
            String h = jl0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                e(sb, HttpRequest.OS_VERSION, h);
            }
            e(sb, "_client_version", d.w());
            e(sb, "_sdk_version", "5.12.0.75");
            String e = jl0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                e(sb, "model", e);
            }
            e(sb, "cuid", d.g());
            e(sb, "net_type", String.valueOf(new zt0().c()));
            if (ai0.a) {
                e(sb, "rd", d.x());
                e(sb, "qa", d.y());
                e(sb, "story_id", d.u());
            }
            String sb2 = sb.toString();
            this.b = sb2;
            return !TextUtils.isEmpty(sb2);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q41, com.baidu.tieba.t41
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                f();
            }
            if (this.a.toString().contains(this.b)) {
                return this.a.toString();
            }
            if (this.a.length() > 0) {
                this.a.append('&');
            }
            this.a.append(this.b);
            return this.a.toString();
        }
        return (String) invokeV.objValue;
    }
}
