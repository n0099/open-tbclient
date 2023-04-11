package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qb5 {
    public static /* synthetic */ Interceptable $ic;
    public static qb5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> a;
    public HashMap<String, String> b;
    public HashMap<String, String> c;

    public qb5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
    }

    public static synchronized qb5 a() {
        InterceptResult invokeV;
        qb5 qb5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (qb5.class) {
                if (d == null) {
                    d = new qb5();
                }
                qb5Var = d;
            }
            return qb5Var;
        }
        return (qb5) invokeV.objValue;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("upload_file_frequency");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("2g");
                String optString2 = optJSONObject.optString("3g");
                String optString3 = optJSONObject.optString("4g");
                String optString4 = optJSONObject.optString("wifi");
                if (optString != null) {
                    this.a.put("2g", optString);
                }
                if (optString2 != null) {
                    this.a.put("3g", optString2);
                }
                if (optString3 != null) {
                    this.a.put("4g", optString3);
                }
                if (optString4 != null) {
                    this.a.put("wifi", optString4);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
            if (optJSONObject2 != null) {
                String optString5 = optJSONObject2.optString("2g");
                String optString6 = optJSONObject2.optString("3g");
                String optString7 = optJSONObject2.optString("4g");
                String optString8 = optJSONObject2.optString("wifi");
                if (optString5 != null) {
                    this.b.put("2g", optString5);
                }
                if (optString6 != null) {
                    this.b.put("3g", optString6);
                }
                if (optString7 != null) {
                    this.b.put("4g", optString7);
                }
                if (optString8 != null) {
                    this.b.put("wifi", optString8);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
            if (optJSONObject3 != null) {
                String optString9 = optJSONObject3.optString("2g");
                String optString10 = optJSONObject3.optString("3g");
                String optString11 = optJSONObject3.optString("4g");
                String optString12 = optJSONObject3.optString("wifi");
                if (optString9 != null) {
                    this.c.put("2g", optString9);
                }
                if (optString10 != null) {
                    this.c.put("3g", optString10);
                }
                if (optString11 != null) {
                    this.c.put("4g", optString11);
                }
                if (optString12 != null) {
                    this.c.put("wifi", optString12);
                }
            }
            jSONObject.optString("is_on");
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
