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
    public static class C0655a {
        public String iZf;
        public Rect iZg;
        public String picUrl;
        public Rect rect;

        public C0655a() {
            this.picUrl = "";
            this.rect = new Rect(0, 0, 0, 0);
            this.iZf = "";
            this.iZg = new Rect(0, 0, 0, 0);
        }

        private C0655a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.rect = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.rect.isEmpty()) ? false : true;
        }

        public boolean cts() {
            return (TextUtils.isEmpty(this.iZf) || this.iZg.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.rect.left);
                jSONObject.put("rect_top", this.rect.top);
                jSONObject.put("rect_right", this.rect.right);
                jSONObject.put("rect_bottom", this.rect.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0655a Hv(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0655a();
            }
            try {
                return new C0655a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0655a();
            }
        }

        public void Hw(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.iZf = jSONObject.optString("pic_url");
                                this.iZg = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
