package com.baidu.tieba.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        String str = map.get("room_id");
        String str2 = map.get("live_id");
        String str3 = map.get("username");
        String str4 = map.get("userrec");
        String str5 = map.get("cover");
        String str6 = map.get("live_url");
        String str7 = map.get(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
        String str8 = map.get("tab");
        String str9 = map.get("tag");
        String str10 = map.get("source");
        String str11 = map.get("from");
        String str12 = map.get("extra");
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str8)) {
                jSONObject.put("tab", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put("tag", str9);
            }
            if (!TextUtils.isEmpty(str10)) {
                jSONObject.put("source", str10);
            }
            if (!TextUtils.isEmpty(str11)) {
                jSONObject.put("from", str11);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("cover", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("live_url", str6);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("enterRoomId", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("enterLiveId", str2);
            }
            if (!TextUtils.isEmpty(str12)) {
                jSONObject.put("extra", str12);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.sdk.a.cPc().a(context != null ? context : TbadkCoreApplication.getInst(), str, "1".equals(str4), str7, jSONObject);
        } else if (!TextUtils.isEmpty(str2)) {
            com.baidu.tieba.sdk.a.cPc().a(context != null ? context : TbadkCoreApplication.getInst(), Long.parseLong(str2), "1".equals(str4), str7, jSONObject);
        } else if (!TextUtils.isEmpty(str3)) {
            com.baidu.tieba.sdk.a.cPc().b(context != null ? context : TbadkCoreApplication.getInst(), str3, "1".equals(str4), str7, jSONObject);
        }
    }
}
