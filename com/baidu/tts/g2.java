package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public a b;
    public String c;
    public String d;
    public String e;
    public long f;
    public long g;
    public long h;
    public long i;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

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
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;
        public long c;
        public long d;

        public b() {
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

        public JSONObject a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (this.a != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    jSONObject.put("firstConnect", z);
                    jSONObject.put("beginConnectToServer", this.a);
                    jSONObject.put("connectionSetup", this.b);
                    jSONObject.put("sendDataToServer", this.c);
                    jSONObject.put("firstReceiveDataFromServer", this.d);
                    jSONObject.put("serverCost", this.d - this.c);
                    long j = this.a;
                    if (j != 0) {
                        jSONObject.put("connectServerCost", this.b - j);
                        jSONObject.put("sendDataToServerCost", this.c - this.b);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public g2() {
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
}
