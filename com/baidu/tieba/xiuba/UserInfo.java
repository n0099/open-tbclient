package com.baidu.tieba.xiuba;

import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.a;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private long errorCode;
    private String errorMsg;
    private int gendar;
    private String nickName;
    private String openID;
    private long tCount;
    private String userName;

    public long getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(long j) {
        this.errorCode = j;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getOpenID() {
        return this.openID;
    }

    public void setOpenID(String str) {
        this.openID = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public int getGendar() {
        return this.gendar;
    }

    public void setGendar(int i) {
        this.gendar = i;
    }

    public long gettCount() {
        return this.tCount;
    }

    public void settCount(long j) {
        this.tCount = j;
    }

    public void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.errorCode = jSONObject.optInt("error_code");
            this.errorMsg = jSONObject.optString("error_msg");
            this.openID = jSONObject.optString("openid");
            JSONObject optJSONObject = jSONObject.optJSONObject("userData");
            if (optJSONObject != null) {
                this.userName = optJSONObject.optString("name");
                this.nickName = optJSONObject.optString(a.NAME_SHOW);
                this.gendar = optJSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
                this.tCount = optJSONObject.optLong("tdouNum");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
