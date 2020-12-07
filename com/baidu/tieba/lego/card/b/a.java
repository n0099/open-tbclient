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
    public static class C0795a {
        public Rect bHi;
        public String kSl;
        public Rect kSm;
        public String picUrl;

        public C0795a() {
            this.picUrl = "";
            this.bHi = new Rect(0, 0, 0, 0);
            this.kSl = "";
            this.kSm = new Rect(0, 0, 0, 0);
        }

        private C0795a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.bHi = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.bHi.isEmpty()) ? false : true;
        }

        public boolean ddE() {
            return (TextUtils.isEmpty(this.kSl) || this.kSm.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.bHi.left);
                jSONObject.put("rect_top", this.bHi.top);
                jSONObject.put("rect_right", this.bHi.right);
                jSONObject.put("rect_bottom", this.bHi.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0795a Oq(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0795a();
            }
            try {
                return new C0795a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0795a();
            }
        }

        public void Or(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.kSl = jSONObject.optString("pic_url");
                                this.kSm = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
