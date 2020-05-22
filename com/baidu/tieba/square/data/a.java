package com.baidu.tieba.square.data;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a {
    private int errorCode;
    private String errorMsg;
    private Date ldR;

    protected abstract void dz(JSONObject jSONObject) throws Exception;

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean isFailed() {
        return this.errorMsg != null;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            setErrorMsg("网络不给力呀");
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.errorCode = jSONObject.optInt("error_code", 0);
            if (this.errorCode != 0) {
                setErrorMsg(jSONObject.optString("error_msg", "网络不给力呀"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.errorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO, 0);
                if (this.errorCode != 0) {
                    setErrorMsg(optJSONObject.optString("usermsg", "网络不给力呀"));
                    return;
                }
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.ldR = new Date(optLong * 1000);
            }
            dz(jSONObject);
        } catch (Exception e) {
            setErrorMsg("网络不给力呀");
            e.printStackTrace();
        }
    }
}
