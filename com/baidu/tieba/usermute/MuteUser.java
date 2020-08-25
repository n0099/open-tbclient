package com.baidu.tieba.usermute;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class MuteUser extends OrmObject implements Serializable {
    public int agreeType;
    private String nickName;
    private String secureMobil;
    private String secureeMail;
    private String userId;
    private String userName;
    private int userStatus;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
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

    public int getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(int i) {
        this.userStatus = i;
    }

    public String getSecureMobil() {
        return this.secureMobil;
    }

    public void setSecureMobil(String str) {
        this.secureMobil = str;
    }

    public String getSecureeMail() {
        return this.secureeMail;
    }

    public void setSecureeMail(String str) {
        this.secureeMail = str;
    }

    public void parserProtobuf(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.userId = String.valueOf(simpleUser.user_id);
            this.userName = simpleUser.user_name;
            this.userStatus = simpleUser.user_status.intValue();
            this.secureeMail = simpleUser.secureemail;
            this.secureMobil = simpleUser.securemobil;
            this.nickName = simpleUser.user_nickname;
            this.agreeType = simpleUser.agree_type.intValue();
        }
    }
}
