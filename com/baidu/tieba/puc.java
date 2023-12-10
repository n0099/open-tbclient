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
public class puc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Anti anti) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anti)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "tbs", anti.tbs);
            ltc.a(jSONObject, "ifpost", anti.ifpost);
            ltc.a(jSONObject, "ifposta", anti.ifposta);
            ltc.a(jSONObject, "forbid_flag", anti.forbid_flag);
            ltc.a(jSONObject, "forbid_info", anti.forbid_info);
            ltc.a(jSONObject, "block_stat", anti.block_stat);
            ltc.a(jSONObject, "hide_stat", anti.hide_stat);
            ltc.a(jSONObject, "vcode_stat", anti.vcode_stat);
            ltc.a(jSONObject, "days_tofree", anti.days_tofree);
            ltc.a(jSONObject, "has_chance", anti.has_chance);
            ltc.a(jSONObject, "ifvoice", anti.ifvoice);
            ltc.a(jSONObject, "voice_message", anti.voice_message);
            ltc.a(jSONObject, "ifaddition", anti.ifaddition);
            ltc.a(jSONObject, "need_vcode", anti.need_vcode);
            ltc.a(jSONObject, "vcode_md5", anti.vcode_md5);
            ltc.a(jSONObject, "vcode_pic_url", anti.vcode_pic_url);
            ltc.a(jSONObject, "user_mute", anti.user_mute);
            ltc.a(jSONObject, "ifxiaoying", anti.ifxiaoying);
            ltc.a(jSONObject, "poll_message", anti.poll_message);
            ltc.a(jSONObject, "video_message", anti.video_message);
            ltc.a(jSONObject, "video_local_message", anti.video_local_message);
            BlockPopInfo blockPopInfo = anti.block_pop_info;
            if (blockPopInfo != null) {
                ltc.a(jSONObject, "block_pop_info", ivc.b(blockPopInfo));
            }
            ltc.a(jSONObject, "reply_private_flag", anti.reply_private_flag);
            if (anti.del_thread_text != null) {
                JSONArray jSONArray = new JSONArray();
                for (DelThreadText delThreadText : anti.del_thread_text) {
                    jSONArray.put(lwc.b(delThreadText));
                }
                ltc.a(jSONObject, "del_thread_text", jSONArray);
            }
            ltc.a(jSONObject, "multi_delthread", anti.multi_delthread);
            ltc.a(jSONObject, "poll_level", anti.poll_level);
            ltc.a(jSONObject, WriteActivityConfig.CAN_GOODS, anti.can_goods);
            ltc.a(jSONObject, "is_sexyforum", anti.is_sexyforum);
            ltc.a(jSONObject, "teenmode_interval", anti.teenmode_interval);
            ltc.a(jSONObject, "user_chat_block", anti.user_chat_block);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
