package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
/* loaded from: classes5.dex */
public class jr2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892831, "Lcom/baidu/tieba/jr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892831, "Lcom/baidu/tieba/jr2;");
                return;
            }
        }
        v = tk1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public jr2() {
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

    public static jr2 b(JSONObject jSONObject, jr2 jr2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, jr2Var)) == null) {
            jr2 jr2Var2 = new jr2();
            if (jSONObject != null) {
                jr2Var2.a = jSONObject.optString("audioId", jr2Var.a);
                jr2Var2.b = jSONObject.optString("slaveId", jr2Var.b);
                jr2Var2.c = jSONObject.optString("src", jr2Var.c);
                if (j43.M() != null && rb3.E(jr2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                jr2Var2.q = z;
                jr2Var2.d = jSONObject.optString("title", jr2Var.d);
                jr2Var2.e = jSONObject.optString("epname", jr2Var.e);
                jr2Var2.f = jSONObject.optString("singer", jr2Var.f);
                jr2Var2.g = jSONObject.optString("coverImgUrl", jr2Var.g);
                jr2Var2.h = jSONObject.optString("lrcURL", jr2Var.h);
                jr2Var2.i = jSONObject.optBoolean("showFloatView", jr2Var.i);
                jr2Var2.j = jSONObject.optString("floatPosition", jr2Var.j);
                jr2Var2.k = jSONObject.optInt(FetchLog.START_TIME, jr2Var.k);
                jr2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, jr2Var.l);
                jr2Var2.p = jSONObject.optString("cb", jr2Var.p);
                jr2Var2.m = jSONObject.optString(Constants.EXTRA_PARAM, jr2Var.m);
                jr2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = db2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    jr2Var2.s = g0;
                }
                String b = qh3.b();
                if (!TextUtils.isEmpty(b) && qh3.c(jr2Var2.c)) {
                    jr2Var2.t = b;
                }
                String j = fd3.l().j(jr2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    jr2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return jr2Var2;
        }
        return (jr2) invokeLL.objValue;
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
                jSONObject.putOpt("appid", j43.g0());
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
