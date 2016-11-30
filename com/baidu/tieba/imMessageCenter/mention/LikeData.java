package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes.dex */
public class LikeData implements Serializable {
    private static final long serialVersionUID = 1250162253971653314L;
    private int mIsMyFriend;
    private String mId = "";
    private String mName = "";
    private String mNameShow = "";
    private String mPortrait = "";
    private int mUserType = 0;
    private int mIsVerify = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.optString("id");
                this.mUserType = jSONObject.optInt("user_type");
                this.mIsVerify = jSONObject.optInt("is_verify");
                this.mName = jSONObject.optString("name");
                this.mNameShow = jSONObject.optString(IntentConfig.NAME_SHOW);
                this.mPortrait = jSONObject.optString(IntentConfig.PORTRAIT);
                this.mIsMyFriend = jSONObject.optInt("is_friend");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtoBuf(User user) {
        if (user != null) {
            try {
                this.mId = String.valueOf(user.id);
                this.mUserType = user.user_type.intValue();
                this.mIsVerify = user.is_verify.intValue();
                this.mName = user.name;
                this.mNameShow = user.name_show;
                this.mPortrait = user.portrait;
                this.mIsMyFriend = user.is_friend.intValue();
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

    public String getNameShow() {
        return this.mNameShow;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public int getIsVerify() {
        return this.mIsVerify;
    }

    public int getIsMyFriend() {
        return this.mIsMyFriend;
    }
}
