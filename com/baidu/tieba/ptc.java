package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;
import tbclient.ActHot;
/* loaded from: classes7.dex */
public class ptc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActHot actHot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actHot)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "bsize", actHot.bsize);
            ktc.a(jSONObject, "img_src", actHot.img_src);
            ktc.a(jSONObject, "link", actHot.link);
            ktc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, actHot.author_name);
            ktc.a(jSONObject, "img_des", actHot.img_des);
            ktc.a(jSONObject, "img_type", actHot.img_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
