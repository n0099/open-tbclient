package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zg4 extends nf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zg4() {
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

    @Override // com.baidu.tieba.nf4
    public JSONArray c() {
        InterceptResult invokeV;
        List<fd4> w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "bbasp_core");
                jSONObject.put("version_name", pb4.b().J(0));
                jSONObject.put("version_code", pb4.b().w(0));
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", "bbasp_game");
                jSONObject2.put("version_name", pb4.b().J(1));
                jSONObject2.put("version_code", pb4.b().w(1));
                jSONArray.put(jSONObject2);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("type", ETAG.KEY_EXTENSION);
                jSONObject3.put("version_name", pb4.b().v(0));
                jSONObject3.put("version_code", pb4.b().j(0));
                jSONArray.put(jSONObject3);
            } catch (JSONException unused3) {
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("type", "extension_game");
                jSONObject4.put("version_name", pb4.b().v(1));
                jSONObject4.put("version_code", pb4.b().j(1));
                jSONArray.put(jSONObject4);
            } catch (JSONException unused4) {
            }
            try {
                w = bc4.i().w(f(10));
            } catch (JSONException unused5) {
            }
            if (w == null) {
                return jSONArray;
            }
            for (fd4 fd4Var : w) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("type", "ddl");
                jSONObject5.put("bundle_id", fd4Var.g);
                jSONObject5.put("version_code", fd4Var.i);
                jSONObject5.put("version_name", fd4Var.j);
                jSONArray.put(jSONObject5);
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return "SELECT * from (SELECT * from (SELECT * from swan_plugin ORDER BY update_time) group by bundle_id) order by update_time DESC limit 0," + i + ParamableElem.DIVIDE_PARAM;
        }
        return (String) invokeI.objValue;
    }
}
