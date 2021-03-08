package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public e ltq = new e();
    public List<c> lts = new ArrayList();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ltq.parseJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    c cVar = new c();
                    cVar.parseJson(optJSONArray.getJSONObject(i));
                    this.lts.add(cVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    static class e {
        public b ltC = new b();
        public d ltD = new d();
        public String mId;
        public String mName;
        public String mPortrait;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mId = jSONObject.optString("id");
                this.mName = jSONObject.optString("name");
                this.mPortrait = jSONObject.optString("portrait");
                this.ltC.parseJson(jSONObject.optJSONObject("pay_member_info"));
                this.ltD.parseJson(jSONObject.optJSONObject("Parr_scores"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0802a {
        public String ltt;
        public String mDesc;
        public String mLink;
        public String mTitle;

        C0802a() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.ltt = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mLink = jSONObject.optString("link");
            }
        }
    }

    /* loaded from: classes8.dex */
    static class c {
        public ArrayList<C0802a> ltx = new ArrayList<>();
        public String mClassName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mClassName = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
                JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        C0802a c0802a = new C0802a();
                        c0802a.parseJson(jSONObject2);
                        this.ltx.add(c0802a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b {
        public long lsr;
        public long ltu;
        public long ltv;
        public String ltw;

        b() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lsr = jSONObject.optInt("props_id");
                this.ltu = jSONObject.optLong("end_time");
                this.ltv = jSONObject.optLong("now_time");
                this.ltw = jSONObject.optString("pic_url");
            }
        }

        public boolean isValid() {
            return (this.lsr == 1 || this.lsr == 2) && this.ltu > this.ltv;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class d {
        public long ltA;
        public long ltB;
        public long lty;
        public long ltz;
        public long mLevel;
        public long mLimit;
        public long mUpdateTime;

        d() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lty = jSONObject.optLong("scores_total");
                this.ltz = jSONObject.optLong("scores_fetch");
                this.ltA = jSONObject.optLong("scores_money");
                this.ltB = jSONObject.optLong("scores_other");
                this.mUpdateTime = jSONObject.optLong("update_time");
                this.mLevel = jSONObject.optLong("level");
                this.mLimit = jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
            }
        }

        public boolean isValid() {
            return this.ltA >= 0 && this.ltB >= 0;
        }
    }
}
