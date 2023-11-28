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
public class o3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameInfo gameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "game_id", gameInfo.game_id);
            ltc.a(jSONObject, "game_name", gameInfo.game_name);
            ltc.a(jSONObject, "game_type", gameInfo.game_type);
            ltc.a(jSONObject, "icon_url", gameInfo.icon_url);
            ltc.a(jSONObject, "player_num", gameInfo.player_num);
            ltc.a(jSONObject, "package_link", gameInfo.package_link);
            ltc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, gameInfo.package_size);
            ltc.a(jSONObject, "game_link", gameInfo.game_link);
            ltc.a(jSONObject, "mark", gameInfo.mark);
            ltc.a(jSONObject, "apple_id", gameInfo.apple_id);
            ltc.a(jSONObject, "bundle_id", gameInfo.bundle_id);
            ltc.a(jSONObject, "schema_url", gameInfo.schema_url);
            if (gameInfo.game_pic != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : gameInfo.game_pic) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "game_pic", jSONArray);
            }
            ltc.a(jSONObject, "introduce", gameInfo.introduce);
            ltc.a(jSONObject, "launch_component", gameInfo.launch_component);
            ltc.a(jSONObject, "andr_pk_name", gameInfo.andr_pk_name);
            ltc.a(jSONObject, "day_downloads", gameInfo.day_downloads);
            ltc.a(jSONObject, "secret_key", gameInfo.secret_key);
            ltc.a(jSONObject, "superscript_color", gameInfo.superscript_color);
            ltc.a(jSONObject, "star", gameInfo.star);
            ltc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, gameInfo.category_id);
            ltc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, gameInfo.category_name);
            ltc.a(jSONObject, "version", gameInfo.version);
            ltc.a(jSONObject, "deadline", gameInfo.deadline);
            ltc.a(jSONObject, "editor_rec", gameInfo.editor_rec);
            ltc.a(jSONObject, "abstract", gameInfo._abstract);
            ltc.a(jSONObject, "game_details_url", gameInfo.game_details_url);
            ltc.a(jSONObject, "app_id", gameInfo.app_id);
            ltc.a(jSONObject, "icon_pic1", gameInfo.icon_pic1);
            ltc.a(jSONObject, "icon_pic2", gameInfo.icon_pic2);
            ltc.a(jSONObject, "icon_pic3", gameInfo.icon_pic3);
            ltc.a(jSONObject, "game_desc", gameInfo.game_desc);
            ltc.a(jSONObject, "subscript_color", gameInfo.subscript_color);
            ltc.a(jSONObject, "launchComponent", gameInfo.launchComponent);
            ltc.a(jSONObject, "category_name_sim", gameInfo.category_name_sim);
            ltc.a(jSONObject, "score", gameInfo.score);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
