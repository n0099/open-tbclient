package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oxI;
    private int oxJ;
    public int oxK;
    public int oxL = -1;

    public void Xv(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oxL = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.oxL == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oxI = this.mData.optString("third_id");
                    this.oxJ = this.mData.optInt("has_sub");
                    this.oxK = this.mData.optInt("notify");
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
        return this.oxI;
    }

    public int efy() {
        return this.oxK;
    }

    public void Ny(int i) {
        this.oxK = i;
    }

    public String getType() {
        return Xw("type") ? this.mType : "";
    }

    public String efz() {
        return Xw("third_id") ? this.oxI : "";
    }

    public boolean isDataValid() {
        return this.oxL == 0;
    }

    private boolean Xw(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
