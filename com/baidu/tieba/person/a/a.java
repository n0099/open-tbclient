package com.baidu.tieba.person.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.p;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<UserData> ckt = new ArrayList<>();
    private ArrayList<UserData> cku = new ArrayList<>();
    private p mPage = new p();
    private int friendNum = 0;
    private int ckv = 0;

    public void a(p pVar) {
        this.mPage = pVar;
    }

    public p getPage() {
        return this.mPage;
    }

    public ArrayList<UserData> agC() {
        return this.ckt;
    }

    public ArrayList<UserData> agD() {
        return this.cku;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int agE() {
        return this.ckv;
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
                        this.ckt.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cku.add(userData2);
                    }
                }
                this.mPage.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.ckv = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
