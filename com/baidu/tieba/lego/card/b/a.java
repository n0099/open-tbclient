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
    public static class C0454a {
        public Rect apc;
        public String heQ;
        public Rect heR;
        public String picUrl;

        public C0454a() {
            this.picUrl = "";
            this.apc = new Rect(0, 0, 0, 0);
            this.heQ = "";
            this.heR = new Rect(0, 0, 0, 0);
        }

        private C0454a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.apc = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.apc.isEmpty()) ? false : true;
        }

        public boolean bHP() {
            return (TextUtils.isEmpty(this.heQ) || this.heR.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.apc.left);
                jSONObject.put("rect_top", this.apc.top);
                jSONObject.put("rect_right", this.apc.right);
                jSONObject.put("rect_bottom", this.apc.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0454a yR(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0454a();
            }
            try {
                return new C0454a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0454a();
            }
        }

        public void yS(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.heQ = jSONObject.optString("pic_url");
                                this.heR = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
