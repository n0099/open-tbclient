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
    private List<k> emA = new ArrayList();
    private int emy;
    private JSONObject emz;
    private String mSign;
    private int mThreshold;
    private JSONObject oqK;
    private JSONObject oqL;
    private JSONObject oqM;
    private String oqN;
    private String oqO;

    public v(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.emz = jSONObject;
    }

    public int bdS() {
        return this.mThreshold;
    }

    public int bdT() {
        return this.emy;
    }

    public List<k> bdU() {
        return this.emA;
    }

    public void fl(List<k> list) {
        this.emA = list;
    }

    public String edm() {
        return this.oqN;
    }

    public String edn() {
        return this.oqO;
    }

    public JSONObject edo() {
        return this.oqM;
    }

    private void eF(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.oqK.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.oqK.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.oqK.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.oqK.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.oqK.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean bdV() {
        try {
            if (this.emz == null) {
                return false;
            }
            JSONObject jSONObject = this.emz;
            this.oqL = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.emy = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oqO = jSONObject.optString("step");
            this.oqN = jSONObject.optString("replace");
            this.oqM = jSONObject.optJSONObject("del");
            if (this.oqL != null) {
                this.oqK = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.oqL.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.oqL.getJSONObject(next);
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
                                    kVar.nj(jSONObject4.getInt("rate"));
                                }
                                if (jSONObject4.has("c")) {
                                    kVar.setCategory(jSONObject4.getString("c"));
                                }
                                if (jSONObject4.has("limitUnit")) {
                                    kVar.nk(jSONObject4.getInt("limitUnit"));
                                }
                                if (jSONObject4.has("limitCnt")) {
                                    kVar.nl(jSONObject4.getInt("limitCnt"));
                                }
                                if (jSONObject4.has("idtype")) {
                                    kVar.yW(jSONObject4.getString("idtype"));
                                }
                                if (jSONObject4.has("ch")) {
                                    kVar.WJ(jSONObject4.getString("ch"));
                                }
                                if (jSONObject4.has("dfc")) {
                                    kVar.WK(jSONObject4.getString("dfc"));
                                }
                                if (jSONObject4.has("reallog")) {
                                    kVar.WL(jSONObject4.getString("reallog"));
                                }
                                if (jSONObject4.has("gflow")) {
                                    String string6 = jSONObject4.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.WM(string6);
                                    }
                                }
                                if (jSONObject4.has("uploadType")) {
                                    String string7 = jSONObject4.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.WN(string7);
                                    }
                                }
                                kVar.setVersion(string);
                                this.emA.add(kVar);
                            }
                        }
                    }
                }
                this.oqK.put("set", jSONObject2);
                eF(jSONObject);
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
