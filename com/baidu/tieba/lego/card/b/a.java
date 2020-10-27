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
    public static class C0762a {
        public Rect bxA;
        public String kyK;
        public Rect kyL;
        public String picUrl;

        public C0762a() {
            this.picUrl = "";
            this.bxA = new Rect(0, 0, 0, 0);
            this.kyK = "";
            this.kyL = new Rect(0, 0, 0, 0);
        }

        private C0762a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.bxA = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.bxA.isEmpty()) ? false : true;
        }

        public boolean cWw() {
            return (TextUtils.isEmpty(this.kyK) || this.kyL.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.bxA.left);
                jSONObject.put("rect_top", this.bxA.top);
                jSONObject.put("rect_right", this.bxA.right);
                jSONObject.put("rect_bottom", this.bxA.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0762a Nu(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0762a();
            }
            try {
                return new C0762a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0762a();
            }
        }

        public void Nv(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.kyK = jSONObject.optString("pic_url");
                                this.kyL = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
