package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.TtsEntity;
import com.baidu.tts.client.TtsMode;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class w1 extends d2<w1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public p0 c;
    public JSONObject d;
    public JSONArray e;
    public JSONObject f;
    public String g;
    public volatile int h;
    public TtsMode i;
    public int j;
    public g2 k;
    public r0 l;
    public HashMap<String, String> m;
    public byte n;

    public w1(TtsEntity ttsEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ttsEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.g = ttsEntity.getSn();
        this.d = new JSONObject();
        this.e = new JSONArray();
        this.a = ttsEntity.getText();
        this.b = ttsEntity.getUtteranceId();
        this.i = ttsEntity.getTtsMode();
        this.m = ttsEntity.getTtsParams();
    }

    public synchronized void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            synchronized (this) {
                JSONObject jSONObject = this.d;
                if (jSONObject != null) {
                    try {
                        JSONObject optJSONObject = jSONObject.optJSONObject("online");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                            this.d.put("online", optJSONObject);
                            try {
                                optJSONObject.put("package_infos", this.e);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        optJSONObject.put(str, obj);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public synchronized void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            synchronized (this) {
                JSONObject jSONObject = this.d;
                if (jSONObject != null) {
                    try {
                        JSONObject optJSONObject = jSONObject.optJSONObject("offline");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                            this.d.put("offline", optJSONObject);
                        }
                        optJSONObject.put(str, obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }
}
