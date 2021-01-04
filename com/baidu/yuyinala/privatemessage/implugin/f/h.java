package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oUE;
    private int oUF;
    public int oUG;
    public int oUH = -1;

    public void Yl(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oUH = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.oUH == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oUE = this.mData.optString("third_id");
                    this.oUF = this.mData.optInt("has_sub");
                    this.oUG = this.mData.optInt("notify");
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
        return this.oUE;
    }

    public int elo() {
        return this.oUG;
    }

    public void OO(int i) {
        this.oUG = i;
    }

    public String getType() {
        return Ym("type") ? this.mType : "";
    }

    public String elp() {
        return Ym("third_id") ? this.oUE : "";
    }

    public boolean isDataValid() {
        return this.oUH == 0;
    }

    private boolean Ym(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
