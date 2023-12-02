package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class kt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public String u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924544, "Lcom/baidu/tieba/kt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924544, "Lcom/baidu/tieba/kt2;");
                return;
            }
        }
        v = vm1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public kt2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = "";
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.q = false;
    }

    public static kt2 b(JSONObject jSONObject, kt2 kt2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, kt2Var)) == null) {
            kt2 kt2Var2 = new kt2();
            if (jSONObject != null) {
                kt2Var2.a = jSONObject.optString("audioId", kt2Var.a);
                kt2Var2.b = jSONObject.optString("slaveId", kt2Var.b);
                kt2Var2.c = jSONObject.optString("src", kt2Var.c);
                if (k63.M() != null && sd3.E(kt2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                kt2Var2.q = z;
                kt2Var2.d = jSONObject.optString("title", kt2Var.d);
                kt2Var2.e = jSONObject.optString("epname", kt2Var.e);
                kt2Var2.f = jSONObject.optString("singer", kt2Var.f);
                kt2Var2.g = jSONObject.optString("coverImgUrl", kt2Var.g);
                kt2Var2.h = jSONObject.optString("lrcURL", kt2Var.h);
                kt2Var2.i = jSONObject.optBoolean("showFloatView", kt2Var.i);
                kt2Var2.j = jSONObject.optString("floatPosition", kt2Var.j);
                kt2Var2.k = jSONObject.optInt("startTime", kt2Var.k);
                kt2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, kt2Var.l);
                kt2Var2.p = jSONObject.optString("cb", kt2Var.p);
                kt2Var2.m = jSONObject.optString("param", kt2Var.m);
                kt2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String h0 = ed2.V().h0();
                if (!TextUtils.isEmpty(h0)) {
                    kt2Var2.s = h0;
                }
                String b = rj3.b();
                if (!TextUtils.isEmpty(b) && rj3.c(kt2Var2.c)) {
                    kt2Var2.t = b;
                }
                String j = gf3.l().j(kt2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    kt2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return kt2Var2;
        }
        return (kt2) invokeLL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("src", str);
                jSONObject.putOpt("title", this.d);
                jSONObject.putOpt("epname", this.e);
                jSONObject.putOpt("singer", this.f);
                jSONObject.putOpt("coverImgUrl", this.g);
                jSONObject.putOpt("lrcURL", this.h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", k63.h0());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt("refer", this.t);
                jSONObject.putOpt("Cookie", this.u);
            } catch (JSONException e) {
                if (v) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "AudioBGPlayerParams{ playerId=" + this.a + " slaveId=" + this.b + " url=" + this.c + " startTime=" + this.k + " pos=" + this.l + " canPlay=" + this.r + " }";
        }
        return (String) invokeV.objValue;
    }
}
