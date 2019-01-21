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
    private int igq;
    private String igr;
    private JSONObject igs;
    private List<h> igt = new ArrayList();
    private int mThreshold;

    public n(String str, JSONObject jSONObject) {
        this.igr = str;
        this.igs = jSONObject;
    }

    public String bSJ() {
        return this.igr;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int bSK() {
        return this.igq;
    }

    public List<h> bSL() {
        return this.igt;
    }

    public boolean bSM() {
        try {
            JSONObject jSONObject = this.igs;
            this.mThreshold = jSONObject.getInt("threshold");
            this.igq = jSONObject.getInt("timeup");
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
                        hVar.xR(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        hVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        hVar.xS(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        hVar.xT(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        hVar.yy(jSONObject2.getString("idtype"));
                    }
                    this.igt.add(hVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
