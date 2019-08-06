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
    public static class C0354a {
        public Rect cxj;
        public String heR;
        public Rect heS;
        public String picUrl;

        public C0354a() {
            this.picUrl = "";
            this.cxj = new Rect(0, 0, 0, 0);
            this.heR = "";
            this.heS = new Rect(0, 0, 0, 0);
        }

        private C0354a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.cxj = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.cxj.isEmpty()) ? false : true;
        }

        public boolean bKs() {
            return (TextUtils.isEmpty(this.heR) || this.heS.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.cxj.left);
                jSONObject.put("rect_top", this.cxj.top);
                jSONObject.put("rect_right", this.cxj.right);
                jSONObject.put("rect_bottom", this.cxj.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0354a Aa(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0354a();
            }
            try {
                return new C0354a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0354a();
            }
        }

        public void Ab(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.heR = jSONObject.optString("pic_url");
                                this.heS = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
