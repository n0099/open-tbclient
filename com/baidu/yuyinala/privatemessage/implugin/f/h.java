package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oOu;
    private int oOv;
    public int oOw;
    public int oOx = -1;

    public void YB(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oOx = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.oOx == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oOu = this.mData.optString("third_id");
                    this.oOv = this.mData.optInt("has_sub");
                    this.oOw = this.mData.optInt("notify");
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
        return this.oOu;
    }

    public int elk() {
        return this.oOw;
    }

    public void OZ(int i) {
        this.oOw = i;
    }

    public String getType() {
        return YC("type") ? this.mType : "";
    }

    public String ell() {
        return YC("third_id") ? this.oOu : "";
    }

    public boolean isDataValid() {
        return this.oOx == 0;
    }

    private boolean YC(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
