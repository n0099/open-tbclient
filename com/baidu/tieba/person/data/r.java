package com.baidu.tieba.person.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ac;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private ArrayList<UserData> dwL = new ArrayList<>();
    private ArrayList<UserData> dwM = new ArrayList<>();
    private ac mPage = new ac();
    private int friendNum = 0;
    private int dwN = 0;

    public void b(ac acVar) {
        this.mPage = acVar;
    }

    public ac getPage() {
        return this.mPage;
    }

    public ArrayList<UserData> aCc() {
        return this.dwL;
    }

    public ArrayList<UserData> aCd() {
        return this.dwM;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int aCe() {
        return this.dwN;
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
                        this.dwL.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.dwM.add(userData2);
                    }
                }
                this.mPage.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.dwN = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
