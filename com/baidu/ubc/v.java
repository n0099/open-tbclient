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
/* loaded from: classes12.dex */
public class v {
    private static final boolean DEBUG = AppConfig.isDebug();
    private String bVL;
    private int dep;
    private JSONObject deq;
    private List<k> der = new ArrayList();
    private JSONObject lNM;
    private JSONObject lNN;
    private JSONObject lNO;
    private String lNP;
    private String lNQ;
    private int mThreshold;

    public v(String str, JSONObject jSONObject) {
        this.bVL = str;
        this.deq = jSONObject;
    }

    public int aDZ() {
        return this.mThreshold;
    }

    public int aEa() {
        return this.dep;
    }

    public List<k> aEb() {
        return this.der;
    }

    public void eS(List<k> list) {
        this.der = list;
    }

    public String dkH() {
        return this.lNP;
    }

    public String dkI() {
        return this.lNQ;
    }

    public JSONObject dkJ() {
        return this.lNO;
    }

    public JSONObject dkK() {
        return this.lNM;
    }

    private void dx(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.lNM.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.lNM.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.lNM.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.lNM.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.lNM.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aEc() {
        try {
            if (this.deq == null) {
                return false;
            }
            JSONObject jSONObject = this.deq;
            this.lNN = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dep = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.lNQ = jSONObject.optString("step");
            this.lNP = jSONObject.optString("replace");
            this.lNO = jSONObject.optJSONObject("del");
            if (this.lNN != null) {
                this.lNM = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.lNN.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.lNN.getJSONObject(next);
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
                                        kVar.jb(jSONObject4.getInt("rate"));
                                    }
                                    if (jSONObject4.has("c")) {
                                        kVar.setCategory(jSONObject4.getString("c"));
                                    }
                                    if (jSONObject4.has("limitUnit")) {
                                        kVar.jc(jSONObject4.getInt("limitUnit"));
                                    }
                                    if (jSONObject4.has("limitCnt")) {
                                        kVar.jd(jSONObject4.getInt("limitCnt"));
                                    }
                                    if (jSONObject4.has("idtype")) {
                                        kVar.si(jSONObject4.getString("idtype"));
                                    }
                                    if (jSONObject4.has("ch")) {
                                        kVar.Np(jSONObject4.getString("ch"));
                                    }
                                    if (jSONObject4.has("dfc")) {
                                        kVar.Nq(jSONObject4.getString("dfc"));
                                    }
                                    if (jSONObject4.has("reallog")) {
                                        kVar.Nr(jSONObject4.getString("reallog"));
                                    }
                                    if (jSONObject4.has("gflow")) {
                                        String string6 = jSONObject4.getString("gflow");
                                        if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                            kVar.Ns(string6);
                                        }
                                    }
                                    kVar.setVersion(string);
                                    this.der.add(kVar);
                                }
                            }
                        }
                    }
                }
                this.lNM.put("set", jSONObject2);
                dx(jSONObject);
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
