package com.baidu.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class v {
    private static final boolean DEBUG = AppConfig.isDebug();
    private String cwM;
    private int dMj;
    private JSONObject dMk;
    private List<k> dMl = new ArrayList();
    private int mThreshold;
    private JSONObject npJ;
    private JSONObject npK;
    private JSONObject npL;
    private String npM;
    private String npN;

    public v(String str, JSONObject jSONObject) {
        this.cwM = str;
        this.dMk = jSONObject;
    }

    public int aWR() {
        return this.mThreshold;
    }

    public int aWS() {
        return this.dMj;
    }

    public List<k> aWT() {
        return this.dMl;
    }

    public void eR(List<k> list) {
        this.dMl = list;
    }

    public String dQb() {
        return this.npM;
    }

    public String dQc() {
        return this.npN;
    }

    public JSONObject dQd() {
        return this.npL;
    }

    private void eo(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.npJ.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.npJ.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.npJ.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.npJ.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.npJ.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aWU() {
        try {
            if (this.dMk == null) {
                return false;
            }
            JSONObject jSONObject = this.dMk;
            this.npK = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dMj = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.npN = jSONObject.optString("step");
            this.npM = jSONObject.optString("replace");
            this.npL = jSONObject.optJSONObject("del");
            if (this.npK != null) {
                this.npJ = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.npK.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.npK.getJSONObject(next);
                    if (jSONObject3 != null) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                        String string = jSONObject3.getString("version");
                        if (jSONObject4 != null && !TextUtils.isEmpty(string)) {
                            String optString = jSONObject4.optString("sdkType");
                            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "1")) {
                                jSONObject2.put(next, jSONObject3);
                            }
                            String string2 = jSONObject4.getString("switch");
                            String string3 = jSONObject4.getString("isreal");
                            String string4 = jSONObject4.getString("isAbtest");
                            int i = jSONObject4.getInt("timeout");
                            String string5 = jSONObject4.getString("type");
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                                k kVar = new k(next, string2, string3, i, string5, string4);
                                if (jSONObject4.has("rate")) {
                                    kVar.mr(jSONObject4.getInt("rate"));
                                }
                                if (jSONObject4.has("c")) {
                                    kVar.setCategory(jSONObject4.getString("c"));
                                }
                                if (jSONObject4.has("limitUnit")) {
                                    kVar.ms(jSONObject4.getInt("limitUnit"));
                                }
                                if (jSONObject4.has("limitCnt")) {
                                    kVar.mt(jSONObject4.getInt("limitCnt"));
                                }
                                if (jSONObject4.has("idtype")) {
                                    kVar.xD(jSONObject4.getString("idtype"));
                                }
                                if (jSONObject4.has("ch")) {
                                    kVar.Ue(jSONObject4.getString("ch"));
                                }
                                if (jSONObject4.has("dfc")) {
                                    kVar.Uf(jSONObject4.getString("dfc"));
                                }
                                if (jSONObject4.has("reallog")) {
                                    kVar.Ug(jSONObject4.getString("reallog"));
                                }
                                if (jSONObject4.has("gflow")) {
                                    String string6 = jSONObject4.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.Uh(string6);
                                    }
                                }
                                if (jSONObject4.has("uploadType")) {
                                    String string7 = jSONObject4.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.Ui(string7);
                                    }
                                }
                                kVar.setVersion(string);
                                this.dMl.add(kVar);
                            }
                        }
                    }
                }
                this.npJ.put("set", jSONObject2);
                eo(jSONObject);
            }
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("OriginalConfigData", e.getMessage());
            }
            return false;
        }
    }
}
