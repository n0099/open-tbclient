package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oQc;
    private int oQd;
    public int oQe;
    public int oQf = -1;

    public void Xc(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oQf = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.oQf == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oQc = this.mData.optString("third_id");
                    this.oQd = this.mData.optInt("has_sub");
                    this.oQe = this.mData.optInt("notify");
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
        return this.oQc;
    }

    public int ehv() {
        return this.oQe;
    }

    public void Nh(int i) {
        this.oQe = i;
    }

    public String getType() {
        return Xd("type") ? this.mType : "";
    }

    public String ehw() {
        return Xd("third_id") ? this.oQc : "";
    }

    public boolean isDataValid() {
        return this.oQf == 0;
    }

    private boolean Xd(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
