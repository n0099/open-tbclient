package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StyleConf;
import tbclient.StyleConfExtra;
import tbclient.StyleContentInfo;
/* loaded from: classes8.dex */
public class w8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StyleConf styleConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, styleConf)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "scene", styleConf.scene);
            ktc.a(jSONObject, "content", styleConf.content);
            StyleConfExtra styleConfExtra = styleConf.android_extra;
            if (styleConfExtra != null) {
                ktc.a(jSONObject, "android_extra", x8d.b(styleConfExtra));
            }
            StyleConfExtra styleConfExtra2 = styleConf.ios_extra;
            if (styleConfExtra2 != null) {
                ktc.a(jSONObject, "ios_extra", x8d.b(styleConfExtra2));
            }
            StyleContentInfo styleContentInfo = styleConf.day;
            if (styleContentInfo != null) {
                ktc.a(jSONObject, "day", y8d.b(styleContentInfo));
            }
            StyleContentInfo styleContentInfo2 = styleConf.dark;
            if (styleContentInfo2 != null) {
                ktc.a(jSONObject, "dark", y8d.b(styleContentInfo2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
