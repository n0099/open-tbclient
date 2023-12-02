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
/* loaded from: classes8.dex */
public class w0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveModuleList liveModuleList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveModuleList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", liveModuleList.id);
            ktc.a(jSONObject, "forum_id", liveModuleList.forum_id);
            ktc.a(jSONObject, "module_type", liveModuleList.module_type);
            if (liveModuleList.module_name != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : liveModuleList.module_name) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, Info.kBaiduModuleKey, jSONArray);
            }
            ktc.a(jSONObject, "module_desc", liveModuleList.module_desc);
            ktc.a(jSONObject, "tag_text", liveModuleList.tag_text);
            ktc.a(jSONObject, "tag_text_color", liveModuleList.tag_text_color);
            ktc.a(jSONObject, "background_url", liveModuleList.background_url);
            if (liveModuleList.head_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : liveModuleList.head_list) {
                    jSONArray2.put(str2);
                }
                ktc.a(jSONObject, "head_list", jSONArray2);
            }
            ktc.a(jSONObject, "jump_type", liveModuleList.jump_type);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, liveModuleList.jump_url);
            ktc.a(jSONObject, "module_sort", liveModuleList.module_sort);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
