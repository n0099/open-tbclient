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
    private int eBE;
    private JSONObject eBF;
    private List<k> eBG = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject oND;
    private JSONObject oNE;
    private String oNF;
    private String oNG;
    private int oNH;
    private int oNI;

    public w(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.eBF = jSONObject;
    }

    public int biN() {
        return this.mThreshold;
    }

    public int biO() {
        return this.eBE;
    }

    public List<k> biP() {
        return this.eBG;
    }

    public void fx(List<k> list) {
        this.eBG = list;
    }

    public String ejg() {
        return this.oNG;
    }

    public JSONObject ejh() {
        return this.oNE;
    }

    public int eji() {
        return this.oNH;
    }

    public int ejj() {
        return this.oNI;
    }

    public boolean biQ() {
        try {
            if (this.eBF == null) {
                return false;
            }
            JSONObject jSONObject = this.eBF;
            this.oND = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.eBE = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oNG = jSONObject.optString("step");
            this.oNF = jSONObject.optString("replace");
            this.oNE = jSONObject.optJSONObject("del");
            this.oNH = jSONObject.optInt("all_size", 614400);
            this.oNI = jSONObject.optInt("single_size", 153600);
            if (this.oND != null) {
                Iterator<String> keys = this.oND.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = this.oND.getJSONObject(next);
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
                                    kVar.nM(jSONObject3.getInt("rate"));
                                }
                                if (jSONObject3.has("c")) {
                                    kVar.setCategory(jSONObject3.getString("c"));
                                }
                                if (jSONObject3.has("limitUnit")) {
                                    kVar.nN(jSONObject3.getInt("limitUnit"));
                                }
                                if (jSONObject3.has("limitCnt")) {
                                    kVar.nO(jSONObject3.getInt("limitCnt"));
                                }
                                if (jSONObject3.has("idtype")) {
                                    kVar.zx(jSONObject3.getString("idtype"));
                                }
                                if (jSONObject3.has("ch")) {
                                    kVar.Xt(jSONObject3.getString("ch"));
                                }
                                if (jSONObject3.has("dfc")) {
                                    kVar.Xu(jSONObject3.getString("dfc"));
                                }
                                if (jSONObject3.has("reallog")) {
                                    kVar.Xv(jSONObject3.getString("reallog"));
                                }
                                if (jSONObject3.has("gflow")) {
                                    String string6 = jSONObject3.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.Xw(string6);
                                    }
                                }
                                if (jSONObject3.has("uploadType")) {
                                    String string7 = jSONObject3.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.Xx(string7);
                                    }
                                }
                                int optInt = jSONObject3.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    kVar.Ot(optInt);
                                }
                                kVar.setVersion(string);
                                this.eBG.add(kVar);
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
