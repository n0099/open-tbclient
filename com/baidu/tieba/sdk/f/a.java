package com.baidu.tieba.sdk.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        String str = map.get("enterroom_type");
        String str2 = map.get("room_id");
        String str3 = map.get("live_id");
        String str4 = map.get("username");
        String str5 = map.get("userrec");
        String str6 = map.get("cover");
        String str7 = map.get("live_url");
        String str8 = map.get("screen_direction");
        String str9 = map.get("open_giftlist");
        String str10 = map.get("tab");
        String str11 = map.get("tag");
        String str12 = map.get("source");
        String str13 = map.get("from");
        String str14 = map.get("extra");
        String str15 = map.get(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
        String str16 = map.get(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
        String str17 = map.get(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        String str18 = map.get(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str10)) {
                jSONObject.put("tab", str10);
            }
            if (!TextUtils.isEmpty(str11)) {
                jSONObject.put("tag", str11);
            }
            if (!TextUtils.isEmpty(str12)) {
                jSONObject.put("source", str12);
            }
            if (!TextUtils.isEmpty(str13)) {
                jSONObject.put("from", str13);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("cover", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONObject.put("live_url", str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                jSONObject.put("screen_direction", str8);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("enterRoomId", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("enterLiveId", str3);
            }
            if (!TextUtils.isEmpty(str14)) {
                jSONObject.put("extra", str14);
            }
            if (!TextUtils.isEmpty(str15)) {
                jSONObject.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL, str15);
            }
            if (!TextUtils.isEmpty(str16)) {
                jSONObject.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG, str16);
            }
            if (!TextUtils.isEmpty(str17)) {
                jSONObject.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, str17);
            }
            if (!TextUtils.isEmpty(str18)) {
                jSONObject.put(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL, str18);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (TextUtils.equals(str, "1")) {
            if (!TextUtils.isEmpty(str2)) {
                com.baidu.tieba.sdk.a.dFx().c(context != null ? context : TbadkCoreApplication.getInst(), str2, "1".equals(str5), str9, jSONObject);
            } else if (!TextUtils.isEmpty(str3)) {
                com.baidu.tieba.sdk.a.dFx().b(context != null ? context : TbadkCoreApplication.getInst(), Long.parseLong(str3), "1".equals(str5), str9, jSONObject);
            } else if (!TextUtils.isEmpty(str4)) {
                com.baidu.tieba.sdk.a.dFx().d(context != null ? context : TbadkCoreApplication.getInst(), str4, "1".equals(str5), str9, jSONObject);
            }
        } else if (!TextUtils.isEmpty(str2)) {
            com.baidu.tieba.sdk.a.dFx().a(context != null ? context : TbadkCoreApplication.getInst(), str2, "1".equals(str5), str9, jSONObject);
        } else if (!TextUtils.isEmpty(str3)) {
            com.baidu.tieba.sdk.a.dFx().a(context != null ? context : TbadkCoreApplication.getInst(), Long.parseLong(str3), "1".equals(str5), str9, jSONObject);
        } else if (!TextUtils.isEmpty(str4)) {
            com.baidu.tieba.sdk.a.dFx().b(context != null ? context : TbadkCoreApplication.getInst(), str4, "1".equals(str5), str9, jSONObject);
        }
    }
}
