package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public e lra = new e();
    public List<c> lrb = new ArrayList();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lra.parseJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    c cVar = new c();
                    cVar.parseJson(optJSONArray.getJSONObject(i));
                    this.lrb.add(cVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static class e {
        public b lrl = new b();
        public d lrm = new d();
        public String mId;
        public String mName;
        public String mPortrait;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mId = jSONObject.optString("id");
                this.mName = jSONObject.optString("name");
                this.mPortrait = jSONObject.optString("portrait");
                this.lrl.parseJson(jSONObject.optJSONObject("pay_member_info"));
                this.lrm.parseJson(jSONObject.optJSONObject("Parr_scores"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0795a {
        public String lrc;
        public String mDesc;
        public String mLink;
        public String mTitle;

        C0795a() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lrc = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mLink = jSONObject.optString("link");
            }
        }
    }

    /* loaded from: classes9.dex */
    static class c {
        public ArrayList<C0795a> lrg = new ArrayList<>();
        public String mClassName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mClassName = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
                JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        C0795a c0795a = new C0795a();
                        c0795a.parseJson(jSONObject2);
                        this.lrg.add(c0795a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b {
        public long lqb;
        public long lrd;
        public long lre;
        public String lrf;

        b() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lqb = jSONObject.optInt("props_id");
                this.lrd = jSONObject.optLong("end_time");
                this.lre = jSONObject.optLong("now_time");
                this.lrf = jSONObject.optString("pic_url");
            }
        }

        public boolean isValid() {
            return (this.lqb == 1 || this.lqb == 2) && this.lrd > this.lre;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class d {
        public long lrh;
        public long lri;
        public long lrj;
        public long lrk;
        public long mLevel;
        public long mLimit;
        public long mUpdateTime;

        d() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lrh = jSONObject.optLong("scores_total");
                this.lri = jSONObject.optLong("scores_fetch");
                this.lrj = jSONObject.optLong("scores_money");
                this.lrk = jSONObject.optLong("scores_other");
                this.mUpdateTime = jSONObject.optLong("update_time");
                this.mLevel = jSONObject.optLong("level");
                this.mLimit = jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
            }
        }

        public boolean isValid() {
            return this.lrj >= 0 && this.lrk >= 0;
        }
    }
}
