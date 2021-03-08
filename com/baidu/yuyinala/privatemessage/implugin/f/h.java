package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String pcV;
    private int pcW;
    public int pcX;
    public int pcY = -1;

    public void Yx(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.pcY = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.pcY == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.pcV = this.mData.optString("third_id");
                    this.pcW = this.mData.optInt("has_sub");
                    this.pcX = this.mData.optInt("notify");
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
        return this.pcV;
    }

    public int ekh() {
        return this.pcX;
    }

    public void setNotify(int i) {
        this.pcX = i;
    }

    public String getType() {
        return Yy("type") ? this.mType : "";
    }

    public String eki() {
        return Yy("third_id") ? this.pcV : "";
    }

    public boolean isDataValid() {
        return this.pcY == 0;
    }

    private boolean Yy(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
