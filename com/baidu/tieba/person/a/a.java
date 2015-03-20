package com.baidu.tieba.person.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<UserData> bQP = new ArrayList<>();
    private ArrayList<UserData> bQQ = new ArrayList<>();
    private q bQR = new q();
    private int friendNum = 0;
    private int bQS = 0;

    public void b(q qVar) {
        this.bQR = qVar;
    }

    public q XE() {
        return this.bQR;
    }

    public ArrayList<UserData> adm() {
        return this.bQP;
    }

    public ArrayList<UserData> adn() {
        return this.bQQ;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int ado() {
        return this.bQS;
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
                        this.bQP.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bQQ.add(userData2);
                    }
                }
                this.bQR.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.bQS = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
