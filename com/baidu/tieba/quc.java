package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes8.dex */
public class quc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ApkDetail apkDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, apkDetail)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "developer", apkDetail.developer);
            ltc.a(jSONObject, "publisher", apkDetail.publisher);
            ltc.a(jSONObject, "version", apkDetail.version);
            ltc.a(jSONObject, "version_code", apkDetail.version_code);
            ltc.a(jSONObject, "update_time", apkDetail.update_time);
            ltc.a(jSONObject, "size", apkDetail.size);
            ltc.a(jSONObject, "need_network", apkDetail.need_network);
            ltc.a(jSONObject, "need_inner_buy", apkDetail.need_inner_buy);
            ltc.a(jSONObject, "authority_url", apkDetail.authority_url);
            ltc.a(jSONObject, "privacy_url", apkDetail.privacy_url);
            ltc.a(jSONObject, "pkg_source", apkDetail.pkg_source);
            ltc.a(jSONObject, "app_effect", apkDetail.app_effect);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
