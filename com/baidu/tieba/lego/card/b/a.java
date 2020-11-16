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
    public static class C0779a {
        public Rect bCa;
        public String kET;
        public Rect kEU;
        public String picUrl;

        public C0779a() {
            this.picUrl = "";
            this.bCa = new Rect(0, 0, 0, 0);
            this.kET = "";
            this.kEU = new Rect(0, 0, 0, 0);
        }

        private C0779a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.bCa = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.bCa.isEmpty()) ? false : true;
        }

        public boolean cYt() {
            return (TextUtils.isEmpty(this.kET) || this.kEU.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.bCa.left);
                jSONObject.put("rect_top", this.bCa.top);
                jSONObject.put("rect_right", this.bCa.right);
                jSONObject.put("rect_bottom", this.bCa.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0779a Nj(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0779a();
            }
            try {
                return new C0779a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0779a();
            }
        }

        public void Nk(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.kET = jSONObject.optString("pic_url");
                                this.kEU = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
