package com.baidu.tieba.lego.card.b;

import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: com.baidu.tieba.lego.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0104a {
        public String dLG;
        public Rect dLH;
        public String picUrl;
        public Rect rect;

        public C0104a() {
            this.picUrl = "";
            this.rect = new Rect(0, 0, 0, 0);
            this.dLG = "";
            this.dLH = new Rect(0, 0, 0, 0);
        }

        private C0104a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.rect = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.rect.isEmpty()) ? false : true;
        }

        public boolean aBS() {
            return (TextUtils.isEmpty(this.dLG) || this.dLH.isEmpty()) ? false : true;
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

        public static C0104a mW(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0104a();
            }
            try {
                return new C0104a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0104a();
            }
        }

        public void mX(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("pics");
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.dLG = jSONObject.optString("pic_url");
                                this.dLH = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
