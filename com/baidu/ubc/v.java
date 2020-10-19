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
    private int dYk;
    private JSONObject dYl;
    private List<k> dYm = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject nFd;
    private JSONObject nFe;
    private JSONObject nFf;
    private String nFg;
    private String nFh;

    public v(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.dYl = jSONObject;
    }

    public int aZz() {
        return this.mThreshold;
    }

    public int aZA() {
        return this.dYk;
    }

    public List<k> aZB() {
        return this.dYm;
    }

    public void eU(List<k> list) {
        this.dYm = list;
    }

    public String dTM() {
        return this.nFg;
    }

    public String dTN() {
        return this.nFh;
    }

    public JSONObject dTO() {
        return this.nFf;
    }

    private void es(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.nFd.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.nFd.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.nFd.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.nFd.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.nFd.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aZC() {
        try {
            if (this.dYl == null) {
                return false;
            }
            JSONObject jSONObject = this.dYl;
            this.nFe = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dYk = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.nFh = jSONObject.optString("step");
            this.nFg = jSONObject.optString("replace");
            this.nFf = jSONObject.optJSONObject("del");
            if (this.nFe != null) {
                this.nFd = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.nFe.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.nFe.getJSONObject(next);
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
                                    kVar.mO(jSONObject4.getInt("rate"));
                                }
                                if (jSONObject4.has("c")) {
                                    kVar.setCategory(jSONObject4.getString("c"));
                                }
                                if (jSONObject4.has("limitUnit")) {
                                    kVar.mP(jSONObject4.getInt("limitUnit"));
                                }
                                if (jSONObject4.has("limitCnt")) {
                                    kVar.mQ(jSONObject4.getInt("limitCnt"));
                                }
                                if (jSONObject4.has("idtype")) {
                                    kVar.yp(jSONObject4.getString("idtype"));
                                }
                                if (jSONObject4.has("ch")) {
                                    kVar.US(jSONObject4.getString("ch"));
                                }
                                if (jSONObject4.has("dfc")) {
                                    kVar.UT(jSONObject4.getString("dfc"));
                                }
                                if (jSONObject4.has("reallog")) {
                                    kVar.UU(jSONObject4.getString("reallog"));
                                }
                                if (jSONObject4.has("gflow")) {
                                    String string6 = jSONObject4.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.UV(string6);
                                    }
                                }
                                if (jSONObject4.has("uploadType")) {
                                    String string7 = jSONObject4.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.UW(string7);
                                    }
                                }
                                kVar.setVersion(string);
                                this.dYm.add(kVar);
                            }
                        }
                    }
                }
                this.nFd.put("set", jSONObject2);
                es(jSONObject);
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
