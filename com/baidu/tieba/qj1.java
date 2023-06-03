package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<a> b;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public String c;
        public String d;
        public String e;
        public String f;
        public Long g;
        public int h;
        public String i;

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

        public a(JSONObject jSONObject) {
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
            if (jSONObject == null) {
                return;
            }
            this.c = jSONObject.optString("display_name");
            this.d = jSONObject.optString("pay_text");
            this.f = jSONObject.optString("icon");
            this.e = jSONObject.optString("valid_info");
            this.i = jSONObject.optString("host_marketing_detail");
            this.g = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.h = jSONObject.optInt("is_selected");
            this.b = jSONObject.optInt("style");
            this.a = jSONObject.optInt("type");
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("display_name", this.c);
                    jSONObject.put("pay_text", this.d);
                    jSONObject.put("icon", this.f);
                    jSONObject.put("valid_info", this.e);
                    jSONObject.put("host_marketing_detail", this.i);
                    jSONObject.put("available_par_money", this.g);
                    jSONObject.put("is_selected", this.h);
                    jSONObject.put("style", this.b);
                    jSONObject.put("type", this.a);
                } catch (JSONException e) {
                    if (xi1.d) {
                        e.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "CouponItem{type=" + this.a + ", style=" + this.b + ", displayName='" + this.c + "', payText='" + this.d + "', validInfo='" + this.e + "', icon='" + this.f + "', cutMoney=" + this.g + ", isSelected=" + this.h + ", hostMarketingDetail='" + this.i + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    public qj1(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONArray == null) {
            return;
        }
        this.b = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i3);
            if (jSONObject != null) {
                this.b.add(new a(jSONObject));
            }
        }
        this.a = this.b.size() > 1;
    }
}
