package com.baidu.tieba.xiuba;

import java.io.Serializable;
/* loaded from: classes.dex */
public class XiubaMsg implements Serializable {
    private static final long serialVersionUID = 1;
    private String content;
    private String groupName;
    private String intro;
    private String likers;
    private String listeners;
    private String[] openId;
    private String userId;
    private String userName;

    public String getListeners() {
        return this.listeners;
    }

    public void setListeners(String str) {
        this.listeners = str;
    }

    public String getLikers() {
        return this.likers;
    }

    public void setLikers(String str) {
        this.likers = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String[] getOpenId() {
        return this.openId;
    }

    public void setOpenId(String[] strArr) {
        this.openId = strArr;
    }
}
