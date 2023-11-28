package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;
import tbclient.ActHot;
/* loaded from: classes8.dex */
public class qtc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActHot actHot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actHot)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "bsize", actHot.bsize);
            ltc.a(jSONObject, "img_src", actHot.img_src);
            ltc.a(jSONObject, "link", actHot.link);
            ltc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, actHot.author_name);
            ltc.a(jSONObject, "img_des", actHot.img_des);
            ltc.a(jSONObject, "img_type", actHot.img_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
