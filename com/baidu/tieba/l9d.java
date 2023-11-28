package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RewardCard;
import tbclient.TaskInfo;
import tbclient.VoteSchema;
/* loaded from: classes7.dex */
public class l9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, taskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "task_id", taskInfo.task_id);
            ltc.a(jSONObject, "thread_id", taskInfo.thread_id);
            ltc.a(jSONObject, "bgimg", taskInfo.bgimg);
            ltc.a(jSONObject, "thread_img", taskInfo.thread_img);
            ltc.a(jSONObject, "start_time", taskInfo.start_time);
            ltc.a(jSONObject, "end_time", taskInfo.end_time);
            ltc.a(jSONObject, "thread_img_size", taskInfo.thread_img_size);
            ltc.a(jSONObject, "forum_id", taskInfo.forum_id);
            ltc.a(jSONObject, "forum_name", taskInfo.forum_name);
            ltc.a(jSONObject, "obj_id", taskInfo.obj_id);
            VoteSchema voteSchema = taskInfo.vote_schema;
            if (voteSchema != null) {
                ltc.a(jSONObject, "vote_schema", lbd.b(voteSchema));
            }
            RewardCard rewardCard = taskInfo.reward_card;
            if (rewardCard != null) {
                ltc.a(jSONObject, "reward_card", s7d.b(rewardCard));
            }
            ltc.a(jSONObject, "is_god_reply", taskInfo.is_god_reply);
            ltc.a(jSONObject, "floor_god_reply", taskInfo.floor_god_reply);
            ltc.a(jSONObject, "card_type", taskInfo.card_type);
            ltc.a(jSONObject, "wh_rate", taskInfo.wh_rate);
            ltc.a(jSONObject, "webview_url", taskInfo.webview_url);
            ltc.a(jSONObject, "top_background_img", taskInfo.top_background_img);
            ltc.a(jSONObject, "theme_color", taskInfo.theme_color);
            ltc.a(jSONObject, "webview_data", taskInfo.webview_data);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
