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
/* loaded from: classes4.dex */
public class w {
    private static final boolean DEBUG = AppConfig.isDebug();
    private int eyY;
    private JSONObject eyZ;
    private List<k> eza = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject oTH;
    private JSONObject oTI;
    private String oTJ;
    private String oTK;
    private int oTL;
    private int oTM;

    public w(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.eyZ = jSONObject;
    }

    public int bfh() {
        return this.mThreshold;
    }

    public int bfi() {
        return this.eyY;
    }

    public List<k> bfj() {
        return this.eza;
    }

    public void fv(List<k> list) {
        this.eza = list;
    }

    public String ehP() {
        return this.oTK;
    }

    public JSONObject ehQ() {
        return this.oTI;
    }

    public int ehR() {
        return this.oTL;
    }

    public int ehS() {
        return this.oTM;
    }

    public boolean bfk() {
        try {
            if (this.eyZ == null) {
                return false;
            }
            JSONObject jSONObject = this.eyZ;
            this.oTH = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.eyY = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oTK = jSONObject.optString("step");
            this.oTJ = jSONObject.optString("replace");
            this.oTI = jSONObject.optJSONObject("del");
            this.oTL = jSONObject.optInt("all_size", 614400);
            this.oTM = jSONObject.optInt("single_size", 153600);
            if (this.oTH != null) {
                Iterator<String> keys = this.oTH.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = this.oTH.getJSONObject(next);
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
                                    kVar.mj(jSONObject3.getInt("rate"));
                                }
                                if (jSONObject3.has("c")) {
                                    kVar.setCategory(jSONObject3.getString("c"));
                                }
                                if (jSONObject3.has("limitUnit")) {
                                    kVar.mk(jSONObject3.getInt("limitUnit"));
                                }
                                if (jSONObject3.has("limitCnt")) {
                                    kVar.ml(jSONObject3.getInt("limitCnt"));
                                }
                                if (jSONObject3.has("idtype")) {
                                    kVar.yF(jSONObject3.getString("idtype"));
                                }
                                if (jSONObject3.has("ch")) {
                                    kVar.Xw(jSONObject3.getString("ch"));
                                }
                                if (jSONObject3.has("dfc")) {
                                    kVar.Xx(jSONObject3.getString("dfc"));
                                }
                                if (jSONObject3.has("reallog")) {
                                    kVar.Xy(jSONObject3.getString("reallog"));
                                }
                                if (jSONObject3.has("gflow")) {
                                    String string6 = jSONObject3.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.Xz(string6);
                                    }
                                }
                                if (jSONObject3.has("uploadType")) {
                                    String string7 = jSONObject3.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.XA(string7);
                                    }
                                }
                                int optInt = jSONObject3.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    kVar.Nj(optInt);
                                }
                                kVar.setVersion(string);
                                this.eza.add(kVar);
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
