package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GameInfo;
/* loaded from: classes7.dex */
public class lyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameInfo gameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "game_id", gameInfo.game_id);
            qoc.a(jSONObject, "game_name", gameInfo.game_name);
            qoc.a(jSONObject, "game_type", gameInfo.game_type);
            qoc.a(jSONObject, "icon_url", gameInfo.icon_url);
            qoc.a(jSONObject, "player_num", gameInfo.player_num);
            qoc.a(jSONObject, "package_link", gameInfo.package_link);
            qoc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, gameInfo.package_size);
            qoc.a(jSONObject, "game_link", gameInfo.game_link);
            qoc.a(jSONObject, "mark", gameInfo.mark);
            qoc.a(jSONObject, "apple_id", gameInfo.apple_id);
            qoc.a(jSONObject, "bundle_id", gameInfo.bundle_id);
            qoc.a(jSONObject, "schema_url", gameInfo.schema_url);
            if (gameInfo.game_pic != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : gameInfo.game_pic) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "game_pic", jSONArray);
            }
            qoc.a(jSONObject, "introduce", gameInfo.introduce);
            qoc.a(jSONObject, "launch_component", gameInfo.launch_component);
            qoc.a(jSONObject, "andr_pk_name", gameInfo.andr_pk_name);
            qoc.a(jSONObject, "day_downloads", gameInfo.day_downloads);
            qoc.a(jSONObject, "secret_key", gameInfo.secret_key);
            qoc.a(jSONObject, "superscript_color", gameInfo.superscript_color);
            qoc.a(jSONObject, "star", gameInfo.star);
            qoc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, gameInfo.category_id);
            qoc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, gameInfo.category_name);
            qoc.a(jSONObject, "version", gameInfo.version);
            qoc.a(jSONObject, "deadline", gameInfo.deadline);
            qoc.a(jSONObject, "editor_rec", gameInfo.editor_rec);
            qoc.a(jSONObject, "abstract", gameInfo._abstract);
            qoc.a(jSONObject, "game_details_url", gameInfo.game_details_url);
            qoc.a(jSONObject, "app_id", gameInfo.app_id);
            qoc.a(jSONObject, "icon_pic1", gameInfo.icon_pic1);
            qoc.a(jSONObject, "icon_pic2", gameInfo.icon_pic2);
            qoc.a(jSONObject, "icon_pic3", gameInfo.icon_pic3);
            qoc.a(jSONObject, "game_desc", gameInfo.game_desc);
            qoc.a(jSONObject, "subscript_color", gameInfo.subscript_color);
            qoc.a(jSONObject, "launchComponent", gameInfo.launchComponent);
            qoc.a(jSONObject, "category_name_sim", gameInfo.category_name_sim);
            qoc.a(jSONObject, "score", gameInfo.score);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
