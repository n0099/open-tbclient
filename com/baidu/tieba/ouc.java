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
/* loaded from: classes7.dex */
public class ouc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Anti anti) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anti)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "tbs", anti.tbs);
            ktc.a(jSONObject, "ifpost", anti.ifpost);
            ktc.a(jSONObject, "ifposta", anti.ifposta);
            ktc.a(jSONObject, "forbid_flag", anti.forbid_flag);
            ktc.a(jSONObject, "forbid_info", anti.forbid_info);
            ktc.a(jSONObject, "block_stat", anti.block_stat);
            ktc.a(jSONObject, "hide_stat", anti.hide_stat);
            ktc.a(jSONObject, "vcode_stat", anti.vcode_stat);
            ktc.a(jSONObject, "days_tofree", anti.days_tofree);
            ktc.a(jSONObject, "has_chance", anti.has_chance);
            ktc.a(jSONObject, "ifvoice", anti.ifvoice);
            ktc.a(jSONObject, "voice_message", anti.voice_message);
            ktc.a(jSONObject, "ifaddition", anti.ifaddition);
            ktc.a(jSONObject, "need_vcode", anti.need_vcode);
            ktc.a(jSONObject, "vcode_md5", anti.vcode_md5);
            ktc.a(jSONObject, "vcode_pic_url", anti.vcode_pic_url);
            ktc.a(jSONObject, "user_mute", anti.user_mute);
            ktc.a(jSONObject, "ifxiaoying", anti.ifxiaoying);
            ktc.a(jSONObject, "poll_message", anti.poll_message);
            ktc.a(jSONObject, "video_message", anti.video_message);
            ktc.a(jSONObject, "video_local_message", anti.video_local_message);
            BlockPopInfo blockPopInfo = anti.block_pop_info;
            if (blockPopInfo != null) {
                ktc.a(jSONObject, "block_pop_info", hvc.b(blockPopInfo));
            }
            ktc.a(jSONObject, "reply_private_flag", anti.reply_private_flag);
            if (anti.del_thread_text != null) {
                JSONArray jSONArray = new JSONArray();
                for (DelThreadText delThreadText : anti.del_thread_text) {
                    jSONArray.put(kwc.b(delThreadText));
                }
                ktc.a(jSONObject, "del_thread_text", jSONArray);
            }
            ktc.a(jSONObject, "multi_delthread", anti.multi_delthread);
            ktc.a(jSONObject, "poll_level", anti.poll_level);
            ktc.a(jSONObject, WriteActivityConfig.CAN_GOODS, anti.can_goods);
            ktc.a(jSONObject, "is_sexyforum", anti.is_sexyforum);
            ktc.a(jSONObject, "teenmode_interval", anti.teenmode_interval);
            ktc.a(jSONObject, "user_chat_block", anti.user_chat_block);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
