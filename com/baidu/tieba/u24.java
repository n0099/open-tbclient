package com.baidu.tieba;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public u24() {
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
        this.a = "swan";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        if (zb3.b0() == null) {
            return;
        }
        ww2.a W = zb3.b0().W();
        this.a = si3.n(W.G());
        this.c = W.H();
        this.b = W.T();
        this.f = W.s0().getString("aiapp_extra_need_download", "");
        this.g = W.W();
        this.h = W.e0();
        this.i = W.V();
        this.d = W.v1();
        this.e = W.w1();
    }

    public u24(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "swan";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.a = jSONObject.optString("from", "swan");
            this.c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.b = jSONObject.optString("source");
            this.f = jSONObject.optString("needDown");
            this.g = jSONObject.optString("scheme");
            this.h = jSONObject.optString("extPage");
            this.i = jSONObject.optString("launchId", null);
            this.d = jSONObject.optString("appVersion");
            this.e = jSONObject.optString("thirdVersion");
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.c);
                jSONObject.put("source", this.b);
                jSONObject.put("needDown", this.f);
                jSONObject.put("scheme", this.g);
                jSONObject.put("extPage", this.h);
                jSONObject.put("launchId", this.i);
                jSONObject.put("appVersion", this.d);
                jSONObject.put("thirdVersion", this.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
