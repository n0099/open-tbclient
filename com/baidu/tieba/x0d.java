package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.LiveModuleList;
/* loaded from: classes9.dex */
public class x0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveModuleList liveModuleList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveModuleList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", liveModuleList.id);
            ltc.a(jSONObject, "forum_id", liveModuleList.forum_id);
            ltc.a(jSONObject, "module_type", liveModuleList.module_type);
            if (liveModuleList.module_name != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : liveModuleList.module_name) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, Info.kBaiduModuleKey, jSONArray);
            }
            ltc.a(jSONObject, "module_desc", liveModuleList.module_desc);
            ltc.a(jSONObject, "tag_text", liveModuleList.tag_text);
            ltc.a(jSONObject, "tag_text_color", liveModuleList.tag_text_color);
            ltc.a(jSONObject, "background_url", liveModuleList.background_url);
            if (liveModuleList.head_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : liveModuleList.head_list) {
                    jSONArray2.put(str2);
                }
                ltc.a(jSONObject, "head_list", jSONArray2);
            }
            ltc.a(jSONObject, "jump_type", liveModuleList.jump_type);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, liveModuleList.jump_url);
            ltc.a(jSONObject, "module_sort", liveModuleList.module_sort);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
