package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public String lqe;
    public int lqd = 0;
    public g lpH = new g();
    public b lpI = new b();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lqd = jSONObject.optInt("have_autopay", 0);
            this.lpH.parseJson(jSONObject.optJSONObject("user"));
            this.lpI.parseJson(jSONObject.optJSONObject("goods_info"));
            this.lqe = jSONObject.optString("equal_cost");
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        long lqx;
        long lqy;
        e lqz = new e();
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
                this.lqx = jSONObject.optLong("user_type");
                this.lqy = jSONObject.optLong("is_verify");
                this.lqz.parseJson(jSONObject.optJSONObject("pay_member_info"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        long lqu;
        long lqv;
        boolean mChecked = true;
        long mEndTime;
        String mPicUrl;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lqu = jSONObject.optLong("props_id");
                this.mEndTime = jSONObject.optLong("end_time");
                this.mPicUrl = jSONObject.optString("pic_url");
                this.lqv = jSONObject.optLong("upgrade_month");
            }
        }
    }

    /* renamed from: com.baidu.tieba.memberCenter.memberpay.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0795f {
        long lqw;
        String mName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mName = jSONObject.optString("name");
                this.lqw = jSONObject.optLong("num");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        int isAutoPay;
        boolean isChecked;
        String lql;
        String lqm;
        String lqn;
        String lqo;
        long lqp;
        long lqq;
        long lqr;
        long lqs;
        boolean lqt;
        String mDesc;
        String mDiscount;
        String mIcon;
        String mTagName;
        String mTitle;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lql = jSONObject.optString("productId");
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mDiscount = jSONObject.optString("discount");
                this.lqm = jSONObject.optString("original_cost");
                this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.lqp = jSONObject.optLong("props_id");
                this.lqq = jSONObject.optLong("money");
                this.lqs = jSONObject.optLong("months");
                this.lqr = jSONObject.optLong(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
                this.lqn = jSONObject.optString("packet_text");
                this.isAutoPay = jSONObject.optInt("is_autopay");
                this.lqt = false;
                this.lqo = jSONObject.optString("payment_pos_key");
                this.mTagName = jSONObject.optString("tag_name");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public List<d> lqf = new ArrayList();
        public List<C0795f> lqg = new ArrayList();
        public String lqh;
        public String lqi;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lqh = jSONObject.optString("tip_text");
                this.lqi = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lqr) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lqf.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            C0795f c0795f = new C0795f();
                            c0795f.parseJson(jSONObject3);
                            this.lqg.add(c0795f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public List<d> lqf = new ArrayList();
        public List<C0795f> lqg = new ArrayList();
        public String lqh;
        public String lqi;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lqh = jSONObject.optString("tip_text");
                this.lqi = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lqr) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lqf.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            C0795f c0795f = new C0795f();
                            c0795f.parseJson(optJSONArray2.optJSONObject(i2));
                            this.lqg.add(c0795f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public c lqj = new c();
        public a lqk = new a();

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lqj.parseJson(jSONObject.optJSONObject("member"));
                this.lqk.parseJson(jSONObject.optJSONObject("adv_member"));
            }
        }
    }
}
