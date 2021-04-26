package com.baidu.tieba.usermute;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class MuteUser extends OrmObject implements Serializable {
    public int agreeType;
    public String nickName;
    public String secureMobil;
    public String secureeMail;
    public String userId;
    public String userName;
    public int userStatus;

    public String getNickName() {
        return this.nickName;
    }

    public String getSecureMobil() {
        return this.secureMobil;
    }

    public String getSecureeMail() {
        return this.secureeMail;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getUserStatus() {
        return this.userStatus;
    }

    public void parserProtobuf(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.userId = String.valueOf(simpleUser.user_id);
        this.userName = simpleUser.user_name;
        this.userStatus = simpleUser.user_status.intValue();
        this.secureeMail = simpleUser.secureemail;
        this.secureMobil = simpleUser.securemobil;
        this.nickName = simpleUser.user_nickname;
        this.agreeType = simpleUser.agree_type.intValue();
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setSecureMobil(String str) {
        this.secureMobil = str;
    }

    public void setSecureeMail(String str) {
        this.secureeMail = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserStatus(int i2) {
        this.userStatus = i2;
    }
}
