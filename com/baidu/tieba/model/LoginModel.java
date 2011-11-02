package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LoginModel {
    private UserData user = new UserData();
    private AntiData anti = new AntiData();

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
        } catch (Exception ex) {
            TiebaLog.e("LoginModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void logPrint() {
        this.user.logPrint();
    }
}
