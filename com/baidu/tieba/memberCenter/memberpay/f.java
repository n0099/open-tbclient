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
    public String lsg;
    public int lsf = 0;
    public g lrJ = new g();
    public b lrK = new b();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lsf = jSONObject.optInt("have_autopay", 0);
            this.lrJ.parseJson(jSONObject.optJSONObject("user"));
            this.lrK.parseJson(jSONObject.optJSONObject("goods_info"));
            this.lsg = jSONObject.optString("equal_cost");
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        long lsA;
        e lsB = new e();
        long lsz;
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
                this.lsz = jSONObject.optLong("user_type");
                this.lsA = jSONObject.optLong("is_verify");
                this.lsB.parseJson(jSONObject.optJSONObject("pay_member_info"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        long lsw;
        long lsx;
        boolean mChecked = true;
        long mEndTime;
        String mPicUrl;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lsw = jSONObject.optLong("props_id");
                this.mEndTime = jSONObject.optLong("end_time");
                this.mPicUrl = jSONObject.optString("pic_url");
                this.lsx = jSONObject.optLong("upgrade_month");
            }
        }
    }

    /* renamed from: com.baidu.tieba.memberCenter.memberpay.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0801f {
        long lsy;
        String mName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mName = jSONObject.optString("name");
                this.lsy = jSONObject.optLong("num");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        int isAutoPay;
        boolean isChecked;
        String lsn;
        String lso;
        String lsp;
        String lsq;
        long lsr;
        long lss;
        long lst;
        long lsu;
        boolean lsv;
        String mDesc;
        String mDiscount;
        String mIcon;
        String mTagName;
        String mTitle;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lsn = jSONObject.optString("productId");
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mDiscount = jSONObject.optString("discount");
                this.lso = jSONObject.optString("original_cost");
                this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.lsr = jSONObject.optLong("props_id");
                this.lss = jSONObject.optLong("money");
                this.lsu = jSONObject.optLong("months");
                this.lst = jSONObject.optLong(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
                this.lsp = jSONObject.optString("packet_text");
                this.isAutoPay = jSONObject.optInt("is_autopay");
                this.lsv = false;
                this.lsq = jSONObject.optString("payment_pos_key");
                this.mTagName = jSONObject.optString("tag_name");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public List<d> lsh = new ArrayList();
        public List<C0801f> lsi = new ArrayList();
        public String lsj;
        public String lsk;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lsj = jSONObject.optString("tip_text");
                this.lsk = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lst) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lsh.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            C0801f c0801f = new C0801f();
                            c0801f.parseJson(jSONObject3);
                            this.lsi.add(c0801f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public List<d> lsh = new ArrayList();
        public List<C0801f> lsi = new ArrayList();
        public String lsj;
        public String lsk;
        public String mContent;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mContent = jSONObject.optString("content");
                this.lsj = jSONObject.optString("tip_text");
                this.lsk = jSONObject.optString("img");
                JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        d dVar = new d();
                        dVar.parseJson(jSONObject2);
                        if (1 == dVar.lst) {
                            dVar.isChecked = true;
                        } else {
                            dVar.isChecked = false;
                        }
                        this.lsh.add(dVar);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.DIRECTION_RIGHT);
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            C0801f c0801f = new C0801f();
                            c0801f.parseJson(optJSONArray2.optJSONObject(i2));
                            this.lsi.add(c0801f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public c lsl = new c();
        public a lsm = new a();

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lsl.parseJson(jSONObject.optJSONObject("member"));
                this.lsm.parseJson(jSONObject.optJSONObject("adv_member"));
            }
        }
    }
}
