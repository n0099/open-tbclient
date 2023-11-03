package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.ItemDetail;
import tbclient.ItemInfo;
import tbclient.ItemOptions;
import tbclient.ItemService;
import tbclient.ItemTable;
import tbclient.ItemThemeColor;
import tbclient.Ranking;
import tbclient.TagInfo;
/* loaded from: classes9.dex */
public class zyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemInfo itemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", itemInfo.id);
            poc.a(jSONObject, "name", itemInfo.name);
            poc.a(jSONObject, "icon_url", itemInfo.icon_url);
            poc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, itemInfo.brief);
            if (itemInfo.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : itemInfo.tags) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "tags", jSONArray);
            }
            poc.a(jSONObject, "icon_size", itemInfo.icon_size);
            if (itemInfo.item_options != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ItemOptions itemOptions : itemInfo.item_options) {
                    jSONArray2.put(azc.b(itemOptions));
                }
                poc.a(jSONObject, "item_options", jSONArray2);
            }
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null) {
                poc.a(jSONObject, "score", ezc.b(itemTable));
            }
            poc.a(jSONObject, "is_school", itemInfo.is_school);
            ItemThemeColor itemThemeColor = itemInfo.theme_color;
            if (itemThemeColor != null) {
                poc.a(jSONObject, "theme_color", gzc.b(itemThemeColor));
            }
            poc.a(jSONObject, "template_name", itemInfo.template_name);
            poc.a(jSONObject, "forum_name", itemInfo.forum_name);
            if (itemInfo.tag_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagInfo tagInfo : itemInfo.tag_info) {
                    jSONArray3.put(d4d.b(tagInfo));
                }
                poc.a(jSONObject, "tag_info", jSONArray3);
            }
            poc.a(jSONObject, "category1", itemInfo.category1);
            poc.a(jSONObject, "category2", itemInfo.category2);
            ItemDetail itemDetail = itemInfo.detail;
            if (itemDetail != null) {
                poc.a(jSONObject, "detail", xyc.b(itemDetail));
            }
            Ranking ranking = itemInfo.ranking;
            if (ranking != null) {
                poc.a(jSONObject, "ranking", e2d.b(ranking));
            }
            ItemService itemService = itemInfo.service;
            if (itemService != null) {
                poc.a(jSONObject, "service", dzc.b(itemService));
            }
            poc.a(jSONObject, "button_name", itemInfo.button_name);
            poc.a(jSONObject, "button_link", itemInfo.button_link);
            poc.a(jSONObject, "item_appid", itemInfo.item_appid);
            poc.a(jSONObject, "button_link_type", itemInfo.button_link_type);
            poc.a(jSONObject, "apk_name", itemInfo.apk_name);
            ApkDetail apkDetail = itemInfo.apk_detail;
            if (apkDetail != null) {
                poc.a(jSONObject, "apk_detail", spc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
