package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String paP;
    private int paQ;
    public int paR;
    public int paS = -1;

    public void Yq(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.paS = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.paS == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.paP = this.mData.optString("third_id");
                    this.paQ = this.mData.optInt("has_sub");
                    this.paR = this.mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return this.mPaId;
    }

    public void setPaid(long j) {
        this.mPaId = j;
    }

    public String getThirdId() {
        return this.paP;
    }

    public int ejX() {
        return this.paR;
    }

    public void setNotify(int i) {
        this.paR = i;
    }

    public String getType() {
        return Yr("type") ? this.mType : "";
    }

    public String ejY() {
        return Yr("third_id") ? this.paP : "";
    }

    public boolean isDataValid() {
        return this.paS == 0;
    }

    private boolean Yr(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
