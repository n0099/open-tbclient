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
    private int egH;
    private JSONObject egI;
    private List<k> egJ = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject ohF;
    private JSONObject ohG;
    private JSONObject ohH;
    private String ohI;
    private String ohJ;

    public v(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.egI = jSONObject;
    }

    public int bbs() {
        return this.mThreshold;
    }

    public int bbt() {
        return this.egH;
    }

    public List<k> bbu() {
        return this.egJ;
    }

    public void fd(List<k> list) {
        this.egJ = list;
    }

    public String dZE() {
        return this.ohI;
    }

    public String dZF() {
        return this.ohJ;
    }

    public JSONObject dZG() {
        return this.ohH;
    }

    private void ez(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.ohF.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.ohF.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.ohF.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.ohF.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.ohF.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean bbv() {
        try {
            if (this.egI == null) {
                return false;
            }
            JSONObject jSONObject = this.egI;
            this.ohG = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.egH = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.ohJ = jSONObject.optString("step");
            this.ohI = jSONObject.optString("replace");
            this.ohH = jSONObject.optJSONObject("del");
            if (this.ohG != null) {
                this.ohF = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.ohG.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.ohG.getJSONObject(next);
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
                                    kVar.mZ(jSONObject4.getInt("rate"));
                                }
                                if (jSONObject4.has("c")) {
                                    kVar.setCategory(jSONObject4.getString("c"));
                                }
                                if (jSONObject4.has("limitUnit")) {
                                    kVar.na(jSONObject4.getInt("limitUnit"));
                                }
                                if (jSONObject4.has("limitCnt")) {
                                    kVar.nb(jSONObject4.getInt("limitCnt"));
                                }
                                if (jSONObject4.has("idtype")) {
                                    kVar.yI(jSONObject4.getString("idtype"));
                                }
                                if (jSONObject4.has("ch")) {
                                    kVar.Wg(jSONObject4.getString("ch"));
                                }
                                if (jSONObject4.has("dfc")) {
                                    kVar.Wh(jSONObject4.getString("dfc"));
                                }
                                if (jSONObject4.has("reallog")) {
                                    kVar.Wi(jSONObject4.getString("reallog"));
                                }
                                if (jSONObject4.has("gflow")) {
                                    String string6 = jSONObject4.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.Wj(string6);
                                    }
                                }
                                if (jSONObject4.has("uploadType")) {
                                    String string7 = jSONObject4.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.Wk(string7);
                                    }
                                }
                                kVar.setVersion(string);
                                this.egJ.add(kVar);
                            }
                        }
                    }
                }
                this.ohF.put("set", jSONObject2);
                ez(jSONObject);
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
