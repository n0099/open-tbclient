package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes9.dex */
public class yyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, item)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "item_id", item.item_id);
            poc.a(jSONObject, "item_name", item.item_name);
            poc.a(jSONObject, "icon_size", item.icon_size);
            poc.a(jSONObject, "icon_url", item.icon_url);
            if (item.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : item.tags) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "tags", jSONArray);
            }
            poc.a(jSONObject, "score", item.score);
            poc.a(jSONObject, "star", item.star);
            poc.a(jSONObject, "button_name", item.button_name);
            poc.a(jSONObject, "button_link", item.button_link);
            poc.a(jSONObject, "item_appid", item.item_appid);
            poc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, item.category_id);
            poc.a(jSONObject, "button_link_type", item.button_link_type);
            poc.a(jSONObject, "apk_name", item.apk_name);
            poc.a(jSONObject, "forum_name", item.forum_name);
            ApkDetail apkDetail = item.apk_detail;
            if (apkDetail != null) {
                poc.a(jSONObject, "apk_detail", spc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
