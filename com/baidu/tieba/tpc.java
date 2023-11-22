package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes8.dex */
public class tpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ApkDetail apkDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, apkDetail)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "developer", apkDetail.developer);
            qoc.a(jSONObject, "publisher", apkDetail.publisher);
            qoc.a(jSONObject, "version", apkDetail.version);
            qoc.a(jSONObject, "version_code", apkDetail.version_code);
            qoc.a(jSONObject, "update_time", apkDetail.update_time);
            qoc.a(jSONObject, "size", apkDetail.size);
            qoc.a(jSONObject, "need_network", apkDetail.need_network);
            qoc.a(jSONObject, "need_inner_buy", apkDetail.need_inner_buy);
            qoc.a(jSONObject, "authority_url", apkDetail.authority_url);
            qoc.a(jSONObject, "privacy_url", apkDetail.privacy_url);
            qoc.a(jSONObject, "pkg_source", apkDetail.pkg_source);
            qoc.a(jSONObject, "app_effect", apkDetail.app_effect);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
