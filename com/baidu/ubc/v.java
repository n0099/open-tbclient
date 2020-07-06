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
    private String cla;
    private int dvb;
    private JSONObject dvc;
    private List<k> dvd = new ArrayList();
    private JSONObject mEn;
    private JSONObject mEo;
    private JSONObject mEp;
    private String mEq;
    private String mEr;
    private int mThreshold;

    public v(String str, JSONObject jSONObject) {
        this.cla = str;
        this.dvc = jSONObject;
    }

    public int aJO() {
        return this.mThreshold;
    }

    public int aJP() {
        return this.dvb;
    }

    public List<k> aJQ() {
        return this.dvd;
    }

    public void ev(List<k> list) {
        this.dvd = list;
    }

    public String dwS() {
        return this.mEq;
    }

    public String dwT() {
        return this.mEr;
    }

    public JSONObject dwU() {
        return this.mEp;
    }

    public JSONObject dwV() {
        return this.mEn;
    }

    private void dO(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.mEn.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.mEn.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.mEn.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.mEn.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.mEn.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aJR() {
        try {
            if (this.dvc == null) {
                return false;
            }
            JSONObject jSONObject = this.dvc;
            this.mEo = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dvb = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.mEr = jSONObject.optString("step");
            this.mEq = jSONObject.optString("replace");
            this.mEp = jSONObject.optJSONObject("del");
            if (this.mEo != null) {
                this.mEn = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.mEo.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.mEo.getJSONObject(next);
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
                                        kVar.jH(jSONObject4.getInt("rate"));
                                    }
                                    if (jSONObject4.has("c")) {
                                        kVar.setCategory(jSONObject4.getString("c"));
                                    }
                                    if (jSONObject4.has("limitUnit")) {
                                        kVar.jI(jSONObject4.getInt("limitUnit"));
                                    }
                                    if (jSONObject4.has("limitCnt")) {
                                        kVar.jJ(jSONObject4.getInt("limitCnt"));
                                    }
                                    if (jSONObject4.has("idtype")) {
                                        kVar.tV(jSONObject4.getString("idtype"));
                                    }
                                    if (jSONObject4.has("ch")) {
                                        kVar.PT(jSONObject4.getString("ch"));
                                    }
                                    if (jSONObject4.has("dfc")) {
                                        kVar.PU(jSONObject4.getString("dfc"));
                                    }
                                    if (jSONObject4.has("reallog")) {
                                        kVar.PV(jSONObject4.getString("reallog"));
                                    }
                                    if (jSONObject4.has("gflow")) {
                                        String string6 = jSONObject4.getString("gflow");
                                        if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                            kVar.PW(string6);
                                        }
                                    }
                                    kVar.setVersion(string);
                                    this.dvd.add(kVar);
                                }
                            }
                        }
                    }
                }
                this.mEn.put("set", jSONObject2);
                dO(jSONObject);
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
