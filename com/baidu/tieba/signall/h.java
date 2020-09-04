package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int lVt;
    private String lVu;
    private int lWY;
    private String lWZ;
    private a lVO = new a();
    private ArrayList<i> lXa = new ArrayList<>();

    public int duo() {
        return this.lVt;
    }

    public String dtM() {
        return this.lVu;
    }

    public a dtO() {
        return this.lVO;
    }

    public ArrayList<i> dup() {
        return this.lXa;
    }

    public int duq() {
        return this.lWY;
    }

    public String dur() {
        return this.lWZ;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lVO.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lVt = jSONObject.optInt("show_dialog");
                this.lVu = jSONObject.optString("sign_notice");
                this.lWY = jSONObject.optInt("is_timeout");
                this.lWZ = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.lXa.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
