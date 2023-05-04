package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class xu2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948312788, "Lcom/baidu/tieba/xu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948312788, "Lcom/baidu/tieba/xu2;");
                return;
            }
        }
        v = ho1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public xu2() {
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

    public static xu2 b(JSONObject jSONObject, xu2 xu2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, xu2Var)) == null) {
            xu2 xu2Var2 = new xu2();
            if (jSONObject != null) {
                xu2Var2.a = jSONObject.optString("audioId", xu2Var.a);
                xu2Var2.b = jSONObject.optString("slaveId", xu2Var.b);
                xu2Var2.c = jSONObject.optString("src", xu2Var.c);
                if (x73.M() != null && ff3.E(xu2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                xu2Var2.q = z;
                xu2Var2.d = jSONObject.optString("title", xu2Var.d);
                xu2Var2.e = jSONObject.optString("epname", xu2Var.e);
                xu2Var2.f = jSONObject.optString("singer", xu2Var.f);
                xu2Var2.g = jSONObject.optString("coverImgUrl", xu2Var.g);
                xu2Var2.h = jSONObject.optString("lrcURL", xu2Var.h);
                xu2Var2.i = jSONObject.optBoolean("showFloatView", xu2Var.i);
                xu2Var2.j = jSONObject.optString("floatPosition", xu2Var.j);
                xu2Var2.k = jSONObject.optInt("startTime", xu2Var.k);
                xu2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, xu2Var.l);
                xu2Var2.p = jSONObject.optString("cb", xu2Var.p);
                xu2Var2.m = jSONObject.optString("param", xu2Var.m);
                xu2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = re2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    xu2Var2.s = g0;
                }
                String b = el3.b();
                if (!TextUtils.isEmpty(b) && el3.c(xu2Var2.c)) {
                    xu2Var2.t = b;
                }
                String j = tg3.l().j(xu2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    xu2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return xu2Var2;
        }
        return (xu2) invokeLL.objValue;
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
                jSONObject.putOpt("appid", x73.g0());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt(TiebaStatic.Params.REFER, this.t);
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
