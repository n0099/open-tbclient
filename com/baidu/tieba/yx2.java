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
/* loaded from: classes8.dex */
public class yx2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948345462, "Lcom/baidu/tieba/yx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948345462, "Lcom/baidu/tieba/yx2;");
                return;
            }
        }
        v = ir1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public yx2() {
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

    public static yx2 b(JSONObject jSONObject, yx2 yx2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, yx2Var)) == null) {
            yx2 yx2Var2 = new yx2();
            if (jSONObject != null) {
                yx2Var2.a = jSONObject.optString("audioId", yx2Var.a);
                yx2Var2.b = jSONObject.optString("slaveId", yx2Var.b);
                yx2Var2.c = jSONObject.optString("src", yx2Var.c);
                if (ya3.M() != null && gi3.E(yx2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                yx2Var2.q = z;
                yx2Var2.d = jSONObject.optString("title", yx2Var.d);
                yx2Var2.e = jSONObject.optString("epname", yx2Var.e);
                yx2Var2.f = jSONObject.optString("singer", yx2Var.f);
                yx2Var2.g = jSONObject.optString("coverImgUrl", yx2Var.g);
                yx2Var2.h = jSONObject.optString("lrcURL", yx2Var.h);
                yx2Var2.i = jSONObject.optBoolean("showFloatView", yx2Var.i);
                yx2Var2.j = jSONObject.optString("floatPosition", yx2Var.j);
                yx2Var2.k = jSONObject.optInt("startTime", yx2Var.k);
                yx2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, yx2Var.l);
                yx2Var2.p = jSONObject.optString("cb", yx2Var.p);
                yx2Var2.m = jSONObject.optString("param", yx2Var.m);
                yx2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = sh2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    yx2Var2.s = g0;
                }
                String b = fo3.b();
                if (!TextUtils.isEmpty(b) && fo3.c(yx2Var2.c)) {
                    yx2Var2.t = b;
                }
                String j = uj3.l().j(yx2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    yx2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return yx2Var2;
        }
        return (yx2) invokeLL.objValue;
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
                jSONObject.putOpt("appid", ya3.g0());
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
