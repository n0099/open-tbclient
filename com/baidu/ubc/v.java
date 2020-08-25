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
/* loaded from: classes8.dex */
public class v {
    private static final boolean DEBUG = AppConfig.isDebug();
    private String cuH;
    private int dKb;
    private JSONObject dKc;
    private List<k> dKd = new ArrayList();
    private int mThreshold;
    private JSONObject nfp;
    private JSONObject nfq;
    private JSONObject nfr;
    private String nfs;
    private String nft;

    public v(String str, JSONObject jSONObject) {
        this.cuH = str;
        this.dKc = jSONObject;
    }

    public int aWf() {
        return this.mThreshold;
    }

    public int aWg() {
        return this.dKb;
    }

    public List<k> aWh() {
        return this.dKd;
    }

    public void eJ(List<k> list) {
        this.dKd = list;
    }

    public String dLT() {
        return this.nfs;
    }

    public String dLU() {
        return this.nft;
    }

    public JSONObject dLV() {
        return this.nfr;
    }

    public JSONObject dLW() {
        return this.nfp;
    }

    private void eg(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.nfp.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.nfp.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.nfp.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.nfp.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.nfp.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aWi() {
        try {
            if (this.dKc == null) {
                return false;
            }
            JSONObject jSONObject = this.dKc;
            this.nfq = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dKb = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.nft = jSONObject.optString("step");
            this.nfs = jSONObject.optString("replace");
            this.nfr = jSONObject.optJSONObject("del");
            if (this.nfq != null) {
                this.nfp = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.nfq.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.nfq.getJSONObject(next);
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
                                        kVar.mg(jSONObject4.getInt("rate"));
                                    }
                                    if (jSONObject4.has("c")) {
                                        kVar.setCategory(jSONObject4.getString("c"));
                                    }
                                    if (jSONObject4.has("limitUnit")) {
                                        kVar.mh(jSONObject4.getInt("limitUnit"));
                                    }
                                    if (jSONObject4.has("limitCnt")) {
                                        kVar.mi(jSONObject4.getInt("limitCnt"));
                                    }
                                    if (jSONObject4.has("idtype")) {
                                        kVar.xj(jSONObject4.getString("idtype"));
                                    }
                                    if (jSONObject4.has("ch")) {
                                        kVar.TD(jSONObject4.getString("ch"));
                                    }
                                    if (jSONObject4.has("dfc")) {
                                        kVar.TE(jSONObject4.getString("dfc"));
                                    }
                                    if (jSONObject4.has("reallog")) {
                                        kVar.TF(jSONObject4.getString("reallog"));
                                    }
                                    if (jSONObject4.has("gflow")) {
                                        String string6 = jSONObject4.getString("gflow");
                                        if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                            kVar.TG(string6);
                                        }
                                    }
                                    kVar.setVersion(string);
                                    this.dKd.add(kVar);
                                }
                            }
                        }
                    }
                }
                this.nfp.put("set", jSONObject2);
                eg(jSONObject);
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
