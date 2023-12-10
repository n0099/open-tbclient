package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StyleConf;
import tbclient.StyleConfExtra;
import tbclient.StyleContentInfo;
/* loaded from: classes9.dex */
public class x8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StyleConf styleConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, styleConf)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "scene", styleConf.scene);
            ltc.a(jSONObject, "content", styleConf.content);
            StyleConfExtra styleConfExtra = styleConf.android_extra;
            if (styleConfExtra != null) {
                ltc.a(jSONObject, "android_extra", y8d.b(styleConfExtra));
            }
            StyleConfExtra styleConfExtra2 = styleConf.ios_extra;
            if (styleConfExtra2 != null) {
                ltc.a(jSONObject, "ios_extra", y8d.b(styleConfExtra2));
            }
            StyleContentInfo styleContentInfo = styleConf.day;
            if (styleContentInfo != null) {
                ltc.a(jSONObject, "day", z8d.b(styleContentInfo));
            }
            StyleContentInfo styleContentInfo2 = styleConf.dark;
            if (styleContentInfo2 != null) {
                ltc.a(jSONObject, "dark", z8d.b(styleContentInfo2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
