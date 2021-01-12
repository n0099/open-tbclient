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
/* loaded from: classes3.dex */
public class w {
    private static final boolean DEBUG = AppConfig.isDebug();
    private int ewP;
    private JSONObject ewQ;
    private List<k> ewR = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject oIY;
    private JSONObject oIZ;
    private String oJa;
    private String oJb;
    private int oJc;
    private int oJd;

    public w(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.ewQ = jSONObject;
    }

    public int beU() {
        return this.mThreshold;
    }

    public int beV() {
        return this.ewP;
    }

    public List<k> beW() {
        return this.ewR;
    }

    public void fx(List<k> list) {
        this.ewR = list;
    }

    public String efp() {
        return this.oJb;
    }

    public JSONObject efq() {
        return this.oIZ;
    }

    public int efr() {
        return this.oJc;
    }

    public int efs() {
        return this.oJd;
    }

    public boolean beX() {
        try {
            if (this.ewQ == null) {
                return false;
            }
            JSONObject jSONObject = this.ewQ;
            this.oIY = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.ewP = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oJb = jSONObject.optString("step");
            this.oJa = jSONObject.optString("replace");
            this.oIZ = jSONObject.optJSONObject("del");
            this.oJc = jSONObject.optInt("all_size", 614400);
            this.oJd = jSONObject.optInt("single_size", 153600);
            if (this.oIY != null) {
                Iterator<String> keys = this.oIY.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = this.oIY.getJSONObject(next);
                    if (jSONObject2 != null) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                        String string = jSONObject2.getString("version");
                        if (jSONObject3 != null && !TextUtils.isEmpty(string)) {
                            String string2 = jSONObject3.getString("switch");
                            String string3 = jSONObject3.getString("isreal");
                            String string4 = jSONObject3.getString("isAbtest");
                            int i = jSONObject3.getInt("timeout");
                            String string5 = jSONObject3.getString("type");
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                                k kVar = new k(next, string2, string3, i, string5, string4);
                                if (jSONObject3.has("rate")) {
                                    kVar.mg(jSONObject3.getInt("rate"));
                                }
                                if (jSONObject3.has("c")) {
                                    kVar.setCategory(jSONObject3.getString("c"));
                                }
                                if (jSONObject3.has("limitUnit")) {
                                    kVar.mh(jSONObject3.getInt("limitUnit"));
                                }
                                if (jSONObject3.has("limitCnt")) {
                                    kVar.mi(jSONObject3.getInt("limitCnt"));
                                }
                                if (jSONObject3.has("idtype")) {
                                    kVar.ym(jSONObject3.getString("idtype"));
                                }
                                if (jSONObject3.has("ch")) {
                                    kVar.Wk(jSONObject3.getString("ch"));
                                }
                                if (jSONObject3.has("dfc")) {
                                    kVar.Wl(jSONObject3.getString("dfc"));
                                }
                                if (jSONObject3.has("reallog")) {
                                    kVar.Wm(jSONObject3.getString("reallog"));
                                }
                                if (jSONObject3.has("gflow")) {
                                    String string6 = jSONObject3.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.Wn(string6);
                                    }
                                }
                                if (jSONObject3.has("uploadType")) {
                                    String string7 = jSONObject3.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.Wo(string7);
                                    }
                                }
                                int optInt = jSONObject3.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    kVar.MM(optInt);
                                }
                                kVar.setVersion(string);
                                this.ewR.add(kVar);
                            }
                        }
                    }
                }
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
