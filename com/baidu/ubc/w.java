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
    private JSONObject eAA;
    private List<k> eAB = new ArrayList();
    private int eAz;
    private String mSign;
    private int mThreshold;
    private JSONObject oVM;
    private JSONObject oVN;
    private String oVO;
    private String oVP;
    private int oVQ;
    private int oVR;

    public w(String str, JSONObject jSONObject) {
        this.mSign = str;
        this.eAA = jSONObject;
    }

    public int bfj() {
        return this.mThreshold;
    }

    public int bfk() {
        return this.eAz;
    }

    public List<k> bfl() {
        return this.eAB;
    }

    public void fv(List<k> list) {
        this.eAB = list;
    }

    public String ehX() {
        return this.oVP;
    }

    public JSONObject ehY() {
        return this.oVN;
    }

    public int ehZ() {
        return this.oVQ;
    }

    public int eia() {
        return this.oVR;
    }

    public boolean bfm() {
        try {
            if (this.eAA == null) {
                return false;
            }
            JSONObject jSONObject = this.eAA;
            this.oVM = jSONObject.optJSONObject("set");
            this.mThreshold = jSONObject.optInt("threshold", 10000);
            this.eAz = jSONObject.optInt("timeup", PersonListModel.CACHETIME);
            this.oVP = jSONObject.optString("step");
            this.oVO = jSONObject.optString("replace");
            this.oVN = jSONObject.optJSONObject("del");
            this.oVQ = jSONObject.optInt("all_size", 614400);
            this.oVR = jSONObject.optInt("single_size", 153600);
            if (this.oVM != null) {
                Iterator<String> keys = this.oVM.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = this.oVM.getJSONObject(next);
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
                                    kVar.mk(jSONObject3.getInt("rate"));
                                }
                                if (jSONObject3.has("c")) {
                                    kVar.setCategory(jSONObject3.getString("c"));
                                }
                                if (jSONObject3.has("limitUnit")) {
                                    kVar.ml(jSONObject3.getInt("limitUnit"));
                                }
                                if (jSONObject3.has("limitCnt")) {
                                    kVar.mm(jSONObject3.getInt("limitCnt"));
                                }
                                if (jSONObject3.has("idtype")) {
                                    kVar.yM(jSONObject3.getString("idtype"));
                                }
                                if (jSONObject3.has("ch")) {
                                    kVar.XD(jSONObject3.getString("ch"));
                                }
                                if (jSONObject3.has("dfc")) {
                                    kVar.XE(jSONObject3.getString("dfc"));
                                }
                                if (jSONObject3.has("reallog")) {
                                    kVar.XF(jSONObject3.getString("reallog"));
                                }
                                if (jSONObject3.has("gflow")) {
                                    String string6 = jSONObject3.getString("gflow");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.equals(string6, "0")) {
                                        kVar.XG(string6);
                                    }
                                }
                                if (jSONObject3.has("uploadType")) {
                                    String string7 = jSONObject3.getString("uploadType");
                                    if (!TextUtils.isEmpty(string7)) {
                                        kVar.XH(string7);
                                    }
                                }
                                int optInt = jSONObject3.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    kVar.Nn(optInt);
                                }
                                kVar.setVersion(string);
                                this.eAB.add(kVar);
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
