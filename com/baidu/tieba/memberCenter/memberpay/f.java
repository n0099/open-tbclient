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
    public String lpQ;
    public int lpP = 0;
    public g lpt = new g();
    public b lpu = new b();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lpP = jSONObject.optInt("have_autopay", 0);
            this.lpt.parseJson(jSONObject.optJSONObject("user"));
            this.lpu.parseJson(jSONObject.optJSONObject("goods_info"));
            this.lpQ = jSONObject.optString("equal_cost");
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        long lqj;
        long lqk;
        e lql = new e();
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
                this.lqj = jSONObject.optLong("user_type");
                this.lqk = jSONObject.optLong("is_verify");
                this.lql.parseJson(jSONObject.optJSONObject("pay_member_info"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        long lqg;
        long lqh;
        boolean mChecked = true;
        long mEndTime;
        String mPicUrl;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lqg = jSONObject.optLong("props_id");
                this.mEndTime = jSONObject.optLong("end_time");
                this.mPicUrl = jSONObject.optString("pic_url");
                this.lqh = jSONObject.optLong("upgrade_month");
            }
        }
    }

    /* renamed from: com.baidu.tieba.memberCenter.memberpay.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0794f {
        long lqi;
        String mName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mName = jSONObject.optString("name");
                this.lqi = jSONObject.optLong("num");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        int isAutoPay;
        boolean isChecked;
        String lpX;
        String lpY;
        String lpZ;
        String lqa;
        long lqb;
        long lqc;
        long lqd;
        long lqe;
        boolean lqf;
        String mDesc;
        String mDiscount;
        String mIcon;
        String mTagName;
        String mTitle;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lpX = jSONObject.optString("productId");
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mDiscount = jSONObject.optString("discount");
                this.lpY = jSONObject.optString("original_cost");
                this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.lqb = jSONObject.optLong("props_id");
                this.lqc = jSONObject.optLong("money");
                this.lqe = jSONObject.optLong("months");
                this.lqd = jSONObject.optLong(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
                this.lpZ = jSONObject.optString("packet_text");
                this.isAutoPay = jSONObject.optInt("is_autopay");
                this.lqf = false;
                this.lqa = jSONObject.optString("payment_pos_key");
                this.mTagName = jSONObject.optString("tag_name");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public List<d> lpR = new ArrayList();
        public List<C0794f> lpS = new ArrayList();
        public String lpT;
        public String lpU;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lpT = jSONObject.optString("tip_text");
                this.lpU = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lqd) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lpR.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            C0794f c0794f = new C0794f();
                            c0794f.parseJson(jSONObject3);
                            this.lpS.add(c0794f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public List<d> lpR = new ArrayList();
        public List<C0794f> lpS = new ArrayList();
        public String lpT;
        public String lpU;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lpT = jSONObject.optString("tip_text");
                this.lpU = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lqd) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lpR.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            C0794f c0794f = new C0794f();
                            c0794f.parseJson(optJSONArray2.optJSONObject(i2));
                            this.lpS.add(c0794f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public c lpV = new c();
        public a lpW = new a();

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lpV.parseJson(jSONObject.optJSONObject("member"));
                this.lpW.parseJson(jSONObject.optJSONObject("adv_member"));
            }
        }
    }
}
