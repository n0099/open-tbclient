package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public String lhJ;
    public int lhI = 0;
    public g lhm = new g();
    public b lhn = new b();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lhI = jSONObject.optInt("have_autopay", 0);
            this.lhm.parseJson(jSONObject.optJSONObject("user"));
            this.lhn.parseJson(jSONObject.optJSONObject("goods_info"));
            this.lhJ = jSONObject.optString("equal_cost");
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        long lic;
        long lid;
        e lie = new e();
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
                this.lic = jSONObject.optLong("user_type");
                this.lid = jSONObject.optLong("is_verify");
                this.lie.parseJson(jSONObject.optJSONObject("pay_member_info"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        long lhZ;
        long lia;
        boolean mChecked = true;
        long mEndTime;
        String mPicUrl;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lhZ = jSONObject.optLong("props_id");
                this.mEndTime = jSONObject.optLong("end_time");
                this.mPicUrl = jSONObject.optString("pic_url");
                this.lia = jSONObject.optLong("upgrade_month");
            }
        }
    }

    /* renamed from: com.baidu.tieba.memberCenter.memberpay.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0792f {
        long lib;
        String mName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mName = jSONObject.optString("name");
                this.lib = jSONObject.optLong("num");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        int isAutoPay;
        boolean isChecked;
        String lhQ;
        String lhR;
        String lhS;
        String lhT;
        long lhU;
        long lhV;
        long lhW;
        long lhX;
        boolean lhY;
        String mDesc;
        String mDiscount;
        String mIcon;
        String mTagName;
        String mTitle;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lhQ = jSONObject.optString("productId");
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mDiscount = jSONObject.optString("discount");
                this.lhR = jSONObject.optString("original_cost");
                this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.lhU = jSONObject.optLong("props_id");
                this.lhV = jSONObject.optLong("money");
                this.lhX = jSONObject.optLong("months");
                this.lhW = jSONObject.optLong(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
                this.lhS = jSONObject.optString("packet_text");
                this.isAutoPay = jSONObject.optInt("is_autopay");
                this.lhY = false;
                this.lhT = jSONObject.optString("payment_pos_key");
                this.mTagName = jSONObject.optString("tag_name");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public List<d> lhK = new ArrayList();
        public List<C0792f> lhL = new ArrayList();
        public String lhM;
        public String lhN;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lhM = jSONObject.optString("tip_text");
                this.lhN = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lhW) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lhK.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            C0792f c0792f = new C0792f();
                            c0792f.parseJson(jSONObject3);
                            this.lhL.add(c0792f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public List<d> lhK = new ArrayList();
        public List<C0792f> lhL = new ArrayList();
        public String lhM;
        public String lhN;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lhM = jSONObject.optString("tip_text");
                this.lhN = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lhW) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lhK.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            C0792f c0792f = new C0792f();
                            c0792f.parseJson(optJSONArray2.optJSONObject(i2));
                            this.lhL.add(c0792f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public c lhO = new c();
        public a lhP = new a();

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lhO.parseJson(jSONObject.optJSONObject("member"));
                this.lhP.parseJson(jSONObject.optJSONObject("adv_member"));
            }
        }
    }
}
