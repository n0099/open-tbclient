package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xe4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static RecommendItemModel a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            RecommendItemModel recommendItemModel = new RecommendItemModel();
            recommendItemModel.appName = jSONObject.optString("app_name");
            recommendItemModel.appKey = jSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
            recommendItemModel.iconUrl = jSONObject.optString("icon_url");
            recommendItemModel.scheme = jSONObject.optString("scheme");
            recommendItemModel.desc = jSONObject.optString("desc");
            JSONObject optJSONObject = jSONObject.optJSONObject(NativeConstants.ID_BUTTON);
            if (optJSONObject != null) {
                recommendItemModel.buttonText = optJSONObject.optString("text");
            }
            return recommendItemModel;
        }
        return (RecommendItemModel) invokeL.objValue;
    }

    @NonNull
    public static we4 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            we4 we4Var = new we4();
            if (jSONObject == null) {
                return we4Var;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
            if (optJSONObject != null) {
                we4Var.a = a(optJSONObject);
            }
            we4Var.b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    we4Var.b.add(a(optJSONArray.optJSONObject(i)));
                }
            }
            return we4Var;
        }
        return (we4) invokeL.objValue;
    }

    @NonNull
    public static ye4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ye4 ye4Var = new ye4();
            try {
                JSONObject jSONObject = new JSONObject(str);
                ye4Var.a = jSONObject.getInt("errno");
                ye4Var.b = jSONObject.optString("errmsg");
                ye4Var.c = jSONObject.optJSONObject("data");
                return ye4Var;
            } catch (JSONException e) {
                ye4Var.a = -1;
                ye4Var.b = "network error: response parse failed.";
                if (rr1.a) {
                    Log.e("RecommendModelParser", "parseResponseModel error:" + e);
                }
                return ye4Var;
            }
        }
        return (ye4) invokeL.objValue;
    }
}
