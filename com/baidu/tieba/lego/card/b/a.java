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
    public static class C0728a {
        public Rect bry;
        public String jWX;
        public Rect jWY;
        public String picUrl;

        public C0728a() {
            this.picUrl = "";
            this.bry = new Rect(0, 0, 0, 0);
            this.jWX = "";
            this.jWY = new Rect(0, 0, 0, 0);
        }

        private C0728a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.bry = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.bry.isEmpty()) ? false : true;
        }

        public boolean cPF() {
            return (TextUtils.isEmpty(this.jWX) || this.jWY.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.bry.left);
                jSONObject.put("rect_top", this.bry.top);
                jSONObject.put("rect_right", this.bry.right);
                jSONObject.put("rect_bottom", this.bry.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0728a Mh(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0728a();
            }
            try {
                return new C0728a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0728a();
            }
        }

        public void Mi(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.jWX = jSONObject.optString("pic_url");
                                this.jWY = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
