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
public class kyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameInfo gameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "game_id", gameInfo.game_id);
            poc.a(jSONObject, "game_name", gameInfo.game_name);
            poc.a(jSONObject, "game_type", gameInfo.game_type);
            poc.a(jSONObject, "icon_url", gameInfo.icon_url);
            poc.a(jSONObject, "player_num", gameInfo.player_num);
            poc.a(jSONObject, "package_link", gameInfo.package_link);
            poc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, gameInfo.package_size);
            poc.a(jSONObject, "game_link", gameInfo.game_link);
            poc.a(jSONObject, "mark", gameInfo.mark);
            poc.a(jSONObject, "apple_id", gameInfo.apple_id);
            poc.a(jSONObject, "bundle_id", gameInfo.bundle_id);
            poc.a(jSONObject, "schema_url", gameInfo.schema_url);
            if (gameInfo.game_pic != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : gameInfo.game_pic) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "game_pic", jSONArray);
            }
            poc.a(jSONObject, "introduce", gameInfo.introduce);
            poc.a(jSONObject, "launch_component", gameInfo.launch_component);
            poc.a(jSONObject, "andr_pk_name", gameInfo.andr_pk_name);
            poc.a(jSONObject, "day_downloads", gameInfo.day_downloads);
            poc.a(jSONObject, "secret_key", gameInfo.secret_key);
            poc.a(jSONObject, "superscript_color", gameInfo.superscript_color);
            poc.a(jSONObject, "star", gameInfo.star);
            poc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, gameInfo.category_id);
            poc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, gameInfo.category_name);
            poc.a(jSONObject, "version", gameInfo.version);
            poc.a(jSONObject, "deadline", gameInfo.deadline);
            poc.a(jSONObject, "editor_rec", gameInfo.editor_rec);
            poc.a(jSONObject, "abstract", gameInfo._abstract);
            poc.a(jSONObject, "game_details_url", gameInfo.game_details_url);
            poc.a(jSONObject, "app_id", gameInfo.app_id);
            poc.a(jSONObject, "icon_pic1", gameInfo.icon_pic1);
            poc.a(jSONObject, "icon_pic2", gameInfo.icon_pic2);
            poc.a(jSONObject, "icon_pic3", gameInfo.icon_pic3);
            poc.a(jSONObject, "game_desc", gameInfo.game_desc);
            poc.a(jSONObject, "subscript_color", gameInfo.subscript_color);
            poc.a(jSONObject, "launchComponent", gameInfo.launchComponent);
            poc.a(jSONObject, "category_name_sim", gameInfo.category_name_sim);
            poc.a(jSONObject, "score", gameInfo.score);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
