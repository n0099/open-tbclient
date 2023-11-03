package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RewardCard;
import tbclient.RewardMaterial;
/* loaded from: classes7.dex */
public class o2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RewardCard rewardCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rewardCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", rewardCard.id);
            poc.a(jSONObject, "icon", rewardCard.icon);
            poc.a(jSONObject, "title", rewardCard.title);
            poc.a(jSONObject, "start_text", rewardCard.start_text);
            poc.a(jSONObject, "end_text", rewardCard.end_text);
            poc.a(jSONObject, "end_time", rewardCard.end_time);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, rewardCard.button_text);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, rewardCard.jump_url);
            poc.a(jSONObject, "join_num", rewardCard.join_num);
            if (rewardCard.reward_material != null) {
                JSONArray jSONArray = new JSONArray();
                for (RewardMaterial rewardMaterial : rewardCard.reward_material) {
                    jSONArray.put(p2d.b(rewardMaterial));
                }
                poc.a(jSONObject, "reward_material", jSONArray);
            }
            poc.a(jSONObject, "total_num", rewardCard.total_num);
            if (rewardCard.head_imgs != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : rewardCard.head_imgs) {
                    jSONArray2.put(str);
                }
                poc.a(jSONObject, "head_imgs", jSONArray2);
            }
            poc.a(jSONObject, "join_succ_text", rewardCard.join_succ_text);
            poc.a(jSONObject, "banner_jump_url", rewardCard.banner_jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
