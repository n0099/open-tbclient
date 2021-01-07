package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public String lmo;
    public int lmn = 0;
    public g llR = new g();
    public b llS = new b();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lmn = jSONObject.optInt("have_autopay", 0);
            this.llR.parseJson(jSONObject.optJSONObject("user"));
            this.llS.parseJson(jSONObject.optJSONObject("goods_info"));
            this.lmo = jSONObject.optString("equal_cost");
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        long lmH;
        long lmI;
        e lmJ = new e();
        long mId;
        String mName;
        String mNameShow;
        String mPortrait;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mId = jSONObject.optLong("id");
                this.mName = jSONObject.optString("name");
                this.mNameShow = jSONObject.optString("name_show");
                this.mPortrait = jSONObject.optString("portrait");
                this.lmH = jSONObject.optLong("user_type");
                this.lmI = jSONObject.optLong("is_verify");
                this.lmJ.parseJson(jSONObject.optJSONObject("pay_member_info"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        long lmE;
        long lmF;
        boolean mChecked = true;
        long mEndTime;
        String mPicUrl;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lmE = jSONObject.optLong("props_id");
                this.mEndTime = jSONObject.optLong("end_time");
                this.mPicUrl = jSONObject.optString("pic_url");
                this.lmF = jSONObject.optLong("upgrade_month");
            }
        }
    }

    /* renamed from: com.baidu.tieba.memberCenter.memberpay.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0809f {
        long lmG;
        String mName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mName = jSONObject.optString("name");
                this.lmG = jSONObject.optLong("num");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        int isAutoPay;
        boolean isChecked;
        long lmA;
        long lmB;
        long lmC;
        boolean lmD;
        String lmv;
        String lmw;
        String lmx;
        String lmy;
        long lmz;
        String mDesc;
        String mDiscount;
        String mIcon;
        String mTagName;
        String mTitle;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lmv = jSONObject.optString("productId");
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mDiscount = jSONObject.optString("discount");
                this.lmw = jSONObject.optString("original_cost");
                this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.lmz = jSONObject.optLong("props_id");
                this.lmA = jSONObject.optLong("money");
                this.lmC = jSONObject.optLong("months");
                this.lmB = jSONObject.optLong("default");
                this.lmx = jSONObject.optString("packet_text");
                this.isAutoPay = jSONObject.optInt("is_autopay");
                this.lmD = false;
                this.lmy = jSONObject.optString("payment_pos_key");
                this.mTagName = jSONObject.optString("tag_name");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public List<d> lmp = new ArrayList();
        public List<C0809f> lmq = new ArrayList();
        public String lmr;
        public String lms;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lmr = jSONObject.optString("tip_text");
                this.lms = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lmB) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lmp.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            C0809f c0809f = new C0809f();
                            c0809f.parseJson(jSONObject3);
                            this.lmq.add(c0809f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public List<d> lmp = new ArrayList();
        public List<C0809f> lmq = new ArrayList();
        public String lmr;
        public String lms;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lmr = jSONObject.optString("tip_text");
                this.lms = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lmB) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lmp.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            C0809f c0809f = new C0809f();
                            c0809f.parseJson(optJSONArray2.optJSONObject(i2));
                            this.lmq.add(c0809f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public c lmt = new c();
        public a lmu = new a();

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lmt.parseJson(jSONObject.optJSONObject("member"));
                this.lmu.parseJson(jSONObject.optJSONObject("adv_member"));
            }
        }
    }
}
