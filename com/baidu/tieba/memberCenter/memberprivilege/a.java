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
    public e liT = new e();
    public List<c> liU = new ArrayList();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.liT.parseJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    c cVar = new c();
                    cVar.parseJson(optJSONArray.getJSONObject(i));
                    this.liU.add(cVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    static class e {
        public b ljf = new b();
        public d ljg = new d();
        public String mId;
        public String mName;
        public String mPortrait;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mId = jSONObject.optString("id");
                this.mName = jSONObject.optString("name");
                this.mPortrait = jSONObject.optString("portrait");
                this.ljf.parseJson(jSONObject.optJSONObject("pay_member_info"));
                this.ljg.parseJson(jSONObject.optJSONObject("Parr_scores"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0793a {
        public String liV;
        public String mDesc;
        public String mLink;
        public String mTitle;

        C0793a() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.liV = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mLink = jSONObject.optString("link");
            }
        }
    }

    /* loaded from: classes8.dex */
    static class c {
        public ArrayList<C0793a> liZ = new ArrayList<>();
        public String mClassName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mClassName = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
                JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        C0793a c0793a = new C0793a();
                        c0793a.parseJson(jSONObject2);
                        this.liZ.add(c0793a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b {
        public long lhU;
        public long liW;
        public long liX;
        public String liY;

        b() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lhU = jSONObject.optInt("props_id");
                this.liW = jSONObject.optLong("end_time");
                this.liX = jSONObject.optLong("now_time");
                this.liY = jSONObject.optString("pic_url");
            }
        }

        public boolean isValid() {
            return (this.lhU == 1 || this.lhU == 2) && this.liW > this.liX;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class d {
        public long lja;
        public long ljb;
        public long ljc;
        public long ljd;
        public long lje;
        public long mLimit;
        public long mUpdateTime;

        d() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lja = jSONObject.optLong("scores_total");
                this.ljb = jSONObject.optLong("scores_fetch");
                this.ljc = jSONObject.optLong("scores_money");
                this.ljd = jSONObject.optLong("scores_other");
                this.mUpdateTime = jSONObject.optLong("update_time");
                this.lje = jSONObject.optLong("level");
                this.mLimit = jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
            }
        }

        public boolean isValid() {
            return this.ljc >= 0 && this.ljd >= 0;
        }
    }
}
