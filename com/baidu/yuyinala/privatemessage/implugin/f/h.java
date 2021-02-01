package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String pao;
    private int pap;
    public int paq;
    public int par = -1;

    public void Ye(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.par = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.par == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.pao = this.mData.optString("third_id");
                    this.pap = this.mData.optInt("has_sub");
                    this.paq = this.mData.optInt("notify");
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
        return this.pao;
    }

    public int ejP() {
        return this.paq;
    }

    public void setNotify(int i) {
        this.paq = i;
    }

    public String getType() {
        return Yf("type") ? this.mType : "";
    }

    public String ejQ() {
        return Yf("third_id") ? this.pao : "";
    }

    public boolean isDataValid() {
        return this.par == 0;
    }

    private boolean Yf(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
