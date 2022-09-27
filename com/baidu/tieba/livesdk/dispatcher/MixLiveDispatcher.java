package com.baidu.tieba.livesdk.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.baidu.tieba.si5;
import com.baidu.tieba.yj7;
import com.baidu.tieba.zf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MixLiveDispatcher implements zf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MixLiveDispatcher() {
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

    public static String bundleToJsonStr(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            if (hashMap == null || hashMap.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : hashMap.keySet()) {
                try {
                    jSONObject.put(str, hashMap.get(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zf8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) || context == null || jSONObject == null) {
            return;
        }
        Uri parse = Uri.parse(si5.d(jSONObject.optString("url"), "url"));
        HashMap hashMap = new HashMap();
        for (String str : parse.getQueryParameterNames()) {
            hashMap.put(str, parse.getQueryParameter(str));
        }
        yj7.j().w(context, (String) hashMap.get("room_id"), (String) hashMap.get("source"), bundleToJsonStr(hashMap), parse);
    }
}
