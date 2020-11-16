package com.baidu.ubs.analytics.d;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.baidu.ubs.analytics.a.l;
import com.baidu.ubs.analytics.a.n;
import com.heytap.mcssdk.mode.CommandMessage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public final class h {
    public static String a(com.baidu.ubs.analytics.b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        try {
            jSONObject2.put("cuid", bVar.n().l());
            jSONObject2.put("imei", bVar.n().getImei());
            jSONObject2.put("osVersion", bVar.n().getOsVersion());
            jSONObject2.put("brandName", bVar.n().r());
            jSONObject2.put(CashierData.DEVICE_TYPE, bVar.n().s());
            jSONObject2.put("mac", bVar.n().t());
            jSONObject2.put(CommandMessage.SDK_VERSION, bVar.n().u());
            jSONObject2.put("testEnable", bVar.n().v());
            jSONObject2.put("appVersion", bVar.n().w());
            jSONObject2.put("appVersionName", bVar.n().w());
            jSONObject2.put("screenWidth", bVar.n().y());
            jSONObject2.put("screenHeight", bVar.n().z());
            jSONObject2.put("screenDensity", bVar.n().A());
            jSONObject2.put("netType", bVar.n().x());
            jSONObject2.put("appName", bVar.n().C());
            jSONObject2.put("expInfo", bVar.n().B());
            jSONObject2.put("phone", bVar.n().getPhone());
            for (n nVar : bVar.o()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("startTime", nVar.N());
                jSONObject3.put("endTime", nVar.O());
                jSONObject3.put("keepTime", nVar.P());
                jSONObject3.put("sessionId", nVar.I());
                jSONArray.put(jSONObject3);
            }
            for (l lVar : bVar.p()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("pagerName", lVar.E());
                jSONObject4.put("sessionId", lVar.I());
                jSONObject4.put("endTime", lVar.O());
                jSONObject4.put("startTime", lVar.N());
                jSONObject4.put("path", lVar.getPath());
                jSONArray2.put(jSONObject4);
            }
            for (com.baidu.ubs.analytics.a.a aVar : bVar.getEvents()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("type", aVar.G());
                jSONObject5.put("sessionId", aVar.I());
                jSONObject5.put("ext", aVar.H());
                jSONObject5.put("timeStamp", aVar.F());
                jSONObject5.put("page", aVar.E());
                jSONObject5.put("from", aVar.D());
                jSONArray3.put(jSONObject5);
            }
            for (com.baidu.ubs.analytics.a.i iVar : bVar.q()) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", iVar.getUrl());
                jSONObject6.put("sessionId", iVar.I());
                jSONObject6.put("method", iVar.getType());
                jSONObject6.put("timeStamp", iVar.F());
                jSONObject6.put(PushConstants.PARAMS, iVar.M());
                jSONArray4.put(jSONObject6);
            }
            jSONObject.put("deviceinfo", jSONObject2);
            jSONObject.put("sessions", jSONArray);
            jSONObject.put("events", jSONArray3);
            jSONObject.put("pagers", jSONArray2);
            jSONObject.put("nets", jSONArray4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
