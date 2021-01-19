package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oQd;
    private int oQe;
    public int oQf;
    public int oQg = -1;

    public void Xd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oQg = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.oQg == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oQd = this.mData.optString("third_id");
                    this.oQe = this.mData.optInt("has_sub");
                    this.oQf = this.mData.optInt("notify");
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
        return this.oQd;
    }

    public int ehv() {
        return this.oQf;
    }

    public void Nh(int i) {
        this.oQf = i;
    }

    public String getType() {
        return Xe("type") ? this.mType : "";
    }

    public String ehw() {
        return Xe("third_id") ? this.oQd : "";
    }

    public boolean isDataValid() {
        return this.oQg == 0;
    }

    private boolean Xe(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
