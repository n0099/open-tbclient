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
/* loaded from: classes8.dex */
public class s7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RewardCard rewardCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rewardCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", rewardCard.id);
            ltc.a(jSONObject, "icon", rewardCard.icon);
            ltc.a(jSONObject, "title", rewardCard.title);
            ltc.a(jSONObject, "start_text", rewardCard.start_text);
            ltc.a(jSONObject, "end_text", rewardCard.end_text);
            ltc.a(jSONObject, "end_time", rewardCard.end_time);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, rewardCard.button_text);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, rewardCard.jump_url);
            ltc.a(jSONObject, "join_num", rewardCard.join_num);
            if (rewardCard.reward_material != null) {
                JSONArray jSONArray = new JSONArray();
                for (RewardMaterial rewardMaterial : rewardCard.reward_material) {
                    jSONArray.put(t7d.b(rewardMaterial));
                }
                ltc.a(jSONObject, "reward_material", jSONArray);
            }
            ltc.a(jSONObject, "total_num", rewardCard.total_num);
            if (rewardCard.head_imgs != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : rewardCard.head_imgs) {
                    jSONArray2.put(str);
                }
                ltc.a(jSONObject, "head_imgs", jSONArray2);
            }
            ltc.a(jSONObject, "join_succ_text", rewardCard.join_succ_text);
            ltc.a(jSONObject, "banner_jump_url", rewardCard.banner_jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
