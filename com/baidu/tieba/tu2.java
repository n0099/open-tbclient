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
/* loaded from: classes6.dex */
public class tu2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/tu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/tu2;");
                return;
            }
        }
        v = do1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public tu2() {
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

    public static tu2 b(JSONObject jSONObject, tu2 tu2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, tu2Var)) == null) {
            tu2 tu2Var2 = new tu2();
            if (jSONObject != null) {
                tu2Var2.a = jSONObject.optString("audioId", tu2Var.a);
                tu2Var2.b = jSONObject.optString("slaveId", tu2Var.b);
                tu2Var2.c = jSONObject.optString("src", tu2Var.c);
                if (t73.M() != null && bf3.E(tu2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                tu2Var2.q = z;
                tu2Var2.d = jSONObject.optString("title", tu2Var.d);
                tu2Var2.e = jSONObject.optString("epname", tu2Var.e);
                tu2Var2.f = jSONObject.optString("singer", tu2Var.f);
                tu2Var2.g = jSONObject.optString("coverImgUrl", tu2Var.g);
                tu2Var2.h = jSONObject.optString("lrcURL", tu2Var.h);
                tu2Var2.i = jSONObject.optBoolean("showFloatView", tu2Var.i);
                tu2Var2.j = jSONObject.optString("floatPosition", tu2Var.j);
                tu2Var2.k = jSONObject.optInt("startTime", tu2Var.k);
                tu2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, tu2Var.l);
                tu2Var2.p = jSONObject.optString("cb", tu2Var.p);
                tu2Var2.m = jSONObject.optString("param", tu2Var.m);
                tu2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = ne2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    tu2Var2.s = g0;
                }
                String b = al3.b();
                if (!TextUtils.isEmpty(b) && al3.c(tu2Var2.c)) {
                    tu2Var2.t = b;
                }
                String j = pg3.l().j(tu2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    tu2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return tu2Var2;
        }
        return (tu2) invokeLL.objValue;
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
                jSONObject.putOpt("appid", t73.g0());
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
