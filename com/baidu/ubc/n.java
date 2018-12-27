package com.baidu.ubc;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class n {
    private int ifi;
    private String ifj;
    private JSONObject ifk;
    private List<h> ifl = new ArrayList();
    private int mThreshold;

    public n(String str, JSONObject jSONObject) {
        this.ifj = str;
        this.ifk = jSONObject;
    }

    public String bSb() {
        return this.ifj;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int bSc() {
        return this.ifi;
    }

    public List<h> bSd() {
        return this.ifl;
    }

    public boolean bSe() {
        try {
            JSONObject jSONObject = this.ifk;
            this.mThreshold = jSONObject.getInt("threshold");
            this.ifi = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("id");
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int i2 = jSONObject2.getInt(AiAppsBluetoothConstants.KEY_TIME_OUT);
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    h hVar = new h(string, string2, string3, i2, string5, string4);
                    if (jSONObject2.has("rate")) {
                        hVar.xP(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        hVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        hVar.xQ(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        hVar.xR(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        hVar.yi(jSONObject2.getString("idtype"));
                    }
                    this.ifl.add(hVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
