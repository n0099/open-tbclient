package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private JSONObject mData;
    private long mPaId;
    private String mType;
    private String oOs;
    private int oOt;
    public int oOu;
    public int oOv = -1;

    public void YB(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oOv = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (this.oOv == 0) {
                this.mData = jSONObject.optJSONObject("data");
                if (this.mData != null) {
                    this.mType = this.mData.optString("type");
                    this.oOs = this.mData.optString("third_id");
                    this.oOt = this.mData.optInt("has_sub");
                    this.oOu = this.mData.optInt("notify");
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
        return this.oOs;
    }

    public int elj() {
        return this.oOu;
    }

    public void OZ(int i) {
        this.oOu = i;
    }

    public String getType() {
        return YC("type") ? this.mType : "";
    }

    public String elk() {
        return YC("third_id") ? this.oOs : "";
    }

    public boolean isDataValid() {
        return this.oOv == 0;
    }

    private boolean YC(String str) {
        return isDataValid() && this.mData != null && this.mData.has(str);
    }
}
