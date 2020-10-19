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
    public static class C0746a {
        public Rect bvm;
        public String kmn;
        public Rect kmo;
        public String picUrl;

        public C0746a() {
            this.picUrl = "";
            this.bvm = new Rect(0, 0, 0, 0);
            this.kmn = "";
            this.kmo = new Rect(0, 0, 0, 0);
        }

        private C0746a(JSONObject jSONObject) {
            this.picUrl = jSONObject.optString("pic_url");
            this.bvm = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) || this.bvm.isEmpty()) ? false : true;
        }

        public boolean cTp() {
            return (TextUtils.isEmpty(this.kmn) || this.kmo.isEmpty()) ? false : true;
        }

        public String toString() {
            if (!isValid()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.picUrl);
                jSONObject.put("rect_left", this.bvm.left);
                jSONObject.put("rect_top", this.bvm.top);
                jSONObject.put("rect_right", this.bvm.right);
                jSONObject.put("rect_bottom", this.bvm.bottom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static C0746a MW(String str) {
            if (TextUtils.isEmpty(str)) {
                return new C0746a();
            }
            try {
                return new C0746a(new JSONObject(str));
            } catch (Throwable th) {
                th.printStackTrace();
                return new C0746a();
            }
        }

        public void MX(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
                    if (optJSONArray != null) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                            if (jSONObject != null) {
                                this.kmn = jSONObject.optString("pic_url");
                                this.kmo = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
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
