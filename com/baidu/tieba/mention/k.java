package com.baidu.tieba.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes.dex */
public class k {
    private int bFZ;
    private String mId = "";
    private String mName = "";
    private String bEu = "";
    private String mPortrait = "";
    private int mUserType = 0;
    private int bFY = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.optString("id");
                this.mUserType = jSONObject.optInt(OfficalBarChatActivityConfig.USER_TYPE);
                this.bFY = jSONObject.optInt("is_verify");
                this.mName = jSONObject.optString("name");
                this.bEu = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW);
                this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
                this.bFZ = jSONObject.optInt("is_friend");
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
                this.bFY = user.is_verify.intValue();
                this.mName = user.name;
                this.bEu = user.name_show;
                this.mPortrait = user.portrait;
                this.bFZ = user.is_friend.intValue();
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

    public String Zj() {
        return this.bEu;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getIsMyFriend() {
        return this.bFZ;
    }
}
