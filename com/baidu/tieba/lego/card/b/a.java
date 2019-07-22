package com.baidu.tieba.lego.card.b;

import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: com.baidu.tieba.lego.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0348a {
        public Rect cxc;
        public String hdZ;
        public Rect hea;
        public String picUrl;

        public C0348a() {
            this.picUrl = "";
            this.cxc = new Rect(0, 0, 0, 0);
            this.hdZ = "";
            this.hea = new Rect(0, 0, 0, 0);
        }

        private C0348a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.cxc = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.cxc.isEmpty()) ? false : true;
        }

        public boolean bKe() {
            return (TextUtils.isEmpty(this.hdZ) || this.hea.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.cxc.left);
                jSONObject.put("rect_top", this.cxc.top);
                jSONObject.put("rect_right", this.cxc.right);
                jSONObject.put("rect_bottom", this.cxc.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0348a zZ(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0348a();
            }
            try {
                return new C0348a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0348a();
            }
        }

        public void Aa(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.hdZ = jSONObject.optString("pic_url");
                                this.hea = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
