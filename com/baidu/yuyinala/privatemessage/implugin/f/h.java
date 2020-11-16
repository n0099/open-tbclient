package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String ozm;
    private int ozn;
    public int ozo;
    public int ozp = -1;

    public void Xg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ozp = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.ozp == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.ozm = this.mData.optString("third_id");
                    this.ozn = this.mData.optInt("has_sub");
                    this.ozo = this.mData.optInt("notify");
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
        return this.ozm;
    }

    public int efw() {
        return this.ozo;
    }

    public void Ob(int i) {
        this.ozo = i;
    }

    public String getType() {
        return Xh("type") ? this.mType : "";
    }

    public String efx() {
        return Xh("third_id") ? this.ozm : "";
    }

    public boolean isDataValid() {
        return this.ozp == 0;
    }

    private boolean Xh(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
