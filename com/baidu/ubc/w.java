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
public class w {
    private static final boolean DEBUG = AppConfig.isDebug();
    private int erU;
    private JSONObject erV;
    private List<k> erW = new ArrayList();
    private String mSign;
    private int mThreshold;
    private JSONObject oHu;
    private JSONObject oHv;
    private String oHw;
    private String oHx;
    private int oHy;
    private int oHz;

    public w(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.erV = jSONObject;
    }

    public int bgq() {
        return this.mThreshold;
    }

    public int bgr() {
        return this.erU;
    }

    public List<k> bgs() {
        return this.erW;
    }

    public void fx(List<k> list) {
        this.erW = list;
    }

    public String eiW() {
        return this.oHx;
    }

    public JSONObject eiX() {
        return this.oHv;
    }

    public int eiY() {
        return this.oHy;
    }

    public int eiZ() {
        return this.oHz;
    }

    public boolean bgt() {
        try {
            if (this.erV == null) {
                return false;
            }
            JSONObject jSONObject = this.erV;
            this.oHu = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.erU = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oHx = jSONObject.optString("step");
            this.oHw = jSONObject.optString("replace");
            this.oHv = jSONObject.optJSONObject("del");
            this.oHy = jSONObject.optInt("all_size", 614400);
            this.oHz = jSONObject.optInt("single_size", 153600);
            if (this.oHu != null) {
                Iterator<String> keys = this.oHu.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = this.oHu.getJSONObject(next);
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
                                    kVar.nD(jSONObject3.getInt("rate"));
                                }
                                if (jSONObject3.has("c")) {
                                    kVar.setCategory(jSONObject3.getString("c"));
                                }
                                if (jSONObject3.has("limitUnit")) {
                                    kVar.nE(jSONObject3.getInt("limitUnit"));
                                }
                                if (jSONObject3.has("limitCnt")) {
                                    kVar.nF(jSONObject3.getInt("limitCnt"));
                                }
                                if (jSONObject3.has("idtype")) {
                                    kVar.zy(jSONObject3.getString("idtype"));
                                }
                                if (jSONObject3.has("ch")) {
                                    kVar.XK(jSONObject3.getString("ch"));
                                }
                                if (jSONObject3.has("dfc")) {
                                    kVar.XL(jSONObject3.getString("dfc"));
                                }
                                if (jSONObject3.has("reallog")) {
                                    kVar.XM(jSONObject3.getString("reallog"));
                                }
                                if (jSONObject3.has("gflow")) {
                                    String string6 = jSONObject3.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.XN(string6);
                                    }
                                }
                                if (jSONObject3.has("uploadType")) {
                                    String string7 = jSONObject3.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.XO(string7);
                                    }
                                }
                                int optInt = jSONObject3.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    kVar.OE(optInt);
                                }
                                kVar.setVersion(string);
                                this.erW.add(kVar);
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
