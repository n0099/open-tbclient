package com.baidu.tieba.person.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private ArrayList<UserData> cNF = new ArrayList<>();
    private ArrayList<UserData> cNG = new ArrayList<>();
    private q mPage = new q();
    private int friendNum = 0;
    private int cNH = 0;

    public void b(q qVar) {
        this.mPage = qVar;
    }

    public q getPage() {
        return this.mPage;
    }

    public ArrayList<UserData> aop() {
        return this.cNF;
    }

    public ArrayList<UserData> aoq() {
        return this.cNG;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int aor() {
        return this.cNH;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.cNF.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cNG.add(userData2);
                    }
                }
                this.mPage.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.cNH = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
