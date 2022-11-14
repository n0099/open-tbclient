package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;
    public JSONObject e;
    public long f;
    public int g;
    public String h;
    public String i;
    public boolean j;
    public String k;

    public pj4(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.a = str;
        this.b = str;
        this.c = -1;
        this.d = str2;
        this.g = i;
        if ((i & 2) == 0) {
            this.f = System.currentTimeMillis();
        }
        try {
            this.e = new JSONObject(this.d);
        } catch (JSONException unused) {
        }
    }

    public pj4(String str, String str2, int i, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.a = str2;
        this.b = str;
        this.c = i;
        this.d = str3;
        this.g = i2;
        if ((i2 & 2) == 0) {
            this.f = System.currentTimeMillis();
        }
        try {
            this.e = new JSONObject(this.d);
        } catch (JSONException unused) {
        }
    }

    public pj4(String str, String str2, int i, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.a = str2;
        this.b = str;
        this.c = i;
        this.d = str3;
        this.g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f = j;
            } else {
                this.f = System.currentTimeMillis();
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            try {
                this.e = new JSONObject(this.d);
            } catch (JSONException unused) {
            }
        }
    }

    public pj4(String str, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.a = str;
        this.b = str;
        this.c = -1;
        this.e = jSONObject;
        this.g = i;
        if ((i & 2) == 0) {
            this.f = System.currentTimeMillis();
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.e;
            if (jSONObject != null) {
                return jSONObject.optString("bizId");
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (str = this.a) != null && str.equals(this.b) && kj4.g().a(this.a)) {
            this.h = lj4.g().h();
        }
    }
}
