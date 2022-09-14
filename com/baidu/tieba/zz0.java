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
/* loaded from: classes6.dex */
public class zz0 extends xz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    public zz0() {
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
            ui0 d = mi0.d();
            StringBuilder sb = new StringBuilder();
            e(sb, "productId", d.q());
            e(sb, HttpRequest.CLIENT_TYPE, "2");
            e(sb, "_os_type", "2");
            String h = cj0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                e(sb, "_os_version", h);
            }
            e(sb, "_client_version", d.u());
            e(sb, "_sdk_version", "5.8.0.17");
            String e = cj0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                e(sb, "model", e);
            }
            e(sb, "cuid", d.g());
            e(sb, "net_type", String.valueOf(new up0().c()));
            if (ag0.a) {
                e(sb, "rd", d.v());
                e(sb, "qa", d.w());
                e(sb, "story_id", d.s());
            }
            String sb2 = sb.toString();
            this.b = sb2;
            return !TextUtils.isEmpty(sb2);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a01
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

    @Override // com.baidu.tieba.xz0, com.baidu.tieba.a01
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
