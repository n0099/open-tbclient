package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes7.dex */
public class puc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ApkDetail apkDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, apkDetail)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "developer", apkDetail.developer);
            ktc.a(jSONObject, "publisher", apkDetail.publisher);
            ktc.a(jSONObject, "version", apkDetail.version);
            ktc.a(jSONObject, "version_code", apkDetail.version_code);
            ktc.a(jSONObject, "update_time", apkDetail.update_time);
            ktc.a(jSONObject, "size", apkDetail.size);
            ktc.a(jSONObject, "need_network", apkDetail.need_network);
            ktc.a(jSONObject, "need_inner_buy", apkDetail.need_inner_buy);
            ktc.a(jSONObject, "authority_url", apkDetail.authority_url);
            ktc.a(jSONObject, "privacy_url", apkDetail.privacy_url);
            ktc.a(jSONObject, "pkg_source", apkDetail.pkg_source);
            ktc.a(jSONObject, "app_effect", apkDetail.app_effect);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
