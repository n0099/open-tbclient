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
    private String bVR;
    private int dev;
    private JSONObject dew;
    private List<k> dex = new ArrayList();
    private JSONObject lNQ;
    private JSONObject lNR;
    private JSONObject lNS;
    private String lNT;
    private String lNU;
    private int mThreshold;

    public v(String str, JSONObject jSONObject) {
        this.bVR = str;
        this.dew = jSONObject;
    }

    public int aDZ() {
        return this.mThreshold;
    }

    public int aEa() {
        return this.dev;
    }

    public List<k> aEb() {
        return this.dex;
    }

    public void eS(List<k> list) {
        this.dex = list;
    }

    public String dkE() {
        return this.lNT;
    }

    public String dkF() {
        return this.lNU;
    }

    public JSONObject dkG() {
        return this.lNS;
    }

    public JSONObject dkH() {
        return this.lNQ;
    }

    private void dx(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.lNQ.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.lNQ.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.lNQ.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.lNQ.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.lNQ.put("del", jSONObject.optJSONObject("del"));
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
            if (this.dew == null) {
                return false;
            }
            JSONObject jSONObject = this.dew;
            this.lNR = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.dev = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.lNU = jSONObject.optString("step");
            this.lNT = jSONObject.optString("replace");
            this.lNS = jSONObject.optJSONObject("del");
            if (this.lNR != null) {
                this.lNQ = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.lNR.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.lNR.getJSONObject(next);
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
                                        kVar.Ns(jSONObject4.getString("ch"));
                                    }
                                    if (jSONObject4.has("dfc")) {
                                        kVar.Nt(jSONObject4.getString("dfc"));
                                    }
                                    if (jSONObject4.has("reallog")) {
                                        kVar.Nu(jSONObject4.getString("reallog"));
                                    }
                                    if (jSONObject4.has("gflow")) {
                                        String string6 = jSONObject4.getString("gflow");
                                        if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                            kVar.Nv(string6);
                                        }
                                    }
                                    kVar.setVersion(string);
                                    this.dex.add(kVar);
                                }
                            }
                        }
                    }
                }
                this.lNQ.put("set", jSONObject2);
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
