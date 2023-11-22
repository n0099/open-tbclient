package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.BlockPopInfo;
import tbclient.DelThreadText;
/* loaded from: classes8.dex */
public class spc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Anti anti) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anti)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "tbs", anti.tbs);
            qoc.a(jSONObject, "ifpost", anti.ifpost);
            qoc.a(jSONObject, "ifposta", anti.ifposta);
            qoc.a(jSONObject, "forbid_flag", anti.forbid_flag);
            qoc.a(jSONObject, "forbid_info", anti.forbid_info);
            qoc.a(jSONObject, "block_stat", anti.block_stat);
            qoc.a(jSONObject, "hide_stat", anti.hide_stat);
            qoc.a(jSONObject, "vcode_stat", anti.vcode_stat);
            qoc.a(jSONObject, "days_tofree", anti.days_tofree);
            qoc.a(jSONObject, "has_chance", anti.has_chance);
            qoc.a(jSONObject, "ifvoice", anti.ifvoice);
            qoc.a(jSONObject, "voice_message", anti.voice_message);
            qoc.a(jSONObject, "ifaddition", anti.ifaddition);
            qoc.a(jSONObject, "need_vcode", anti.need_vcode);
            qoc.a(jSONObject, "vcode_md5", anti.vcode_md5);
            qoc.a(jSONObject, "vcode_pic_url", anti.vcode_pic_url);
            qoc.a(jSONObject, "user_mute", anti.user_mute);
            qoc.a(jSONObject, "ifxiaoying", anti.ifxiaoying);
            qoc.a(jSONObject, "poll_message", anti.poll_message);
            qoc.a(jSONObject, "video_message", anti.video_message);
            qoc.a(jSONObject, "video_local_message", anti.video_local_message);
            BlockPopInfo blockPopInfo = anti.block_pop_info;
            if (blockPopInfo != null) {
                qoc.a(jSONObject, "block_pop_info", lqc.b(blockPopInfo));
            }
            qoc.a(jSONObject, "reply_private_flag", anti.reply_private_flag);
            if (anti.del_thread_text != null) {
                JSONArray jSONArray = new JSONArray();
                for (DelThreadText delThreadText : anti.del_thread_text) {
                    jSONArray.put(nrc.b(delThreadText));
                }
                qoc.a(jSONObject, "del_thread_text", jSONArray);
            }
            qoc.a(jSONObject, "multi_delthread", anti.multi_delthread);
            qoc.a(jSONObject, "poll_level", anti.poll_level);
            qoc.a(jSONObject, WriteActivityConfig.CAN_GOODS, anti.can_goods);
            qoc.a(jSONObject, "is_sexyforum", anti.is_sexyforum);
            qoc.a(jSONObject, "teenmode_interval", anti.teenmode_interval);
            qoc.a(jSONObject, "user_chat_block", anti.user_chat_block);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
