package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public JSONObject g;
    public String h;
    public h32 i;

    public r63() {
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

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h32 h32Var = this.i;
            if (h32Var != null && !h32Var.isSuccess()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.e)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SwanPluginFunPageModel{providerAppKey='");
            sb.append(this.a);
            sb.append('\'');
            sb.append(", providerRootPath='");
            sb.append(this.c);
            sb.append('\'');
            sb.append(", providerVersion='");
            sb.append(this.d);
            sb.append('\'');
            sb.append(", componentId='");
            sb.append(this.f);
            sb.append('\'');
            sb.append(", cb='");
            sb.append(this.h);
            sb.append('\'');
            sb.append(", pageParams=");
            sb.append(this.g);
            sb.append(", swanApiResult=");
            h32 h32Var = this.i;
            if (h32Var == null) {
                a = null;
            } else {
                a = h32Var.a();
            }
            sb.append(a);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
