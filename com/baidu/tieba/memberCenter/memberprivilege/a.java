package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public e lnz = new e();
    public List<c> lnA = new ArrayList();

    public void parseJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lnz.parseJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    c cVar = new c();
                    cVar.parseJson(optJSONArray.getJSONObject(i));
                    this.lnA.add(cVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static class e {
        public b lnL = new b();
        public d lnM = new d();
        public String mId;
        public String mName;
        public String mPortrait;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mId = jSONObject.optString("id");
                this.mName = jSONObject.optString("name");
                this.mPortrait = jSONObject.optString("portrait");
                this.lnL.parseJson(jSONObject.optJSONObject("pay_member_info"));
                this.lnM.parseJson(jSONObject.optJSONObject("Parr_scores"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0810a {
        public String lnB;
        public String mDesc;
        public String mLink;
        public String mTitle;

        C0810a() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lnB = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("desc");
                this.mLink = jSONObject.optString("link");
            }
        }
    }

    /* loaded from: classes9.dex */
    static class c {
        public ArrayList<C0810a> lnF = new ArrayList<>();
        public String mClassName;

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.mClassName = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
                JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        C0810a c0810a = new C0810a();
                        c0810a.parseJson(jSONObject2);
                        this.lnF.add(c0810a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b {
        public long lmz;
        public long lnC;
        public long lnD;
        public String lnE;

        b() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lmz = jSONObject.optInt("props_id");
                this.lnC = jSONObject.optLong("end_time");
                this.lnD = jSONObject.optLong("now_time");
                this.lnE = jSONObject.optString("pic_url");
            }
        }

        public boolean isValid() {
            return (this.lmz == 1 || this.lmz == 2) && this.lnC > this.lnD;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class d {
        public long lnG;
        public long lnH;
        public long lnI;
        public long lnJ;
        public long lnK;
        public long mLimit;
        public long mUpdateTime;

        d() {
        }

        public void parseJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.lnG = jSONObject.optLong("scores_total");
                this.lnH = jSONObject.optLong("scores_fetch");
                this.lnI = jSONObject.optLong("scores_money");
                this.lnJ = jSONObject.optLong("scores_other");
                this.mUpdateTime = jSONObject.optLong("update_time");
                this.lnK = jSONObject.optLong(MapBundleKey.MapObjKey.OBJ_LEVEL);
                this.mLimit = jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
            }
        }

        public boolean isValid() {
            return this.lnI >= 0 && this.lnJ >= 0;
        }
    }
}
