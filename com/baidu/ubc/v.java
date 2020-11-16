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
/* loaded from: classes17.dex */
public class v {
    private static final boolean DEBUG = AppConfig.isDebug();
    private int ekR;
    private JSONObject ekS;
    private List<k> ekT = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject oso;
    private JSONObject osp;
    private JSONObject osq;
    private String osr;
    private String oss;

    public v(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.ekS = jSONObject;
    }

    public int bdl() {
        return this.mThreshold;
    }

    public int bdm() {
        return this.ekR;
    }

    public List<k> bdn() {
        return this.ekT;
    }

    public void fl(List<k> list) {
        this.ekT = list;
    }

    public String edl() {
        return this.osr;
    }

    public String edm() {
        return this.oss;
    }

    public JSONObject edn() {
        return this.osq;
    }

    private void eA(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("threshold") > 0) {
                    this.oso.put("threshold", jSONObject.optString("threshold"));
                }
                if (jSONObject.optInt("timeup") > 0) {
                    this.oso.put("timeup", jSONObject.optString("timeup"));
                }
                if (jSONObject.optString("step") != null) {
                    this.oso.put("step", jSONObject.optString("step"));
                }
                if (jSONObject.optString("replace") != null) {
                    this.oso.put("replace", jSONObject.optString("replace"));
                }
                if (jSONObject.optJSONObject("del") != null) {
                    this.oso.put("del", jSONObject.optJSONObject("del"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("OriginalConfigData", e.getMessage());
                }
            }
        }
    }

    public boolean bdo() {
        try {
            if (this.ekS == null) {
                return false;
            }
            JSONObject jSONObject = this.ekS;
            this.osp = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.ekR = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oss = jSONObject.optString("step");
            this.osr = jSONObject.optString("replace");
            this.osq = jSONObject.optJSONObject("del");
            if (this.osp != null) {
                this.oso = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = this.osp.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = this.osp.getJSONObject(next);
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
                                    kVar.nf(jSONObject4.getInt("rate"));
                                }
                                if (jSONObject4.has("c")) {
                                    kVar.setCategory(jSONObject4.getString("c"));
                                }
                                if (jSONObject4.has("limitUnit")) {
                                    kVar.ng(jSONObject4.getInt("limitUnit"));
                                }
                                if (jSONObject4.has("limitCnt")) {
                                    kVar.nh(jSONObject4.getInt("limitCnt"));
                                }
                                if (jSONObject4.has("idtype")) {
                                    kVar.yR(jSONObject4.getString("idtype"));
                                }
                                if (jSONObject4.has("ch")) {
                                    kVar.Wu(jSONObject4.getString("ch"));
                                }
                                if (jSONObject4.has("dfc")) {
                                    kVar.Wv(jSONObject4.getString("dfc"));
                                }
                                if (jSONObject4.has("reallog")) {
                                    kVar.Ww(jSONObject4.getString("reallog"));
                                }
                                if (jSONObject4.has("gflow")) {
                                    String string6 = jSONObject4.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.Wx(string6);
                                    }
                                }
                                if (jSONObject4.has("uploadType")) {
                                    String string7 = jSONObject4.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.Wy(string7);
                                    }
                                }
                                kVar.setVersion(string);
                                this.ekT.add(kVar);
                            }
                        }
                    }
                }
                this.oso.put("set", jSONObject2);
                eA(jSONObject);
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
