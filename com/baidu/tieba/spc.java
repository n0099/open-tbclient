package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes8.dex */
public class spc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ApkDetail apkDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, apkDetail)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "developer", apkDetail.developer);
            poc.a(jSONObject, "publisher", apkDetail.publisher);
            poc.a(jSONObject, "version", apkDetail.version);
            poc.a(jSONObject, "version_code", apkDetail.version_code);
            poc.a(jSONObject, "update_time", apkDetail.update_time);
            poc.a(jSONObject, "size", apkDetail.size);
            poc.a(jSONObject, "need_network", apkDetail.need_network);
            poc.a(jSONObject, "need_inner_buy", apkDetail.need_inner_buy);
            poc.a(jSONObject, "authority_url", apkDetail.authority_url);
            poc.a(jSONObject, "privacy_url", apkDetail.privacy_url);
            poc.a(jSONObject, "pkg_source", apkDetail.pkg_source);
            poc.a(jSONObject, "app_effect", apkDetail.app_effect);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
