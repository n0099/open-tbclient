package com.baidu.tieba.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes.dex */
public class k {
    private int btw;
    private String mId = "";
    private String mName = "";
    private String auY = "";
    private String mPortrait = "";
    private int mUserType = 0;
    private int btv = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.optString("id");
                this.mUserType = jSONObject.optInt(OfficalBarChatActivityConfig.USER_TYPE);
                this.btv = jSONObject.optInt("is_verify");
                this.mName = jSONObject.optString("name");
                this.auY = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.btw = jSONObject.optInt("is_friend");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(User user) {
        if (user != null) {
            try {
                this.mId = String.valueOf(user.id);
                this.mUserType = user.user_type.intValue();
                this.btv = user.is_verify.intValue();
                this.mName = user.name;
                this.auY = user.name_show;
                this.mPortrait = user.portrait;
                this.btw = user.is_friend.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String Um() {
        return this.auY;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getIsMyFriend() {
        return this.btw;
    }
}
