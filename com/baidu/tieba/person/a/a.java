package com.baidu.tieba.person.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<UserData> bTL = new ArrayList<>();
    private ArrayList<UserData> bTM = new ArrayList<>();
    private q bTN = new q();
    private int friendNum = 0;
    private int bTO = 0;

    public void a(q qVar) {
        this.bTN = qVar;
    }

    public q Zq() {
        return this.bTN;
    }

    public ArrayList<UserData> aeK() {
        return this.bTL;
    }

    public ArrayList<UserData> aeL() {
        return this.bTM;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int aeM() {
        return this.bTO;
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
                        this.bTL.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bTM.add(userData2);
                    }
                }
                this.bTN.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.bTO = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
