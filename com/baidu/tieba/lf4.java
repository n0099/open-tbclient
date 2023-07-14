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
/* loaded from: classes6.dex */
public class lf4 {
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
    public static kf4 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            kf4 kf4Var = new kf4();
            if (jSONObject == null) {
                return kf4Var;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
            if (optJSONObject != null) {
                kf4Var.a = a(optJSONObject);
            }
            kf4Var.b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    kf4Var.b.add(a(optJSONArray.optJSONObject(i)));
                }
            }
            return kf4Var;
        }
        return (kf4) invokeL.objValue;
    }

    @NonNull
    public static mf4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            mf4 mf4Var = new mf4();
            try {
                JSONObject jSONObject = new JSONObject(str);
                mf4Var.a = jSONObject.getInt("errno");
                mf4Var.b = jSONObject.optString("errmsg");
                mf4Var.c = jSONObject.optJSONObject("data");
                return mf4Var;
            } catch (JSONException e) {
                mf4Var.a = -1;
                mf4Var.b = "network error: response parse failed.";
                if (fs1.a) {
                    Log.e("RecommendModelParser", "parseResponseModel error:" + e);
                }
                return mf4Var;
            }
        }
        return (mf4) invokeL.objValue;
    }
}
