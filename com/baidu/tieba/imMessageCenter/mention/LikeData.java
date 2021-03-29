package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.GodUserData;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes3.dex */
public class LikeData implements Serializable {
    public static final long serialVersionUID = 1250162253971653314L;
    public GodUserData mGodData;
    public int mIsMyFriend;
    public String mId = "";
    public String mName = "";
    public String mNameShow = "";
    public String mPortrait = "";
    public int mUserType = 0;
    public int mIsVerify = 0;

    public String getId() {
        return this.mId;
    }

    public int getIsMyFriend() {
        return this.mIsMyFriend;
    }

    public int getIsVerify() {
        return this.mIsVerify;
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

    public boolean isBigV() {
        GodUserData godUserData = this.mGodData;
        return godUserData != null && godUserData.isBigV();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mId = jSONObject.optString("id");
            this.mUserType = jSONObject.optInt("user_type");
            this.mIsVerify = jSONObject.optInt("is_verify");
            this.mName = jSONObject.optString("name");
            this.mNameShow = jSONObject.optString("name_show");
            this.mPortrait = jSONObject.optString("portrait");
            this.mIsMyFriend = jSONObject.optInt("is_friend");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtoBuf(User user) {
        if (user == null) {
            return;
        }
        try {
            this.mId = String.valueOf(user.id);
            this.mUserType = user.user_type.intValue();
            this.mIsVerify = user.is_verify.intValue();
            this.mName = user.name;
            this.mNameShow = user.name_show;
            this.mPortrait = user.portrait;
            this.mIsMyFriend = user.is_friend.intValue();
            if (user.god_data != null) {
                GodUserData godUserData = new GodUserData();
                this.mGodData = godUserData;
                godUserData.parserProtobuf(user.god_data);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
