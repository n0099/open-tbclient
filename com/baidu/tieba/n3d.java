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
public class n3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameInfo gameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "game_id", gameInfo.game_id);
            ktc.a(jSONObject, "game_name", gameInfo.game_name);
            ktc.a(jSONObject, "game_type", gameInfo.game_type);
            ktc.a(jSONObject, "icon_url", gameInfo.icon_url);
            ktc.a(jSONObject, "player_num", gameInfo.player_num);
            ktc.a(jSONObject, "package_link", gameInfo.package_link);
            ktc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, gameInfo.package_size);
            ktc.a(jSONObject, "game_link", gameInfo.game_link);
            ktc.a(jSONObject, "mark", gameInfo.mark);
            ktc.a(jSONObject, "apple_id", gameInfo.apple_id);
            ktc.a(jSONObject, "bundle_id", gameInfo.bundle_id);
            ktc.a(jSONObject, "schema_url", gameInfo.schema_url);
            if (gameInfo.game_pic != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : gameInfo.game_pic) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "game_pic", jSONArray);
            }
            ktc.a(jSONObject, "introduce", gameInfo.introduce);
            ktc.a(jSONObject, "launch_component", gameInfo.launch_component);
            ktc.a(jSONObject, "andr_pk_name", gameInfo.andr_pk_name);
            ktc.a(jSONObject, "day_downloads", gameInfo.day_downloads);
            ktc.a(jSONObject, "secret_key", gameInfo.secret_key);
            ktc.a(jSONObject, "superscript_color", gameInfo.superscript_color);
            ktc.a(jSONObject, "star", gameInfo.star);
            ktc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, gameInfo.category_id);
            ktc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, gameInfo.category_name);
            ktc.a(jSONObject, "version", gameInfo.version);
            ktc.a(jSONObject, "deadline", gameInfo.deadline);
            ktc.a(jSONObject, "editor_rec", gameInfo.editor_rec);
            ktc.a(jSONObject, "abstract", gameInfo._abstract);
            ktc.a(jSONObject, "game_details_url", gameInfo.game_details_url);
            ktc.a(jSONObject, "app_id", gameInfo.app_id);
            ktc.a(jSONObject, "icon_pic1", gameInfo.icon_pic1);
            ktc.a(jSONObject, "icon_pic2", gameInfo.icon_pic2);
            ktc.a(jSONObject, "icon_pic3", gameInfo.icon_pic3);
            ktc.a(jSONObject, "game_desc", gameInfo.game_desc);
            ktc.a(jSONObject, "subscript_color", gameInfo.subscript_color);
            ktc.a(jSONObject, "launchComponent", gameInfo.launchComponent);
            ktc.a(jSONObject, "category_name_sim", gameInfo.category_name_sim);
            ktc.a(jSONObject, "score", gameInfo.score);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
