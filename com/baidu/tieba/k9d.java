package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RewardCard;
import tbclient.TaskInfo;
import tbclient.VoteSchema;
/* loaded from: classes6.dex */
public class k9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, taskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "task_id", taskInfo.task_id);
            ktc.a(jSONObject, "thread_id", taskInfo.thread_id);
            ktc.a(jSONObject, "bgimg", taskInfo.bgimg);
            ktc.a(jSONObject, "thread_img", taskInfo.thread_img);
            ktc.a(jSONObject, "start_time", taskInfo.start_time);
            ktc.a(jSONObject, "end_time", taskInfo.end_time);
            ktc.a(jSONObject, "thread_img_size", taskInfo.thread_img_size);
            ktc.a(jSONObject, "forum_id", taskInfo.forum_id);
            ktc.a(jSONObject, "forum_name", taskInfo.forum_name);
            ktc.a(jSONObject, "obj_id", taskInfo.obj_id);
            VoteSchema voteSchema = taskInfo.vote_schema;
            if (voteSchema != null) {
                ktc.a(jSONObject, "vote_schema", kbd.b(voteSchema));
            }
            RewardCard rewardCard = taskInfo.reward_card;
            if (rewardCard != null) {
                ktc.a(jSONObject, "reward_card", r7d.b(rewardCard));
            }
            ktc.a(jSONObject, "is_god_reply", taskInfo.is_god_reply);
            ktc.a(jSONObject, "floor_god_reply", taskInfo.floor_god_reply);
            ktc.a(jSONObject, "card_type", taskInfo.card_type);
            ktc.a(jSONObject, "wh_rate", taskInfo.wh_rate);
            ktc.a(jSONObject, "webview_url", taskInfo.webview_url);
            ktc.a(jSONObject, "top_background_img", taskInfo.top_background_img);
            ktc.a(jSONObject, "theme_color", taskInfo.theme_color);
            ktc.a(jSONObject, "webview_data", taskInfo.webview_data);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
