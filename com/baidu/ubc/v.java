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
/* loaded from: classes11.dex */
public class v {
    private static final boolean DEBUG = AppConfig.isDebug();
    private String cne;
    private int dAR;
    private JSONObject dAS;
    private List<k> dAT = new ArrayList();
    private JSONObject mMt;
    private JSONObject mMu;
    private JSONObject mMv;
    private String mMw;
    private String mMx;
    private int mThreshold;

    public v(String str, JSONObject jSONObject) {
        this.cne = str;
        this.dAS = jSONObject;
    }

    public int aNF() {
        return this.mThreshold;
    }

    public int aNG() {
        return this.dAR;
    }

    public List<k> aNH() {
        return this.dAT;
    }

    public void eB(List<k> list) {
        this.dAT = list;
    }

    public String dAg() {
        return this.mMw;
    }

    public String dAh() {
        return this.mMx;
    }

    public JSONObject dAi() {
        return this.mMv;
    }

    public JSONObject dAj() {
        return this.mMt;
    }

    private void dV(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.mMt.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.mMt.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.mMt.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.mMt.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.mMt.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aNI() {
        try {
            if (this.dAS == null) {
                return false;
            }
            JSONObject jSONObject = this.dAS;
            this.mMu = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dAR = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.mMx = jSONObject.optString("step");
            this.mMw = jSONObject.optString("replace");
            this.mMv = jSONObject.optJSONObject("del");
            if (this.mMu != null) {
                this.mMt = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.mMu.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.mMu.getJSONObject(next);
                    if (jSONObject3 != null) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                        String string = jSONObject3.getString("version");
                        if (jSONObject4 != null && !TextUtils.isEmpty(string)) {
                            String optString = jSONObject4.optString("sdkType");
                            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "1")) {
                                jSONObject2.put(next, jSONObject3);
                            } else {
                                String string2 = jSONObject4.getString("switch");
                                String string3 = jSONObject4.getString("isreal");
                                String string4 = jSONObject4.getString("isAbtest");
                                int i = jSONObject4.getInt("timeout");
                                String string5 = jSONObject4.getString("type");
                                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                                    k kVar = new k(next, string2, string3, i, string5, string4);
                                    if (jSONObject4.has("rate")) {
                                        kVar.ka(jSONObject4.getInt("rate"));
                                    }
                                    if (jSONObject4.has("c")) {
                                        kVar.setCategory(jSONObject4.getString("c"));
                                    }
                                    if (jSONObject4.has("limitUnit")) {
                                        kVar.kb(jSONObject4.getInt("limitUnit"));
                                    }
                                    if (jSONObject4.has("limitCnt")) {
                                        kVar.kc(jSONObject4.getInt("limitCnt"));
                                    }
                                    if (jSONObject4.has("idtype")) {
                                        kVar.uY(jSONObject4.getString("idtype"));
                                    }
                                    if (jSONObject4.has("ch")) {
                                        kVar.QE(jSONObject4.getString("ch"));
                                    }
                                    if (jSONObject4.has("dfc")) {
                                        kVar.QF(jSONObject4.getString("dfc"));
                                    }
                                    if (jSONObject4.has("reallog")) {
                                        kVar.QG(jSONObject4.getString("reallog"));
                                    }
                                    if (jSONObject4.has("gflow")) {
                                        String string6 = jSONObject4.getString("gflow");
                                        if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                            kVar.QH(string6);
                                        }
                                    }
                                    kVar.setVersion(string);
                                    this.dAT.add(kVar);
                                }
                            }
                        }
                    }
                }
                this.mMt.put("set", jSONObject2);
                dV(jSONObject);
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
