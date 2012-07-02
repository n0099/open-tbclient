package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LoginModel {
    private ArrayList<String> mSuggnames;
    private int smsCodeTime = 0;
    private UserData user = new UserData();
    private AntiData anti = new AntiData();

    public LoginModel() {
        this.mSuggnames = null;
        this.mSuggnames = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public void setAnti(AntiData anti) {
        this.anti = anti;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("LoginModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        try {
            JSONObject obj = json.optJSONObject("user");
            this.user.parserJson(obj);
            JSONObject obj2 = json.optJSONObject("anti");
            this.anti.parserJson(obj2);
            JSONArray list = json.optJSONArray("suggnames");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    this.mSuggnames.add(list.optString(i, null));
                }
            }
            setSmsCodeTime(json.optInt("retrytime"));
        } catch (Exception ex) {
            TiebaLog.e("LoginModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public ArrayList<String> getSuggnames() {
        return this.mSuggnames;
    }

    public void setSuggnames(ArrayList<String> suggnames) {
        this.mSuggnames = suggnames;
    }

    public void logPrint() {
        this.user.logPrint();
    }

    public void setSmsCodeTime(int smsCodeTime) {
        this.smsCodeTime = smsCodeTime;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
