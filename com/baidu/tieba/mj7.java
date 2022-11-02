package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;

    public mj7() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                return false;
            }
            if (this.d == 2) {
                if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
                    return false;
                }
                return true;
            } else if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("pic");
        this.b = jSONObject.optString("picNight");
        this.c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.d = optInt;
        if (optInt == 2 && (optJSONObject = jSONObject.optJSONObject("extra")) != null) {
            this.e = optJSONObject.optString("title");
            this.f = optJSONObject.optString("content");
            this.g = optJSONObject.optString("imageUrl");
        }
    }
}
