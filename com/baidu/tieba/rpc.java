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
public class rpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Anti anti) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anti)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "tbs", anti.tbs);
            poc.a(jSONObject, "ifpost", anti.ifpost);
            poc.a(jSONObject, "ifposta", anti.ifposta);
            poc.a(jSONObject, "forbid_flag", anti.forbid_flag);
            poc.a(jSONObject, "forbid_info", anti.forbid_info);
            poc.a(jSONObject, "block_stat", anti.block_stat);
            poc.a(jSONObject, "hide_stat", anti.hide_stat);
            poc.a(jSONObject, "vcode_stat", anti.vcode_stat);
            poc.a(jSONObject, "days_tofree", anti.days_tofree);
            poc.a(jSONObject, "has_chance", anti.has_chance);
            poc.a(jSONObject, "ifvoice", anti.ifvoice);
            poc.a(jSONObject, "voice_message", anti.voice_message);
            poc.a(jSONObject, "ifaddition", anti.ifaddition);
            poc.a(jSONObject, "need_vcode", anti.need_vcode);
            poc.a(jSONObject, "vcode_md5", anti.vcode_md5);
            poc.a(jSONObject, "vcode_pic_url", anti.vcode_pic_url);
            poc.a(jSONObject, "user_mute", anti.user_mute);
            poc.a(jSONObject, "ifxiaoying", anti.ifxiaoying);
            poc.a(jSONObject, "poll_message", anti.poll_message);
            poc.a(jSONObject, "video_message", anti.video_message);
            poc.a(jSONObject, "video_local_message", anti.video_local_message);
            BlockPopInfo blockPopInfo = anti.block_pop_info;
            if (blockPopInfo != null) {
                poc.a(jSONObject, "block_pop_info", kqc.b(blockPopInfo));
            }
            poc.a(jSONObject, "reply_private_flag", anti.reply_private_flag);
            if (anti.del_thread_text != null) {
                JSONArray jSONArray = new JSONArray();
                for (DelThreadText delThreadText : anti.del_thread_text) {
                    jSONArray.put(mrc.b(delThreadText));
                }
                poc.a(jSONObject, "del_thread_text", jSONArray);
            }
            poc.a(jSONObject, "multi_delthread", anti.multi_delthread);
            poc.a(jSONObject, "poll_level", anti.poll_level);
            poc.a(jSONObject, WriteActivityConfig.CAN_GOODS, anti.can_goods);
            poc.a(jSONObject, "is_sexyforum", anti.is_sexyforum);
            poc.a(jSONObject, "teenmode_interval", anti.teenmode_interval);
            poc.a(jSONObject, "user_chat_block", anti.user_chat_block);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
