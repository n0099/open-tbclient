package com.baidu.tieba;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k04 extends j04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int q;
    public int r;
    public int s;
    public String t;

    @Override // com.baidu.tieba.j04
    public HashMap<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j04
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j04
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://powerful.xdplt.com/api/v1/front/ltc" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k04(Context context, h04 h04Var, int i, int i2) {
        super(context, h04Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, h04Var, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (h04) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 1;
        this.r = 1;
        this.s = 1;
        this.r = i;
        this.s = i2;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                String a = lw3.b.a(this.b);
                if (TextUtils.isEmpty(a)) {
                    return UUID.randomUUID().toString();
                }
                return a;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", this.i.e());
                jSONObject2.put("name", yz3.b().a());
                jSONObject2.put(StateManager.KEY_STATE, z04.k());
                jSONObject2.put("version", z04.l());
                jSONObject.put("app", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ua", l());
                jSONObject3.put("imei", yz3.b().m());
                jSONObject3.put(HttpRequest.ANDROID_ID, h());
                jSONObject3.put("ip", j(true));
                jSONObject3.put("type", 1);
                jSONObject3.put(TtsLogLoad.KEY_OS, 1);
                jSONObject3.put(HttpConstants.OS_VERSION, z04.f());
                jSONObject3.put("make", z04.g());
                jSONObject3.put("model", z04.e());
                jSONObject3.put("language", this.b.getResources().getConfiguration().locale.getLanguage());
                jSONObject3.put("connection_type", NetworkUtils.c(true));
                jSONObject3.put("carrier", k(this.b));
                jSONObject3.put("mac", NetworkUtils.e(this.b));
                jSONObject3.put("screen_width", z04.i(this.b));
                jSONObject3.put("screen_height", z04.h(this.b));
                jSONObject3.put("screen_orientation", this.b.getResources().getConfiguration().orientation);
                jSONObject.put(Config.DEVICE_PART, jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("sid", this.i.b());
                jSONObject4.put("ad_count", this.q);
                jSONObject4.put(TiebaStatic.Params.AD_TYPE, this.r);
                jSONObject4.put("pos", this.s);
                jSONObject4.put("width", this.i.d());
                jSONObject4.put("height", this.i.a());
                jSONObject4.put(ClientCookie.SECURE_ATTR, 1);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject4);
                jSONObject.put("imps", jSONArray);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        r0 = r3.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            String str = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                loop0: while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!z || !(nextElement instanceof Inet6Address)) {
                            if (!nextElement.isLoopbackAddress()) {
                                break loop0;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeZ.objValue;
    }

    public int k(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String simOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                return 0;
            }
            if (!"46000".equals(simOperator) && !"46002".equals(simOperator) && !"46007".equals(simOperator)) {
                if ("46001".equals(simOperator)) {
                    return 2;
                }
                if (!"46003".equals(simOperator)) {
                    return 0;
                }
                return 3;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TextUtils.isEmpty(this.t)) {
                try {
                    try {
                        this.t = WebSettings.getDefaultUserAgent(this.b);
                    } catch (Exception unused) {
                        this.t = "";
                    }
                } catch (Exception unused2) {
                    this.t = System.getProperty("http.agent");
                }
            }
            return this.t;
        }
        return (String) invokeV.objValue;
    }
}
