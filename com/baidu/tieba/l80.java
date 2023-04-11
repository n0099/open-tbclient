package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l80 extends k80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public int c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, int i);

        void b(int i, String str, int i2);
    }

    @Override // com.baidu.tieba.m80.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m80.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public l80(Context context, a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = aVar;
        this.c = i;
    }

    @Override // com.baidu.tieba.m80.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int a2 = q80.a(this.a);
            if (a2 == 1) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else if (a2 == 2) {
                return "http://sz-shaheenv-al-b.bcc-szwg.baidu.com:8911/rest/5.0/generate_lcm_token";
            } else if (q80.b(this.a)) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else {
                return "https://pim.baidu.com/rest/5.0/generate_lcm_token";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m80.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = (JSONObject) p80.c(this.a, true);
                if (jSONObject != null) {
                    return jSONObject.toString().getBytes();
                }
                return new byte[0];
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m80.d
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.b.b(i, str, this.c);
        }
    }

    @Override // com.baidu.tieba.m80.d
    public void onSuccess(byte[] bArr) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(new String(bArr));
                r80.a("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
                int optInt = jSONObject2.optInt("error_code", -1);
                String optString = jSONObject2.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                k70 g = j70.h(this.a).g(601110);
                g.c("token_end", System.currentTimeMillis());
                g.b("connect_state", 1);
                g.d("P2", jSONObject2.toString());
                g.d("con_err_code", "P2");
                if (optInt == 0) {
                    s80.q(this.a, jSONObject2.optBoolean("bddns_enable", false));
                    String optString2 = jSONObject2.optString("token");
                    JSONArray jSONArray = jSONObject2.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                    if (!TextUtils.isEmpty(optString2) && jSONArray != null && jSONArray.length() >= 1) {
                        s80.w(this.a, jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
                            s80.v(this.a, jSONObject3.optString(ProbeTB.PROTOCOL) + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(ClientCookie.PORT_ATTR), i);
                        }
                        s80.s(this.a, jSONObject2.optInt("ipv6_strategy", 3));
                        s80.x(this.a, optString2);
                        this.b.a(optString2, this.c);
                        try {
                            String optString3 = jSONObject2.optString("client_log_config", "");
                            if (!TextUtils.isEmpty(optString3)) {
                                JSONObject jSONObject4 = new JSONObject(optString3);
                                o70.j(this.a, jSONObject4.optInt("client_upload_log_switch", 0));
                                JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    for (int i2 = 0; i2 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i2)) != null; i2++) {
                                        o70.i(this.a, jSONObject.optInt("id", 0), jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0));
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            a aVar = this.b;
                            aVar.b(10001, "Json Exception" + e, this.c);
                            r80.b("GetTokenRequest", "Json Exception");
                            return;
                        }
                    }
                    this.b.b(10002, "token or protocol is empty", this.c);
                    return;
                }
                this.b.b(optInt, optString, this.c);
            } catch (JSONException e2) {
                a aVar2 = this.b;
                aVar2.b(10001, "parse response exception ：" + e2, this.c);
            }
        }
    }
}
