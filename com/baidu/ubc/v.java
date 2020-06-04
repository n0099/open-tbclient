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
    private String cgm;
    private int dqp;
    private JSONObject dqq;
    private List<k> dqr = new ArrayList();
    private int mThreshold;
    private JSONObject mir;
    private JSONObject mis;
    private JSONObject mit;
    private String miu;
    private String miv;

    public v(String str, JSONObject jSONObject) {
        this.cgm = str;
        this.dqq = jSONObject;
    }

    public int aII() {
        return this.mThreshold;
    }

    public int aIJ() {
        return this.dqp;
    }

    public List<k> aIK() {
        return this.dqr;
    }

    public void fb(List<k> list) {
        this.dqr = list;
    }

    public String dsj() {
        return this.miu;
    }

    public String dsk() {
        return this.miv;
    }

    public JSONObject dsl() {
        return this.mit;
    }

    public JSONObject dsm() {
        return this.mir;
    }

    private void dE(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.mir.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.mir.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.mir.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.mir.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.mir.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean aIL() {
        try {
            if (this.dqq == null) {
                return false;
            }
            JSONObject jSONObject = this.dqq;
            this.mis = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dqp = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.miv = jSONObject.optString("step");
            this.miu = jSONObject.optString("replace");
            this.mit = jSONObject.optJSONObject("del");
            if (this.mis != null) {
                this.mir = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.mis.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.mis.getJSONObject(next);
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
                                        kVar.jw(jSONObject4.getInt("rate"));
                                    }
                                    if (jSONObject4.has("c")) {
                                        kVar.setCategory(jSONObject4.getString("c"));
                                    }
                                    if (jSONObject4.has("limitUnit")) {
                                        kVar.jx(jSONObject4.getInt("limitUnit"));
                                    }
                                    if (jSONObject4.has("limitCnt")) {
                                        kVar.jy(jSONObject4.getInt("limitCnt"));
                                    }
                                    if (jSONObject4.has("idtype")) {
                                        kVar.tN(jSONObject4.getString("idtype"));
                                    }
                                    if (jSONObject4.has("ch")) {
                                        kVar.Pg(jSONObject4.getString("ch"));
                                    }
                                    if (jSONObject4.has("dfc")) {
                                        kVar.Ph(jSONObject4.getString("dfc"));
                                    }
                                    if (jSONObject4.has("reallog")) {
                                        kVar.Pi(jSONObject4.getString("reallog"));
                                    }
                                    if (jSONObject4.has("gflow")) {
                                        String string6 = jSONObject4.getString("gflow");
                                        if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                            kVar.Pj(string6);
                                        }
                                    }
                                    kVar.setVersion(string);
                                    this.dqr.add(kVar);
                                }
                            }
                        }
                    }
                }
                this.mir.put("set", jSONObject2);
                dE(jSONObject);
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
