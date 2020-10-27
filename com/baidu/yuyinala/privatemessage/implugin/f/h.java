package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oon;
    private int ooo;
    public int oop;
    public int ooq = -1;

    public void WR(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ooq = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.ooq == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oon = this.mData.optString("third_id");
                    this.ooo = this.mData.optInt("has_sub");
                    this.oop = this.mData.optInt("notify");
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
        return this.oon;
    }

    public int ebJ() {
        return this.oop;
    }

    public void Nd(int i) {
        this.oop = i;
    }

    public String getType() {
        return WS("type") ? this.mType : "";
    }

    public String ebK() {
        return WS("third_id") ? this.oon : "";
    }

    public boolean isDataValid() {
        return this.ooq == 0;
    }

    private boolean WS(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
