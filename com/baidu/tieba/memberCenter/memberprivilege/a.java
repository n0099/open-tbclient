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
    public e lro = new e();
    public List<c> lrp = new ArrayList();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lro.parseJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    c cVar = new c();
                    cVar.parseJson(optJSONArray.getJSONObject(i));
                    this.lrp.add(cVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static class e {
        public String mId;
        public String mName;
        public String mPortrait;
        public b lrz = new b();
        public d lrA = new d();

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mId = jSONObject.optString("id");
                this.mName = jSONObject.optString("name");
                this.mPortrait = jSONObject.optString("portrait");
                this.lrz.parseJson(jSONObject.optJSONObject("pay_member_info"));
                this.lrA.parseJson(jSONObject.optJSONObject("Parr_scores"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0796a {
        public String lrq;
        public String mDesc;
        public String mLink;
        public String mTitle;

        C0796a() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lrq = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mLink = jSONObject.optString("link");
            }
        }
    }

    /* loaded from: classes9.dex */
    static class c {
        public ArrayList<C0796a> lru = new ArrayList<>();
        public String mClassName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mClassName = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
                JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        C0796a c0796a = new C0796a();
                        c0796a.parseJson(jSONObject2);
                        this.lru.add(c0796a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b {
        public long lqp;
        public long lrr;
        public long lrs;
        public String lrt;

        b() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lqp = jSONObject.optInt("props_id");
                this.lrr = jSONObject.optLong("end_time");
                this.lrs = jSONObject.optLong("now_time");
                this.lrt = jSONObject.optString("pic_url");
            }
        }

        public boolean isValid() {
            return (this.lqp == 1 || this.lqp == 2) && this.lrr > this.lrs;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class d {
        public long lrv;
        public long lrw;
        public long lrx;
        public long lry;
        public long mLevel;
        public long mLimit;
        public long mUpdateTime;

        d() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lrv = jSONObject.optLong("scores_total");
                this.lrw = jSONObject.optLong("scores_fetch");
                this.lrx = jSONObject.optLong("scores_money");
                this.lry = jSONObject.optLong("scores_other");
                this.mUpdateTime = jSONObject.optLong("update_time");
                this.mLevel = jSONObject.optLong("level");
                this.mLimit = jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
            }
        }

        public boolean isValid() {
            return this.lrx >= 0 && this.lry >= 0;
        }
    }
}
