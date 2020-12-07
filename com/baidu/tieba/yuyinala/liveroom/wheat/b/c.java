package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public void ah(w wVar) {
        if (wVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, wVar.aKL.croom_id);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "miclinkbtn_clk").setContentExt(jSONObject));
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
            if (Zd != null && Zd.aKL != null) {
                jSONObject.put("live_id", Zd.aKL.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Zd.aKL.croom_id);
            }
            jSONObject.put("loc", i);
            boolean z = false;
            if (alaWheatInfoData != null) {
                z = true;
            }
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? "occupy" : SchemeCollecter.CLASSIFY_EMPTY);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micpos_clk").setContentExt(jSONObject));
    }
}
