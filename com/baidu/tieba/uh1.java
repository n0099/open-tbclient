package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public String c;
    public String d;
    public JSONObject e;

    public uh1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new JSONObject();
        this.a = str;
        this.b = System.currentTimeMillis();
        this.c = ii1.c();
    }

    public uh1 a(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            try {
                this.e.put(str, obj);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (uh1) invokeLL.objValue;
    }

    public uh1 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.d = str;
            return this;
        }
        return (uh1) invokeL.objValue;
    }

    public uh1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            this.e = jSONObject;
            return this;
        }
        return (uh1) invokeL.objValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                gi1.d("statistics action can not null");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("a", this.a);
                jSONObject.put("t", this.b);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.c);
                if (this.e != null) {
                    jSONObject.put("cn", this.e);
                } else if (!TextUtils.isEmpty(this.d)) {
                    try {
                        jSONObject.put("cn", new JSONObject(this.d));
                    } catch (JSONException unused) {
                        jSONObject.put("cn", this.d);
                    }
                }
            } catch (JSONException e) {
                if (gi1.d) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
